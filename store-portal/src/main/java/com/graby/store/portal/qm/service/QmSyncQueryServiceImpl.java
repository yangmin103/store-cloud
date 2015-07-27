package com.graby.store.portal.qm.service;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.graby.store.portal.qm.util.HttpClientUtils;

@Component
public class QmSyncQueryServiceImpl implements QmSyncQueryService {

	/**
	 * 自测数据
	 */
	private String appKey = "1023012748";
	private String customerId = "c1437381455454";
	
	private String qmUrl="";
	private String sign="abc";
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 获取请求奇门URL
	 * @param method
	 * @return
	 */
	private String getQmUrl(String method){
		StringBuilder urlStr=new StringBuilder();
		urlStr.append("http://qimen.api.taobao.com/router/qimen/service?method=")
			.append(method)
			.append("&timestamp=")
			.append(this.sdf.format(new Date()))
			.append("&format=xml&app_key=")
			.append(appKey)
			.append("&v=1.0&sign=")
			.append(sign)
			.append("&sign_method=md5&customerId=")
			.append(customerId);
		return urlStr.toString();
	}
	/**
	 * 提交奇门的发送请求
	 * @param xmlStr XML格式的参数体
	 * @param method 调用方法
	 * @return
	 */
	public String submitQm(String xmlStr,String method){
		String url=this.getQmUrl(method);
		String requestUrl=URLEncoder.encode(url);
		String resultStr="";
		try{
			resultStr=HttpClientUtils.httpPost(requestUrl, xmlStr);
		}catch(Exception e){
			e.printStackTrace();
			resultStr="";
		}
		/**
		 * 这里对结果进行判断处理，返回想要的数据或map
		 */
		return resultStr;
	}
	/**
	 * 发货单缺货通知业务组装
	 */
	@Override
	public String itemlackReport(String jsonStr) {
		if(jsonStr==null || jsonStr.length()==0){
			return "通知数据为空!";
		}
		return null;
	}
	
	
	
	
}
