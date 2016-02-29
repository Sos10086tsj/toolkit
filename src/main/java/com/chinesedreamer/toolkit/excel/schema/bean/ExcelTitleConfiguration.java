package com.chinesedreamer.toolkit.excel.schema.bean;
/** 
 * Description: excel title配置，用来确定没列的title和value读取方法
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午10:38:29 
 * Copyright:   Copyright (c)2015
 */
public class ExcelTitleConfiguration extends AbstractTitleConfiguration{
	private int column;//列号
	private String targetProperty;//转换成的目标属性
	private String typeHandler;//扩展的处理方法，必须实现接口 ReadExcelTypeHandler
	
	public int getColumn() {
		return column;
	}

	public String getTargetProperty() {
		return targetProperty;
	}

	public String getTypeHandler() {
		return typeHandler;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setTargetProperty(String targetProperty) {
		this.targetProperty = targetProperty;
	}

	public void setTypeHandler(String typeHandler) {
		this.typeHandler = typeHandler;
	}

	@Override
	public String toString() {
		return "ExcelTitleConfiguration [column=" + column 
				+ ", targetProperty=" + targetProperty + ", typeHandler="
				+ typeHandler + "]";
	}

	
}
