<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>登录页面</title>
		<link rel="stylesheet" type="text/css" href="/css/login.css">
        <script src="/js/jquery.js"></script>
		<script src="/js/login.js"></script>
    </head>
    <body>
    	<!-- 登录、注册操作域 -->
    	<div class="login_back">
    		<!-- 标题 -->
			<div class="login_title">
				<span class="title_name">项目分享平台</span>
				<div class="login_cz">
					<a href="#" class="cz_one">登录</a>
					<a href="#" class="cz_two">注册</a>
				</div>
				<span class="border_span"></span>
			</div>
			<div id="main">
    		<!-- 登录表单 -->
    		<div class="login_fro">
    			<from class="fro_log">
    				<!-- 学号 -->
    				<div class="log_name">
    					<span>学号</span>
    					<input type="text" id="stuName" name="usename" placeholder="请输入学号" autofocus="autofocus">
    				</div>
    				<!-- 密码 -->
    				<div class="log_pass">
    					<span>密码</span>
    					<input type="password" id="password" name="pass" placeholder="请输入密码">
    				</div>
					<!-- 忘记密码等操作 -->
    				<div class="log_forget">
    					<!-- 记住该账户 -->
    					<input type="checkbox" name="jiZhuuse">记住该账户
    					<!-- 忘记密码 -->
    					<%--<a href="#">忘记密码?</a>--%>
    				</div>
    				<div class="log_button">
    			   <input onclick="signIn()"  type="button" value="登录" name="login">
					</div>
    			</from>
    		</div>
    		<!-- 注册表单 -->
    		<div class="register_fro">
    			<from class="fro_reg">
    				<!-- 昵称 -->
    				<div class="reg_name">
    					<span>昵称</span>
    					<input type="text" id="nickName" name="useNc" placeholder="请创建你的昵称" >
    				</div>
    				<!-- 学号 -->
    				<div class="reg_id">
    					<span>学号</span>
    					<input type="text" id="stuId" name="stuId" placeholder="请输入学号">
    				</div>
					<!-- 密码 -->
    				<div class="reg_pass">
    					<span>密码</span>
    					<input type="password" id="zcPassword" name="passone" placeholder="请输入密码">
    				</div>
    				<!-- 再次输入密码 -->
    				<div class="reg_repass">
    					<span>确认密码</span>
    					<input type="password"  id="rePassword" name="passtwo" placeholder="请再次输入密码">
    				</div>
    				<!-- 提交注册 -->
    				<div class="reg_sub">
    						<input onclick="signUp()" type="submit" value="提交注册">
    					</div>
    			</from>
    		</div>
    	</div>
		</div>
		<script type="text/javascript">
            $(document).ready(function() {
                $(".login_back").css("animation","down 1s ease 0.2s 1 forwards")
                var index=0;
                $(".cz_two").click(function() {
                    if(index==0){
                        $("#main").css("transform",'translate(-450px,0px)');
                        $(".border_span").css("transform",'translate(180px,0px)');
                        index++;
                    }
                });
                $(".cz_one").click(function() {
                    if(index==1){
                        $(".border_span").css("transform",'translate(0px,0px)');
                        $("#main").css("transform",'translate(0px,0px)');
                        index--;
                    }
                });
            });
		</script>
    </body>
</html>