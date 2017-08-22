$(function(){
	 jQuery(".fullSlide").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true});/*ht*/
	 jQuery(".focusBox").slide({ mainCell:".pic",effect:"fold", autoPlay:true, delayTime:300});/*oppein*/
	 jQuery(".baimaBox").slide({ mainCell:".pic",effect:"fold", autoPlay:true, delayTime:300});/*baima*/
	 jQuery(".adBox").slide({ mainCell:".pic",effect:"fold", autoPlay:true, delayTime:300});/*aodi*/
	
	});
	
$(function () {
    function isScrolledIntoView(elem) {
        var docViewTop = $(window).scrollTop();
        var docViewBottom = docViewTop + $(window).height();
        var elemTop = $(elem).offset().top;
        if (elemTop + 50 < docViewBottom) {
            return true
        } else {
            return false
        }
    }

    var box = $('.text1'), 
		box2 = $('.text2'),
		box3 = $('.text3'), 
		box4 = $('.oppeintext2'), 
		box5 = $('.oppeintext3'), 
		box6 = $('.oppeintext4'), 
		box7 = $('.downtext'), 
		box8 = $('.adscreen3'), 
		box9 = $('.adscreen2'), 
		box10 = $('.ztshow'), 
		box11 = $('.circle'), 
		box12 = $('.sfyleft'), 
		box13 = $('.sfyright');

    $.each(box, function () {
        $(this).attr('init', 'false');
    });
    $.each(box2, function () {
        $(this).attr('init', 'false');
    });
    $.each(box3, function () {
        $(this).attr('init', 'false');
    });
    $.each(box4, function () {
        $(this).attr('init', 'false');
    });
    $.each(box5, function () {
        $(this).attr('init', 'false');
    });
    $.each(box6, function () {
        $(this).attr('init', 'false');
    });
    $.each(box7, function () {
        $(this).attr('init', 'false');
    });
    $.each(box8, function () {
        $(this).attr('init', 'false');
    });
    $.each(box9, function () {
        $(this).attr('init', 'false');
    });
    $.each(box10, function () {
        $(this).attr('init', 'false');
    });
    $.each(box11, function () {
        $(this).attr('init', 'false');
    });
    $.each(box12, function () {
        $(this).attr('init', 'false');
    });
    $.each(box13, function () {
        $(this).attr('init', 'false');
    });
	
    function animateInit(){
        $.each(box, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'left': '50%'}, 1000, 'easeOutCubic');
            }
        }); 
		$.each(box2, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'right': '50%'}, 1000, 'easeOutCubic');
            }
        });   
		$.each(box3, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'right': '50%'}, 1000, 'easeOutCubic');
            }
        });    
		$.each(box4, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'right': '50%'}, 1000, 'easeOutCubic');
            }
        });     
		$.each(box5, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'left': '50%'}, 1000, 'easeOutCubic');
            }
        });     
		$.each(box6, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'right': '50%'}, 1000, 'easeOutCubic');
            }
        });      
		$.each(box7, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                //$(this).animate({'right': '50%'}, 1000, 'easeOutCubic');
				$(this).addClass('y_fd');
            }
        });       
		$.each(box8, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'right': '100%'}, 1500, 'easeOutCubic');
            }
        });        
		$.each(box9, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'left': '50%'}, 2000, 'easeOutCubic');
            }
        });        
		$.each(box10, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).addClass('cz');
            }
        });          
		$.each(box11, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'top': '238px'}, 2000, 'easeOutCubic');
            }
        });         
		$.each(box12, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'left': '50%'}, 1000, 'easeOutCubic');
            }
        });         
		$.each(box13, function () {
            if ($(this).attr('init') == 'false' && isScrolledIntoView($(this))) {
                $(this).attr('init', 'true');
                $(this).animate({'right': '50%'}, 1000, 'easeOutCubic');
            }
        }); 
		 

    }
    animateInit();
    $(window).scroll(function () {
        animateInit();
    });

  });