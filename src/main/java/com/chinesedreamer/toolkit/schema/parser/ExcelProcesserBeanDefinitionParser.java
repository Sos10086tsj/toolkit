package com.chinesedreamer.toolkit.schema.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.chinesedreamer.toolkit.schema.bean.ExcelProcesser;

/**
 * Description:
 * 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午9:40:25 Copyright: Copyright (c)2015
 */
public class ExcelProcesserBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	protected Class<ExcelProcesser> getBeanClass(Element element) {
		return ExcelProcesser.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String name = element.getAttribute("name");
		String age = element.getAttribute("age");
		String id = element.getAttribute("id");
		if (StringUtils.hasText(id)) {
			bean.addPropertyValue("id", id);
		}
		if (StringUtils.hasText(name)) {
			bean.addPropertyValue("name", name);
		}
		if (StringUtils.hasText(age)) {
			bean.addPropertyValue("age", Integer.valueOf(age));
		}
	}
}
