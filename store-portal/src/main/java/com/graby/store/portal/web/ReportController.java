package com.graby.store.portal.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.graby.store.service.report.ReportService;
import com.graby.store.web.auth.ShiroContextUtils;

/**
 * 用户交易
 * 
 * @author huabiao.mahb
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	

	@RequestMapping(value = "/sellout")
	public String sellout() throws Exception {
		return "report/sellout";
	}
	
	
	@RequestMapping(value = "/sellout/ajax/sum")
	public String sellerSums(
			@RequestParam(value = "start") String startDay,
			@RequestParam(value = "end") String endDay,
			Model model) throws Exception {
		Long userId = ShiroContextUtils.getUserid();
		List<Map<String,Object>> result = reportService.sumUserSellouts(userId, startDay, endDay);
		
		long total = 0;
		if (CollectionUtils.isNotEmpty(result)) {
			for (Map<String, Object> map : result) {
				Number sumVal = (Number)map.get("num");
				total += sumVal.longValue();
			}
		}
		model.addAttribute("result", result);
		model.addAttribute("total", total);
		return "report/selloutDetail";
	}

}
