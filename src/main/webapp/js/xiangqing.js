	
//  轮播
    var nowpage=0;
    var time=false;
    var leftwidth=$(".decoration-left").width();
	var rightwidth=$(".decoration-right").width();
	function show() {
        var screenwidth=$(window).width();
        var srollwidth=nowpage*screenwidth+screenwidth;
        if(nowpage<=2){
        	nowpage++;
        	$(".slideBox").animate({left:"-"+srollwidth+"px"});
        	$(".banner-dian>span[count="+nowpage+"]").addClass("banner-action").siblings().removeClass("banner-action");
        	if(nowpage==3){
	        	nowpage=-1;
	        }
        }
	}
	setInterval("show()",2000);




$(function(){
	var isTop=true;
	var topBtn=$("#top-btn");
	var clientHeight=document.documentElement.clientHeight;
	window.onscroll=function(){
		
		if(!isTop){
			$("html,body").stop();	
		}
		
		var osTop=document.documentElement.scrollTop || document.body.scrollTop;
		if(osTop>=clientHeight){
			topBtn.css("display","block");
		}else{
			topBtn.css("display","none");
		}
	}
	$("#top-btn").click(function(){

		$("html,body").animate({scrollTop:0},500);
		isTop=true;
	})
	
	var n=0;
	var imgLength=$(".b-img .bannerbox").length;
	var ctWidth=imgLength*100;
	var itemWidth=1/imgLength*100;
	$(".b-img").width(ctWidth+"%");
	$(".b-img .bannerbox").width(itemWidth+"%");
	$(".b-list").width(imgLength*26);
	if(imgLength>1){
		for(var i=0;i<imgLength;i++){
			var listSpan=$("<span></span>")
			$(".b-list").append(listSpan);
		}
	}
	$(".b-list span:eq(0)").addClass("spcss").siblings("span").removeClass("spcss");
	$(".bar-right em").click(function(){
		if(n==imgLength-1)
		{
			var ctPosit=(n+1)*100;
			$(".banner,.banner1").append($(".b-img").clone());
			$(".b-img:last").css("left","100%");
			$(".b-img:first").animate({"left":"-"+ctPosit+"%"},1000);
			$(".b-img:last").animate({"left":"0"},1000);
			var setTime0=setTimeout(function () {
            $(".banner .b-img:first,.banner1 .b-img:first").remove();
            }, 1000);
			n=0;
			$(".b-list span:eq("+n+")").addClass("spcss").siblings("span").removeClass("spcss");
			}
		else
		{
		n++;
		var ctPosit=n*100;
		$(".b-img").animate({"left":"-"+ctPosit+"%"},1000);
		$(".b-list span:eq("+n+")").addClass("spcss").siblings("span").removeClass("spcss");
		}
		})
	$(".bar-left em").click(function(){
		if(n==0)
		{
			var stPosit=imgLength*100;
			var etPosit=(imgLength-1)*100;
			$(".banner,.banner1").prepend($(".b-img").clone());
			$(".b-img:first").css("left","-"+stPosit+"%");
			$(".b-img:last").animate({"left":"100%"},1000);
			$(".b-img:first").animate({"left":"-"+etPosit+"%"},1000);
			var setTime0=setTimeout(function () {
            $(".banner .b-img:last,.banner1 .b-img:last").remove();
            }, 1000);
			n=imgLength-1;
			$(".b-list span:eq("+n+")").addClass("spcss").siblings("span").removeClass("spcss");
			}
		else
		{
		n--;
		var ctPosit=n*100;
		$(".b-img").animate({"left":"-"+ctPosit+"%"},1000);
		$(".b-list span:eq("+n+")").addClass("spcss").siblings("span").removeClass("spcss");
		}
		})
	$(".b-list span").click(function(){
		var lsIndex=$(this).index();
		n=lsIndex;
		var ctPosit=n*100;
		$(".b-img").animate({"left":"-"+ctPosit+"%"},1000);
		$(this).addClass("spcss").siblings("span").removeClass("spcss");
		})
	function rollEnvent(){
		if(n==imgLength-1){
			var ctPosit=(n+1)*100;
			$(".banner,.banner1").append($(".b-img").clone());
			$(".b-img:last").css("left","100%");
			$(".b-img:first").animate({"left":"-"+ctPosit+"%"},1000);
			$(".b-img:last").animate({"left":"0"},1000);
			var setTime0=setTimeout(function () {
	            $(".banner .b-img:first,.banner1 .b-img:first").remove();
	        }, 1000);
			n=0;
			$(".b-list span:eq(0)").addClass("spcss").siblings("span").removeClass("spcss");
		}
		else{
			n++;
			var ctPosit=n*100;
			$(".b-img").animate({"left":"-"+ctPosit+"%"},1000);
			$(".b-list span:eq("+n+")").addClass("spcss").siblings("span").removeClass("spcss");
		}
	}
	var slidesetInterval=setInterval(rollEnvent,4000);
	$(".banner,.banner1").hover(function(){clearInterval(slidesetInterval);},function(){slidesetInterval=setInterval(rollEnvent,4000);});
	$(".bar-left").mouseover(function(){
		// $(this).css("background","url(images/arr-bg.png)");
		$(this).find("em").addClass("emcss");
		}).mouseleave(function(){
		$(this).css("background","none");
		$(this).find("em").removeClass("emcss");
	})
	$(".bar-right").mouseover(function(){
		// $(this).css("background","url(images/arr-bg.png)");
		$(this).find("em").addClass("emcss");
	}).mouseleave(function(){
			$(this).css("background","none");
			$(this).find("em").removeClass("emcss");
	})
})
//全屏滚动end

//	上拉
	$(".three_a").hover(function(){
		$(this).find(".three_hidden").stop().animate({'height':'218px'},500);
	},function(){
		$(this).find(".three_hidden").stop().animate({'height':'0px'},500);
	})
	$(".service1").hover(function(){
		$(this).find(".service_hidden").stop().animate({'height':'342px'},500);
	},function(){
		$(this).find(".service_hidden").stop().animate({'height':'0px'},500);
	})
//	$(".case-bottom").hover(function(){
//		$(".case-bottom").stop().animate({'bottom':'0px'},500);
//		$(this).stop().animate({'bottom':'50px'},500);
//	})
//	底部小人和头部导航
	var ww=$(window).width();
        var winh=$(window).height();
	var wh=$(document).height();
        var scroll=0;
        var jian=0;
	$(window).scroll(function(){
	   scroll=$(window).scrollTop();
           jian=wh-scroll-winh;
	   if(scroll>=38){
	   	$(".nav").addClass("nav_fix");
	   	$(".nav .nav-a img").attr({ "src": "/Muban/Default/PC/img/logo1.png" });
	   }else{
	   	 $(".nav").removeClass("nav_fix");
	   	 $(".nav .nav-a img").attr({ "src": "/Muban/Default/PC/img/logo.png" });
	   }
           if(scroll<winh){
	   	 $(".bh").css({"opacity":"0"});
	   }else{
	   	 $(".bh").css({"opacity":"1"});
	   }
    });
//  定时器
   function showback(){
    	if(scroll>winh){
    		$(".bh").animate({'left':'0px'},500);
    	}
    }
    var key=setInterval("showback()",15000);
	$(".bh-back").click(function(){
		$(".bh").animate({'left':'-'+ww+'px'},500);
		$(".bh-bug").show();
	})
	$(".bh-bug").click(function(){
                 $(".bh").animate({'left':'0px'},500);
        })
//	下拉
	$(".spe-li").hover(function(){
		$(".header_table").stop().slideDown("slow");
		$(this).addClass("ul-red");
		$(this).find("img").attr({"src": "/Muban/Default/PC/img/add_redxl.jpg"});
	},function(){
		$(".header_table").stop().slideUp("slow");
		$(this).removeClass("ul-red");
		$(this).find("img").attr({"src": "/Muban/Default/PC/img/add_whitexiala.jpg"});
	})
//二维码
	$("#header_weixin").hover(function(){
                $(this).addClass("ul-red");
                $(this).find(".ul-i").attr("src","/Muban/Default/PC/img/add_redwx.jpg");
		$(this).find(".header_img").stop().slideDown("slow");
	},function(){
		$(this).removeClass("ul-red");
                $(this).find(".ul-i").attr("src","/Muban/Default/PC/img/add_whitewx.jpg");
                $(this).find(".header_img").stop().slideUp("slow");
	})
	$("#header_taobao").hover(function(){
    
               $(this).addClass("ul-red");
               $(this).find("a").css({"color":"#ffffff"});
                $(this).find(".ul-i").attr("src","/Muban/Default/PC/img/add_redtb.jpg");
		$(this).find(".header_img").stop().slideDown("slow");
	},function(){
               $(this).removeClass("ul-red");
               $(this).find("a").css({"color":"#000000"});
               $(this).find(".ul-i").attr("src","/Muban/Default/PC/img/add_whitetb.jpg");
               $(this).find(".header_img").stop().slideUp("slow");
	})
//免费预约变色
$(".free-redli").hover(function(){
		 $(this).find(".free-redli-mengban").stop().fadeIn(1000);
	},function(){
		$(this).find(".free-redli-mengban").stop().fadeOut(1000);
	});
$(".free-li").eq(0).hover(function(){
		  $(this).find(".free-redli-mengban1").stop().fadeIn(1000);
		  $(this).find(".free-redli-mengban1 img").attr("src","/Muban/Default/PC/img/right11.png");
	},function(){
		$(this).find(".free-redli-mengban1").stop().fadeOut(1000,function(){
			$(this).find(".free-redli-mengban1 img").attr("src","/Muban/Default/PC/img/right1.png");
		});
	});
	$(".free-li").eq(1).hover(function(){
		  $(this).find(".free-redli-mengban1").stop().fadeIn(1000);
		  $(this).find(".free-redli-mengban1 img").attr("src","/Muban/Default/PC/img/right22.png");
	},function(){
		$(this).find(".free-redli-mengban1").stop().fadeOut(1000,function(){
			$(this).find(".free-redli-mengban1 img").attr("src","/Muban/Default/PC/img/right2.png");
		});
	});
	$(".free-li").eq(2).hover(function(){
		  $(this).find(".free-redli-mengban1").stop().fadeIn(1000);
		  $(this).find(".free-redli-mengban1 img").attr("src","/Muban/Default/PC/img/right33.png");
	},function(){
		$(this).find(".free-redli-mengban1").stop().fadeOut(1000,function(){
			$(this).find(".free-redli-mengban1 img").attr("src","/Muban/Default/PC/img/right3.png");
		});
	});
	
	
	
//全部红色
$(".case-left").hover(function(){
		 $(this).find(".add-mengban").stop().fadeIn(300);
	},function(){
		$(this).find(".add-mengban").stop().fadeOut(300);
	});
//右边计算器
	$(".add-jisunji").hover(function(){
		$(this).find(".jsq_box").stop().slideDown();
	},function(){
		$(this).find(".jsq_box").stop().slideUp();
	});
	

//height
$(".height-nr-in .imgbox").each(function(){
		$(this).hover(function(){
			$(this).find(".mengban").stop().slideDown();
		},function(){
			$(".mengban").stop().slideUp();
		});
	})

//ketang
$(function(){
	var obj=$("#obj1 ul li");
	var obj1=$("#obj2 ul li");
		function num1(obj){
			var liLen=obj.length;
			for(var i=1;i<=liLen;i++){
				var txt2=$("<span class='f-case1-num'></span>").text(i);   // 以 jQuery 创建新元素
				obj.eq(i-1).find("a").before(txt2);    
			}
		};
		num1(obj);
		num1(obj1);
});
$(".ck-slide-wrapper li").eq(0).show();
      (function($){
        function init(){
		var bannerLen=$(".ck-slide-wrapper li").length;
		for(var i=0;i<bannerLen;i++){
			if(i==0){
				$("<li class='current'><em></em></li>").appendTo($(".dot-wrap"));
			}else{
				$("<li><em></em></li>").appendTo($(".dot-wrap"));
			}
		}
	}
	init();
    $.fn.ckSlide = function(opts){
        opts = $.extend({}, $.fn.ckSlide.opts, opts);
        this.each(function(){
            var slidewrap = $(this).find('.ck-slide-wrapper');
            var slide = slidewrap.find('li');
            var count = slide.length;
            var that = this;
            var index = 0;
            var time = null;
            $(this).data('opts', opts);
            // next
            $(this).find('.ck-next').on('click', function(){
                if(opts['isAnimate'] == true){
                    return;
                }
                
                var old = index;
                if(index >= count - 1){
                    index = 0;
                }else{
                    index++;
                }
                change.call(that, index, old);
            });
            // prev
            $(this).find('.ck-prev').on('click', function(){
                if(opts['isAnimate'] == true){
                    return;
                }
                
                var old = index;
                if(index <= 0){
                    index = count - 1;
                }else{                                      
                    index--;
                }
                change.call(that, index, old);
            });
            $(this).find('.ck-slidebox li').each(function(cindex){
                $(this).on('click.slidebox', function(){
                    change.call(that, cindex, index);
                    index = cindex;
                });
            });
            
            // focus clean auto play
            $(this).on('mouseover', function(){
                if(opts.autoPlay){
                    clearInterval(time);
                }
                $(this).find('.ctrl-slide').css({opacity:0.6});
            });
            //  leave
            $(this).on('mouseleave', function(){
                if(opts.autoPlay){
                    startAtuoPlay();
                }
                $(this).find('.ctrl-slide').css({opacity:0.15});
            });
            startAtuoPlay();
            // auto play
            function startAtuoPlay(){
                if(opts.autoPlay){
                    time  = setInterval(function(){
                        var old = index;
                        if(index >= count - 1){
                            index = 0;
                        }else{
                            index++;
                        }
                        change.call(that, index, old);
                    }, 2000);
                }
            }
            // 修正box
            var box = $(this).find('.ck-slidebox');
            box.css({
                'margin-left':-(box.width() / 2)
            })
            // dir
            switch(opts.dir){
                case "x":
                    opts['width'] = $(this).width();
                    slidewrap.css({
                        'width':count * opts['width']
                    });
                    slide.css({
                        'float':'left',
                        'position':'relative'
                    });
                    slidewrap.wrap('<div class="ck-slide-dir"></div>');
                    slide.show();
                    break;
            }
        });
    };
    function change(show, hide){
        var opts = $(this).data('opts');
        if(opts.dir == 'x'){
            var x = show * opts['width'];
            $(this).find('.ck-slide-wrapper').stop().animate({'margin-left':-x}, function(){opts['isAnimate'] = false;});
            opts['isAnimate'] = true
        }else{
            $(this).find('.ck-slide-wrapper li').eq(hide).stop().animate({opacity:0});
            $(this).find('.ck-slide-wrapper li').eq(hide).css('display','none');
            $(this).find('.ck-slide-wrapper li').eq(show).show().css({opacity:0}).stop().animate({opacity:1});
            $(this).find('.ck-slide-wrapper li').eq(show).css('display','block');
        }
        $(this).find('.ck-slidebox li').removeClass('current');
        $(this).find('.ck-slidebox li').eq(show).addClass('current');
    }
    $.fn.ckSlide.opts = {
        autoPlay: false,
        dir: null,
        isAnimate: false
    };
})(jQuery);
$('.ck-slide').ckSlide({
				autoPlay: true
			});//vr
$(function(){
		var LiLen=$(".pic_lists ul li").length;
		var i=5;//每一屏的数量
		var page_count=Math.ceil(LiLen/5);
		var page=1;
		var $picDiv=$(".pic_lists");
		var $p_Div=$(".pic_content");
		var $pDiv_w=$p_Div.width()+12;
		$(".vr-next,.xq_btn_next").click(function(){
			if(page_count>page){
				$picDiv.animate({left:'-'+page*$pDiv_w+"px"},"normal");
				page++;
			}
		});
		$(".vr-prev,.xq_btn_pre").click(function(){
			if(page>1){
				$picDiv.animate({left:"+="+$pDiv_w+'px'},"normal");
			page--;
			}
		});
	});
//xiangqing
   $(".xq_br_top ul li").click(function(){
		$(this).addClass("this").siblings().removeClass("this");
	})
	var imgName;
	$(".xq_imgcont ul li").click(function(){
		imgName=$(this).find("img").attr("src");
		
		$(".xq_bigimg").attr("src",imgName);
	});
	var LiLen1=$(".xq_imgcont ul li").length;
	
	var page_count1=Math.ceil(LiLen1/3);
	
	var page1=1;
	var $p_Div1=$(".xq_imgcont")
	var $pDiv_w1=$p_Div1.width();
	$(".xq_btn_next").click(function(){
		if(page_count1>page1){
			$(".xq_imgcont ul").animate({left:'-'+page1*$pDiv_w1+"px"},"normal");
			page1++;
		}
	});
	$(".xq_btn_pre").click(function(){
		if(page1>1){
			$(".xq_imgcont ul").animate({left:"+="+$pDiv_w1+'px'},"normal");
		    page1--;
		}
	});
//xiangqing
var xqImg=$(".xq_imgcont ul li").eq(0).find("img").attr("src");
$(".xq_left .xq_bigimg").attr("src",xqImg);

//三个小图标
$(".type-list-in  .type-list-in-tit").eq(1).find("img").attr("src","/Muban/Default/PC/img/height2.png");
$(".type-list-in  .type-list-in-tit").eq(2).find("img").attr("src","/Muban/Default/PC/img/height3.png");

//lunbo两张图切换
 var twow=$(".decoration-left").width();//左边盒子的
	  var twow_right=$(".decoration-right").width();//右边盒子的
	  var twol=0;//左边盒子移动的宽度
	  var twol_right=0;//右边盒子移动的宽度
	  var twotimer=null;
	  var twolen=$(".decoration-banner1 .decoration-left").length*2;
	 $(".decoration-banner1").append($(".decoration-banner1").html()).css({'width':twolen*twow, 'left': -twolen*twow/2});
	 $(".decoration-banner2").append($(".decoration-banner2").html()).css({'width':twolen*twow_right, 'left': -twolen*twow_right/2});
	//自动每5秒切换一次 
	//twotimer=setInterval(init,5000);	
	function init(){
		 $(".decoration-button-right .decoration-button2").trigger('click'); 
	}
	
	$(".decoration-button-left,.decoration-button-right").hover(function(){
		 clearInterval(twotimer);
		},function(){
			twotimer=setInterval(init,5000);
	  });
	
	  $(".decoration-button-left .decoration-button1").click(function(){
		  twol=parseInt($(".decoration-banner1").css("left"))+twow;  //这里要转成整数，因为后面带了px单位
		  twol_right=parseInt($(".decoration-banner2").css("left"))+twow_right;
			 showCurrent(twol,twol_right); 
		  });
		 $(".decoration-button-right .decoration-button2").click(function(){
		     twol=parseInt($(".decoration-banner1").css("left"))-twow;//这里要转成整数，因为后面带了px单位
		     twol_right=parseInt($(".decoration-banner2").css("left"))-twow_right;
			   showCurrent(twol,twol_right);
	  });
	   function showCurrent(twol,twol_right){     
	   if($(".decoration-banner1").is(':animated')){ 
	      return;
	   }
	   if($(".decoration-banner2").is(':animated')){
	      return;
	   }
		   $(".decoration-banner1").animate({"left":twol},500,function(){
				if(twol==0){
			   $(".decoration-banner1").css("left",-twolen*twow/2);   
			 }else if(twol==(1-twolen)*twow){
				 $(".decoration-banner1").css('left',(1-twolen/2)*twow); 
				}
		   }); 
		   
		     $(".decoration-banner2").animate({"left":twol_right},500,function(){
						if(twol_right==0){
					   $(".decoration-banner2").css("left",-twolen*twow_right/2);   
					 }else if(twol_right==(1-twolen)*twow_right){ 
						 $(".decoration-banner2").css('left',(1-twolen/2)*twow_right); 
						}
				  }); 	  
		  }

//装修课堂的三张图片切换
$(".fuwu-car .fuwu-car-name").each(function(index){
    if($(this).find('a').attr('href')==window.location.pathname){
        if(index==0){
        	var kt_a1=$("#kt_hiddenImg").find('a').eq(0).attr("src");
        	var kt_img1=$("#kt_hiddenImg").find('a').eq(0).find('img').attr("src");
			$(".fuwu1 .wfuwu a").attr("src",kt_a1);
			$(".fuwu1 .wfuwu img").attr("src",kt_img1);
		}else if(index==1){
			var kt_a2=$("#kt_hiddenImg").find('a').eq(1).attr("src");
			var kt_img2=$("#kt_hiddenImg").find('a').eq(1).find('img').attr("src");
			$(".fuwu1 .wfuwu a").attr("src",kt_a2);
            $(".fuwu1 .wfuwu img").attr("src",kt_img2);
		}else{
			var kt_a3=$("#kt_hiddenImg").find('a').eq(2).attr("src");
			var kt_img3=$("#kt_hiddenImg").find('a').eq(2).find('img').attr("src");
			$(".fuwu1 .wfuwu a").attr("href",kt_a3);
			$(".fuwu1 .wfuwu img").attr("src",kt_img3);
		}
    }
})
//去掉title
$(".zxiu img,.old img").attr("title"," ");


 
//高度
//$(window).resize(function(){
// var liheight=$(".ck-slide-wrapper li").height();
//   $(".ck-slide-wrapper,.ck-slide").css({height:liheight+"px"});
//});

$(".header_table").find("tr:first>td").css("border-top","none");//去掉上边框  
   $(".header_table").find("tr:last>td").css("border-bottom","none");//去掉下边框  
    $(".header_table").find("tr>td:first-child").css("border-left","none");//去掉左边框  
    $(".header_table").find("tr>td:last-child").css("border-right","none");//去掉右边框



//报价隐藏蒙板按钮
$("#baojia_qr").click(function(){
	$(".baojia_mengban,.baojia_alert").css({"display":"none"});
})
$(".index_backImg").click(function(){
	$(".baojia_mengban,.index_alert").css({"display":"none"});
})

//首页城市切换
$(".header_table ul:not(:last-child) li").click(function(){
	$(".ul-afterspan").text($(this).text());
})

$(" img").attr('title',"");

	



