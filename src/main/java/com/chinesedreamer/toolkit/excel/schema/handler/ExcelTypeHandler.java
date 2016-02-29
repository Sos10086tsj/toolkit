package com.chinesedreamer.toolkit.excel.schema.handler;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午10:41:54 
 * Copyright:   Copyright (c)2015
 */
public interface ExcelTypeHandler {
	public void handle(Workbook workbook, Sheet sheet, Row row, Object model);
}
