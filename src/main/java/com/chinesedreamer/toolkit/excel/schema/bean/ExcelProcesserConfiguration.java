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
	private String sheetIndexs;
	private String sheetNames;
	private List<ExcelTitleConfiguration> titleConfigurations;
	
	
	public String getTargetEntity() {
		return targetEntity;
	}


	public int getStartRow() {
		return startRow;
	}


	public String getSheetIndexs() {
		return sheetIndexs;
	}


	public String getSheetNames() {
		return sheetNames;
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


	public void setSheetIndexs(String sheetIndexs) {
		this.sheetIndexs = sheetIndexs;
	}


	public void setSheetNames(String sheetNames) {
		this.sheetNames = sheetNames;
	}


	public void setTitleConfigurations(List<ExcelTitleConfiguration> titleConfigurations) {
		this.titleConfigurations = titleConfigurations;
	}


	@Override
	public String toString() {
		return "ExcelProcesserConfiguration [targetEntity=" + targetEntity + ", startRow=" + startRow + ", sheetIndexs="
				+ sheetIndexs + ", sheetNames=" + sheetNames + ", titleConfigurations=" + titleConfigurations + "]";
	}
	
	
}
