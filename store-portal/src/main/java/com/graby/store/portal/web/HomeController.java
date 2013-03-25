package com.graby.store.portal.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taobao.api.ApiException;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping(value = "")
	public String index(HttpServletRequest request, HttpServletResponse response) throws ApiException {
		return "welcome";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome(HttpServletRequest request, HttpServletResponse response) throws ApiException {
		return "welcome";
	}
	
	
}
