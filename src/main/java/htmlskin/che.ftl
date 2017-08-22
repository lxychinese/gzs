<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">



<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<meta name="apple-mobile-web-app-capable" content="yes">

<meta name="apple-mobile-web-app-status-bar-style" content="black">

<title>垄上拼车互助平台</title>

<link rel="stylesheet" type="text/css" href="source/plugin/vyuan_pinche/static/common.css">

<link rel="stylesheet" type="text/css" href="source/plugin/vyuan_pinche/static/index_new.css">

<link rel="stylesheet" type="text/css" href="source/plugin/vyuan_pinche/static/car.css">

<link rel="stylesheet" type="text/css" href="source/plugin/vyuan_pinche/static/swiper.min.css">

<link href="source/plugin/vyuan_zhaopin/static/style.css" rel="stylesheet" type="text/css">

<style>





    .govip2{

        text-align: center;

        font-size: 15px;

        font-style: normal;

        font-weight: 300;

        width: 17%;

        height: 26.39px;

        vertical-align: middle;

        color: #fff;

        margin-right: 0.5rem

    }







    header {

margin: 0;

padding: 0;

border: 0;

font: inherit;

font-size: 100%;

vertical-align: baseline

}

.share-mp-info,.share-mp-info a,.share-mp-info em,.share-mp-info i {

color: #999

}

.share-mp-info {

position: relative;

background: #1e1d22;

font-size: 0;

line-height: 0;

padding: 1px 160px 1px 1px

}



.share-mp-info .links,.share-mp-info .page-mp-info {

font-size: 14px;

line-height: 2rem;

color: #999

}

.share-mp-info .page-mp-info {

display: block;

padding: 4px 0 4px 10px

}



.share-mp-info img.mp-image {

vertical-align: middle;

margin-right: 3px;

width: 24px;

height: 24px;

border-radius: 100%;

-webkit-box-shadow: 0 0 3px rgba(0,0,0,.25);

box-shadow: 0 0 3px rgba(0,0,0,.25)

}



.share-mp-info .links,.share-mp-info .page-mp-info {

font-size: 14px;

line-height: 24px;

color: #999

}

.share-mp-info .links {

position: absolute;

top: 6px;

right: 10px;

display: inline-block

}



.share-mp-info .mp-search {

position: relative;

display: inline-block;

vertical-align: middle;

width: 25px;

height: 27px

}



.share-mp-info .mp-search::before {

content: '';

position: absolute;

top: 6px;

left: 6px;

width: 12px;

height: 12px;

background: url(data:image/png;

base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAMAAADXqc3KAAAANlBMVEUAAACampqcnJyampqampqampqZmZmoqKiZmZmZmZmampqZmZmampqZmZmampqZmZmZmZmZmZkjvjFoAAAAEXRSTlMAVkSc5Yk3DPPc2aVR7M/GUP5yJZQAAACPSURBVCjPhZFZEgMhCEQFcRl1tvtfNoBJMFNFpb8antWohCnordbWIfxqbPdb21j76V6UnP5ChpYxl5Kj2k+a5BNOjyRzpgc5pH0lUoHaLjk2UNK6usYuG8hcNnWVXTFQuKwe2L2o0xseveui88DD+5Jkn/gQ/Ce2qCN9ia12PyOyM/LQJJdHKDjEwKqLCF/tMQ6H98ej5gAAAABJRU5ErkJggg==) no-repeat;background-size: 12px 12px

}



.share-mp-info .links .mp-homepage {

margin-left: 0

}





.popup-container {

display:-webkit-box;

display:-moz-flex;

display:-ms-flexbox;

display:flex;

-webkit-box-pack:center;

-ms-flex-pack:center;

-moz-justify-content:center;

justify-content:center;

-webkit-box-align:center;

-ms-flex-align:center;

-moz-align-items:center;

align-items:center;

visibility:hidden;

z-index:12

}



.popup-container,.popup-container .popup-mask {

position:fixed;

top:0;

left:0;

bottom:0;

right:0;

width:100%;

height:100%

}

.popup-container .popup-mask {

background:rgba(0,0,0,.8)

}

.popup-container.active .popup {

-webkit-animation-name:superScaleIn;

animation-name:superScaleIn;

-webkit-animation-duration:.2s;

animation-duration:.2s;

-webkit-animation-timing-function:ease-in-out;

animation-timing-function:ease-in-out;

-webkit-animation-fill-mode:both;

animation-fill-mode:both

}

.popup-container .popup {

position:relative;

width:250px;

max-width:100%;

max-height:90%;

border-radius:3px;

background-color:#fff;

display:-webkit-box;

display:-moz-flex;

display:-ms-flexbox;

display:flex;

-webkit-box-direction:normal;

-webkit-box-orient:vertical;

-moz-flex-direction:column;

-ms-flex-direction:column;

flex-direction:column;

-webkit-user-select:none;

-moz-user-select:none;

-ms-user-select:none;

user-select:none;

z-index:13

}

.popup-container.popup-show {

visibility:visible;

z-index:1005;

}

.popup-head {

padding:15px 10px;

border-bottom:1px solid #eee

}

.popup-title {

margin:0;

padding:0;

font-size:15px

}

.balanced {

color:#4ebd52

}

.popup-body {

padding:10px

}

.centerwin,.dmenu .tab,.gz-qr,.popup-body,.popup-head {

text-align:center

}



.suggestnotices{



padding: 0 2%;



margin: 0 auto;



max-height: 7rem;

min-height:2.8rem;



line-height: 2.3rem;



/* border:1px #ddd solid; */



color: #757575;



/* border-top-left-radius: 10px; */



/* border-bottom-right-radius: 25px; */



font-size: 1.5rem;



/* font-weight: 600; */



background: #FFF;



border-bottom: 1px #f3f3f3 solid;

}





</style>

<script src="source/plugin/vyuan_pinche/static/jquery-1.7.2.min.js" type="text/javascript"></script>

<script src="source/plugin/vyuan_pinche/static/swiper.jquery.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="source/plugin/vyuan_pinche/static/mobiscroll.min.css">

<script src="source/plugin/vyuan_pinche/static/mobiscroll.min.js" type="text/javascript"></script>

<script src="source/plugin/vyuan_pinche/static/index.js" type="text/javascript"></script>

<script src="source/plugin/vyuan_pinche/static/global.js" type="text/javascript"></script>

<script type="text/javascript">

$(document).ready(index_obj.index_init);

</script>



</head>

<body>



<div class="header">

                <div class="js-mp-info share-mp-info ">

        <a class="page-mp-info" href="">

            <img class="mp-image" width="24" height="24" src="source/plugin/vyuan/data/avatar/20161228/wx.jpg">

            <i class="mp-nickname" style="font:inherit">

                                    垄上拼车互助平台                            </i>

        </a>

        <div class="links">	
        <img src="source/plugin/vyuan_pinche/static/visit2.png" style="height: 1.0rem;"/>

                            110 
                            <span onClick="setFocus().html" href="javascript:void(0)"><img src="source/plugin/vyuan_pinche/static/259.png" style="height: 1.0rem;">关注&nbsp;</span>

                                    </div>

    </div>

</div>



<div class="swiper-container swiper-container-horizontal">

       <div class="swiper-wrapper" style="transform: translate3d(-2250px, 0px, 0px); transition-duration: 0ms;">

              <div class="swiper-slide" data-swiper-slide-index="0"><img src="source/plugin/vyuan/data/avatar/20161228/wxupload_14829399766274.jpg" ></div>

              

              <div class="swiper-slide" data-swiper-slide-index="0"><img src="source/plugin/vyuan/data/avatar/20161228/wxupload_14829401592995.jpg" ></div>

              

              <div class="swiper-slide" data-swiper-slide-index="1" ><img src="source/plugin/vyuan/data/avatar/20161228/wxupload_14829401713992.jpg" ></div>

              

      	

        </div>

       <div class="swiper-pagination"></div> 

</div>



<div class="link">

            <span><a href="plugin.html"><img src="source/plugin/vyuan_pinche/static/link3.png"/>刷新</a></span>

        <span><a href="plugin.html"><img src="source/plugin/vyuan_pinche/static/259.png"/>发布</a></span>

        <span><a href="plugin.html"><img src="source/plugin/vyuan_pinche/static/link1.png"/>人找车</a></span>

        <span><a href="plugin.html"><img src="source/plugin/vyuan_pinche/static/link2.png"/>车找人</a></span>

    



  

</div>



<div class="search">

  <input type="text" id="fromPlace" name="fromPlace" value="" placeholder="出发地搜索"><input type="text" id="toPlace" name="toPlace" placeholder="目的地搜索" value=""><botton id="btnSearch" name="btnSearch"><img src="source/plugin/vyuan_pinche/static/search.png"></botton>

  <div class="boder"></div>

</div>



<div class="suggestnotices" style="margin-bottom:0.5rem;font-size:1.3rem; color:#2b9af7"><span class="love" style="color:#FFFFFF;background-color: #e40d66;font-size:1.4rem;margin-left: 2px;margin-right: 2px;">公告</span>&nbsp;垄上拼车互助平台正式推出，请老乡相互转告！..</div>



<div class="suggest">全部信息(共有${list?size}条新信息)</div>

<!--nav-->







 <div class="carCon ul_content">
  <#list list as che>

    
       <div class="carList" >



    <a href="javascript:;" class="carlist"   onClick="#" >

     <ul class="carlist01" >

      <li class="carli01 " style="line-height:2.5rem;">           <i class="govip2" style="background-color:#2b9af7;border: 3px solid #2b9af7"><#if che.type==1>车找人</#if>
      <#if che.type==2><font color=red>人找车</font></#if></i>                              

          ${che.start} <i class="carto "></i>  ${che.end}     <#if che.pass?exists && che.pass!="">(途经:${che.pass} ) </#if>  </li>

      <li class="carli02 ">

       <div class="carli02L">

<font color=<#if che.jt==true>   red </#if>   > ${che.timeFmt} </font>
     (${che.week})${che.fz}&nbsp;<#if che.time_memo?exists>(${che.time_memo})  </#if>&nbsp;出发

       </div>

                 <div class="carli02R">

        <i></i>${che.read}    </div>

       </li>

       <li class="carli03 ">

         <p  style="margin-top: 0.2rem;"  onClick="javascript:window.location.href='#'" ><#if che.memo?exists && che.memo!="">${che.memo}。  </#if></p>

                </li>



     </ul> </a>



     <div class="carbot1">



     <div class="carbot1l carbot1lp">

         <font color="#2b9af7"><#if che.type==1>${che.surplus}空位  </#if></font> </div> 

     <div class="carbot1r"> 

      <span class="cartime"><span title="${che.ptimedec}">${che.ptimedec}</span>发布</span> 

      <span class="ctell " style="cursor:pointer" data-isend="0" onClick="javascript:window.location.href='tel:${che.mobile}'" ><i></i>拨打</span> 

     </div> 

    </div> 

   </div> 
    
   
 </#list>
     

   

  </div>





<div style="width: 100%;height: 55px;text-align: center;padding-top: 10px">

    我的底线

</div>



<footer>

<ul>

    <li>

        <a href="plugin.html">

            <span class="imga"><img src="source/plugin/vyuan_pinche/static/footer6.png"></span>

            <span style="color: #ff3434;">首页</span>

        </a>

    </li>

    <li>

        <a href="plugin.html">

            <span class="imga"><img src="source/plugin/vyuan_pinche/static/footer5.png"></span>

            <span>发布</span>

        </a>

    </li>

     <li>

        <a href="plugin.html">

            <span class="imga"><img src="source/plugin/vyuan_pinche/static/footer3.png"></span>

            <span>我的</span>

        </a>

    </li>

</ul>

</footer>

<!--layer-->

<div class="popup-container layui-m-anim-scale" id="popup-container-wx">

    <div class="popup-mask" id="popup-mask-1"></div>

    <div class="popup">

        <div class="popup-head">

            <h3 class="popup-title"> 长按关注 <strong class="balanced" style="font-weight:bold">垄上拼车互助平台</strong> 公众号 </h3>

        </div>

        <div class="popup-body">

                <img alt="" src="source/plugin/vyuan/data/avatar/20161228/wxupload_14829370803466.jpg" style="max-width:100%;max-height:200px;">

            <div style="text-align:center;color:#999;font-size:1.4rem;">

                点击灰色区域关闭弹窗

            </div>

        </div>

    </div>

</div>





<script type="text/javascript">

 

$(document).ready(function(){

 var swiper = new Swiper('.swiper-container', {

   pagination : '.swiper-pagination',

   paginationType : 'bullets',

    paginationClickable: true,

speed:300,

autoplay:3000,

loop:1,

    })

 $(".date").mobiscroll().date({  

  

     theme: "android-holo",  

     lang: "zh",  

     cancelText: null,  

     dateFormat: 'yy-mm-dd', //返回结果格式化为年月格式

    dateOrder: 'yymmddD', 

    display: 'bottom',

    weekDays:'short',

     // wheels:[], 设置此属性可以只显示年月，此处演示，就用下面的onBeforeShow方法,另外也可以用treelist去实现  

     onBeforeShow: function (inst) { inst.settings.wheels[0].length>3?inst.settings.wheels[0].pop():null; }, //弹掉"日"滚轮  

     headerText: function (valueText) { //自定义弹出框头部格式  

         array = valueText.split(' ');

         return  array[0];  

     }  

 })

 

 	$("#btnSearch").click(function() {



location.href="plugin.php?id=vyuan_pinche&pid=100541" + "&fromPlace="+ $('#fromPlace').val() + "&toPlace="+ $('#toPlace').val() + "&type=" + "0";

      

    });



 	$("#popup-mask-1").click(function () {



$("#popup-container-wx").removeClass("popup-show");



});	







})	



 function setFocus(){ 

        

$('#popup-container-wx').addClass('popup-show');



    }



</script>











<style>

    .site-float {

        position: fixed;

        bottom: 120px;

        right: 0;

        background: rgba(16,174,255,0.9);

        color: #FFF;

        padding: 5px;

        font-size: 1.2rem;

        z-index: 99;

        text-align: center

    }



</style>







<!-- 关注弹层 start -->

<div class="attentionDialogSR" style="display:none;" id="tc" >

    <div class="attentionContentSR">

        <p class="aTitle">长按添加<span>垄上拼车互助平台</span>客服微信</p>

       <!-- <hr/>-->

        <div style="width: 100%;height: 1rem"></div>

        <img src="" alt=""/>

        <div style="width: 100%;height: 1rem"></div>

        <p class="aTip">点击灰色区域关闭弹窗</p>

    </div>

    <div class="dialogShadeSR"  id="tc2" style="display: none;" onclick="setClose().html"></div>

</div>

<!-- 关注弹层 end -->

<script>

    function setOpen(){



        document.getElementById("tc").style.display="block";//隐藏



        document.getElementById("tc2").style.display="block";//显示



    }

    function setClose(){



        document.getElementById("tc").style.display="none";//隐藏

        document.getElementById("tc2").style.display="none";//隐藏



    }



</script>



</body>

</html>