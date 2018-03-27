$(function(){
    $.ajax({
        url:"/ifLogin",
        type:"GET",
        error:function(data){
            layer.msg("请求出错！");
        },
        success:function(data){
            if(true == data){
                $(".nonlogin-model").hide();
                $(".login-model").show();
            } else {
                $(".nonlogin-model").show();
                $(".login-model").hide();
            }
        }
    });

});
