package com.jtzh.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class TestTime {
	public Map<String,String> getTimes() {
		long current=System.currentTimeMillis();//当前时间毫秒数
		long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
		long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
		String  currentTimeEnd =  new Timestamp(twelve).toString();
		String  currentTimeStart= new Timestamp(zero).toString();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        String firstday, lastday;  
        Calendar cale = Calendar.getInstance();  
        cale.add(Calendar.MONTH, 0);  
        cale.set(Calendar.DAY_OF_MONTH, 1);  
        firstday = format.format(cale.getTime());  
        cale = Calendar.getInstance();  
        cale.add(Calendar.MONTH, 1);  
        cale.set(Calendar.DAY_OF_MONTH, 0);  
        lastday = format.format(cale.getTime());
        int year = cale.get(Calendar.YEAR);
        String yearStart = year + "-01-01 00:00:00";
        String yearEnd = year + "-12-31 59:59:59";
        Map<String,String> map = new HashMap<String,String>();
        map.put("yearStart", yearStart);
        map.put("yearEnd", yearEnd);
        map.put("CurrentTimeStart", currentTimeStart);
        map.put("currentTimeEnd", currentTimeEnd);
        map.put("firstday", firstday);
        map.put("lastday", lastday);
        return map;
	}
	
}
