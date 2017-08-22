
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

		<div class="newsBanner">
			<ul class="newsMenu fixed">
				<li rel="18"><a href="#">公司新闻</a></li>
				<li rel="19"><a href="#">项目动态</a></li>
				<li rel="20"><a href="#">杂记</a></li>

			</ul>
		</div>
		<script>
    (function ($) {
        var tid=20;
         $(".newsMenu li").each(function(ii){  
             if($(".newsMenu li").eq(ii).attr("rel")==tid)
             {
                   $(".newsMenu li").removeClass("on");
                   $(".newsMenu li").eq(ii).addClass("on");
             }
         }); 
    })(jQuery);
</script>



		<div class="newsCon">

			<div class="newsInfoCon wp">

				<div class="newsInfoBox">

					<div class="closeBtn">
						<a href="javascript:window.close()">关闭</a>
					</div>

					<h1>	${news.title}</h1>

					<div class="time">
						发布日期：${news.createTime}&nbsp;&nbsp;&nbsp;浏览次数：
						&nbsp;&nbsp;&nbsp;来源：<a href="index.htm" title="查看来源">垄上工作室</a>
					</div>

					<div class="article">

						${news.content}

					</div>

				</div>

				<div class="otherPage fixed">

					

					<ol class="otherTool fixed">

						<li id="bdshare" class="share bdshare_b bdsharebuttonbox"><a
							class="bds_more" title="分享" data-cmd="more" href="javascript:;">分享</a></li>

						<li class="close"><a href="javascript:window.close()">关闭</a></li>

					</ol>

				</div>

			</div>

			<div class="reNewsCon wp">

				<div class="reNewsTit">相关推荐</div>

				<div class="reNewsBox">

					<ul class="newsList fixed">
					
					
					 <#list list as news>

						<li class="fixed">

							<div class="info">

								<a href="${news.url}" target="_blank"
									title="">${news.title}</span></a>

								<p>${news.memo}</p>

							</div>

						</li>
						 </#list>

						



					</ul>

				</div>

				<a href="news" class="readMore">查看更多>></a>

			</div>

		</div>



		<script>

	window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];

	</script>





	</div>





	<ul class="indexFloatCon">

		<li><a href="javascript:;" class="indexGoTop" title="返回顶部"></a></li>

		<li><a target="_blank"
			href="http://wpa.qq.com/msgrd?v=3&uin=41794983&site=qq&menu=yes"
			title="点击咨询" class="online">在线服务</a></li>

		<li class="wenti"><a href="news"></a>

			<dl class="wentiCon fixed">

				<dt>
					<a href="#">更多></a><span>常见问题</span>
				</dt>

 <#list index as news>
				<dd>
					<a href="${news.url}" target="_blank">· ${news.title}</a>
				</dd>

</#list>

			</dl></li>

		<li class="ewmLi"><a href="javascript:;" class="erweima"></a>

			<div class="ewmCon fixed">

				<div class="ewm">
					<img src="/templates\default\images\erweima.jpg"><p>关注</p>
				</div>

				<div class="ewm">
					<img src="/templates\default\images\weim.jpg"><p>手机站</p>
				</div>

			</div></li>

	</ul>



	<span class="pdisplay"><script type="text/javascript"> var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://"); document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fa1a6296ef1286432ec2f1f459385026f' type='text/javascript'%3E%3C/script%3E")) </script></span>

</body>

</html>