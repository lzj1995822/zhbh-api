package com.jtzh;

import com.jtzh.controller.CgshangbaoController;
import com.jtzh.entity.NetGridMember;
import com.jtzh.mapper.*;
import com.jtzh.service.HwuserService;
import com.jtzh.service.NetGridMemberService;
import com.jtzh.service.SSEventService;
import com.jtzh.vo.dispute.DisputeEventVO;
import com.jtzh.vo.dispute.DisputePeopleVO;
import com.jtzh.vo.gis.SocietySecurityEventVO;
import com.jtzh.vo.netGrid.NetGridMemberVO;
import com.jtzh.vo.served.ServedPersonBasicCountVO;
import com.jtzh.vo.ss.SSCountVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHw {


    @Autowired
    private NetGridMemberMapper gridMemberMapper;
    @Autowired
    private HwuserService hwuserService;

    @Autowired
    private HwuserMapper hwuserMapper;

    @Autowired
    private CgshangbaoController cgshangbaoMapper;

    @Autowired
    private ServedPersonBasicMapper servedPersonBasicMapper;

    @Autowired
    private SSEventService eventService;

    @Autowired
    private SocietySecurityEventMapper mapper;

    @Autowired
    private DisputeEventMapper eventMapper;

    @Autowired
    private  NetGridMemberMapper netGridMemberMapper;
    @Test
    public  void  testUser(){
        Map<String,Integer> map =new HashMap<>();
        map.put("18-30岁", 0);
        map.put("30-40岁", 0);
        map.put("40-50岁", 0);
        map.put("50-60岁", 0);
        map.put("60-70岁" , 0);
        List<String> list = hwuserMapper.hwAgeRange();
        for(String item: list) {
            if (item == null) {
                continue;
            }
            Integer year = Integer.valueOf(item);
            if (year >= 18 && year <= 30) {
                Integer integer = map.get("18-30岁");
                integer ++;
                map.put("18-30岁", integer);
            }
            if (year > 30 && year <= 40) {
                Integer integer = map.get("30-40岁");
                integer ++;
                map.put("30-40岁", integer);
            }
            if (year >40 && year <= 50) {
                Integer integer = map.get("40-50岁");
                integer ++;
                map.put("40-50岁", integer);
            }
            if (year >50 && year <= 60) {
                Integer integer = map.get("50-60岁");
                integer ++;
                map.put("50-60岁", integer);
            }
        }

        for (Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+','+entry.getValue());
        }




    }

    @Test
    public  void  test2(){
        List<Map> list = cgshangbaoMapper.calByPeople("2019-12-17");
        list.sort(Comparator.comparing(o -> o.get("value").toString()));
        System.out.println(list);
    }


    @Test
    public  void test3(){
        List<ServedPersonBasicCountVO> servedPersonCount = servedPersonBasicMapper.getServedPersonCount();
        int  sum=0;
        for( int i = 0 ; i < servedPersonCount.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。

          sum+= servedPersonCount.get(i).getFloating();
        }
        System.out.println(sum);

    }

    //测试巡查概况
    @Test
    public  void  test(){
        TreeMap<Object,Object> map =new TreeMap();
        int common = 0,great=0;

        int todayRes= eventService.tesocietysecurityeventToday();
        List<SSCountVO> ssCountVO = eventService.getSSCountVO();
        for (int i = 0; i < ssCountVO.size(); i++) {
            common+=  ssCountVO.get(i).getCommon();
             great+=  ssCountVO.get(i).getGreat();
        }
        map.put("todayRes",todayRes);
        map.put("common",common);
        map.put("great",great);

        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next();

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

    }


    @Test
    public  void test4(){
        List<SocietySecurityEventVO> societySecurityEventVOS = mapper.SSEventQuery();
        TreeMap<Object,Object>  map=new TreeMap<>();
        for (SocietySecurityEventVO val:societySecurityEventVOS
             ) {
           map.put("ssEventTypeName",val.getSsEventTypeName());
           map.put("ssEventStatusTypeName",val.getSsEventStatusTypeName());
           map.put("netGridName",val.getNetGridName());
        }
            for (Map.Entry<Object,Object> entry:map.entrySet()){
                System.out.println("key="+entry.getKey()+",val"+entry.getValue());
            }
    }

    //getDisputeEventDeptDespatcherQuery
    @Test
    public  void  test5() {

        // List<DisputeEventVO> despatcherQuery = eventMapper.getDespatcherQuery();

       /* TreeSet<String> set=new TreeSet<>();
        for (DisputeEventVO list: despatcherQuery
             ) {
            set.add(list.getEventTypeName());
        }
        System.out.println(set);
    }*/

        List<DisputeEventVO> despatcherQuery = eventMapper.getDespatcherQuery2();
        for (DisputeEventVO list : despatcherQuery
        ) {
            System.out.println(list.getEventTypeName());
        }

    }

    //测试矛盾审核情况比例
    @Test
    public  void test6(){

        List<DisputeEventVO> disputeEventVOS = eventMapper.contraditionProportion();
        int  a1=0;
        int a2=0;
        int a3=0;
        int a4=0;
        for (DisputeEventVO list: disputeEventVOS
        ) {
            System.out.println(list.getEventStatusName());
            if(list.getEventStatusName().equals("已立案，待派发")){
                a3+=1;
            }
            else if(list.getEventStatusName().equals("已上报，待立案")){
                a1+=1;
            }else if(list.getEventStatusName().equals("已派发，待处理")){
                a4+=1;
            }
        }
        System.out.println(a1);
        System.out.println(a3);
        System.out.println(a4);
        TreeMap<Object,Object> map =new TreeMap<>();
        map.put(a3,"已立案，待派发");
        map.put(a1,"已上报，待立案");
        map.put(a4,"已派发，待处理");

    }


    //巡查员上报TOP5
    @Test
    public  void  test7(){


        List<NetGridMemberVO> netGridMembers = netGridMemberMapper.reporterRank();
        System.out.println(netGridMembers);
        List<String> arrayList=new ArrayList<String>();
       TreeMap<Object,Object> map=new TreeMap<>();
        for (NetGridMemberVO list: netGridMembers
             ) {
            arrayList.add(list.getName());
        }

        for (int i = 0; i < arrayList.size(); i++) {
            map.put(arrayList.get(i), arrayList.get(i));
        }



        for(Map.Entry<Object,Object>map2:map.entrySet()){
            System.out.println("key="+map2.getKey()+",val="+map2.getValue());
        }


    }



    @Autowired
    private NetGridMemberService netGridMemberService;

    @Test
    public  void  testAchievements() {
        List<NetGridMemberVO> achievements = netGridMemberService.Achievements();
        Map<String, Integer> map = new LinkedHashMap<>();


        for (NetGridMemberVO list : achievements
        ) {
            // System.out.println(list.getName()+'-'+list.getNo());
            map.put(list.getName(), list.getNo());
        }
        map=  sortDescend(map);

        for (Map.Entry<String, Integer> maps : map.entrySet()
        ) {
            System.out.println(maps.getKey() + "--" + maps.getValue());
        }

    }
    public static <K, V extends Comparable<? super V>> Map<K, V> sortDescend(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;
    }


}
