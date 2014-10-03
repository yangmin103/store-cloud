package com.graby.store.web.top.wms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graby.store.base.ServiceException;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.TradeOrderInfo;
import com.taobao.api.domain.WaybillAddress;
import com.taobao.api.domain.WaybillApplyNewInfo;
import com.taobao.api.internal.util.json.JSONErrorListener;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.request.WlbWaybillGetRequest;
import com.taobao.api.response.WlbWaybillGetResponse;

/**
 * 电子面单相关
 * 
 * 
 * @author discolt 2014年10月2日 下午6:17:14
 */
public class TopWmsApi {

	// ----------------- 默认开发环境 ----------------- //

	// 1021395257
	private String appKey = "23018428";

	// sandbox0475ca7f0a4a47a3d5303014e
	private String appSecret = "f2e7f709ff1a05f6e09745612a048a61";

	private String serverUrl = "http://gw.api.taobao.com/router/rest";

	private DefaultTaobaoClient client;

	private String wmsSessionKey;

	public void init() {
		client = new DefaultTaobaoClient(serverUrl, appKey, appSecret, "json");
	}

	public List<WaybillApplyNewInfo> wayBillGet(String cpCode, WaybillAddress address,
			List<TradeOrderInfo> tradeOrderInfos) throws ApiException {
		JSONWriter write = new JSONWriter();
		WlbWaybillGetRequest req = new WlbWaybillGetRequest();
		req.setCpCode(cpCode);
		req.setShippingAddress(write.write(address));
		req.setTradeOrderInfoCols(write.write(tradeOrderInfos));
		req.setTimestamp(new Date().getTime());
		WlbWaybillGetResponse response = client.execute(req, wmsSessionKey);
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
