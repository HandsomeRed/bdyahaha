package com.bd.dao;

import java.util.List;


public interface 占位 {
	
	// 添加订单明细
	public void addOrderDetail();
	
	// 通过id获取订单明细
	public List getOrderDetailById(int id);
	
}
