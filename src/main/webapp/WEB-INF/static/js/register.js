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
                layer.msg("注册失败");
            },
            success:function (data) {
                debugger;
                layer.msg("注册成功");
            }
        });
    });

})