$(function () {

    $(".btn_register").on("click",function () {
        $.ajax({
            url:"/user/registerSave",
            type:'POST',
            data:JSON.stringify({"loginName": $("#loginName").val(),"password":$("#password").val(),"phone":$("#phone").val()}),
            // data:$(".register_form").serialize(),
            dataType: "json",
            contentType: "application/json",
            error:function(data){
                layer.msg(data.message);
            },
            success:function (data) {
                layer.msg(data.message);
            }
        });
    });

})