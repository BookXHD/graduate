$(function(){

    $(".li_logout").on("click",function(){
        $.ajax({
            url:"/user/logout",
            type:"POST",
            async:false,
            success:function(){
                $(window).attr('location','/');
            }
        });
    });

    $(".btn_edit").on("click",function(){
        layer.open({
            type: 2,
            title: '修改个人信息',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '450px'],
            content: '/user/editInformation'
        });
    });

    $(".btn_verify").on("click",function(){
        $.ajax({
            url:"/user/editInformationverify",
            type:'POST',
            data: JSON.stringify({"loginName":$("#loginName").val(),"id":$("#id").val(),"password":$("#password").val(),"nickName":$("#nickName").val(),
                "phone":$("#phone").val(),"email":$("#email").val(),"sex":$("#sex").val(),"location":$("#location").val(),"identity":$("#identity").val(),
                "introduce":$("#introduce").val()}),
            async: false,
            cache: false,
            dataType: "json",
            contentType: "application/json",
            error:function(data){
                layer.msg(data.message);
            },
            success:function (data) {
                //重定向只会在layer弹层中重定向
                parent.location.reload();
                //刷新父对象有效，但是丢失了对layer弹窗的控制
                layer.msg(data.message);
            }
        });
    });

    var $form = $("#pic_form");
    $(".pic_upload").on("click",function () {
        var form = new FormData($form[0]);
       $.ajax({
           url:"/user/upload",
           type:"POST",
           data:form,
           async: false,
           cache: false,
           contentType: false,
           processData: false,
           error:function(data){
               layer.msg(data.message);
           },
           success:function (data) {
               window.location.reload();
               layer.msg(data.message);
           }
       });
    });

});