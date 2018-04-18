$(function(){
    //收藏
   $(".btn_collect").on("click",function () {
      $.ajax({
          url:'/tripPlan/collectPlanSave?planId='+$(this).attr("value"),
          type:'GET',
          async:false,
          success:function(data){
              layer.msg(data.message);
          },
          error:function(){
              layer.msg(data.message);
          }
      });
   });

   //购买
    $(".btn_buy").on("click",function () {
        location.href="/tripPlan/pay?planId="+$(this).attr("value");
    });

    //订单详情
    $(".btn_detail").on("click",function () {
        layer.open({
            type: 2,
            title: '详情',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['800px', '600px'],
            content: '/tripPlan/detail?planId='+$(this).attr("value")
        });
    });
});