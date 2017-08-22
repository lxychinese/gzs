// JavaScript Document

// 按需写入所需的函数名
$(function() {

    forms();

    style();

    animate();
    
    $(window).scroll(function(){
        if($(this).scrollTop() > 90){
            $('.indexGoTop').stop(true,true).fadeIn();
        }else{
            $('.indexGoTop').stop(true,true).fadeOut();            
        }            
    });

    // 首页搜索框
    $('.headerContact .search').hover(function() {
        $(this).find('.searchBox').stop(0, 0).animate({
            opacity: 1,
            width: '180px'
        });
    }, function() {
        $(this).find('.searchBox').stop(0, 0).animate({
            opacity: 0,
            width: 0
        });
    });

    $(".nav").lavaLamp({
        fx: "easeOutBack",
        speed: 700
    });

    goTop(".goTop,.aboutFloat .botC,.indexGoTop,.bfBot a");

    $('.nav li').hover(function() {
        $(this).find('.sub').show();
    }, function() {
        $(this).find('.sub').hide();
    });
    
    
    $(window).scroll(function() {
        var st = $(window).scrollTop();

        if (st > 90) {
            $('.indexFloatCon .indexGoTop').stop(true, true).animate({
                top: 0
            });
        } else {
            $('.indexFloatCon .indexGoTop').stop(true, true).animate({
                top: '46px'
            });
        }
    });

    $('#jobIframe').find('.closeBtn').click(function() {
        $('#jobIframe').hide();
        $('#jobBox').css('opacity', 1);
    });

    $('.faqList li h3').click(function(){
        var self = $(this);

        if (self.parent('li').hasClass('on')) {
            self.parent('li').removeClass('on').find('.info').hide();
        }else{
            self.parent('li').addClass('on').siblings().removeClass('on');
            self.next('.info').stop(0,0).show().parent('li').siblings('li').find('.info').hide();
        };
    });

});

//样式微调——自行扩展增删
function style() {

    //$('.nav li').last().css('marginRight', 0);

    $('.indexPro dl').each(function() {
        var self = $(this),
            oLi = self.find('li'),
            length = oLi.length;
        if (length > 3) oLi.addClass('short');
    });

    // 首页客户图标排版
    $('.indexCustomSlide .bd ul').each(function() {
        var self = $(this),
            oLi = self.find('li');
        oLi.eq(0).css('marginLeft','502px');
        oLi.eq(4).css('marginLeft','379px');
        oLi.eq(9).css('marginLeft','256px');
        oLi.eq(15).css('marginLeft','133px');
    });

    $('.newsCon .newsBox.even').find('li:last-child').addClass('last');

    $('.newsBox .newsList li:nth-child(2n+6)').css('marginLeft', '15px');

    $('.reNewsBox .newsList li:nth-child(2n+1)').css('marginRight', '15px');

}

//表单相关
function forms() {

    // 输入框文字清空还原，控制value
    // <input type="text" value="请输入关键字" />
    $('.searchBox input[type="text"]').focus(function() {
        if ($(this).val() == this.defaultValue) {
            $(this).val("");
        }
    }).blur(function() {
        if ($(this).val() === '') {
            $(this).val(this.defaultValue);
        }
    });

    $('.faqSearch input[type="text"]').focus(function(event) {
        if ($(this).val() == this.defaultValue) {
            $(this).val("");
        }
        $(this).stop(0,0).animate({width:355});
    }).blur(function() {
        if ($(this).val() === '') {
            $(this).val(this.defaultValue);
        }
        $(this).stop(0,0).animate({width:155});
    });
}


// 动画相关
function animate() {

    $('.caseInfoBox .goNextBtn').click(function(event) {
        $('html,body').animate({
            scrollTop: $('.caseInfoList').position().top
        }, 600);
    });

    $('.buildBox').each(function(i) {
        var self = $(this),
            h = self.position().top;

        self.find('.goNext').click(function() {
            var _this = $(this);

            if (!_this.hasClass('up')) {
                _this.addClass('up');
                $('html,body').animate({
                    scrollTop: h - 50
                }, 600);

            } else {
                var ph = self.prev().position().top;

                _this.removeClass('up');
                $('html,body').animate({
                    scrollTop: ph - 50
                }, 600);
                console.log(ph);
            }
        });
    });

    $('.acCardBox').hover(function() {
        $(this).find('.way').show();
        $(this).find('.way img').addClass('ltr');
    }, function() {
        $(this).find('.way').hide();
        $(this).find('.way img').removeClass('ltr');
    });

    $('.wxMainBg dl').hover(function() {
        $(this).find('dd').stop(true,true).show(400,'easeOutBounce');
    }, function() {
        $(this).find('dd').stop(true,true).fadeOut('fast');
    });

    $('.wxMainBg').delay(1000).fadeIn(1000);

    $('.introR,.introL').delay(1500).fadeIn();

    /* 0810 */
    $('.indexFloatCon .online,.indexFloatCon .bf1,.indexFloatCon .bf2,.indexFloatCon .bf3,.indexFloatCon .bf4,.indexFloatCon .bf5,.indexFloatCon .bf6,.indexFloatCon .nextPage,.indexFloatCon .goList,.indexFloatCon .prevPage').hover(function() {
        $(this).stop(true, true).animate({
            left: '-90px'
        });
    }, function() {
        $(this).stop(true, true).animate({
            left: 0
        });
    });

    $('.indexFloatCon .ewmLi').hover(function() {
        $(this).find('.ewmCon').stop(true, true).fadeIn();
    }, function() {
        $(this).find('.ewmCon').stop(true, true).fadeOut();
    });

    $('.indexFloatCon .wenti').hover(function() {
        $(this).find('.wentiCon').stop(true, true).fadeIn();
    }, function() {
        $(this).find('.wentiCon').stop(true, true).fadeOut();
    })
}

// 简单标签切换
function tabs(tit, box) {
    /*html结构
		<div class="tabs">
		
			<div class="tabhd">
				<ul>
					<li>标题一</li>
					<li>标题二</li>
				</ul>
			</div>
			
			<div class="tabbd">
				<div>内容一</div>
				<div>内容二</div>
			</div>
			
		</div>
	*/
    var $div_li = $(tit + " ul li");
    var i;

    $(tit + " ul li").each(function() {
        if ($(this).hasClass('cur'))
            i = $(this).index();
    });

    $(box + " > div").eq(i).show();

    $div_li.click(function() {
        var index = $div_li.index(this);

        $(this).addClass("cur").siblings().removeClass("cur");
        $(box + " > div").eq(index).fadeIn("linear").siblings().hide();
    });

}

// 回到顶部
function goTop(dom) {
    $(dom).click(function() {
        $('html,body').animate({
            scrollTop: 0
        }, 800);
    });
}

// 招聘弹出层0324
// @param url 传入iframe的url
function popup(url) {
    var wh = $(window).height();
    var domH = $('#jobIframe').height();
    var st = $(window).scrollTop();
    var domt = st + (wh - domH) / 2;

    if (st === 0 && st + domH >= wh) {
        domt = 102;
    };

    $('#jobIframe').find('iframe').attr('src', url);
    $('#jobIframe').css('top', domt).show();
    $('#jobBox').css('opacity', 0);
}
