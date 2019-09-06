package com.jtzh.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtil {

	/**
	 * 导出Excel
	 * 
	 * @param sheetName
	 *            sheet名称
	 * @param title
	 *            标题
	 * @param values
	 *            内容
	 * @param wb
	 *            HSSFWorkbook对象
	 * @return
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		// 声明列对象
		HSSFCell cell = null;

		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}

		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				// 将内容按顺序赋给对应的列对象
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		return wb;
	}

	public static String importByExcelForDate(Cell currentCell) {
		String currentCellValue = "";
		// 判断单元格数据是否是日期
		if ("yyyy/mm;@".equals(currentCell.getCellStyle().getDataFormatString())
				|| "m/d/yy".equals(currentCell.getCellStyle().getDataFormatString())
				|| "yy/m/d".equals(currentCell.getCellStyle().getDataFormatString())
				|| "mm/dd/yy".equals(currentCell.getCellStyle().getDataFormatString())
				|| "dd-mmm-yy".equals(currentCell.getCellStyle().getDataFormatString())
				|| "yyyy/m/d".equals(currentCell.getCellStyle().getDataFormatString())) {
			if (DateUtil.isCellDateFormatted(currentCell)) {
				// 用于转化为日期格式
				Date d = currentCell.getDateCellValue();
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				currentCellValue = formater.format(d);
			}
		} else {
			// 不是日期原值返回
			currentCellValue = currentCell.toString();
		}
		return currentCellValue;
	}

}
