package com.chinesedreamer.toolkit.excel.schema.handler;

import org.apache.poi.ss.usermodel.Cell;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午10:41:54 
 * Copyright:   Copyright (c)2015
 */
public interface ExcelTypeHandler {
	public Object handle(Cell cell);
}
