package com.graby.store.service.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graby.store.dao.mybatis.ReportDao;
import com.graby.store.entity.ShipOrder;


@Component
@Transactional(readOnly = true)
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
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
	public List<Map<String, Object>> sumUserSellouts(long userId, String from, String to) {
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("userId", userId);
		p.put("startDate",from);
		p.put("endDate", to);
		return reportDao.sumUserSellouts(p);
	}
	

	/**
	 * 查询用户发货单
	 * @param parameters
	 * @return
	 */
	public List<ShipOrder> findOrderSellout(Map<String, Object> parameters) {
		return reportDao.findOrderSellout(parameters);
	}
	
	public long findOrderSelloutCount(Map<String, Object> parameters) {
		return reportDao.findOrderSelloutCount(parameters);
	}
	
	
}