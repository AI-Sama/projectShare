<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/css/public_Nav.css">
	<link rel="stylesheet" type="text/css" href="/css/proShow.css">
	<script src="/js/jquery.js"></script>
</head>
<body>
	<!-- 导航栏 -->
	<div id="nav">
		<jsp:include page="nav.jsp"></jsp:include>
	</div>
	<!-- 主体部分 -->
	<div class="pro_title">
		<!-- 项目名称 -->
		<span class="title_font">${item.iname}</span>
		<!-- 项目信息 -->
		<div class="infor">
			<span class="infor_name">&ensp;${item.user.nickName}</span>
			<%--<span class="infor_type">&ensp;</span>--%>
			<span class="infor_time">&ensp;<fmt:formatDate value="${item.upTime}" type="date"></fmt:formatDate></span>
		</div>
	</div>
	<!-- 项目主体 -->
	<div class="pro_main">
		<!-- 项目介绍 -->
		<div class="pro_js">
			<span class="js_title">项目简述</span><br>
			<div class="js_char">
				${item.itext}
			</div>
		</div>
		<div class="rule_xz">
			<div class="pro_xz">
				<span class="xz_ico"></span>
				<a href="#" class="xz_button">项目下载</a>
			</div>
		</div>
	</div>
	<!-- 留言评论区域 -->
	<div class="pro_comment">
		
	</div>
</body>
</html>