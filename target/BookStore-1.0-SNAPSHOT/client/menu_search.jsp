<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/my.js"></script> --%>
<script type="text/javascript" charset=UTF-8>
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
//鼠标点击搜索框时执行
function my_click(obj, myid){
	//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
	if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
	  document.getElementById(myid).value = '';
	  obj.style.color='#000';
	}
}
//鼠标不聚焦在搜索框时执行
function my_blur(obj, myid){
	//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
	if (document.getElementById(myid).value == ''){
	 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
	 obj.style.color='#999';
 }
}

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
</script>

<div id="divmenu">
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=哲学">哲学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=经济学">经济学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=法学">法学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=教育学">教育学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=文学">文学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=历史学">历史学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=理学">理学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=工学">工学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=农学">农学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=医学">医学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=军事学">军事学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=管理学">管理学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=艺术学">艺术学</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByCategory?category=公共资料">公共资料</a>
	<a href="${pageContext.request.contextPath}/client/product/findProductByName" style="color:#FFFF00">全部商品目录</a>
</div>
<div id="divsearch">
<form action="${pageContext.request.contextPath}/client/product/findProductByName" id="searchform">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td style="text-align:right; padding-right:220px">
				Search
				<input type="text" name="name" class="inputtable" id="textfield" value="${name==null?'请输入书名':name}"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');"/>
				<a href="#">
					<img src="${pageContext.request.contextPath}/client/images/serchbutton.gif" border="0" style="margin-bottom:-4px" onclick="search()"/>
				</a>
			</td>
		</tr>
	</table>
</form>
</div>
