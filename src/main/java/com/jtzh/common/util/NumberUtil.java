package com.jtzh.common.util;

import java.util.Calendar;

public class NumberUtil {
	public static String getNumber() {
		String number = String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
				+ String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1)
				+ String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
				+ String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
				+ String.valueOf(Calendar.getInstance().get(Calendar.MINUTE))
				+ String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
		return number;
	}
	public static void main(String args[]) {
		String phone = "17712659161";  //11位置
		String pwd = phone.substring(5, phone.length());
		System.out.println(pwd+"---"+phone.length());
	}
	public static String getPwdByPhone(String phone){
		return phone.substring(5, phone.length());
	}
}
