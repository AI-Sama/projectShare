<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
    	<!-- 导航栏 -->
    	<div id="nav_pub">
    		<!-- 图标 -->
    		<div class="nav_logo">
    			<i class="ico"></i>
    			<ul class="nav_char">
    				<li style="color: #C7EDCC;">
    					<span></span>
    					<a href="/itemController/jumpIndex">系统首页</a>
    				</li>
    				<li>
    					<span></span>
    					<a href="/itemController/jumpUpItem">上传项目</a>
    				</li>
    				<li>
    					<span></span>
    					<a href="/assortmentController/jumpAssortment">项目展示</a>
    				</li>
    				<li>
    					<span></span>
    					<a href="#">关于我们</a>
    				</li>
    			</ul>
    		</div>
    		<!-- 搜索框 -->
    		<div class="message">
    			<input type="text" name="inq" placeholder="项目、代码" class="inq">
    			<a href="#"></a>
    		</div>
            <!-- 个人界面入口 -->
            <div class="info">
                <span class="info_tx"><!-- 头像 -->
                  <a href="/userController/jumpPersonPage"><img src="/image/nologin.jpg"></a>
                </span>
               <ul class="info_xlk">
                   <li><a href="/userController/jumpPersonPage">个人中心</a></li>
                   <li><a href="/userController/exitLogin">退出登录</a></li>
               </ul>
            </div>
    	</div>