$(function() {
	style();
	animate();
	tab();
	gototop();
	path();
	$("select.relselet").customSelect();
	pos('.floorBox .hd ul li a');
	pos('.seartchab li a');
	heightanimate('.floorthreeright ul li', 'p', '30px');
	heightanimate('.projectlist li a', '.redbj', '201px');
	heightanimate('.salesBox .bImg li', 'p', '50px');
	$('.nav ul li').hover(function() {
		$(this).find('.navmenu').stop(true, true).slideDown();
	}, function() {
		$(this).find('.navmenu').stop(true, true).slideUp();
	});
	$('.floorimg li a').hover(function() {
		$(this).find('div').stop(true, true).fadeIn();
	}, function() {
		$(this).find('div').stop(true, true).fadeOut();
	});
	$(".floorsixlist li").hover(function() {
		$(this).find('.ftext img').stop(true, true).addClass('shake');
	}, function() {
		$(this).find('.ftext img').stop(true, true).removeClass('shake');
	});
	$('.honorlist li a').hover(function() {
		$('.main').css('z-index', '4');
		$(this).find('div').stop(true, true).slideDown();
	}, function() {
		$('.main').css('z-index', '2');
		$(this).find('div').stop(true, true).slideUp();
	});
})
function pos(dom) {
	var length = $(dom).length + 1;
	for (var j = 0; j <= length; j++) {
		$(dom).eq(j).addClass(function() {
			return 'a' + (j + 1);
		});
	}
}
function heightanimate(dom, dom2, dom3) {
	$(dom).hover(function() {
		$(this).find(dom2).stop(0, 0).animate({
			opacity : 1,
			height : dom3
		});
	}, function() {
		$(this).find(dom2).stop(0, 0).animate({
			opacity : 0,
			height : 0
		});
	});
}
function tab() {
	var $div_li = $(".projecttab .projectleft dd");
	$div_li.hover(function() {
		$(this).addClass("on").siblings().removeClass("on");
		var index = $div_li.index(this);
		$(".projectright > .prodate").eq(index).show().siblings().hide();
	});
}
function style() {
	var len = $('.linklist li').length;
	if (len % 7 !== 0) {
		$('.linklist li:last-child').addClass('on');
	} else {
		$('.linklist li:last-child').removeClass('on');
	}
	$('.linklist li:nth-child(7n+7)').css('width', '172px');
	$('.projectBox .projecttab').eq(2).addClass('fbj');
	$('.protable tr:even').addClass('probg');
}
function animate() {
	$('.linklist li').each(function() {
		var oLeft = $(this).position().left, oTop = $(this).position().top;
		$(this).hover(function(e) {
			if (oLeft + 553 < 1198) {
				$(this).find('.bImg').css('left', '170px')
			} else {
				$(this).find('.bImg').css('left', '-383px')
			}
			;
			if (oTop + 212 < 428) {
				$(this).find('.bImg').css('top', 0)
			} else {
				$(this).find('.bImg').css('bottom', 0)
			}
			;
			$(this).css('z-index', 4);
			$(this).find('.bImg').css('display', 'block').addClass('veLi');
		}, function() {
			$(this).css('z-index', 1);
			$(this).find('.bImg').css('display', 'none').removeClass('veLi');
		})
	});
}
function gototop() {
	$backToTopEle = $(".back2up").click(function() {
		$("html, body").animate({
			scrollTop : 0
		}, 300);
	}), $backToTopFun = function() {
		var st = $(document).scrollTop(), winh = $(window).height();
		(st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
		if (!window.XMLHttpRequest) {
			$backToTopEle.css("top", st + winh - 166);
		}
	};
	$backToTopSH = function() {
		var st = $(document).scrollTop(), winh = $(window).height();
		(st > 0) ? $('#floor_select').show() : $('#floor_select').hide();
		if (!window.XMLHttpRequest) {
			$('#floor_select').css("top", st + winh - 166);
		}
	};
	$(window).bind("scroll", $backToTopSH);
	$(function() {
		$backToTopSH();
	});
}
function path() {
	$(".newsboxlist").next('.paged').css('padding', '26px 0 47px 43px');
	$(".brandleft .newsboxlist").next('.paged').css('padding', '29px 0 2px');
	$(".othercase .caselist").next('.paged').css('padding', '3px 0 30px');
	$(".event_list div:last-child li:last-child").addClass('nobg');
}