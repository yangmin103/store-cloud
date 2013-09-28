<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<script src="${ctx}/static/util/jquery.cityselect.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#city_div").citySelect({
			url:${cityJson},
			prov:"",
			city:"",
			dist:"",
			required:false
		});
		
		$("#call").click(function() {
	   		var action = "${ctx}/trade/ajax/waits?" + 
	   			"userId=" + $("#selectUser").val() + 
	   			"&state=" + $("#selectState").val() +
	   			"&city=" + $("#selectCity").val() +
	   			"&itemTitle=" + $("#itemTitle").val();
	   		htmlobj=$.ajax({
				url:action,
				async:true,
				type:"post",
				success: function(msg) {
	                 $("#content").html(htmlobj.responseText);
	            },
					error: function(XMLHttpRequest, textStatus, errorThrown) {
	           }
			});
		});
	
	});
	
	</script>

</head>
<body>
	<legend></legend>
	<form action="${ctx}/trade/waits/batch">
	    <div class="span3">
		   	<select id="selectUser" name="userId">
			<option value='0'>全部</option> 
			<c:forEach items="${users}" var="user">
				<option value='${user.id}'  
				<c:if test="${user.id == userId}">
					selected='selected'
				</c:if>
				>${user.shopName}</option>
			</c:forEach>
			</select>
		</div>
			
		<div id="city_div" class="span3">
		 	<select id="selectState" name="state" class="prov span4"></select>
			<select id="selectCity" name="city" class="city span4" disabled="disabled"></select>
	   	</div>
	    	
	   	<div class="span3">
	    	<input id="itemTitle" name="itemTitle" type="text" name="itemTitle" placeholder="输入商品名称查询 ...">
	    </div>
	    	
	    <div class="span2">
	    	<a id="call" href="#" class="btn btn-primary">搜索</a>
	    </div>
	</form>
	
	<div>
		<div id="content">
	</div>
	
</body>
</html>