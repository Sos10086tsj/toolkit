package com.chinesedreamer.toolkit.excel.parse.service;

import java.util.List;

import com.chinesedreamer.toolkit.excel.parse.entity.Excel;
import com.chinesedreamer.toolkit.excel.schema.bean.AbstractExcelProcesserConfiguration;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午9:38:44 
 * Copyright:   Copyright (c)2015
 */
public interface ExcelReaderService {
	/**
	 * 解析excel，生成配置指定的java 类
	 * @param excel
	 * @param configuration
	 * @return
	 */
	public List<Object> readExcel(Excel excel, AbstractExcelProcesserConfiguration configuration);
}
