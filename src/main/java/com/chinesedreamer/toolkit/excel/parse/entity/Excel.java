package com.chinesedreamer.toolkit.excel.parse.entity;

import java.io.File;

/** 
 * Description: Excel抽象类
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月28日 上午9:39:42 
 * Copyright:   Copyright (c)2015
 */
public abstract class Excel {
	private String name;
	private File file;
	
	public Excel(File file){
		this.file = file;
		this.name = file.getName();
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	
}
