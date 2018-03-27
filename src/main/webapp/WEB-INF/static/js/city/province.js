$(function(){
    var content = '/city/province?provinceId=';

    function newLayer(content){
        layer.open({
            type: 2,
            title: '该省城市',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '450px'],
            content: content
        });
    }


    $(".btn_province").on("click",function(){
        var con = content + $(this).attr("value");
        newLayer(con);
    });

    $(".btn_citys").on("click",function(){
        var cityId = $(this).attr("value");
        $.ajax({
            url:"/city/city?cityId=" + cityId,
            type:"GET",
            async:false,
            success:function(){
                parent.location.reload();
            }
        });
    });
});
