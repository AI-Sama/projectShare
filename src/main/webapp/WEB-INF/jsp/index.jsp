<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>首页</title>
       <link rel="stylesheet" type="text/css" href="/css/page.css">
       <link rel="stylesheet" type="text/css" href="/css/public_Nav.css">
       <link rel="stylesheet" type="text/css" href="/css/page_2.css">
       <script src="/js/jquery.js"></script>
    </head>
    <body>
        <!-- 导航栏 -->
    	<div id="nav">
            <jsp:include page="nav.jsp"></jsp:include>
    	</div>
        <!-- 推荐上传 -->
        <div class="tj_upload">
            <div class="tj_center">
                <p class="tj_top">上传你的项目，</p>
                <p class="tj_bottom">展现你的才华。</p>
            </div>
    
        </div>
    	<!-- 主题部分 -->
    	<div id="main_show" class="main_show">
           <div class="block_title">
                <span>项目展示</span>
            </div>
    		<!-- 渐变背景 -->
    		<div class="main_back"></div>
    		<!-- 图片轮播 -->
            <div id="box" class="box">
    		<div class="image_show">
               <ul>
                   <li><a href=""><img src="/image/back1.jpg"alt=""></a></li>
                   <li><a href=""><img src="/image/back2.jpg" alt=""></a></li>
                   <li><a href=""><img src="/image/back3.jpg" alt=""></a></li>
                   <li><a href=""><img src="/image/back4.jpg" alt=""></a></li>
                   <li><a href=""><img src="/image/login_img.jpg" alt=""></a></li>
               </ul>
                <!-- 右下角切换图片按钮 -->
    			<ul class="click_lb">
    			     
    			</ul>
                <!-- 左右切换的按钮 -->
    			<div id="arr">
                     <span id="left">
                        <
                     </span>
                     <span id="right">
                         >
                     </span>
                </div>
    		</div>
        </div>
    	</div>
        <!-- 技术介绍 -->
        <div class="block">
            <div class="block_center">
                <div class="block_title">
                    <span>技术学习</span>
                </div>
                <!-- 上部分 -->
                <ul class="block_ultop">
                    <li class="ultop_html">
                        <!-- 标题 -->
                        <span>&ensp;HTML+css</span>
                        <!-- 介绍 -->
                        <ul>
                            <li><a href="http://www.w3school.com.cn/html/html_jianjie.asp">HTML 简介</a></li>
                            <li><a href="http://www.w3school.com.cn/html/html_editors.asp">HTML 编辑器</a></li>
                            <li><a href="http://www.w3school.com.cn/html/html_elements.asp">HTML 元素</a></li>
                            <li><a href="http://www.w3school.com.cn/html/html_attributes.asp">HTML 属性</a></li>
                            <li><a href="http://www.w3school.com.cn/css3/css3_intro.asp">CSS3 简介</a></li>
                            <li><a href="http://www.w3school.com.cn/css3/css3_transition.asp">CSS3 过渡</a></li>
                            <li><a href="http://www.w3school.com.cn/css3/css3_animation.asp">CSS3 动画</a></li>
                            <li><a href="http://www.w3school.com.cn/cssref/index.asp">CSS 参考手册</a></li>
                            <li><span><a href="http://www.w3school.com.cn/h.asp">了解更多</a></span></li>
                        </ul>
                    </li>
                    <li class="ultop_js">
                        <span>&ensp;JS+JQ</span>
                        <ul>
                            <li><a href="http://www.w3school.com.cn/js/js_intro.asp">JavaScript 简介</a></li>
                            <li><a href="http://www.w3school.com.cn/js/js_howto.asp">JavaScript 使用</a></li>
                            <li><a href="http://www.w3school.com.cn/js/js_statements.asp">JavaScript 语句</a></li>
                            <li><a href="http://www.w3school.com.cn/js/js_obj_intro.asp">JavaScript 对象</a></li>
                            <li><a href="http://www.w3school.com.cn/js/js_functions.asp">JavaScript 函数</a></li>
                            <li><a href="http://www.w3school.com.cn/js/js_htmldom.asp">JavaScript HTML DOM</a></li>
                            <li><a href="http://www.w3school.com.cn/js/js_library_jquery.asp">JavaScript - 测试 jQuery</a></li>
                            <li><a href="http://www.w3school.com.cn/js/index_pro.asp">JavaScript 高级教程</a></li>
                            <li><span><a href="http://www.w3school.com.cn/b.asp">了解更多</a></span></li>
                        </ul>
                    </li>
                    <li class="ultop_and">
                        <span>&ensp;Android</span>
                        <ul>
                            <li><a href="http://www.runoob.com/android/android-overview.html">Android 概述</a></li>
                            <li><a href="http://www.runoob.com/android/android-architecture.html">Android 架构</a></li>
                            <li><a href="http://www.runoob.com/android/android-application-components.html">Android 应用程序组件</a></li>
                            <li><a href="http://www.runoob.com/android/android-acitivities.html">Android 活动</a></li>
                            <li><a href="http://www.runoob.com/android/android-services.html">Android 服务</a></li>
                            <li><a href="http://www.runoob.com/android/android-broadcast-receivers.html">Android 广播接收器</a></li>
                            <li><a href="http://www.runoob.com/android/android-content-providers.html">Android - 内容提供者</a></li>
                            <li><a href="http://www.runoob.com/android/android-fragment.html">Android 碎片</a></li>
                            <li><span><a href="http://www.runoob.com/android/android-tutorial.html">了解更多</a></span></li>
                        </ul>
                    </li>
                </ul>
                <!--  下部分 -->
                <ul class="block_ulbottom">
                    <li class="ulbottom_java">
                        <span>&ensp;JAVA</span>
                        <ul>
                            <li><a href="http://www.runoob.com/java/java-intro.html">Java 简介</a></li>
                            <li><a href="http://www.runoob.com/java/java-basic-syntax.html">Java 基础语法</a></li>
                            <li><a href="http://www.runoob.com/java/java-object-classes.html">Java 对象和类</a></li>
                            <li><a href="http://www.runoob.com/java/java-basic-datatypes.html">Java 基本数据类型</a></li>
                            <li><a href="http://www.runoob.com/java/java-loop.html">Java 循环结构</a></li>
                            <li><a href="http://www.runoob.com/java/java-array.html">Java 数组</a></li>
                            <li><a href="http://www.runoob.com/java/java-methods.html">Java 方法</a></li>
                            <li><a href="http://www.runoob.com/java/java-inheritance.html">继承的概念</a></li>
                            <li><span><a href="http://www.runoob.com/java/java-tutorial.html">了解更多</a></span></li>
                        </ul>
                    </li>
                    <li class="ulbottom_c">
                        <span>&ensp;C</span>
                        <ul>
                            <li><a href="http://www.runoob.com/cprogramming/c-intro.html">C 简介</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-program-structure.html">C 程序结构</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-basic-syntax.html">C 基本语法</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-data-types.html">C 数据类型</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-variables.html">C 变量</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-loops.html">C 循环</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-arrays.html">C 数组</a></li>
                            <li><a href="http://www.runoob.com/cprogramming/c-pointers.html">C 指针</a></li>
                            <li><span><a href="http://www.runoob.com/cprogramming/c-tutorial.html">了解更多</a></span></li>
                        </ul>
                    </li>
                    <li class="ulbottom_expand">
                        <div class="expand_center">
                            <a href="http://www.baidu.com">更多技术，等你自己去探索</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    <script type="text/javascript">
        function my(id) {
        return document.getElementById(id);
    }
 
    //获取各元素，方便操作
    var box=my("box");
    var inner=box.children[0];
    var ulObj=inner.children[0];
    var list=ulObj.children;
    var olObj=inner.children[1];
    var arr=my("arr");
    var imgWidth=inner.offsetWidth;
    var right=my("right");
    var pic=0;
    //根据li个数，创建小按钮
    for(var i=0;i<list.length;i++){
        var liObj=document.createElement("li");
 
        olObj.appendChild(liObj);
        liObj.innerText=(i+1);
        liObj.setAttribute("index",i);
 
        //为按钮注册mouseover事件
        liObj.onmouseover=function () {
            //先清除所有按钮的样式
 
            for (var j=0;j<olObj.children.length;j++){
                olObj.children[j].removeAttribute("class");
            }
            this.className="current";
            pic=this.getAttribute("index");
            animate(ulObj,-pic*imgWidth);
        }
 
    }
 
 
    //设置ol中第一个li有背景颜色
    olObj.children[0].className = "current";
    //克隆一个ul中第一个li,加入到ul的最后=====克隆
    ulObj.appendChild(ulObj.children[0].cloneNode(true));
 
    var timeId=setInterval(onmouseclickHandle,3000);
    //左右焦点实现点击切换图片功能
    box.onmouseover=function () {
        arr.style.display="block";
        clearInterval(timeId);
    };
    box.onmouseout=function () {
        arr.style.display="none";
        timeId=setInterval(onmouseclickHandle,3000);
    };
 
    right.onclick=onmouseclickHandle;
    function onmouseclickHandle() {
        //如果pic的值是5,恰巧是ul中li的个数-1的值,此时页面显示第六个图片,而用户会认为这是第一个图,
        //所以,如果用户再次点击按钮,用户应该看到第二个图片
        if (pic == list.length - 1) {
            //如何从第6个图,跳转到第一个图
            pic = 0;//先设置pic=0
            ulObj.style.left = 0 + "px";//把ul的位置还原成开始的默认位置
        }
        pic++;//立刻设置pic加1,那么此时用户就会看到第二个图片了
        animate(ulObj, -pic * imgWidth);//pic从0的值加1之后,pic的值是1,然后ul移动出去一个图片
        //如果pic==5说明,此时显示第6个图(内容是第一张图片),第一个小按钮有颜色,
        if (pic == list.length - 1) {
            //第五个按钮颜色干掉
            olObj.children[olObj.children.length - 1].className = "";
            //第一个按钮颜色设置上
            olObj.children[0].className = "current";
        } else {
            //干掉所有的小按钮的背景颜色
            for (var i = 0; i < olObj.children.length; i++) {
                olObj.children[i].removeAttribute("class");
            }
            olObj.children[pic].className = "current";
        }
    }
    left.onclick=function () {
        if (pic==0){
            pic=list.length-1;
            ulObj.style.left=-pic*imgWidth+"px";
        }
        pic--;
        animate(ulObj,-pic*imgWidth);
        for (var i = 0; i < olObj.children.length; i++) {
            olObj.children[i].removeAttribute("class");
        }
        //当前的pic索引对应的按钮设置颜色
        olObj.children[pic].className = "current";
    };
 
    //设置任意的一个元素,移动到指定的目标位置
    function animate(element, target) {
        clearInterval(element.timeId);
        //定时器的id值存储到对象的一个属性中
        element.timeId = setInterval(function () {
            //获取元素的当前的位置,数字类型
            var current = element.offsetLeft;
            //每次移动的距离
            var step = 10;
            step = current < target ? step : -step;
            //当前移动到位置
            current += step;
            if (Math.abs(current - target) > Math.abs(step)) {
                element.style.left = current + "px";
            } else {
                //清理定时器
                clearInterval(element.timeId);
                //直接到达目标
                element.style.left = target + "px";
            }
        }, 10);
    }
        </script>
    </body>
</html>