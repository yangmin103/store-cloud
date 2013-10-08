package com.graby.store.portal.report;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.graby.store.dao.mybatis.ReportDao;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ReportTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ReportDao reportDao;
	
	@Test
	public void testRegister() {
		List<Map<String, Object>> result = reportDao.sumUserSellouts(16, "2013-07-06 00:00", "2013-07-06 23:59");
	}
}
