<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
</head>
<body>
	<!-- <p:user /> -->
	<!-- 确认支付form -->
	<form action="${pageContext.request.contextPath}/client/order/pay" method="post">
		<h3>订单号：${order.id},付款金额 ：${order.money }</h3>
		<input type="hidden" name="id" value="${order.id}">
		<input type="hidden" name="money" value="${order.money}">
		<input type="submit" value="确认支付" />
	</form>
</body>
</html>
