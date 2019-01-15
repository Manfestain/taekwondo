// JavaScript Document
$(function(){
//鏍囩鍒囨崲鍐呭 鏍囩ul.tabs 鍐呭*.tabs_ctt 蹇呰鏉′欢锛�.tabs涓�.tabs_ctt蹇呴』澶勪簬鍚屼竴绾ф爣绛句笅銆�
    $(".tabs").each(function(){
        $(this).siblings(".tabs_ctt").hide();
        $(this).siblings(".tabs_ctt:eq(0)").show();
        $(this).children("li:eq(0)").addClass("active");
    });
    $(".tabs>li").click(function(){
        var n = $(this).index();
        $(this).siblings().removeClass("active");
        $(this).addClass("active");
        var $tabs = $(this).parent(".tabs");
        $tabs.siblings(".tabs_ctt").hide();
        $tabs.siblings(".tabs_ctt:eq("+n+")").show();
    });
    //鍒楄〃闅�5琛岀┖琛�
    var listli_len = Math.floor($(".list_list>li").length/5);
    for(var i=0;i<listli_len;i++){
        var n = i*5-1;
        var $obj = $(".list_list>li:eq("+n+")");
        $obj.css("margin-bottom","40px");
    }
    //杩斿洖椤堕儴 鍔ㄧ敾
    var $div = $("<div class=\"gotop hidden-xs\" style=\"padding:15px 20px; text-align:center; cursor:pointer;\"><a href=\"javascript:void(0)\" onClick=\"gotop()\"><span class=\"fa fa-chevron-up\"></span></a></div>");
    $("body").append($div); 
    var page_width = $(".container").width()+50;    
    var gotop_left = ($(window).width()-page_width)/2+page_width;
    $(".gotop").css({'position':'fixed','bottom':'150px','left':gotop_left}).hide();
    $(window).scroll(function(){
        if($(this).scrollTop() > 200){
            $(".gotop").show("fast");
        }else{
            $(".gotop").hide("fast");
        }
    });
    $(window).resize(function(){
        page_width = $(".container").width()+50;    
        gotop_left = ($(window).width()-page_width)/2+page_width;
        $(".gotop").css({'left':gotop_left});
    });
    $(".gotop").click(function(){
        $('body,html').animate({scrollTop:0},500);
        return false;
    });
    //鏈€澶у瓧鏁伴檺鍒� 渚嬶細<p class="maxtext" maxnumber="100">
    $(".maxtext").each(function(){
        var maxnum = $(this).attr("maxnumber");
        if($(this).text().length > maxnum){
            $(this).text($(this).text().substring(0,maxnum)+"...");
        }
    });
    //椤甸潰涓昏彍鍗曚笅鎷夋晥鏋�
    $(".menu_dropdown>li").mouseenter(function(){
        $(this).children(".menu_sub").show();
    }).mouseleave(function(){
        $(this).children(".menu_sub").hide();
    });
    //瑙嗛鍥剧墖鐨刬con鎺у埗
    $(".vedio_wrap img").each(function(){
        var img_w = $(this).width();
        var fa_size = Math.round(img_w/5)+"px";
        if(parseInt(fa_size)>64) {
            fa_size = "64px";
        }
        var fa_mtop = "-"+Math.round(parseInt(fa_size)/2)+"px";
        var $obj = $(this).parent().children(".fa");
        $obj.css({
            "font-size":fa_size,
            "margin-top":fa_mtop,
            "margin-left":fa_mtop
        });
    });
});