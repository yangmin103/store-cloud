package com.graby.store.web.top;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.graby.store.base.ServiceException;
import com.graby.store.web.auth.ShiroContextUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.TradeOrderInfo;
import com.taobao.api.domain.WaybillAddress;
import com.taobao.api.domain.WaybillApplyNewInfo;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.request.WlbWaybillGetRequest;
import com.taobao.api.response.WlbWaybillGetResponse;

/**
 * 电子面单
 * 
 */
@Component
public class TopWmsApi {

	// ----------------- 默认开发环境 ----------------- //

	@Value("${top_wms.appkey}")
	private String appKey = "23018428";

	@Value("${top_wms.appSecret}")
	private String appSecret = "f2e7f709ff1a05f6e09745612a048a61";

	@Value("${top.serverUrl}")
	private String serverUrl = "http://gw.api.taobao.com/router/rest";

	private DefaultTaobaoClient client;

	@PostConstruct
	public void init() {
		client = new DefaultTaobaoClient(serverUrl, appKey, appSecret, "json");
	}

	public List<WaybillApplyNewInfo> wayBillGet(String cpCode, WaybillAddress address,
			List<TradeOrderInfo> tradeOrderInfos) throws ApiException {
//		JSONWriter write = new JSONWriter();
//		WlbWaybillGetRequest req = new WlbWaybillGetRequest();
//		req.setCpCode(cpCode);
//		req.setShippingAddress(write.write(address));
//		req.setTradeOrderInfoCols(write.write(tradeOrderInfos));
//		req.setTimestamp(new Date().getTime());
		
		WlbWaybillGetRequest req=new WlbWaybillGetRequest();
		req.setTradeOrderInfoCols("[{ \"consignee_address\": { \"address_detail\": \"文一西路969号\",\"area\": \"余杭区\",\"city\": \"杭州市\", \"province\": \"浙江省\"},\"consignee_name\": \"小明\",\"consignee_phone\": \"13512345678\",\"item_name\": \"测试\",\"order_channels_type\": \"TB\",\"trade_order_list\": [\"XXXXXX\"]}]");
		req.setCpCode("SF");
		req.setShippingAddress("{\"province\":\"浙江省\",\"city\":\"杭州市\",\"area\":\"余杭区\",\"address_detail\":\"文一西路969号\"}");
		WlbWaybillGetResponse response = client.execute(req, ShiroContextUtils.getWmsSessionKey());
		throwIfError(response);
		return response.getResults();
	}

	private void throwIfError(TaobaoResponse resp) {
		if (StringUtils.isNotEmpty(resp.getErrorCode())) {
			throw new ServiceException(resp.getMsg() + resp.getSubMsg());
		}
	}

	private static JSONWriter write = new JSONWriter(false, true);
	private static String toJsonString(Object object) {
		return write.write(object);
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		WaybillAddress addr = new WaybillAddress();
		addr.setAddressDetail("aaass呵呵  啊啊");
		System.out.println(toJsonString(addr));

	}
}
