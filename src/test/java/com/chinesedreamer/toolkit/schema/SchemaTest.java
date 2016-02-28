package com.chinesedreamer.toolkit.schema;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinesedreamer.toolkit.schema.excel.bean.ExcelProcesserConfiguration;
import com.chinesedreamer.toolkit.schema.excel.bean.ExcelTitleConfiguration;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午9:50:53 
 * Copyright:   Copyright (c)2015
 */
public class SchemaTest {

	@Test
	public void testSchema(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ExcelProcesserTest.xml");
		ExcelProcesserConfiguration ep = (ExcelProcesserConfiguration)applicationContext.getBean("config");
		Assert.assertNotNull(ep);
		System.out.println(ep.toString());
		for (ExcelTitleConfiguration titleConfiguration : ep.getTitleConfigurations()) {
			System.out.println(titleConfiguration.toString());
		}
	}
}
