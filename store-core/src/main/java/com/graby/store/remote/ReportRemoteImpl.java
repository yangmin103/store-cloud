package com.graby.store.remote;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.graby.store.base.remote.service.RemotingService;
import com.graby.store.service.report.ReportService;

@RemotingService(serviceInterface = ReportRemote.class, serviceUrl = "/report.call")
public class ReportRemoteImpl implements ReportRemote {
	
	@Autowired
	private ReportService reportService;
	
	@Override
	public List<Map<String, Object>> shipCount(Map<String, Object> parameters) {
		return reportService.shipCount(parameters);
	}

}
