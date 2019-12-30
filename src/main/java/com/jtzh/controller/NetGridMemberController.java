/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.mapper.NetGridMemberMapper;
import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.NetGridMemberService;

/*    */ import com.jtzh.vo.netGrid.NetGridMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/*    */
/*    */ @CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/netGridMember"})
/*    */ public class NetGridMemberController
/*    */ {
/*    */   @Autowired
/*    */   private NetGridMemberService netGridMemberService;

            @Autowired
            private NetGridMemberMapper memberMapper;
/*    */   
/*    */   @RequestMapping({"/addNetGridMember"})
/*    */   @ResponseBody
/*    */   public ExtResponse addNetGridMember(@RequestParam(value="file", required=false) MultipartFile file, String netGridMember)
/*    */   {
/* 26 */     return ResponseUtil.success(Boolean.valueOf(this.netGridMemberService.addNetGridMember(file, netGridMember)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateNetGridMember"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateNetGridMember(@RequestParam(value="file", required=false) MultipartFile file, String netGridMember) {
/* 32 */     return ResponseUtil.success(Boolean.valueOf(this.netGridMemberService.updateNetGridMember(file, netGridMember)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteNetGridMember"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteNetGridMember(Long id) {
/* 38 */     return ResponseUtil.success(Boolean.valueOf(this.netGridMemberService.deleteNetGridMember(id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getNetGridMemberForOrg"})
/*    */   @ResponseBody
/*    */   public ExtResponse getNetGridMemberForOrg(Long id) {
/* 44 */     return ResponseUtil.success(this.netGridMemberService.getNetGridMemberForOrg(id));
/*    */   }

    @RequestMapping({"/getNetGridMemberByNetGridID"})
    @ResponseBody
    public ExtResponse getNetGridMemberByNetGridID(Long id)
    {
        return ResponseUtil.success(this.netGridMemberService.getNetGridMemberByNetGridID(id));
    }
/*    */


    @RequestMapping({"/reporterRankName"})
    @ResponseBody
    public Object reporterRankName() {
        List<NetGridMemberVO> netGridMembers = memberMapper.reporterRank();
        System.out.println(netGridMembers);
        List<String> arrayList = new ArrayList<String>();
        TreeMap<Object, Object> map = new TreeMap<>();
        for (NetGridMemberVO list : netGridMembers
        ) {
            arrayList.add(list.getName());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.put(arrayList.get(i), arrayList.size() - i);
        }
        return map;
    }
        @RequestMapping({"/achievements"})
        @ResponseBody
        public Object achievements()    {
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
               // System.out.println(maps.getKey() + "--" + maps.getValue());
            }
            return map;

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
    /*    */ }


