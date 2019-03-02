var delItemId;
$(document).ready(function (){
    delItemId=$(".leftul_li:first");
    $(".kongJian").click(function(){disPlay("main_center")});
    $(".xiuGai").click(function(){disPlay("personal_information")});
    $(".xiangMu").click(function(){disPlay("myProject")});
    $(".miMa").click(function(){disPlay("ChangePassword")});
    $(".shenHe").click(function(){
        $(".leftul_li:first").css("background","#6668");
        disPlay("Auditing");
    });
    $(".tJfenlei").click(function(){disPlay("addfl")});
});
var classArray=new Array("main_center","personal_information","myProject","ChangePassword","Auditing","addfl");
function disPlay(className){
    for(var i=0;i<classArray.length;i++){
        $("."+classArray[i]).css('display', 'none');
        console.log(i);
    }
    $("."+className).fadeIn(500);
};
function addAssortment() {
        var assortmentName=$("#fenLeiName").val();
        var assortment={
            fName:assortmentName
        }
        $.ajax({
            type:"post",
            data:assortment,
            url:"/assortmentController/addAssortment",
            success:function (result) {
                alert(result);
                $("#fenLeiName").val("");
            }
        })
}
function  delAssortment() {
        var delName=$("#pro_xlk").val();
         var assortment={
          id:delName
         }
    $.ajax({
        type:"post",
        data:assortment,
        url:"/assortmentController/deleteAssortment",
        success:function (result) {
            alert(result);
            $("#pro_xlk").val("default");
        }
    })
}
function ChangeItem(item,obj){
    delItemId=obj;
    $(".leftul_li").css("background","white");
    $(obj).css("background","#6668");
    $.ajax({
        type:"post",
        url:"/userController/changeAuditingItems",
        data:{id:item},
        dataType:"json",
        success:function (result){
                $("#jiansu").html(result.itext);
                $("#itemId").val(result.id);
        }
    });
}
function changeItemState(state) {
    var itemid=$("#itemId").val();
    if(!itemid){
        alert("请先选择一个项目");
        return false;
    }
    var data={
        state:state,
        id:itemid
    }
    $.ajax({
        type:"post",
        url:"/itemController/changeItemState",
        data:data,
        success:function () {
            alert("审核成功");
            $(delItemId).css("display","none");
            $(".ms_center").empty();
            $("#itemId").val(null);
        }
    })
}
function updateUser(userid) {
        var nickName=$("#nickName").val();
        var userName=$("#userName").val();
        var className=$("#className").val();
        var sign=$("#sign").val();
        var user={
            id:userid,
            nickName:nickName,
            name:userName,
            userClass:className,
            personalSign:sign
        }
        $.ajax({
            type:"post",
            url:"/userController/changeUser",
            data:user,
            success:function (result) {
                alert(result);
                window.location.reload();
            }
        })
}
function changePassword(userId) {
    var oldPassword=$("#oldPassword").val();
    var newPassword=$("#newPassword").val();
    var rePassword=$("#rePassword").val();
    if(newPassword.trim().length<6||newPassword.trim().length>10){
        alert("密码在6-10位之间");
        $("#newPassword").val("");
        $("#rePassword").val("");
        return false;
    }
    if(newPassword!=rePassword){
        alert("新密码与确认密码不一致");
        $("#newPassword").val("");
        $("#rePassword").val("");
        return false;
    }
    var user={
        userId:userId,
        oldPassword:oldPassword,
        password:newPassword
    }
    $.ajax({
        type:"post",
        url:"/userController/changePassword",
        data:user,
        success:function (result) {
            alert(result);
            $("#oldPassword").val("");
            $("#newPassword").val("");
            $("#rePassword").val("");
        }
    })
}