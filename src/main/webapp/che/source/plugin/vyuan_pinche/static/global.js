
$(document).ready(function(){global_obj.page_init()});

var global_obj={
	page_init:function(){
		
		$('a').each(function(){
			var url=$(this).attr('href');
			var rel=$(this).attr('rel');
			if(url && url.indexOf('tel:')==-1 && url.indexOf('javascript:')==-1 && url.indexOf('#')==-1 && !rel){
				//修改开始
				//$(this).attr('href', apiurl(url));
				//修改完成
//				if(url.charAt(url.length-1)=='/'){
//					$(this).attr('href', url);
//				}else if(url.indexOf('?')==-1){
//					$(this).attr('href', url);
//				}else{
//					$(this).attr('href', url);
//				}
			}
		});
	},
	div_mask:function(remove){
		if(remove==1){
			$('#div_mask').remove();
		}else{
			$('body').prepend('<div id="div_mask"></div>');
			$('#div_mask').css({
				width:'100%',
				height:$(document).height(),
				overflow:'hidden',
				position:'fixed',
				top:0,
				left:0,
				background:'#000',
				opacity:0.6,
				'z-index':10000
			});
		}
	},
	win_alert:function(tips, handle){
		$('body').prepend('<div id="global_win_alert"><div>'+tips+'</div><h1>好</h1></div>');
		$('#global_win_alert').css({
			position:'fixed',
			left:$(window).width()/2-125,
			top:'30%',
			background:'#fff',
			border:'1px solid #ccc',
			opacity:0.95,
			width:250,
			'z-index':1000000,
			'border-radius':'8px'
		}).children('div').css({
			'text-align':'center',
			padding:'30px 10px',
			'font-size':16
		}).siblings('h1').css({
			height:40,
			'line-height':'40px',
			'text-align':'center',
			'border-top':'1px solid #ddd',
			'font-weight':'bold',
			'font-size':20
		});
		$('#global_win_alert h1').click(function(){
			$('#global_win_alert').remove();
		});
		if($.isFunction(handle)){
			$('#global_win_alert h1').click(handle);
		}
	},
	
	check_form:function(obj){
		var flag=false;
		obj.each(function(){
			if($(this).val()==''){
				alert($(this).attr("notice"));
				$(this).focus();
				flag=true;
				return false;
			}
		});
		return flag;
	},
	
	share_init:function(share,config){
		/*if(typeof(share.img_url)=='undefined' || !share.img_url){
			if(window.PG.cover){
				share.img_url=window.PG.cover;
			}else{
				share.img_url=system_obj.domain('static')+'/api/images/global/share/'+window.PG.page[1]+'.jpg';
			}
		}*/
		(typeof(share.link)=='undefined' || !share.link) && (share.link=window.location.href);
		(typeof(share.title)=='undefined' || !share.title) && (share.title=document.title);
		(typeof(share.desc)=='undefined' || !share.desc) && (share.desc=share.title);
		(typeof(share.trans)=='undefined' || !share.trans) && (share.trans=1);
			
		var share_res=function(share_to){
			share.share_to=share_to;
			share.do_action='action.share';
			$.post('./', share);
		}
		var appmessage_share={
			'img_url':share.img_url,
			'link':share.link,
			'title':share.title,
			'desc':share.desc
		}
		var timeline_share={
			'img_url':share.img_url,
			'link':share.link,
			'title':share.title,
			'desc':share.desc
		}
		wx.config({
		    debug: true,
		    appId: config.appid,
		    timestamp: config.timestamp,
		    nonceStr: config.nonceStr,
		    signature: config.signature,
		    jsApiList: [
		      	'checkJsApi',
		        'onMenuShareTimeline',
		        'onMenuShareAppMessage',
		        'onMenuShareQQ',
		        'onMenuShareWeibo',
		        'hideMenuItems',
		        'showMenuItems',
		        'hideAllNonBaseMenuItem',
		        'showAllNonBaseMenuItem',
		        'translateVoice',
		        'startRecord',
		        'stopRecord',
		        'onRecordEnd',
		        'playVoice',
		        'pauseVoice',
		        'stopVoice',
		        'uploadVoice',
		        'downloadVoice',
		        'chooseImage',
		        'previewImage',
		        'uploadImage',
		        'downloadImage',
		        'getNetworkType',
		        'openLocation',
		        'getLocation',
		        'hideOptionMenu',
		        'showOptionMenu',
		        'closeWindow',
		        'scanQRCode',
		        'chooseWXPay',
		        'openProductSpecificView',
		        'addCard',
		        'chooseCard',
		        'openCard'
		    ]
		  });
	  wx.ready(function(){
		  wx.onMenuShareTimeline({
			    title: timeline_share.title, 
			    link: timeline_share.link,
			    imgUrl: timeline_share.imgUrl, 
			    success: function () { 
			        // 用户确认分享后执行的回调函数
			    },
			    cancel: function () { 
			        // 用户取消分享后执行的回调函数
			    }
			});
		  wx.onMenuShareAppMessage({
			  	title: appmessage_share.title, 
			    link: appmessage_share.link,
			    imgUrl: appmessage_share.imgUrl, 
			    desc: appmessage_share.imgUrl, 
			    type: '', // 分享类型,music、video或link，不填默认为link
			    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
			    success: function () { 
			    	alert('成功');
			        // 用户确认分享后执行的回调函数
			    },
			    cancel: function () { 
			        // 用户取消分享后执行的回调函数
			    }
			});
		});
		
	},
	
}
//生成url函数,和php中实现的效果不一样
/*function apiurl($moudle){
	if($moudle == ''){
		return '';
	}
	if($moudle.indexOf('http://') != -1 || $moudle.indexOf('wechat.php?') != -1){
		return $moudle;
	}else if($moudle.indexOf('nlmy') != -1 ||$moudle.indexOf('quotation') != -1 ||$moudle.indexOf('news') != -1 || $moudle.indexOf('medical') != -1 || $moudle.indexOf('home') != -1|| $moudle.indexOf('recruit') != -1 || $moudle.indexOf('coupon') != -1 || $moudle.indexOf('bunsiness') != -1|| $moudle.indexOf('second') != -1|| $moudle.indexOf('activity') != -1  ){
		return  domain.www+'/wechat.php?s='+$moudle+'/index.html';
	}else if($moudle.indexOf('dating') != -1){
		return  domain.www+'/wechat.php?s='+$moudle+'/myindex.html';
	}else if($moudle.indexOf('baby') != -1){
		return  domain.www+'/wechat.php?s='+$moudle;
	}else if($moudle.indexOf('code') != -1){
		return  domain.www+'/wechat.php?s='+$moudle+'/codelist.html';
	}else if($moudle.indexOf('carpooling') != -1){
		return  domain.www+'/wechat.php?s='+$moudle+'/hascar.html';
	}
	
}*/

function imitate(id) {
	  var aa = document.getElementById(id);
	  $(aa).siblings(".imitate").text(aa.value);
	}
function imitatearea(id) {
	  var aa = document.getElementById(id);
	  $(aa).siblings("table").find(".imitate").text(aa.value);
	}
function imitatedate(id) {
	  var aa = document.getElementById(id);
	  $(aa).siblings("table").find(".imitate").text(aa.value+"日");
	}
function fillSelect() 
{
var ddlYear = document.getElementById("sYear");
var ddlMonth = document.getElementById("sMonth");
var ddlDate = document.getElementById("sDate");
var opt = null;
var curDay = null;
	if(birthday['syear']!=""){
		curDay = new Date(birthday['syear'],birthday['smonth'],birthday['sdate']);
	}else{
		curDay = new Date();
	}
var nowyear = new Date();
var year = nowyear.getFullYear();
for (var i = -80; i < 1; i++) 
{
 opt = document.createElement("OPTION");
 opt.value = year + i;
 opt.innerText = (year + i) + "年";
 ddlYear.appendChild(opt);
}
ddlYear.value = curDay.getFullYear();
for (var i = 1; i <= 12; i++) 
{
 opt = document.createElement("OPTION");
 opt.value = i;
 opt.innerText = i + "月";
 ddlMonth.appendChild(opt);
}
ddlMonth.value = curDay.getMonth();
fillDate();
ddlDate.value = curDay.getDate();
}
function fillDate() 
{
	 var ddlYear = document.getElementById("sYear");
	 var ddlMonth = document.getElementById("sMonth");
	 var ddlDate = document.getElementById("sDate");
	// alert(ddlMonth.value)
	 while (ddlDate.options.length > 0)
	 {
	     ddlDate.remove(0);
	 }
	 var selDay = new Date();
	 selDay.setFullYear(ddlYear.value, ddlMonth.value, 1);
	 var lastDay = new Date(selDay - (24 * 60 * 60 * 1000));
	
	 var days = lastDay.getDate();
	 for (var i = 1; i <= days; i++) 
	 {
	     var opt = document.createElement("OPTION");
	     opt.value = i;
	     opt.innerText = i + "日";
	     ddlDate.appendChild(opt);
	 }
	 if(birthday['sdate']!=""){
		 ddlDate.value = birthday['sdate'];
	 }
	 $("#year_box .imitate").text($("#sYear").val()+"年"); 
	 $("#month_box .imitate").text($("#sMonth").val()+"月"); 
	 $("#date_box .imitate").text($("#sDate").val()+"日");
}
