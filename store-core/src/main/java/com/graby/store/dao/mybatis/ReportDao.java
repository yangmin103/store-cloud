package com.graby.store.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.graby.store.base.MyBatisRepository;
import com.graby.store.entity.ShipOrder;

@MyBatisRepository
public interface ReportDao {

	/**
	 * 查询用户卖出的商品统计
	 * 返回
	 * itemName:商品名称
	 * itemCount:售出总数
	 * 
	 * @param userId 用户ID
	 * @param from 起始日期
	 * @param to 结束日期
	 * @return
	 */
	List<Map<String, Object>> sumUserSellouts(Map<String, Object> parameters);
	
	/**
	 * 查询用户发货单
	 * @param parameters
	 * @return
	 */
	List<ShipOrder> findOrderSellout(Map<String, Object> parameters);
	long findOrderSelloutCount(Map<String, Object> parameters);
}
