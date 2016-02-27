package com.chinesedreamer.toolkit.schema.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.chinesedreamer.toolkit.schema.parser.ExcelProcesserBeanDefinitionParser;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午9:37:56 
 * Copyright:   Copyright (c)2015
 */
public class ExcelProcesserNameHandler extends NamespaceHandlerSupport{

	@Override
	public void init() {
		registerBeanDefinitionParser("excelProcesser", new ExcelProcesserBeanDefinitionParser());
	}

}
