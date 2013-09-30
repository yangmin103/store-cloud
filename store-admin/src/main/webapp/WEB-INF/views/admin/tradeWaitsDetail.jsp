<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="e" uri="http://www.wlpost.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<script type="text/javascript">
	
	$(function() {
		// 全选事件
	   	$("#checkAll").click(function() {
	   		if($(this).attr("checked") == "checked") {
	   			$("input[name='trade_select[]']").each(function() {
	            	$(this).attr("checked", true);
	        	});
	   		} else {
	   			$("input[name='trade_select[]']").each(function() {
	            	$(this).attr("checked", false);
	        	});
	   		}
		});
	});
	
	$(document).ready(function() {
		// 打开淘宝商品列表关联
		$("a[data-toggle=modal]").click(function(){
			//postSelected();
		});	
		
		$('#confirm').confirm({
			'title' : '删除',
			'message' : '确认删除该商品',
		});			
	});
	
	function postSelected() {
		var expressId = $('#expressCompany').val();
	   	var chk_value =[];  
	  		$('input[name="trade_select[]"]:checked').each(function(){  
	   		chk_value.push($(this).val());
  		});  
  		if (chk_value.length==0) {
  			//alert('你还没有选择任何订单！');
  		} else {
  			// 分段发送至仓库
  			var arr = new Array();
  			var size=200;
  			for(var i = 1, len = chk_value.length; i<= len; i++) {
  				arr.push(chk_value[i-1]);
  				if (i%size == 0 ) {
  					auditTrade(arr, expressId);
  					arr=[];
  				} else if (i == len) {
  					auditTrade(arr, expressId);
  				}
 			}
  		}
	}

	// 审核		
	function auditTrade(tradeIds, express) {
 		var action = "${ctx}/trade/mkships?tradeIds=" + tradeIds + "&expressCompany=" + express;
	   	$.post(action, function(data){
			//$('#myModal').modal('hide')；
		   	$("#body").html(data);
	   	});
	}
	
	</script>
</head>
<body id="body">
	
	<table id="contentTable" class="table table-striped table-condensed"  >
		<thead><tr>
		<th>来源商铺</th>
		<th>建单时间</th>
		<th>交易订单号</th>
		<th>收货地址</th>
		<th>订购商品</th>
		<th>备注</th>	
		<th><input type="checkbox" id="checkAll" name="checkAll"/> 全选</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${trades}" var="trade">
			<c:if test="${trade.id != null}">
			<tr>
				<td class="span2">${trade.user.shopName}</td>
				<td class="span2"><fmt:formatDate value="${trade.payTime}" type="date" pattern="yyyy-MM-dd HH:mm"/> </td>
				<td class="span2">${trade.tradeFrom}</td>
				<td class="span3">${trade.receiverState} ${trade.receiverCity} ${trade.receiverDistrict} <br>
				 	${trade.receiverAddress}
				</td>
				<td class="span3">${trade.itemTitles}
				</td>			
				<td>
					买家：${trade.buyerMemo} ${trade.buyerMessage} <br>
					卖家：${trade.sellerMemo}
				</td>
				<td>
					<input type='checkbox' id='trade_select' name='trade_select[]' value='${trade.id}' />
				</td>
			</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="row">
	  	<div class="pull-right">
	  		<a class="btn btn-primary" data-toggle="modal" href="#myModal" >批量审核</a>
	  		<a id="btn_pick" href="#" class="btn btn-info">批量删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
	  	</div>
	</div>
	
	<div class="modal hide fade" id="myModal">
 		<div class="modal-header">
    		<a class="close" data-dismiss="modal">×</a>
    		<h3>批量审核订单</h3>
  		</div>
  		<div class="modal-body">
    		<p>
    		<span id="tids"></span>
            运输公司：
            <select name="expressCompany" id="expressCompany">
		    	<option value="-1">未选择</option>
		    	<c:forEach items="${expressCompanys}" var="e">
		    		<option value="${e.key}">${e.value}</option>
		    	</c:forEach>
		    </select>
		    </p>
  		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">关闭</a>
	    	<a href="javascript:postSelected();" class="btn btn-primary">审核通过</a>
	  	</div>
	</div>
	
</body>
</html>
