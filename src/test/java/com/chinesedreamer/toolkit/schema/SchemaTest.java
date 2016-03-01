package com.chinesedreamer.toolkit.schema;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.chinesedreamer.toolkit.excel.parse.ExcelReader;
import com.chinesedreamer.toolkit.excel.parse.entity.Excel;
import com.chinesedreamer.toolkit.excel.parse.entity.Excel03;
import com.chinesedreamer.toolkit.excel.parse.entity.Excel07;
import com.chinesedreamer.toolkit.excel.schema.bean.ExcelProcesserConfiguration;

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
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("F:\\projects\\GitHub\\toolkit\\src\\test\\resources\\ExcelProcesserTest.xml");
		//ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ExcelProcesserTest.xml");
		ExcelProcesserConfiguration ep = (ExcelProcesserConfiguration)applicationContext.getBean("config");
		Assert.assertNotNull(ep);
//		Excel excel = new Excel03(new File("C:\\Users\\Paris\\Desktop\\江北（新） - 副本.xls"));
		Excel excel = new Excel07(new File("C:\\Users\\Paris\\Desktop\\江北（新） - 副本.xlsx"));
		List<Object> datas = ExcelReader.readExcel(excel, ep);
		Assert.assertNotNull(datas);
		for (Object object : datas) {
			TestModel tm = (TestModel)object;
			System.out.println(tm);
		}
	}
}
