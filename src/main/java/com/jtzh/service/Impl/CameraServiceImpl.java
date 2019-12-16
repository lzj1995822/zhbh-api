package com.jtzh.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.jtzh.entity.TbCamera;
import com.jtzh.mapper.TbCameraMapper;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.CameraPagination;
import com.jtzh.service.CameraService;
import com.jtzh.util.MD5Utils;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


@Service
public class CameraServiceImpl implements CameraService {

//    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Resource
    private TbCameraMapper tbCameraMapper;

    /**
     * 接口访问ip和端口
     */
    private static final String IP_PORT = "http://172.16.1.133:8080";

    /**
     * app_key
     */
    private static final String APP_KEY = "a592d676";

    /**
     * 秘钥
     */
    private static final String SECRET = "69681c3587194a50a2b11f1335ad6f41";

    /**
     * 摄像头资源列表
     */
    private static final String CAMERA_LIST = "/openapi/service/vss/res/getEncoders";

    /**
     * 查询监控点设备
     */
    private static final String PONIT_URL = "/openapi/service/vss/res/getCamerasEx";

    /**
     * 获取所有网域
     */
    private static final String NET_URL = "/openapi/service/base/netZone/getNetZones";

    /**
     * 预览
     */
    private static final String PERVIEW_URL = "/openapi/service/vss/preview/getPreviewParamByCameraUuid";

    /**
     * 获取经纬度
     */
    private static final String XY_URL = "/openapi/service/ems/location/getResLocations";
    /**
     * 获取请求token
     * @param URI 相对接口的请求地址
     * @param json 需要参与生成token的入参json串
     * @return token
     */
    private String generateToken(String URI, String json) {
        String origin = URI + json + SECRET;
        return MD5Utils.MD5Encode(origin, "utf-8");
    }

    /**
     * 获取请求全路径
     * @param URI 相对接口的请求地址
     * @param json 需要参与生成token的入参json串
     * @return 请求全路径
     */
    private String getFullUrl(String URI,String json) {
        String token = generateToken(URI, json);
        return String.format("%s?token=%s", IP_PORT + URI, token.toUpperCase());
    }

    /**
     * 发起post请求
     * @param url 请求全路径
     * @param param 请求入参
     * @return 结果字符串
     */
   public JSONObject post(String url, JSONObject param) {
       return  restTemplate.postForEntity(url, param, JSONObject.class).getBody();
   }

    public void getCameraList(){
        JSONObject param = new JSONObject();
        param.put("appkey", APP_KEY);
        param.put("time",new Date().getTime());
        param.put("pageNo", 1);
        param.put("pageSize", 10);
        param.put("opUserUuid", getDefaultUUID());
        param.put("unitUuids", "1048576");
        String fullUrl = getFullUrl(CAMERA_LIST, param.toJSONString());
        JSONObject post = post(fullUrl, param);
        System.out.printf(post.toJSONString());
    }

    public void getAllNet(){
        JSONObject param = new JSONObject();
        param.put("appkey", APP_KEY);
        param.put("time",new Date().getTime());
        param.put("pageNo", 1);
        param.put("pageSize", 10);
        param.put("opUserUuid", getDefaultUUID());
        String fullUrl = getFullUrl(NET_URL, param.toJSONString());
        JSONObject post = post(fullUrl, param);
        System.out.printf(post.toJSONString());
    }

//    宝华城管流动板房 51d903ab88f1486c9a1290b1c953b638
//    宝华新中学 68d84f741fda4ba1a7142d5e74a2bb53
//    仙林大道 e975836a993545c5b2a7bbdfc70dcbb2
//    宝华大道 ea2a0e1e8ad447e0abb4b71953b6f259
//    玉兰路 a6c81a2437e144b691d6afd078126b8e
//    栏江行政村 b6b3b5262c1f46f3ae64d31c39733025
//    铜山行政村 c6995c0baf7b40c2b40b254fb0e0e2ac
//    仓头行政村 da7abb2a2f194dc78d705885e0d7bd14
//    栗庄行政村 a8648b143baa486db60895e19436a995
//    宝华行政村 b0fe775ffcb144b3a4cbe643dac5ea4f
//    和平行政村 31235e441143401a8eda3ea9e5c8c79c
//    宝华物流园 7fd7fc28294f45daa46bbe8929dc1e3b
//    宝华山人脸识别 54ab82f24a544db7978de9dac2f98c19
//    宝华交警 3deb282944df4d6e9e92cf1d7fbd02cc
//    宝华青龙山采石宕口 2940d78c81db49fda04940ccd1480db3
//    铁路沿线 72f6e0f6eb3a422ebf7c7ce86419751d
//    宝华2019新增 ef873975ac22467195e9e59616a69e56
//    南北通道 7f69cd6ba9894be99426920a0fce6ba1
//    312国道 13558c7e9e0f48deb1e3578e960915af
//    宝华山北门 2744eb96f5954f338e4c8037fe53bb92

    public void getPointList(){
        JSONObject param = new JSONObject();
        param.put("appkey", APP_KEY);
        param.put("time",new Date().getTime());
        param.put("pageNo", 1);
        param.put("pageSize", 500);
        param.put("opUserUuid", "c26a811c141a11e79aeeb32ef95273f2");
//        param.put("cameraName", "大门口");
//        param.put("unitUuids","1048576" );
        param.put("regionUuids","51d903ab88f1486c9a1290b1c953b638,68d84f741fda4ba1a7142d5e74a2bb53,e975836a993545c5b2a7bbdfc70dcbb2," +
                "ea2a0e1e8ad447e0abb4b71953b6f259,a6c81a2437e144b691d6afd078126b8e,b6b3b5262c1f46f3ae64d31c39733025," +
                "c6995c0baf7b40c2b40b254fb0e0e2ac,da7abb2a2f194dc78d705885e0d7bd14,a8648b143baa486db60895e19436a995," +
                "b0fe775ffcb144b3a4cbe643dac5ea4f,31235e441143401a8eda3ea9e5c8c79c,7fd7fc28294f45daa46bbe8929dc1e3b," +
                "54ab82f24a544db7978de9dac2f98c19,3deb282944df4d6e9e92cf1d7fbd02cc,2940d78c81db49fda04940ccd1480db3," +
                "72f6e0f6eb3a422ebf7c7ce86419751d,ef873975ac22467195e9e59616a69e56,7f69cd6ba9894be99426920a0fce6ba1," +
                "13558c7e9e0f48deb1e3578e960915af,2744eb96f5954f338e4c8037fe53bb92");
        String fullUrl = getFullUrl(PONIT_URL, param.toJSONString());
        JSONObject post = post(fullUrl, param);
//        tbCameraMapper.insert();
        ArrayList<LinkedHashMap> arrayList = (ArrayList)((LinkedHashMap) post.get("data")).get("list");
        arrayList.forEach(item -> {
            TbCamera  tbCamera = new TbCamera();
            tbCamera.setCamerauuid((String) item.get("cameraUuid"));
            tbCamera.setCameraname((String) item.get("cameraName"));
            tbCamera.setCameratype(String.valueOf((Integer) item.get("cameraType")));
            tbCamera.setCamerachannelnum((String) item.get("cameraChannelNum"));
            tbCamera.setSmarttype((String) item.get("smartType"));
            tbCamera.setSmartsupport(String.valueOf((Integer) item.get("smartSupport")));
            tbCamera.setOnlinestatus(String.valueOf((Integer) item.get("onLineStatus")));
            tbCamera.setKeyboardcode((String) item.get("keyBoardCode"));
            tbCamera.setOrdernum(String.valueOf((Integer) item.get("orderNum")));
            tbCamera.setUpdatetime(new Date((long) item.get("updateTime")));
            tbCamera.setUnituuid((String) item.get("unitUuid"));
            tbCamera.setRegionuuid((String) item.get("regionUuid"));
            tbCamera.setEncoderuuid((String) item.get("encoderUuid"));
            tbCamera.setResauths((String) item.get("resAuths"));
            tbCameraMapper.insert(tbCamera);
        });

        System.out.printf(post.toJSONString());
    }
    @Test
    public void test() {
       getPreivewList("1b8412465b434e1ea2008145367b2273");
    }
///openapi/service/vss/preview/getPreviewParamByCameraUuid{"appkey":"a592d676","time":1547621030451,"pageNo":1,"pageSize":10,"opUserUuid":"c26a811c141a11e79aeeb32ef95273f2","netZoneUuid":"5b994421aced4e2d9a76179e8cc70734"}69681c3587194a50a2b11f1335ad6f41
    public JSONObject getPreivewList(String cameraUuid){
//        {"appkey":"a592d676","time":1547619590896,"pageNo":1,"pageSize":10,"opUserUuid":"c26a811c141a11e79aeeb32ef95273f2","cameraUuid":"05cb445d93eb4a6bb21c69e9169a43c4","netZoneUuid":"5b994421aced4e2d9a76179e8cc70734"}
        JSONObject param = new JSONObject();
        param.put("appkey", APP_KEY);
        param.put("time",new Date().getTime());
        param.put("pageNo", 1);
        param.put("pageSize", 10);
        param.put("opUserUuid", "c26a811c141a11e79aeeb32ef95273f2");
        param.put("cameraUuid", cameraUuid);
        param.put("netZoneUuid","5b994421aced4e2d9a76179e8cc70734"); // 外网
//        param.put("netZoneUuid", "f5816cf43fcc41d880d9f636fa8bc443"); // 内网
        String fullUrl = getFullUrl(PERVIEW_URL, param.toJSONString());
        JSONObject post;
        try {
            post = post(fullUrl, param);
        } catch (Exception e) {
            return null;
        }
        System.out.println(post.toJSONString());
        return post;
    }

    public void readExcelOrigin() {
        File file = new File("/Users/asher/Desktop/tb_camera.xls");
        List list = readExcel(file);
        for (int i = 1; i < list.size(); i++) {
            ArrayList row = (ArrayList) list.get(i);
            String cameraUuid = (String) row.get(1);
            double x = Double.valueOf((String) row.get(2));
            double y = Double.valueOf((String) row.get(3));
            Point point = wgs84togcj02(x, y);
            point = gcj02tobd09(point.x, point.y);
            TbCamera tbCamera = tbCameraMapper.selectByCameraName(cameraUuid);
            if (tbCamera != null) {
                tbCamera.setXloc(String.valueOf(point.x));
                tbCamera.setYloc(String.valueOf(point.y));
                tbCameraMapper.updateByPrimaryKey(tbCamera);
            }
        }
    }

    public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                        System.out.print(cellinfo);
                    }
                    outerList.add(i, innerList);
                    System.out.println();
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void getXY() {
        JSONObject param = new JSONObject();
        param.put("appkey", APP_KEY);
        param.put("time",new Date().getTime());
        param.put("opUserUuid", getDefaultUUID());
        param.put("resUuid", "ae61b4cfa88e4b94a8e51d06662282fd");
        String fullUrl = getFullUrl(XY_URL, param.toJSONString());
        JSONObject post = post(fullUrl, param);
        System.out.printf(post.toJSONString());
    }

    public String getDefaultUUID(){
        JSONObject param = new JSONObject();
        param.put("appkey", APP_KEY);
        param.put("time",new Date().getTime());
        String fullUrl = getFullUrl("/openapi/service/base/user/getDefaultUserUuid", param.toJSONString());
        String post = (String) post(fullUrl, param).get("data");
        return post;
    }

    public List<TbCamera> selectAll() {
       return tbCameraMapper.selectAll();
    }

    @Override
    public BaseResponse<List<TbCamera>> page(CameraPagination cameraPagination) {
        BaseResponse<List<TbCamera>> res = new BaseResponse<>();
        List<TbCamera> cameras = tbCameraMapper.page(cameraPagination);
        res.setTotal(tbCameraMapper.count(cameraPagination));
        res.setResponseData(cameras);
        res.setStatusCode(200);
        return res;
    }

    public class Point {
       private double x;
       private double y;
       Point(double x, double y){
           this.x = x;
           this.y = y;
       }
    }
        double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
        double PI = 3.1415926535897932384626;
        double a = 6378245.0;
        double ee = 0.00669342162296594323;

        /**
         * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换
         * 即 百度 转 谷歌、高德
         * @param bd_lon
         * @param bd_lat
         * @returns {*[]}
         */
        public Point bd09togcj02(double bd_lon, double bd_lat){
            double x = bd_lon - 0.0065;
            double y = bd_lat - 0.006;
            double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_PI);
            double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_PI);
            double gg_lng = z * Math.cos(theta);
            double gg_lat = z * Math.sin(theta);
            Point point=new Point(gg_lng, gg_lat);
            return point;
        }

        /**
         * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换
         * 即谷歌、高德 转 百度
         * @param lng
         * @param lat
         * @returns {*[]}
         */
        public Point gcj02tobd09(double lng, double lat){
            double z = Math.sqrt(lng * lng + lat * lat) + 0.00002 * Math.sin(lat * x_PI);
            double theta = Math.atan2(lat, lng) + 0.000003 * Math.cos(lng * x_PI);
            double bd_lng = z * Math.cos(theta) + 0.0065;
            double bd_lat = z * Math.sin(theta) + 0.006;
            Point point=new Point(bd_lng, bd_lat);
            return point;
        };

        /**
         * WGS84转GCj02
         * @param lng
         * @param lat
         * @returns {*[]}
         */
        public Point wgs84togcj02(double lng, double lat){
            double dlat = transformlat(lng - 105.0, lat - 35.0);
            double dlng = transformlng(lng - 105.0, lat - 35.0);
            double radlat = lat / 180.0 * PI;
            double magic = Math.sin(radlat);
            magic = 1 - ee * magic * magic;
            double sqrtmagic = Math.sqrt(magic);
            dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
            dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
            double mglat = lat + dlat;
            double mglng = lng + dlng;
            Point point=new Point(mglng, mglat);
            return point;
        };

        /**
         * GCJ02 转换为 WGS84
         * @param lng
         * @param lat
         * @returns {*[]}
         */
        public Point gcj02towgs84(double lng, double lat){
            double dlat = transformlat(lng - 105.0, lat - 35.0);
            double dlng = transformlng(lng - 105.0, lat - 35.0);
            double radlat = lat / 180.0 * PI;
            double magic = Math.sin(radlat);
            magic = 1 - ee * magic * magic;
            double sqrtmagic = Math.sqrt(magic);
            dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
            dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
            double mglat = lat + dlat;
            double mglng = lng + dlng;
            Point point=new Point(mglng, mglat);
            return point;
        };


        private double transformlat(double lng,double lat){
            double ret= -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1 * lng * lat + 0.2 * Math.sqrt(Math.abs(lng));
            ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
            ret += (20.0 * Math.sin(lat * PI) + 40.0 * Math.sin(lat / 3.0 * PI)) * 2.0 / 3.0;
            ret += (160.0 * Math.sin(lat / 12.0 * PI) + 320 * Math.sin(lat * PI / 30.0)) * 2.0 / 3.0;
            return ret;
        }

        private double transformlng(double lng,double lat){
            double ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng * lat + 0.1 * Math.sqrt(Math.abs(lng));
            ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
            ret += (20.0 * Math.sin(lng * PI) + 40.0 * Math.sin(lng / 3.0 * PI)) * 2.0 / 3.0;
            ret += (150.0 * Math.sin(lng / 12.0 * PI) + 300.0 * Math.sin(lng / 30.0 * PI)) * 2.0 / 3.0;
            return ret;
        }

}
