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
	private int titleRow;//title行号，默认同行。如果类名不在同行，通过 ReadExcelTitleConfiguration.row 设置
	private List<ExcelTitleConfiguration> titleConfigurations;
	public String getTargetEntity() {
		return targetEntity;
	}
	public void setTargetEntity(String targetEntity) {
		this.targetEntity = targetEntity;
	}
	public int getTitleRow() {
		return titleRow;
	}
	public void setTitleRow(int titleRow) {
		this.titleRow = titleRow;
	}
	public List<ExcelTitleConfiguration> getTitleConfigurations() {
		return titleConfigurations;
	}
	public void setTitleConfigurations(
			List<ExcelTitleConfiguration> titleConfigurations) {
		this.titleConfigurations = titleConfigurations;
	}
	@Override
	public String toString() {
		return "ExcelProcesserConfiguration [targetEntity=" + targetEntity
				+ ", titleRow=" + titleRow + ", titleConfigurations="
				+ titleConfigurations + "]";
	}
	
	
}
