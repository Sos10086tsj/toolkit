package com.chinesedreamer.toolkit.schema;

import java.util.Date;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2016年2月29日 下午7:16:23 
 * Copyright:   Copyright (c)2015
 */
public class TestModel {
	private String name;//姓名
	private Date deliveryDate;//送达银行时间
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "TestModel [name=" + name + ", deliveryDate=" + deliveryDate
				+ "]";
	}
	
	
}
