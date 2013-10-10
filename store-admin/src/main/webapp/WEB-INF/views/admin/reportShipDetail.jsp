<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<body>

<c:if test="${empty results}">
	无库存信息
</c:if>

<c:if test="${not empty results}">
<table id="contentTable" class="table table-striped table-condensed"  >
<thead><tr class="always_top">
	<th>商家</th>
	<th>运单合计</th>
	</tr></thead>
	<tbody>
		<c:forEach items="${results}" var="val">
		<tr>
			<td>${val.shopName}</td>
			<td>${val.num}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>