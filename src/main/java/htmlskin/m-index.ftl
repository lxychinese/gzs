<!DOCTYPE html>
<html>
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
   
    
<header class="fixed">
     <a href="/mobile/uweb/contactus" class="goPhone"></a>
     <a href="javascript:;" class="goBack" id="goBackBtn"></a>
     <h1>垄上工作室</h1>
     <a href="javascript:;" class="headerMenu" id="headerMenu"></a>
     <a href="javascript:;" class="headerClose" id="closeBtn"></a>
 </header>
<div class="banner" id="banner">
    <div class="hd"><ul></ul></div>
    <div class="bd">
        <ul>
              <li><a href="contanct.htm"><img src="/templates/default/images_m/banner.jpg" alt=""></a></li>
            <li><a href="m.htm"><img src="/templates/default/images_m/banner2.jpg" alt=""></a></li>
            <li><a href="wei.htm"><img src="/templates/default/images_m/banner3.jpg" alt=""></a></li>
            <li><a href="kehu.htm"><img src="/templates/default/images_m/banner4.jpg" alt=""></a></li>
        </ul>
    </div>
</div>
<script>
    TouchSlide({slideCell: "#banner", effect: 'leftLoop', mainCell: ".bd ul", titCell: ".hd ul", autoPage: "<li></li>", autoPlay: true});
</script>

<div class="indexBox">
    <!-- <div class="indexTit"><h4>服务业务</h4><hr></div> -->
    <ul class="bigMenu fixed">
        <li><a href="web.htm"><b>网站建设</b><p>Website Construction</p></a></li>
        <li><a href="m.htm"><b>移动端应用</b><p>Application</p></a></li>
        <li><a href="3d.htm"><b>3D虚拟仿真</b><p>Website Construction</p></a></li>
        <li><a href="wei.htm"><b>企业微信<br>大战略</b><p>Website Construction</p></a></li>
    </ul>
    <div class="indexTit"><h4>重点客户</h4><hr></div>
    <div class="indexkh" id="indexkh">
        <div class="bd">
            <ul>
                <li><img src="/templates/default/images_m/kehu.gif"></li>
                <li><img src="/templates/default/images_m/kehu1.jpg"></li>
            </ul>
        </div> 
        <div class="hd"><ul></ul></div>
        <div class="intro"><a href="/mobile/uweb/kehu">6000多家客户，400家集团、上市公司的长期合作伙伴</a></div>
    </div>
    <script>
        TouchSlide({slideCell:"#indexkh",effect:'leftLoop',mainCell:".bd ul",titCell:".hd ul",autoPage:"<li></li>",autoPlay:true,interTime:4000});
    </script>
    <div class="indexTit"><h4>最新动态</h4><hr></div>
    <ul class="indexNewsList">
          <#list index as news>
            <li><a  href="${news.url}"class="fixed">
                                        <img src="/upfile/2016/11/07/20161107091451_205.png"  class="pic">
                                        <dl>
                        <dt>${news.title}</dt>
                        <dd>扎根垄上</dd>
                    </dl>
                </a></li>
                </#list>
              
            
             
    </ul>
</div>	



</body>
</html>