<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>项目分类展示界面</title>
        <link rel="stylesheet" type="text/css" href="/css/public_Nav.css">
        <link rel="stylesheet" type="text/css" href="/css/xm_Menu.css">
        <link rel="stylesheet" type="text/css" href="/css/classify_center.css">
        <link rel="stylesheet" type="text/css" href="/layui-v2.4.5/layui/css/layui.css" media="all">
         <script src="/js/jquery.js"></script>
        <script src="/js/xm_Menu.js"></script>
    </head>
    <body>
    	<div id="nav">
        <jsp:include page="nav.jsp"></jsp:include>
		</div>
    	<!-- 项目展示主页 -->
    	<div id="main">
    		<!-- 项目分类菜单 -->
    		<div id="main_left">
                <div class="left_cd">
                        <ul class="left_cd">
                            <c:forEach items="${assortments}" var="name">
                                <li class="fenlei" onclick="changeFenlei('${name.id}',this)">${name.fName}</li>
                            </c:forEach>
                        </ul>
                </div>
    		</div>
    		<!-- 项目放置	 -->
    		<div class="main_center">
    			<ul class="center_ul">
                            <c:forEach items="${itemLists}" var="item">
                                <li class="ul_li">
                                        <div class="li_top">
                                            <a href="/itemController/loadBigItem?itemId=${item.id}">
                                                <img src="/imgFile/${item.mainImg}" width="100%">
                                            </a>
                                        </div>
                                        <div class="li_bottom">
                                            <p><span>上传者:</span>${item.user.nickName}</p>
                                            <p><span>&ensp;班级:</span>${item.iname}</p>
                                            <p><span>项目标题:</span>${item.iname}</p>
                                            <div class="thumbup">
                                                <span class="watch_per">${item.lookNum}</span><!-- 浏览人数图片 -->
                                                <span class="thumb_up">${item.goodNum}</span>
                                            </div>
                                        </div>
                                </li>
                            </c:forEach>

    			</ul>
    		</div>
             <!-- 翻页按钮 -->

            <div id="center_bottom">

            </div>
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
                    ,prev: '<em>←</em>'
                    ,next: '<em>→</em>'
                });
            });
        </script>
    </body>
</html>