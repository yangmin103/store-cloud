package com.graby.store.remote;

import java.util.List;
import java.util.Map;

public interface ReportRemote {

	/**
	 * 统计发货单
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> shipCount(Map<String, Object> parameters);
}
