

function  signIn() {
        var stuName=$("#stuName").val();
        var password=$("#password").val();
        var user={
            stuID:stuName,
            password:password
        }
        $.ajax({
            type:"post",
            contentType:"application/json",
            url:"/userController/signIn",
            dataType:"text",
            data:JSON.stringify(user),
            success:function (result) {
                    alert(result);
                    if(result=="登录成功"){
                        window.location.replace("/itemController/jumpIndex");
                    }
            }
        })
}

function signUp(){
    var nickname=$("#nickName").val();
    var stuid=$("#stuId").val();
    var password=$("#zcPassword").val();
    var repassword=$("#rePassword").val();
    if(nickname.trim().length>6||nickname.trim().length<2){
        alert("昵称在2-6位之间");
        return false;
    }
    if(password.trim().length<6||password.trim().length>10){
        alert("密码在6-10位之间");
        return false;
    }
    if(password!=repassword){
        alert("密码和确认密码不一致");
        return false;
    }
    var user={
        stuID:stuid,
        nickName:nickname,
        password:password
    }
    $.ajax({
        type:"post",
        contentType:"application/json",
        resultType:"text",
        url:"/userController/signUp",
        data:JSON.stringify(user),
        success:function (result) {
            alert(result)
        }
    })
}