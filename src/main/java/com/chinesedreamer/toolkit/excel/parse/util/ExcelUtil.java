package com.chinesedreamer.toolkit.excel.parse.util;

import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午11:37:04 
 * Copyright:   Copyright (c)2015
 */
public class ExcelUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	
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
		Object value = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			if (clazz.getName().equals("java.lang.Boolean")) {
				value = cell.getBooleanCellValue();
			}else {
				logger.error("Can't convert boolean value to Boolean property.");
			}
			break;
		case Cell.CELL_TYPE_ERROR:
			break;
		case Cell.CELL_TYPE_FORMULA:
			value = convertValue2TargetType(clazz, cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)){
				value = cell.getDateCellValue();
			}else {
				value = convertValue2TargetType(clazz, String.valueOf(cell.getNumericCellValue()));
			}
			break;
		case Cell.CELL_TYPE_STRING:
			value = convertValue2TargetType(clazz, cell.getStringCellValue());
			break;
		default:
			break;
		}
		return value;
	}
	
	private static Object convertValue2TargetType(Class<?> clazz, String tempValue) {
		if (clazz.getName().equals("java.lang.Boolean")) {
			return tempValue;
		}else if (clazz.getName().equals("java.lang.Integer")) {
			return Integer.valueOf(tempValue);
		}else if (clazz.getName().equals("java.lang.Float")) {
			return Float.valueOf(tempValue);
		}else if (clazz.getName().equals("java.lang.Double")) {
			return Double.valueOf(tempValue);
		}else if (clazz.getName().equals("java.lang.Short")) {
			return Short.valueOf(tempValue);
		}else if (clazz.getName().equals("java.lang.Long")) {
			return Long.valueOf(tempValue);
		}else if (clazz.getName().equals("java.lang.BigDecimal")) {
			return new BigDecimal(tempValue);
		}else if (clazz.getName().equals("java.lang.String")) {
			return tempValue;
		}else {
			logger.error("Not supported type of {} for formula cell.", clazz.getName());
			return null;
		}
	}
}
