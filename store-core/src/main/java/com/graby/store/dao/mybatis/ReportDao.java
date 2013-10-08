package com.graby.store.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.graby.store.base.MyBatisRepository;

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
	List<Map<String, Object>> sumUserSellouts(long userId, String from, String to);

}
