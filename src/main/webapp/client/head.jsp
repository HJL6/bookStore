<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td style="text-align:right">
				<img src="${pageContext.request.contextPath}/client/images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />&nbsp;<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>
				| <a href="${pageContext.request.contextPath}/client/user/myAccount">我的帐户</a>
				| <a href="${pageContext.request.contextPath}/client/register.jsp">新用户注册</a>
				| <a href="${pageContext.request.contextPath}/admin/login/login">后台登录</a>
<%-- 				<br><br><br>欢迎您： ${user.username} --%>
			</td>
		</tr>

	</table>
</div>
