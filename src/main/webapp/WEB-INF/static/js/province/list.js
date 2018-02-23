$(function(){
    $(".btn_add").on("click",function(){
        $.ajax({
            url:'../add',
            type:'POST',

        });
    });
});
