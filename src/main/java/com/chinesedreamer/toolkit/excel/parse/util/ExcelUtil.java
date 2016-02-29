package com.chinesedreamer.toolkit.excel.parse.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午11:37:04 
 * Copyright:   Copyright (c)2015
 */
public class ExcelUtil {
	/**
	 * 判断row是否是空行
	 * @param row
	 * @return
	 */
	public static boolean isEmptyRow(Row row) {
		for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			if (null != cell && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 读取cell的值
	 * @param cell
	 * @return
	 */
	public static Object getCellValue(Cell cell, Class<?> clazz) {
		if (cell == null) {
			return null;
		}
		cell.getCellStyle().equals(HSSFCellStyle.)
		return null;
	}
}
