package com.chinesedreamer.toolkit.excel.parse.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinesedreamer.toolkit.excel.parse.entity.Excel;
import com.chinesedreamer.toolkit.excel.parse.service.ExcelReaderService;
import com.chinesedreamer.toolkit.excel.parse.util.ExcelUtil;
import com.chinesedreamer.toolkit.excel.schema.bean.AbstractExcelProcesserConfiguration;
import com.chinesedreamer.toolkit.excel.schema.bean.ExcelProcesserConfiguration;
import com.chinesedreamer.toolkit.excel.schema.bean.ExcelTitleConfiguration;
import com.chinesedreamer.toolkit.excel.schema.exception.ExcelHandlerNotDefinedException;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午9:44:19 
 * Copyright:   Copyright (c)2015
 */
public class Excel03ReaderServiceImpl implements ExcelReaderService{
	
	private Logger logger = LoggerFactory.getLogger(Excel03ReaderServiceImpl.class);

	@Override
	public List<Object> readExcel(Excel excel,
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
	private List<Object> readExcelProcesserConfiguration(Excel excel,ExcelProcesserConfiguration configuration) {
		//1. 获取title column对应的property
		Map<Integer, ExcelTitleConfiguration> titleMap = this.getTitleMap(configuration);
		//2. 逐行格封装参数
		List<Object> datas = new ArrayList<Object>();
		Workbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(excel.getFile()));
			Sheet sheet = workbook.getSheetAt(configuration.getSheetIndex());
			int rowNum = sheet.getLastRowNum();
			for (int i = configuration.getStartRow(); i < rowNum; i++) {
				//逐行解析数据
				Row row = sheet.getRow(i);
				if (null == row || ExcelUtil.isEmptyRow(row)) {
					continue;
				}
				Object object = this.readRowData(workbook, sheet, row, configuration, titleMap);
				if (null != object) {
					datas.add(object);
				}
			}
			
		} catch (Exception e) {
			this.logger.error("",e);
		}finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					this.logger.error("",e);
				}
			}
		}
		return datas;
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
	
	/**
	 * 解析一行的数据
	 * @param row
	 * @param titleMap
	 * @return
	 */
	private Object readRowData(Workbook workbook, Sheet sheet, Row row,ExcelProcesserConfiguration configuration, Map<Integer, ExcelTitleConfiguration> titleMap) {
		String modelClass = configuration.getTargetEntity();
		try {
			Class<?> clazz = Class.forName(modelClass);
			Object model = clazz.newInstance();
			for (Integer key : titleMap.keySet()) {
				ExcelTitleConfiguration titleConfiguration = titleMap.get(key);
				int columnNum = titleConfiguration.getColumn();
				
				Cell cell = null;
				if (null != titleConfiguration.getRow() && row.getRowNum() != titleConfiguration.getRow()) {//读取非此行数据
					cell = sheet.getRow(titleConfiguration.getRow()).getCell(columnNum);
				}else {
					cell = row.getCell(columnNum);
				}
				
				if (StringUtils.isNotEmpty(titleConfiguration.getTypeHandler())) {//type handler处理
					String handlerClassName = titleConfiguration.getTypeHandler();
					Class<?> handlerClazz = Class.forName(handlerClassName);
					Object handlerClass = handlerClazz.newInstance();
					if (null == handlerClass) {
						throw new ExcelHandlerNotDefinedException("Excel Type Handler:" + handlerClassName + " not defined.");
					}
					Method handlerMethod = handlerClazz.getDeclaredMethod("handle", Workbook.class, Sheet.class, Row.class, Object.class);
					handlerMethod.invoke(handlerClass, workbook, sheet, row, model);
				}else {

					//映射属性
					String propertyName = titleConfiguration.getTargetProperty();
					String setterMethodName = "set" + StringUtils.capitalize(propertyName);
					Field field = clazz.getDeclaredField(propertyName);
					if (null == field) {
						this.logger.error("No property:" + propertyName + " field defined.");
						continue;
					}
					String className = field.getGenericType().toString();
					if (className.equals("class java.lang.String")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, String.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, String.class));
					}else if (className.equals("class java.lang.Integer")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, Integer.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, Integer.class));
					}else if (className.equals("class java.lang.Double")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, Double.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, Double.class));
					}else if (className.equals("class java.lang.Boolean")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, Boolean.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, Boolean.class));
					}else if (className.equals("class java.util.Date")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, Date.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, Date.class));
					}else if (className.equals("class java.lang.Short")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, Short.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, Short.class));
					}else if (className.equals("class java.lang.Long")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, Long.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, Long.class));
					}else if (className.equals("class java.math.BigDecimal")) {
						Method method = clazz.getDeclaredMethod(setterMethodName, BigDecimal.class);
						this.methodInvokd(propertyName, method, model, ExcelUtil.getCellValue(cell, BigDecimal.class));
					}
				}	
			}
			return model;
		} catch (Exception e) {
			this.logger.error("",e);
			return null;
		}
	}
	
	/**
	 * 反射值
	 * @param method
	 * @param object
	 * @param objectValue
	 */
	private void methodInvokd(String propertyName, Method method, Object object, Object objectValue) {
		if (null == method) {
			this.logger.error("No setter method of property:{}" + propertyName);
		}else {
			try {
				method.invoke(object, objectValue);
			} catch (Exception e) {
				this.logger.error("",e);
			}
		}
	}
}
