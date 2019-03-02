function upItem() {
	var items=new FormData();
	var itemName=$("#itemName").val();
	var itemFl=$("#itemFl").val();
	var iText=$("#summernote").summernote("code");
    items.append("Iname",itemName);
    items.append("Itext",iText)
	items.append("assortmentId",itemFl);
	items.append("file2",$("#itemFile")[0].files[0]);
    items.append("file1",$("#itemImg")[0].files[0]);
    $.ajax({
		type:"post",
		contentType:false,
		processData:false,
		url:"/itemController/uploadItem",
		data:items,
		resultType:"text",
		success:function (result) {
			alert(result);
			window.location.reload();
        }
	})
}