$(function() {

    var headerText = $('header h1').text();
    var userA = navigator.userAgent;
    var isIOS = userA.match('iPad') || userA.match('iPhone');
    var winH = $(window).height();

    // console.log(isIOS);

    if (isIOS) {
        $('head').append('<link rel="stylesheet" href="/templates/default/style_m/ios.css">');
    };

    $('#headerMenu').on('click', function(event) {
        var st = $(window).scrollTop();
        $('header > a').css('display', 'none');
        $('header > a[id*="Btn"]').css('display', 'block');
        // $('body,html').attr('style','overflow:hidden; height:'+winH+'px;')
        // $('html').css({'height':'100%','overflow':'hidden'});
        $('#menuCon').css({'height': winH,'top':st});
        $('header h1').text('导航');
        document.addEventListener('touchmove', func, false);
    });

    $('#closeBtn,#goBackBtn').on('click', function(event) {
        $('header > a').css('display', 'block');
        $('header > a[id*="Btn"]').css('display', 'none');
        // $('body').removeAttr('style');
        // $('html').removeAttr('style');
        $('#menuCon').css({'height': 0,'top':0});
        $('header h1').text(headerText);
        document.removeEventListener('touchmove', func, false);
    });

    $('#footerMenu dl').on('click', function(event) {
        // event.preventDefault();
        var self = $(this);
        if (self.hasClass('on')) {
            self.removeClass('on').find('.sub').hide();
            $('#mask').remove();
        } else {
            var dh = $(document).height();
            self.siblings().removeClass('on').find('.sub').hide();
            self.addClass('on').find('.sub').show();
            if ($('body').has('#mask').length <= 0) {
                $('body').append('<div class="mask" id="mask" style="height:' + dh + 'px"></div>');
            }
        }
    });

    $('body').delegate('#mask', 'click', function(event) {
        $('#headerMenu').removeClass('on').next('#headerMenuList').stop(true, true).hide();
        $('#footerMenu dl').removeClass('on').find('.sub').stop(true, true).hide();
        $('#mask').remove();
    });

    document.addEventListener('scroll', function() {
        var st = $(window).scrollTop();
        var hh = $('header').height();

        /* 0327 */
        if (st >= 1) {
            $('#infoH').addClass('pf');
        } else {
            $('#infoH').removeClass('pf');
        }

        if (st >= hh) {
            $('#caseMenu,#newsMenu').addClass('pf');
        } else {
            $('#caseMenu,#newsMenu').removeClass('pf');
        }
    }, false);
});

function func(event){
    event.preventDefault();
}


