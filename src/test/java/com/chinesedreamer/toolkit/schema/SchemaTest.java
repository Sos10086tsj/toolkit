package com.chinesedreamer.toolkit.schema;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinesedreamer.toolkit.schema.bean.ExcelProcesser;

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
		ExcelProcesser ep = (ExcelProcesser)applicationContext.getBean("cutesource");
		System.out.println(ep.getId());  
		System.out.println(ep.getName());  
		System.out.println(ep.getAge()); 
	}
}
