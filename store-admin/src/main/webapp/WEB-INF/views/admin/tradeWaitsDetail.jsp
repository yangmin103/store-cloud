<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="e" uri="http://www.wlpost.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
</head>
<script type="text/javascript">
	$(function() {
   		// Loading ������
		$('#loadingDiv')
		.hide();
	});
	
	$(document).ready(function() {
	
		$('#loadingDiv').hide();
		
		// ��ㄩ��浜�浠�
	   	$("#selectAll").live('click',function() {
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
		
		// ���寮�娣�瀹����������琛ㄥ�宠��
		$("a[data-toggle=modal]").click(function(){
			var chk_value =[];  
	  		$('input[name="trade_select[]"]:checked').each(function(){  
	   		chk_value.push($(this).val());
	  		});
	  		if (chk_value.length==0) {
	  			alert('浣�杩�娌℃�������╀换浣�璁㈠��锛�');
	  			return;
	  		}
		});	
		
		$('#confirm').confirm({
			'title' : '������',
			'message' : '纭�璁ゅ����よ�ヨ�㈠��',
		});			
	});
	
	function postSelected() {
		var expressId = $('#expressCompany').val();
	   	var chk_value =[];  
	  		$('input[name="trade_select[]"]:checked').each(function(){  
	   		chk_value.push($(this).val());
  		});
  		if (chk_value.length==0) {
  			alert('浣�杩�娌℃�������╀换浣�璁㈠��锛�');
  			return;
  		}
  		auditTrade(chk_value, expressId);
	}

	// 瀹℃��		
	function auditTrade(tradeIds, express) {
		$('#loadingDiv').show();
		$('#myModal').hide();
 		var action = "${ctx}/trade/mkships?tradeIds=" + tradeIds + "&expressCompany=" + express;
 		window.location.href=action;
	   	//$.post(action, function(data){
			//$('#myModal').modal('hide')锛�
		//   	$("#body").html(data);
	   	//});
	}
	
	</script>
<body id="body">
	
	<table id="contentTable" class="table table-striped table-condensed"  >
		<thead><tr>
		<th>��ユ��������</th>
		<th>寤哄����堕��</th>
		<th>浜ゆ��璁㈠�����</th>
		<th class="span3">��惰揣��板��</th>
		<th class="span4">璁㈣喘������</th>
		<th class="span3">澶�娉�</th>	
		<th><input type="checkbox" id="selectAll" name="selectAll"/> ��ㄩ��</th>
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
					涔板�讹��${trade.buyerMemo} ${trade.buyerMessage} <br>
					���瀹讹��${trade.sellerMemo}
				</td>
				<td>
					${trade.id}
					<input type='checkbox' id='trade_select' name='trade_select[]' value='${trade.id}' />
				</td>
			</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="row">
	  	<div class="pull-right">
	  		<a class="btn btn-primary" data-toggle="modal" href="#myModal" >��归��瀹℃��</a>
	  		<!-- 
	  		<a id="btn_pick" href="#" class="btn btn-info">��归��������</a>&nbsp;&nbsp;&nbsp;&nbsp;
	  		 -->
	  	</div>
	</div>
	
	<div class="modal hide fade" id="myModal">
 		<div class="modal-header">
    		<a class="close" data-dismiss="modal">��</a>
    		<h3>��归��瀹℃�歌�㈠��</h3>
  		</div>
  		<div class="modal-body">
    		<p>
    		<span id="tids"></span>
            杩�杈������革��
            <select name="expressCompany" id="expressCompany">
		    	<option value="-1">���������</option>
		    	<c:forEach items="${expressCompanys}" var="e">
		    		<option value="${e.key}">${e.value}</option>
		    	</c:forEach>
		    </select>
		    </p>
  		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">��抽��</a>
	    	<a href="javascript:postSelected();" class="btn btn-primary">瀹℃�搁��杩�</a>
	  	</div>
	</div>
	 
	<div id="loadingDiv" class="hint hide">
		<img src = "${ctx}/static/images/fetch.gif">
	</div>
	
</body>
</html>
