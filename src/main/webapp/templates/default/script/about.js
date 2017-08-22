$(function() {
    var f1top = $('#f1').position().top,
        f2top = $('#f2').position().top,
        f3top = $('#f3').position().top,
        // f4top = $('#f4').position().top,
        f5top = $('#f5').position().top,
        f6top = $('#f6').position().top,
        f7top = $('#f7').position().top,
        hltop = $('#honorList').position().top,
        wh = $(window).height(),
        dh = $(document).height(),
        t = true;

    // 滚动操作
    $(window).scroll(function(event) {
        var h = $(window).scrollTop();

        if (h >= 100) {
            $('.aboutFloat').stop(true, true).show().addClass('ttb');
        } else {
            $('.aboutFloat').stop(true, true).hide().removeClass('ttb');
        };

        // 滚动与侧边栏的联系
        if (h >= f1top && h < f2top) {
            $('#af1').addClass('on');
        } else {
            $('#af1').removeClass('on');
        }

        if (h >= f2top && h < f3top) {
            $('#af2').addClass('on');
        } else {
            $('#af2').removeClass('on');
        }

        if (h >= f3top && h < f5top) {
            $('#af3').addClass('on');
        } else {
            $('#af3').removeClass('on');
        }

        // if (h >= f4top && h < f5top) {
        // 	$('#af4').addClass('on');
        // } else {
        // 	$('#af4').removeClass('on');
        // }

        if (h >= f5top && h < f6top) {
            $('#af5').addClass('on');
        } else {
            $('#af5').removeClass('on');
        }

        if (h >= f6top && h < f7top) {
            var i = $('#aboutNewsSlide .hd .on').index();
            if (i === 0 && t) {
                $('#af6').addClass('on');
            }
            if (i == 1 && t) {
                $('#af7').addClass('on');
            }
            if (i == 2 && t) {
                $('#af8').addClass('on');
            }
        } else {
            $('#af6,#af7,#af8').removeClass('on');
            t = true;
        }

        if (h >= f7top || h + wh >= dh) {
            $('#af9').addClass('on').siblings().removeClass('on');
        } else {
            $('#af9').removeClass('on');
        }

        // 滚动内容显示
        if (h + wh >= f3top) {
            $('#aboutSlide').animate({
                opacity: 1
            }, 2000);
        }

        if (h + wh > hltop) {
            $('#honorList').addClass('wikiBtT');
        }

        if (h + wh >= f5top) {
            $('#partnerSlide .bd').addClass('wikiBtS');
        }

        if (h + wh + 300 >= f6top) {
            $('#wfBox .dot').each(function(i) {
                setTimeout(function() {
                    $('#wfBox .dot').eq(i).animate({
                        opacity: 1
                    }, 400);
                }, i * 100);
            });
        }

        if (h + wh - 200 > f7top) {
            $('.acCon .acCardBox').eq(0).addClass('fanL');
            $('.acCon .acCardBox').eq(1).addClass('fanR');
        }
    });

    // 点击操作
    $('#af1').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f1top
        });
    });
    $('#af2').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f2top
        });
    });
    $('#af3').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f3top
        });
    });
    // $('#af4').click(function() {
    // 	$('html,body').stop(true, true).animate({
    // 		scrollTop: f4top
    // 	});
    // });
    $('#af5').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f5top
        });
    });
    $('#af6').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f6top
        });
        $('#aboutNewsSlide .hd li').eq(0).trigger('click');
        $(this).addClass('on').siblings().removeClass('on');
        t = true;
    });
    $('#af7').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f6top
        });
        $('#aboutNewsSlide .hd li').eq(1).trigger('click');
        $(this).addClass('on').siblings().removeClass('on');
        t = false;
    });
    $('#af8').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f6top
        });
        $('#aboutNewsSlide .hd li').eq(2).trigger('click');
        $(this).addClass('on').siblings().removeClass('on');
        t = false;
    });
    $('#af9').click(function() {
        $('html,body').stop(true, true).animate({
            scrollTop: f7top
        });
    });
});
