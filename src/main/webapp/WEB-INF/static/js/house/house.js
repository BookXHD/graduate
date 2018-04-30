$(function(){

    $(".btn_input").on("click",function(){
        layer.open({
            type: 2,
            title: '请输入住宿信息',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '450px'],
            content: '/house/roomerDetail?id='+$(this).attr("value")
        });
    });

    $(".btn_pay").on("click",function () {
        location.href="/house/pay?roomTimeStr="+$("#roomTimeStr").val()+"&houseId="+$("#houseId").val()+"&roomDays="+$("#roomDays").val()+"&roomAmount="+$("#roomAmount").val();
    });

});
