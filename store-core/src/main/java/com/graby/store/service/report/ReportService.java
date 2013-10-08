package com.graby.store.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graby.store.dao.mybatis.ReportDao;


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
		return reportDao.sumUserSellouts(userId, from, to);
	}
}
