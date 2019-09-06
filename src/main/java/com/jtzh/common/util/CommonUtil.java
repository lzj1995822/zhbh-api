package com.jtzh.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;

public class CommonUtil {

	/*
	 * 是否是数字
	 */
	public static boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isNum = pattern.matcher(str);
	   return isNum.matches(); 
	}
	
	/**
	 * 获取0-9随机数
	 * 
	 * @param size
	 * @param range
	 * @return
	 */
	public static String getRandoms(int size){
		Random random = new Random();
		String result = "";
		while (size-- > 0) {
			result += random.nextInt(10);;
		}
		return result;
	}
	
public static String JSAPI_TICKET = "";
	
	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * 获取当前时间字符串
	 * 
	 * @return
	 */
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	/**
	 * 获取四位随机数
	 * 
	 * @return
	 */
	public static String getRandomNumber(){
		Integer i = (int)((Math.random()*9+1)*1000);
		return i.toString();
	}
	
	/**
	 * 字符串非空验证
	 * 
	 * @param str
	 * @return
	 */
	public static boolean verifyString(String str){
		if(str == null || "".equals(str)){
			return false;
		}else{
			return true;
		}
	}
	
	// 请求方法
	public static String httpsRequestJson(String requestUrl, String requestMethod, String outputStr) {  
          try {  
               
              URL url = new URL(requestUrl);  
              HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
              
              conn.setDoOutput(true);  
              conn.setDoInput(true);  
              conn.setUseCaches(false);  
			// 设置请求方式（GET/POST）
              conn.setRequestMethod(requestMethod);  
              conn.setRequestProperty("content-type", "application/json; encoding=utf-8");  
			// 当outputStr不为null时向输出流写数据
              if (null != outputStr) {  
                  OutputStream outputStream = conn.getOutputStream();  
				// 注意编码格式
                  outputStream.write(outputStr.getBytes("UTF-8"));  
                  outputStream.close();  
              }  
			// 从输入流读取返回内容
              InputStream inputStream = conn.getInputStream();  
              InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
              BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
              String str = null;  
              StringBuffer buffer = new StringBuffer();  
              while ((str = bufferedReader.readLine()) != null) {  
                  buffer.append(str);  
              }  
			// 释放资源
              bufferedReader.close();  
              inputStreamReader.close();  
              inputStream.close();  
              inputStream = null;  
              conn.disconnect();  
              return buffer.toString();  
          } catch (ConnectException ce) {  
			System.out.println("连接超时：{}" + ce);
          } catch (Exception e) {  
			System.out.println("https请求异常：{}" + e);
          }  
          return null;  
      }
	
	// 请求xml组装
    public static String getRequestXml(Map<String,String> parameters){  
          StringBuffer sb = new StringBuffer();  
          sb.append("<xml>");  
          Set es = parameters.entrySet();  
          Iterator it = es.iterator();  
          while(it.hasNext()) {  
              Map.Entry entry = (Map.Entry)it.next();  
              String key = (String)entry.getKey();  
              String value = (String)entry.getValue();  
              if ("attach".equalsIgnoreCase(key)||"body".equalsIgnoreCase(key)||"sign".equalsIgnoreCase(key)) {  
                  sb.append("<"+key+">"+"<![CDATA["+value+"]]></"+key+">");  
              }else {  
                  sb.append("<"+key+">"+value+"</"+key+">");  
              }  
          }  
          sb.append("</xml>");  
          return sb.toString();  
      }
	
	// 请求方法
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {  
          try {  
               
              URL url = new URL(requestUrl);  
              HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
              
              conn.setDoOutput(true);  
              conn.setDoInput(true);  
              conn.setUseCaches(false);  
			// 设置请求方式（GET/POST）
              conn.setRequestMethod(requestMethod);  
              conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");  
			// 当outputStr不为null时向输出流写数据
              if (null != outputStr) {  
                  OutputStream outputStream = conn.getOutputStream();  
				// 注意编码格式
                  outputStream.write(outputStr.getBytes("UTF-8"));  
                  outputStream.close();  
              }  
			// 从输入流读取返回内容
              InputStream inputStream = conn.getInputStream();  
              InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
              BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
              String str = null;  
              StringBuffer buffer = new StringBuffer();  
              while ((str = bufferedReader.readLine()) != null) {  
                  buffer.append(str);  
              }  
			// 释放资源
              bufferedReader.close();  
              inputStreamReader.close();  
              inputStream.close();  
              inputStream = null;  
              conn.disconnect();  
              return buffer.toString();  
          } catch (ConnectException ce) {  
			System.out.println("连接超时：{}" + ce);
          } catch (Exception e) {  
			System.out.println("https请求异常：{}" + e);
          }  
          return null;  
      }
    
	// xml解析
//    public static Map doXMLParse(String strxml) throws JDOMException, IOException {  
//          strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");  
//
//          if(null == strxml || "".equals(strxml)) {  
//              return null;  
//          }  
//            
//          Map m = new HashMap();  
//            
//          InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));  
//          SAXBuilder builder = new SAXBuilder();  
//          Document doc = builder.build(in);  
//          Element root = doc.getRootElement();  
//          List list = root.getChildren();  
//          Iterator it = list.iterator();  
//          while(it.hasNext()) {  
//              Element e = (Element) it.next();  
//              String k = e.getName();  
//              String v = "";  
//              List children = e.getChildren();  
//              if(children.isEmpty()) {  
//                  v = e.getTextNormalize();  
//              } else {  
//                  v = getChildrenText(children);  
//              }  
//                
//              m.put(k, v);  
//          }  
//            
	// //关闭流
//          in.close();  
//            
//          return m;  
//      }  
//      
//    public static String getChildrenText(List children) {  
//          StringBuffer sb = new StringBuffer();  
//          if(!children.isEmpty()) {  
//              Iterator it = children.iterator();  
//              while(it.hasNext()) {  
//                  Element e = (Element) it.next();  
//                  String name = e.getName();  
//                  String value = e.getTextNormalize();  
//                  List list = e.getChildren();  
//                  sb.append("<" + name + ">");  
//                  if(!list.isEmpty()) {  
//                      sb.append(getChildrenText(list));  
//                  }  
//                  sb.append(value);  
//                  sb.append("</" + name + ">");  
//              }  
//          }  
//            
//          return sb.toString();  
//      }
    
	// 随机字符串生成
	public static String getRandomString(int length) { // length表示生成字符串的长度
           String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";         
           Random random = new Random();         
           StringBuffer sb = new StringBuffer();         
           for (int i = 0; i < length; i++) {         
               int number = random.nextInt(base.length());         
               sb.append(base.charAt(number));         
           }         
           return sb.toString();         
    }
	
	/**
     * 获取访问用户的客户端IP（适用于公网与局域网）.
     */
    public static final String getIpAddr(final HttpServletRequest request)
            throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }
     
        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }
     
        return ipString;
    }
    
    public static String getStrFromStr(String str){
        return str.replaceAll("\\d+","");
    }
    
    public static String getNumberFromStr(String c1){
    	char[] cc;
		cc = c1.toCharArray();
		c1 = c1.trim();
		String c11 = "";
		if (c1 != null && !"".equals(c1)) {
			for (int i = 0; i < c1.length(); i++) {
				if (c1.charAt(i) >= 48 && c1.charAt(i) <= 57) {
					c11 += c1.charAt(i);
				}
			}
		}
		return c11;
    }
}
