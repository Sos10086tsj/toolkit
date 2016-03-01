package com.chinesedreamer.toolkit.excel.parse.service;

import com.chinesedreamer.toolkit.excel.parse.entity.Excel;
import com.chinesedreamer.toolkit.excel.parse.entity.Excel03;
import com.chinesedreamer.toolkit.excel.parse.entity.Excel07;
import com.chinesedreamer.toolkit.excel.parse.service.impl.Excel03ReaderServiceImpl;
import com.chinesedreamer.toolkit.excel.parse.service.impl.Excel07ReaderServiceImpl;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午9:46:46 
 * Copyright:   Copyright (c)2015
 */
public class ExcelReadServiceFactory {
	
	private static Excel03ReaderServiceImpl excel03ReaderService = null;
	private static Excel07ReaderServiceImpl excel07ReaderService = null;
	
	
	private static Excel03ReaderServiceImpl getExcel03ReaderService() {
		if (null == excel03ReaderService) {
			excel03ReaderService = new Excel03ReaderServiceImpl();
		}
		return excel03ReaderService;
	}
	
	private static Excel07ReaderServiceImpl getExcel07ReaderService(){
		if (null == excel07ReaderService) {
			excel07ReaderService = new Excel07ReaderServiceImpl();
		}
		return excel07ReaderService;
	}


	public static ExcelReaderService getInstance(Excel excel){
		if (excel instanceof Excel03) {
			return getExcel03ReaderService();
		}else if (excel instanceof Excel07) {
			return getExcel07ReaderService();
		}
		return null;
	}
}
