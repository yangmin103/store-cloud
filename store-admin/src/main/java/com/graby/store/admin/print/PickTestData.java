package com.graby.store.admin.print;

import java.util.ArrayList;
import java.util.List;

public class PickTestData {
	
	public static List<Pick> geneDatas() {
		List<Pick> picks = new ArrayList<Pick>();
		Pick pick = new Pick();
		pick.setExpressCompany("1顺丰");
		pick.setExpressOrderno("100001200301");
		pick.setReceivedAddress("湖南省 湘潭市 岳塘区 书院路 1023号");
		pick.setReceivedName("李小姐");
		pick.setRemark("红色小一码");
		pick.addDetail(createDetail("100030100", "春季A牛仔裤", "颜色：紫色;适用身高:1.5", 2, ""));
		pick.addDetail(createDetail("100030101", "春季B牛仔裤", "颜色：紫色;适用身高:1.5", 2, ""));
		pick.addDetail(createDetail("100030102", "春季C牛仔裤", "颜色：紫色;适用身高:1.5", 2, ""));
		
		Pick pick2 = new Pick();
		pick2.setExpressCompany("2韵达");
		pick2.setExpressOrderno("200001200302");
		pick2.setReceivedAddress("测试 湖南省 湘潭市 岳塘区 书院路 1023号");
		pick2.setReceivedName("测试 李小姐");
		pick2.setRemark("测试 红色小一码");
		pick2.addDetail(createDetail("200030100", "测试 春季A牛仔裤", "颜色：紫色;适用身高:1.5", 2, ""));
		pick2.addDetail(createDetail("200030101", "测试 春季B牛仔裤", "颜色：紫色;适用身高:1.5", 2, ""));
		pick2.addDetail(createDetail("200030102", "测试  春季C牛仔裤", "颜色：紫色;适用身高:1.5", 2, ""));
		
		picks.add(pick);
		picks.add(pick2);
		return picks;
	}
	
	private static PickDetail createDetail(String code, String title, String sku, int num, String position) {
		PickDetail d = new PickDetail();
		d.setCode(code);
		d.setTitle(title);
		d.setSku(sku);
		d.setNum(num);
		d.setPosition(position);
		return d;
	}
	
}
