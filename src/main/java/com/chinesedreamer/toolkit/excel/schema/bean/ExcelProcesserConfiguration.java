package com.chinesedreamer.toolkit.excel.schema.bean;

import java.util.List;

/** 
 * Description: 读取excel配置类
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午9:43:32 
 * Copyright:   Copyright (c)2015
 */
public class ExcelProcesserConfiguration extends AbstractExcelProcesserConfiguration{
	
	private String targetEntity;//目标类名
	private int startRow;//开始读取的行号，默认1
	private int sheetIndex;
	private List<ExcelTitleConfiguration> titleConfigurations;
	public String getTargetEntity() {
		return targetEntity;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getSheetIndex() {
		return sheetIndex;
	}
	public List<ExcelTitleConfiguration> getTitleConfigurations() {
		return titleConfigurations;
	}
	public void setTargetEntity(String targetEntity) {
		this.targetEntity = targetEntity;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}
	public void setTitleConfigurations(List<ExcelTitleConfiguration> titleConfigurations) {
		this.titleConfigurations = titleConfigurations;
	}
	@Override
	public String toString() {
		return "ExcelProcesserConfiguration [targetEntity=" + targetEntity + ", startRow=" + startRow + ", sheetIndex="
				+ sheetIndex + ", titleConfigurations=" + titleConfigurations + "]";
	}
	
	
	
}
