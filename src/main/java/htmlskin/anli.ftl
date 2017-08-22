<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>垄上工作室-网站建设高端品牌-广州网站建设-企业网站建设</title>
<meta name="keywords" content="网站建设，网页设计，广州网站建设，深圳网站建设，企业网站建设，垄上工作室，手机网站，微信营销、APP开发、扎根垄上" />
<meta name="description" content="垄上工作室专注网站建设及信息化咨询服务，提供完善的网站建设、移动端应用、企业微信大战略、3D虚拟仿真等一系列企业互联网解决方案，知名客户有欧派、索菲亚、王老吉、PICC、海天味业、珠江钢琴、例外服饰、广百集团、轻工集团、广州发展集团。" />


<link rel="stylesheet" href="/templates/default/style/style.css" />

<link rel="stylesheet" href="/templates/default/style/media.css" />



<script type="text/javascript" src="/templates\default\script\jquery1.72.js"></script>

<script type="text/javascript" src="/templates\default\script\respond.min.js"></script>

<script type="text/javascript" src="/templates\default\script\jquery.SuperSlide2.11.js"></script>

<script type="text/javascript" src="/templates\default\script\jquery.lavalamp.min.js"></script>

<script type="text/javascript" src="/templates\default\script\jquery.imagesloaded.js"></script>

<script type="text/javascript" src="/templates\default\script\jquery.wookmark.min.js"></script>

<script type="text/javascript" src="/templates\default\script\jquery.easing.1.3.min.js"></script>

<script type="text/javascript" src="/templates\default\script\script.js"></script>
</head>
<body>

    <div id="web">

<script type="text/javascript" src="/templates\default\script\jquery.lazyload.js"></script>

<div class="caseBanner" style="background:url(/templates/default/images/banner2.jpg) center top no-repeat;"></div>



<div class="caseBox bgea">

    <div class="hotTag hotTagmenu hotTagmenu1 wp">

       <div class="hottaghead">热门案例</div>

       <div class="casecon">

           <ul class="fixed caseulfd">

				<li class="casenoli lion"><a href="index.html">全部案例</a></li>

                                            <li class="" rel="6"><a href="#">品牌展示网站</a></li>

                                                <li class="" rel="7"><a href="#">电子商务网站</a></li>

                                                <li class="" rel="8"><a href="#">官方门户网站</a></li>

                                                <li class="" rel="31"><a href="#">企业营销网站</a></li>

                                                <li class="" rel="9"><a href="#">信息门户网站</a></li>

                                                <li class="" rel="102"><a href="#">集团站群网站</a></li>

                                                <li class="" rel="101"><a href="#">手机网站</a></li>

                                                <li class="" rel="11"><a href="#">移动APP</a></li>

                                                <li class="" rel="12"><a href="#">微官网</a></li>

                                                <li class="" rel="105"><a href="#">微商城</a></li>

                                                <li class="casenoli" rel="13"><a href="#">DIY体验馆</a></li>

                                                <li class="" rel="106"><a href="#">360全景展厅</a></li>

                                                <li class="" rel="107"><a href="#">3D虚拟仿真</a></li>

                                                <li class="" rel="103"><a href="#">响应式网站</a></li>

                                                <li class="" rel="104"><a href="#">自适应网站</a></li>

                                                <li class="" rel="108"><a href="#">微活动</a></li>

                                                <li class="" rel="109"><a href="#">微社区</a></li>

                                                <li class="" rel="110"><a href="#">微信支付</a></li>

                                                <li class="" rel="111"><a href="#">微信CRM</a></li>

                    

           </ul>           

       </div>

    </div>

    <ul class="caseInfoWater wp" id="caseInfoWater">
		 <#list ex as news>
		 	<li><a href="${news.url}" ><i></i>
		 	<div class="img"><img class="lazy" width="278" height="${news.height}" data-original="${news.imgSrc}"  /></div>
		 	<div class="info"><h3><span>【3D虚拟展厅】 </span>${news.title}</h3><p>${news.title}</p></div></a></li>
		</#list>
              
      
            </ul>
    <div class="paged pagedcase fixed">

        <a class="readMore" title="下一页" href="#">下一页></a>    </div>

</div>

<script>

    (function ($) {

        var tid=5;

         $(".caseulfd li").each(function(ii){  

             if($(".caseulfd li").eq(ii).attr("rel")==tid)

             {

                   $(".caseulfd li").removeClass("lion");

                   $(".caseulfd li").eq(ii).addClass("lion");

             }

         }); 

            

        

        var handler = $('#caseInfoWater li');



        handler.wookmark({

            autoResize: true, 

            container: $('#caseInfoWater'), 

            offset: 30,

            align: "center",

            onLayoutChanged: function() {

            }

        });



        $("img.lazy").lazyload({

            effect: 'fadeIn'

        });





        handler.hover(function() {

            var self = $(this),

                obg = self.find('i');



            obg.stop(true,true).animate({bottom: 0},function(){

                self.addClass('redborder');

            });

            self.addClass('on');

        }, function() {

            var self = $(this),

                obg = self.find('i');



            obg.stop(true,true).animate({bottom: '99px'});

            self.removeClass('on redborder');

        });



    })(jQuery);

</script>




 

    </div>



 

<ul class="indexFloatCon">

    <li><a href="javascript:;" class="indexGoTop" title="返回顶部"></a></li>

            <li><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=41794983&site=qq&menu=yes" title="点击咨询" class="online">在线服务</a></li>

    <li class="wenti">

        <a href="#"></a>

        <dl class="wentiCon fixed">

            <dt><a href="..\faq\index.html">更多></a><span>常见问题</span></dt>
		  <#list faq as news>
		                                <dd><a href="${news.url}" target="_blank">·${news.title}</a></dd>
		                                  </#list>

                

        </dl>

    </li>

    <li class="ewmLi">

        <a href="javascript:;" class="erweima"></a>

        <div class="ewmCon fixed">

            <div class="ewm"><img src="/templates\default\images\erweima.jpg"><p>关注</p></div>

            <div class="ewm"><img src="/templates\default\images\weim.jpg"><p>手机站</p></div>

        </div>

    </li>

</ul>

   


</body>

</html>