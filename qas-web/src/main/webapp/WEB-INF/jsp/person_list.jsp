<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
<title>Spring MVC表单处理</title>
</head>
<body>
	<h2>您拥有以下这些人物信息：</h2>
	<table frame="box" rules="all">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>电话</td>
		</tr>
		<c:if test="${list!= null || fn:length(list) != 0}">
			<c:forEach items="${list}" var="person" begin="0"
				end="${fn:length(list) }">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<c:if test="${person.gender=='0'}">
						<td>男</td>
					</c:if>
					<c:if test="${person.gender=='1'}">
						<td>女</td>
					</c:if>
					<td>${person.age}</td>
					<td>${person.telephone}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<table>
		<tr items="${page}">
			<form method="GET"
				action="${pageContext.request.contextPath}/person/list">
				<td><input type="hidden" name="pageNo" value="1"></td>
				<td><input type="submit" value="首页"></td>
			</form>
			<form method="GET"
				action="${pageContext.request.contextPath}/person/list">
				<td><input type="hidden" name="pageNo" value="${page.prefPage}"></td>
				<td><input type="submit" value="上一页"></td>
			</form>
			<td>当前：第${page.currentPage}页<--></td>
			<td>共：${page.totalPages}页</td>
			<form method="GET"
				action="${pageContext.request.contextPath}/person/list">
				<td><input type="hidden" name="pageNo" value="${page.nextPage}"></td>
				<td><input type="submit" value="下一页"></td>
			</form>
			<form method="GET"
				action="${pageContext.request.contextPath}/person/list">
				<td><input type="hidden" name="pageNo"
					value="${page.totalPages}"></td>
				<td><input type="submit" value="尾页"></td>
			</form>
		</tr>
	</table>
	<form method="GET"
		action="${pageContext.request.contextPath}/person/list">
		<table>
			<tr>
				<td>跳转到第:<input type="text" name="pageNo" size="5" />页
				</td>
				<td><input type="submit" value="确定"></td>
			</tr>
		</table>
	</form>
</body>
</html>
