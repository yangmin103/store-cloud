package com.graby.store.web.top.wms;

import org.apache.shiro.util.ThreadContext;

public class WmsSessionUtils {

	public static final String WMS_SESSION_KEY = ThreadContext.class.getName() + "_WMS_SESSION_KEY";

	public static boolean isWmsLogined() {
		return getWmsSessionKey() != null;
	}

	public static void setSessionKey(String sessionKey) {
		ThreadContext.put(WMS_SESSION_KEY, sessionKey);
	}

	public static String getWmsSessionKey() {
		return (String) ThreadContext.get(WMS_SESSION_KEY);
	}

}
