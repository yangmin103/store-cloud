package com.graby.store.portal.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graby.store.cache.Cache;
import com.graby.store.service.base.AuthService;
import com.graby.store.util.EncryptUtil;
import com.graby.store.web.auth.ShiroContextUtils;
import com.graby.store.web.top.TopApi;
import com.graby.store.web.top.wms.WmsSessionUtils;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Shop;
import com.taobao.api.internal.util.WebUtils;

@Controller
@Component
@RequestMapping(value = "/")
public class TopAuthController {

	@Value("${top.appkey}")
	private String clientId = "23018428";

	@Value("${top.appSecret}")
	private String clientSecret = "f2e7f709ff1a05f6e09745612a048a61";
	
	@Value("${top.oauth.token}")
	private String tokenUrl = "https://oauth.taobao.com/token";
	
	@Value("${top.oauth.redirect_uri}")
	private String redirectUri = "http://www.wlpost.com/top_oauth";
	
	@Value("${top_wms.appkey}")
	private String wmsClientId = "23012748";

	@Value("${top_wms.appSecret}")
	private String wmsClientSecret = "1ef1ff93070d9be52f3bdd05adc10a02";
	
	@Value("${top_wms.oauth.redirect_uri}")
	private String wmsRedirectUri = "http://www.wlpost.com/top_oauth";

	@Autowired
	private Cache<String, String> userCache;

	@Autowired
	private TopApi topApi;

	@Autowired
	private AuthService userService;

	/**
	 * 老的方式
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "top_auth")
	public String auth(HttpServletRequest request, HttpServletResponse response, Model model) throws ApiException {
		String sessionKey = request.getParameter("top_session");
		if (sessionKey != null) {
			String nickName = topApi.getNick(sessionKey);
			Shop shop = topApi.getShop(nickName);
			// 同步淘宝用户, 密码为用户名
			userService.addUserIfNecessary(nickName, shop.getTitle());
			userCache.put(nickName, sessionKey);
			model.addAttribute("username", nickName);
			model.addAttribute("password", EncryptUtil.md5(nickName));
			ShiroContextUtils.logout();
		}
		return "auth/post";
	}

	/**
	 * OAuth2方式
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "top_oauth")
	public String oauth(HttpServletRequest request, HttpServletResponse response, Model model) throws ApiException,
			IOException {
		String error = request.getParameter("error");
		if (StringUtils.isNotBlank(error)) {
			String error_description = request.getParameter("error_description");
			System.out.println(error_description);
		}
		String code = request.getParameter("code");
		model.addAttribute("code", code);
		Map<String, String> params = new HashMap<String, String>();
		params.put("code", code);
		params.put("client_id", clientId);
		params.put("client_secret", clientSecret);
		params.put("grant_type", "authorization_code");
		params.put("redirect_uri", redirectUri);
		String json = WebUtils.doPost(tokenUrl, params, 1000, 1000);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> value = mapper.readValue(json, Map.class);
		String sessionKey = value.get("access_token");
		String nick = URLDecoder.decode(value.get("taobao_user_nick"), "UTF-8");
		if (nick.equals("商家测试帐号17")) {
			// 过滤
			model.addAttribute("username", nick);
			model.addAttribute("password", EncryptUtil.md5(nick));
		} else if (sessionKey != null) {
			Shop shop = topApi.getShop(nick);
			// 同步淘宝用户, 密码为用户名
			userService.addUserIfNecessary(nick, shop.getTitle());
			userCache.put(nick, sessionKey);
			model.addAttribute("username", nick);
			model.addAttribute("password", EncryptUtil.md5(nick));
			ShiroContextUtils.logout();
		}
		return "auth/post";
	}
	
	/**
	 * wms 模块认证
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "top_oauth_wms")
	public String oauth4wms(HttpServletRequest request, HttpServletResponse response, Model model) throws ApiException,
			IOException {
		String error = request.getParameter("error");
		if (StringUtils.isNotBlank(error)) {
			String error_description = request.getParameter("error_description");
			System.out.println(error_description);
		}
		String code = request.getParameter("code");
		model.addAttribute("code", code);
		Map<String, String> params = new HashMap<String, String>();
		params.put("code", code);
		params.put("client_id", wmsClientId);
		params.put("client_secret", wmsClientSecret);
		params.put("redirect_uri", wmsRedirectUri);
		params.put("grant_type", "authorization_code");
		String json = WebUtils.doPost(tokenUrl, params, 1000, 1000);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> value = mapper.readValue(json, Map.class);
		String sessionKey = value.get("access_token");
		if (StringUtils.isNotEmpty(sessionKey)) {
			WmsSessionUtils.setSessionKey(sessionKey);
		}
		return "auth/post";
	}

}
