<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="UTF-8">
	<title>上传你的项目</title>
	<link rel="stylesheet" type="text/css" href="/css/public_Nav.css">
	<link rel="stylesheet" type="text/css" href="/css/upload.css">
	<link rel="stylesheet" type="text/css" href="/dist/summernote-lite.css">
	<script src="/js/jquery.js"></script>
	<script src="/dist/summernote-lite.js"></script>
	<script src="/js/upLoad.js"></script>
	<script  src="/dist/lang/summernote-zh-CN.js"></script>
</head>
<body>
	<!-- 导航栏 -->
	<div id="nav">
		<jsp:include page="nav.jsp"></jsp:include>
	</div>
	<!-- 上传界面 -->
	<div class="load_main">
		<!-- HTML上传页面 -->
			<div class="html_center">
				<!-- 上传域 -->
				<div class="load_title">
					<span>创建项目</span>
				</div>
				<form action="#" method="post" class="load_for" enctype="multipart/form-data">
					<table>
					<tr>
						<td>项目名称</td>
						<td><input id="itemName" type="text" placeholder="输入项目名称" name="project_name" autofocus></td>
					</tr>
					<tr class="pro_fl">
						<td>项目分类</td>
						<td>
							<select id="itemFl">
								<c:forEach items="${assortments}" var="assortment">
									<option value="${assortment.id}">${assortment.fName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr class="load_file">
						<td>上传项目(压缩包格式)</td>
						<td><input id="itemFile" type="file" required="required"></td>
					</tr>
					<tr class="load_file">
						<td>上传项目主图</td>
						<td><input id="itemImg" type="file" accept="image/*" required="required"></td>
					</tr>
					<div class="sub_button">
						<input onclick="upItem()" type="button" value="提交">
					</div>
				</table>
				</form>
				<div class="note_rq">
					<span class="note_jt">上传截图及项目描述</span>
					<div id="summernote"></div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		$('#summernote').summernote({
        placeholder: '输入你的项目描述.....',
        tabsize: 2,
        height: 450,
        focus:false,
        lang:'zh-CN',
        toolbar:[
            ['style',['style','bold','italic','underline','clear','']],
           // ['font', ['strikethrough']],
            ['fontsize', ['fontsize']],
            ['table', ['table']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['insert',['picture']]
        ],
            callbacks:{
                onImageUpload: function (files,editor,$editable) {
                    sendFile(files[0],editor,$editable );
                }
            }
    });
        function sendFile(files,editor,$editable) {
            // var text = $("#summernote").summernote("code");//获取里面的html文本内容
            // console.log(text);
            var filename=false;
            try{
                filename=file['name'];
            }catch (e) {
                filename=false;
            }
            if(!filename){
                $(".note-alarm").remove();
            }
            //以上代码防止图片在编辑框里的拖拽引发二次上传导致的错误提示

           var data=new FormData();
            data.append("file",files);
            $.ajax({
                data:data,
                type:"post",
                url:"/itemController/upItemImg",
                dataType:'json',
                contentType:false,
                processData:false,
                success:function (url) {
                    var path=url.path;
                    console.log(path);
                    $("#summernote").summernote("insertImage",path);//设置图片回显路径
                },
                error:function () {
                    alert("上传失败");
			}
            })
        }
</script>
</body>
</html>