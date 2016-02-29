package com.chinesedreamer.toolkit.schema;

import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

import com.chinesedreamer.toolkit.excel.parse.util.ExcelUtil;
import com.chinesedreamer.toolkit.excel.schema.handler.ExcelTypeHandler;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月29日 下午7:17:59 
 * Copyright:   Copyright (c)2015
 */
public class DeliveryDateHandler implements ExcelTypeHandler{

	@Override
	public Object handle(Cell cell){
		return ExcelUtil.getCellValue(cell, Date.class);
	}

}
