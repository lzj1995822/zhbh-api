/*package com.jtzh.common.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import com.jtzh.entity.YnwUser;

public class InitUser {
	@Test
	public void testReadList() throws Exception {
	    List<YnwUser> list = new ArrayList<YnwUser>();

	    HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("D:/web-info.xls")));

	    HSSFSheet sheet = book.getSheetAt(0);

	    for(int i=2; i<sheet.getLastRowNum()+1; i++) {
	    	YnwUser user = new YnwUser();
	    	HSSFRow row = sheet.getRow(i);
	    	user.setXz(row.getCell(0).getStringCellValue());
	    	user.setCjzmc(row.getCell(1).getStringCellValue());
	    	user.setZdlx(row.getCell(2).getStringCellValue());
	    	user.setJzzt(row.getCell(3).getStringCellValue());
	    	user.setKzfw(row.getCell(4).getStringCellValue());
	    	user.setXxyxm(row.getCell(5).getStringCellValue());
	    	user.setXxyxb(row.getCell(6).getStringCellValue());
	    	user.setXxynl(row.getCell(7).getStringCellValue());
	    	user.setXxyxl(row.getCell(8).getStringCellValue());
	    	user.setXxylxfs(row.getCell(9).getStringCellValue());
	    	user.setCjzdz(row.getCell(10).getStringCellValue());
	    	user.setCjzbh(row.getCell(12).getStringCellValue());
	    	user.setLat(row.getCell(14).getStringCellValue());
	    	user.setLon(row.getCell(15).getStringCellValue());
	    	list.add(user);
	    }
	    System.out.println(list);
	}
}
*/