package com.chinesedreamer.toolkit.excel.schema.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.chinesedreamer.toolkit.excel.schema.bean.ExcelTitleConfiguration;

/**
 * Description:
 * 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午9:40:25 Copyright: Copyright (c)2015
 */
public class ExcelTitleBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	protected Class<ExcelTitleConfiguration> getBeanClass(Element element) {
		return ExcelTitleConfiguration.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String column = element.getAttribute("column");
		if (StringUtils.hasText(column)) {
			bean.addPropertyValue("column",Integer.valueOf(column));
		}
		
		String row = element.getAttribute("row");
		if (StringUtils.hasText(row)) {
			bean.addPropertyValue("row",Integer.valueOf(row));
		}
		
		String targetProperty = element.getAttribute("targetProperty");
		if (StringUtils.hasText(targetProperty)) {
			bean.addPropertyValue("targetProperty",targetProperty);
		}
		
		String typeHandler = element.getAttribute("typeHandler");
		if (StringUtils.hasText(typeHandler)) {
			bean.addPropertyValue("typeHandler",typeHandler);
		}
	}
}
