<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>我的空间</title>
	<link rel="stylesheet" type="text/css" href="/css/public_Nav.css">
	<script src="/js/jquery.js"></script>
	<script src="/js/person.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/person.css">
	<link rel="stylesheet" type="text/css" href="/layui-v2.4.5/layui/css/layui.css" media="all">
</head>
<body>
<!-- 导航栏 -->
<div id="nav">
	<jsp:include page="nav.jsp"></jsp:include>
</div>
	<!-- 主体内容 -->
	<div class="main">
		<!-- 左侧功能栏 -->
		<div class="main_left">
			<span class="left_tx"><!-- 头像 -->
                <img src="image/twodogsun.jpeg">
            </span>
            <span class="gh_tx">点击更换头像</span>
			<ul class="left_function">
				<li><a href="#" class="kongJian" >空间主页</a></li>
				<li><a href="#" class="xiuGai" >修改信息</a></li>
				<li><a href="#" class="xiangMu" >我的项目</a></li>
				<li><a href="#" class="miMa" >修改密码</a></li>
				<c:if test="${user.userLv>0}">
				<li><a href="#" class="shenHe" >项目审核</a></li>
				<li><a href="#" class="tJfenlei" >添加分类</a></li>
				</c:if>
				<%--<li><a href="index.html" >返回主页</a></li>--%>
			</ul>
		</div>
		<div class="main_center">
			<span class="center_title">信息概览</span>
			<div class="center_person">
			<!-- 个人信息 -->
				<div class="person_one">
					<div class="one_title">
						<span>个人信息</span>
						<a class="xiuGai">修改信息 ></a>
					</div>
					<div>
						<ul class="one_left">
							<li>学号</li>
							<li>昵称</li>
							<li>姓名</li>
							<li>班级</li>
						    <li>个人签名</li>
					 	</ul>
						<ul class="one_right">
						    <li><span >${user.stuID}</span></li>
						    <li><span >${user.nickName}</span></li>
						     <li><span >${user.name}</span></li>
						    <li><span >${user.userClass}</span></li>
						    <li><span >${user.personalSign}</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- 个人信息详细页 -->
		<div  class="personal_information">
			<!-- 修改个人信息界面 -->
			<div class="personal_xg">
				<div class="personal_title">
					<span>个人信息修改</span>
				</div>
				<div class="xg_center">
					<ul class="xg_ul">
						<li>
							<span>学号</span>
							<%--<input type="password" placeholder="请输入学号">--%>
							<span>${user.stuID}</span>
						</li>
						<li>
							<span>昵称</span>
							<input id="nickName" type="text" placeholder="请输入昵称" value="${user.nickName}">
						</li>
						<li>
							<span>姓名</span>
							<input id="userName" type="text" placeholder="请输入姓名" value="${user.name}">
						</li>
						<li>
								<span>班级</span>
								<input id="className" type="text" placeholder="请输入班级" value="${user.userClass}">
						</li>
						<li>
							<span>个人签名</span>
							<input id="sign" type="text" placeholder="请输入个人签名" value="${user.personalSign}">
						</li>
						<li id="xgul_lastli">
							<div><input type="button" onclick="updateUser(${user.id})" class="lastli_one" value="提交"/></div>
							
							<div><input type="button"  class="lastli_two" value="重置"/></div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 我的项目详情页 -->
		<div class="myProject">
			<div class="pro_center">
				<div class="pro_title">
					<span>项目管理</span>
				</div>
				<!-- 项目列表 -->
				<div class="pro_lb">
					<ul class="prolb_ul">
						<c:forEach items="${sessionScope.itemLists}" var="item">
						<li>
							<p>${item.iname}</p>
							<span><a href="/itemController/loadBigItem?itemId=${item.id}">查看 </a><a href="">删除 </a></span>
						</li>
					</c:forEach>
					</ul>
				<!-- 翻页按钮 -->
            	<div id="center_bottom">

            	</div>
					<script src="/layui-v2.4.5/layui/layui.js"></script>
					<script >
                        layui.use('laypage', function(){
                            var laypage = layui.laypage;

                            //执行一个laypage实例
                            laypage.render({
                                elem: 'center_bottom'
                                ,count: 100
                                ,first: '首页'
                                ,last: '尾页'
								,theme:'#0009'
                                ,prev: '<em>←</em>'
                                ,next: '<em>→</em>'
                            });
                        });
					</script>
			</div>
		</div>
	</div>
	<!-- 修改密码页面 -->
		<div class="ChangePassword">
			<div class="password_center">
				<div class="pass_title">
					<span>修改密码</span>
				</div>
				<!-- 要提交的数据 -->
				<div class="pass_for">
					<ul class="for_ul">
						<li>
							<span>原密码</span>
							<input id="oldPassword" type="password" placeholder="请输入原密码">
						</li>
						<li>
							<span>新密码</span>
							<input id="newPassword" type="password" placeholder="请输入新密码">
						</li>
						<li>
							<span>确认密码</span>
							<input id="rePassword" type="password" placeholder="请输入确认密码">
						</li>
						<%--<li id="ul_yzli">--%>
							<%--<span>邮箱验证</span>--%>
							<%--<input type="text" placeholder="请输入邮箱验证码">--%>
							<%--<a href="#">点击发送验证码</a>--%>
						<%--</li>--%>
						<li id="ul_lastli">
							<input onclick="changePassword(${user.id})" type="submit" value="修改">
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 项目审核页面 -->
		<div class="Auditing">
			<div class="Auditing_center">
				<div class="aud_title">
					<span>项目审核</span>
				</div>
				<!-- 左侧显示需审核项目 -->
				<div class="aud_left">
					<div class="audleft_title">
						<span class="title_sum">待审核项目&nbsp;<strong>19</strong>&nbsp;件</span>
					</div>
					<ul class="audleft_ul">
						<c:forEach items="${sessionScope.items}" var="item">
						<li onclick="ChangeItem(${item.id},this)" class="leftul_li"><span >${item.iname}</span></li>
						</c:forEach>
					</ul>
					<!-- 翻页列表 -->
					<div class="fy_lb">
						<ul class="fylb_ul">
							<li>1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
							<li>5</li>
						</ul>
					</div>
				</div>
				<!-- 右侧项目详情 -->
				<div class="pro_xq">
					<!-- 项目描述 -->
					<div class="pro_ms">
						<div class="ms_title"><span>项目简述</span></div>
						<div class="ms_center" id="jiansu">
							<c:if test="${not empty sessionScope.items}">
								${sessionScope.items.get(0).itext}
							</c:if>
						</div>
					</div>
	              	<%--<!-- 项目标签 -->--%>
	              	<%--<div class="pro_fl">--%>
						<%--<span class="fl_span">项目分类</span>--%>
					<%--</div>--%>
					<!-- 项目下载 -->
					<%--<div class="pro_xz">--%>
						<%--<span class="xz_span">点此下载</span>--%>
					<%--</div>--%>
					<!-- 按钮 -->
					<div class="pro_but">
						<c:if test="${not empty sessionScope.items}">
						<input type="text" id="itemId" style="display: none" value="${sessionScope.items.get(0).id}">
						</c:if>
						<a class="but_one" onclick="changeItemState(1)">通过</a>
						<a class="but_two" onclick="changeItemState(2)">不通过</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 添加项目分类 -->
			<div class="addfl">
				<!-- 添加项目分类 -->
				<div class="add_center">
					<span class="addcenter_title">项目分类添加</span>
					<div class="addcenter_fl">
						<input type="text" id="fenLeiName"  class="addinput" placeholder="请输入你要添加的分类">
						<span class="addSpan" onclick="addAssortment()">添加</span>
					</div>
				</div>
				<!-- 删除项目分类 -->
				<div class="delete_center">
					<span class="delete_title">项目分类删除</span>
					<div class="delete_fl">
						<span class="span_one">选择你要删除的分类</span>
						<select name="profl" id="pro_xlk">
							<option value="default">请选择</option>
							<c:forEach items="${assortments}" var="name">
								<option value="${name.id}">${name.fName}</option>
							</c:forEach>
						</select>
						<span onclick="delAssortment()" class="span_two">删除</span>
					</div>
				</div>
			</div>
	</div>
</body>
</html>