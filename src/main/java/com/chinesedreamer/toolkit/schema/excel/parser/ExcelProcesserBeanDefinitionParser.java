package com.chinesedreamer.toolkit.schema.excel.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import com.chinesedreamer.toolkit.schema.excel.bean.ExcelProcesserConfiguration;
import com.chinesedreamer.toolkit.schema.excel.bean.ExcelTitleConfiguration;

/**
 * Description:
 * 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月27日 上午9:40:25 Copyright: Copyright (c)2015
 */
public class ExcelProcesserBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	protected Class<ExcelProcesserConfiguration> getBeanClass(Element element) {
		return ExcelProcesserConfiguration.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String targetEntity = element.getAttribute("targetEntity");
		String titleRow = element.getAttribute("titleRow");
		if (StringUtils.hasText(targetEntity)) {  
            bean.addPropertyValue("targetEntity", targetEntity);  
        }
		if (StringUtils.hasText(titleRow)) {  
            bean.addPropertyValue("titleRow", Integer.valueOf(titleRow));  
        }
		
		List<ExcelTitleConfiguration> titleConfigurations = new ArrayList<ExcelTitleConfiguration>();
		List<Element> titles = DomUtils.getChildElementsByTagName(element, "title");
		for (Element titleElement : titles) {
			titleConfigurations.add(this.convert2TitleConfiguration(titleElement));
		}
		bean.addPropertyValue("titleConfigurations", titleConfigurations);
	}
	
	private ExcelTitleConfiguration convert2TitleConfiguration(Element titleElement) {
		ExcelTitleConfiguration titleConfiguration = new ExcelTitleConfiguration();
		
		String column = titleElement.getAttribute("column");
		if (StringUtils.hasText(column)) {
			titleConfiguration.setColumn(Integer.valueOf(column));
		}
		
		String row = titleElement.getAttribute("row");
		if (StringUtils.hasText(row)) {
			titleConfiguration.setRow(Integer.valueOf(row));
		}
		
		String targetProperty = titleElement.getAttribute("targetProperty");
		if (StringUtils.hasText(targetProperty)) {
			titleConfiguration.setTargetProperty(targetProperty);
		}
		
		String typeHandler = titleElement.getAttribute("typeHandler");
		if (StringUtils.hasText(typeHandler)) {
			titleConfiguration.setTypeHandler(typeHandler);
		}
		
		return titleConfiguration;
	}
}
