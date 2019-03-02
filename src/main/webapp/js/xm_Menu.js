/*
* @Author: Fuyuumiai
* @Date:   2018-12-20 23:22:24
* @Last Modified by:   Fuyuumiai
* @Last Modified time: 2018-12-22 22:30:53
*/

'use strict';
 $(document).ready(function() {
       // $(".cdul_li").click(function(e) {
       // 		var lei=$(e.target).attr("id");
     	// 	$("#"+lei+">ul").slideToggle(300);
       //      });
       $(".fenlei:first").css("background","red");
       	});
 
 function changeFenlei(assortID,a) {
     $(".fenlei").css("background","white");
     $(a).css("background","red");
     var data={
         assortmentId:assortID
     }
     $.ajax({
        type:"post",
        data:data,
        url:"/itemController/loadItems",
         dataType:"json",
         success:function (result) {
            $(".center_ul").empty();
            for (var a=0;a<result.length;a++){
                $(".center_ul").append("   <li class=\"ul_li\">\n" +
                    "                                        <div class=\"li_top\">\n" +
                    "                                            <a href=\"/itemController/loadBigItem?itemId="+result[a].id+"\">\n" +
                    "                                                <img src=\"/imgFile/"+result[a].mainImg+"\" width=\"100%\">\n" +
                    "                                            </a>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"li_bottom\">\n" +
                    "                                            <p><span>上传者:</span>"+result[a].user.nickName+"</p>\n" +
                    "                                            <p><span>&ensp;班级:</span>"+result[a].user.userClass+"</p>\n" +
                    "                                            <p><span>项目标题:</span>"+result[a].iname+"</p>\n" +
                    "                                            <div class=\"thumbup\">\n" +
                    "                                                <span class=\"watch_per\">"+result[a].lookNum+"</span><!-- 浏览人数图片 -->\n" +
                    "                                                <span class=\"thumb_up\">"+result[a].goodNum+"</span>\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                </li>");
            }
         }
     })
 }
