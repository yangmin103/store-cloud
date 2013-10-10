package com.graby.store.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.graby.store.entity.User;
import com.graby.store.remote.ReportRemote;
import com.graby.store.remote.UserRemote;

@Controller
@RequestMapping(value = "/report")
public class ReportController {

	@Autowired
	private UserRemote userRemote;

	@Autowired
	private ReportRemote reportRemote;

	@RequestMapping(value = "/ship")
	public String ship(Model model) {
		List<User> users = userRemote.findAll();
		model.addAttribute("users", users);
		return "admin/reportShip";
	}
	
	@RequestMapping(value = "/ship/ajax")
	public String ship(
			@RequestParam(value = "userId", defaultValue = "0") Long userId,
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate,
			Model model) {
		
		Map<String, Object> p = new HashMap<String, Object>();
		if (userId > 0) {
			p.put("userId", userId);
		}
		p.put("startDate", startDate);
		p.put("endDate", endDate);
		List<Map<String,Object>> results = reportRemote.shipCount(p);
		model.addAttribute("results", results);
		List<User> users = userRemote.findAll();
		model.addAttribute("users", users);
		
		return "admin/reportShipDetail";
	}

}
