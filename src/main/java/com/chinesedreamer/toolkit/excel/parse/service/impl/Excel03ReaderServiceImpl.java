package com.chinesedreamer.toolkit.excel.parse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinesedreamer.toolkit.excel.parse.entity.Excel;
import com.chinesedreamer.toolkit.excel.parse.service.ExcelReaderService;
import com.chinesedreamer.toolkit.excel.schema.bean.AbstractExcelProcesserConfiguration;
import com.chinesedreamer.toolkit.excel.schema.bean.ExcelProcesserConfiguration;
import com.chinesedreamer.toolkit.excel.schema.bean.ExcelTitleConfiguration;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午9:44:19 
 * Copyright:   Copyright (c)2015
 */
public class Excel03ReaderServiceImpl implements ExcelReaderService{

	@Override
	public Object readExcel(Excel excel,
			AbstractExcelProcesserConfiguration configuration) {
		if (configuration instanceof ExcelProcesserConfiguration) {
			return this.readExcelProcesserConfiguration(excel, (ExcelProcesserConfiguration)configuration);
		}
		return null;
	}
	
	/**
	 * 解析参数类型为ExcelProcesserConfiguration的文件
	 * @param excel
	 * @param configuration
	 * @return
	 */
	private Object readExcelProcesserConfiguration(Excel excel,ExcelProcesserConfiguration configuration) {
		//1. 获取title column对应的property
		Map<Integer, ExcelTitleConfiguration> titleMap = this.getTitleMap(configuration);
		//2. 逐行格封装参数 TODO
		String modelClass = configuration.getTargetEntity();
		try {
			Object model = Class.forName(modelClass).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block logback
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取列对应的property和handler
	 * @param configuration
	 * @return
	 */
	private Map<Integer, ExcelTitleConfiguration> getTitleMap(ExcelProcesserConfiguration configuration) {
		Map<Integer, ExcelTitleConfiguration> titleMap = new HashMap<Integer, ExcelTitleConfiguration>();
		for (ExcelTitleConfiguration titleConfiguration : configuration.getTitleConfigurations()) {
			titleMap.put(titleConfiguration.getColumn(), titleConfiguration);
		}
		return titleMap;
	}
}
