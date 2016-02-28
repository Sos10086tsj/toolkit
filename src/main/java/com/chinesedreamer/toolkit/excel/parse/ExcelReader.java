package com.chinesedreamer.toolkit.excel.parse;

import com.chinesedreamer.toolkit.excel.parse.entity.Excel;
import com.chinesedreamer.toolkit.excel.parse.service.ExcelReadServiceFactory;
import com.chinesedreamer.toolkit.excel.schema.bean.AbstractExcelProcesserConfiguration;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午9:45:23 
 * Copyright:   Copyright (c)2015
 */
public class ExcelReader {
	/**
	 * 解析excel
	 * @param excel
	 * @param configuration
	 * @return
	 */
	public static Object readExcel(Excel excel, AbstractExcelProcesserConfiguration configuration) {
		return ExcelReadServiceFactory.getInstance(excel).readExcel(excel, configuration);
	}
}
