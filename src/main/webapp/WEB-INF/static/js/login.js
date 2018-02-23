$(function(){

    $(".btn_login").on("click",function () {
            $.ajax({
                url:"/user/check",
                type:'POST',
                async: true,
                data:$(".login-form").serialize(),
                dataType:"json",
                error:function(data){
                    layer.msg(data.message);
                },
                success:function (data) {
                    layer.msg(data.message);
                }
            });
    });

    $(".btn_register").on("click",function () {
        layer.open({
            type: 2,
            title: '注册',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '450px'],
            content: '/user/register'
        });
    })

});