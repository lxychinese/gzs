/*
 * 首页banner动画效果
 * @function endFun函数为当前视图的动画效果
 * @function startFun函数为当前视图动画效果执行前的效果
 * ---
 * @param i为当前分页数
 * @param c为分页总数
 * @param s相当与Jquery('.indexBanner')
 * @param t相当于titCell
 * @param m相当于mainCell
 * @param previ 为前一个分页值
 * @param nexti 为下一个分页值
 * ---
 * @animate startFun中的previ的动画效果为切换到当前分页的前一个视图隐藏动画
 * @animate startFun中的nexti的动画效果为切换到当前分页的下一个视图隐藏动画
 * ---
 * @css startFun中的css为当前视图图片的初始位置
 */


jQuery('.indexBanner').slide({
    mainCell: ".bd ul",
    titCell: ".hd ul",
    autoPage: "<li></li>",
    autoPlay: true,
    effect: "fold",
    interTime: 5000,
    delayTime: 1500,
    easing: "easeInSine",
    mouseOverStop: false,
    startFun: function(i, c, s, t, m) {
        var previ = (i + 1 <= c && i + 1 > 1) ? i - 1 : c - 1,
            nexti = (i + 1 < c) ? i + 1 : 0,
            oLi = m.find('li');
        if (i === 0) {
            oLi.eq(previ).find('.pic1').stop(true, true).animate({
                    'marginLeft': '-525px',
                    'top': '-300px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'marginLeft': '150px',
                    'opacity': 0
                }, 800);

            oLi.eq(nexti).find('.pic1').stop(true, true).animate({
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    marginLeft: '75px',
                    'opacity': 0
                }, 800);

            oLi.eq(i).find('.pic1').css({
                'marginLeft': '50px',
                'top': '-50px',
                'opacity': 0
            }).next('.pic2').css({
                'top': 0,
                'opacity': 0
            });
        }

        if (i == 1) {
            oLi.eq(previ).find('.pic1').stop(true, true).animate({
                    'marginLeft': '50px',
                    'top': '-50px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'top': 0,
                    'opacity': 0
                }, 800);

            oLi.eq(nexti).find('.pic1').stop(true, true).animate({
                    marginLeft: '-600px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    marginLeft: '200px',
                    top: '120px',
                    'opacity': 0
                }, 800);

            oLi.eq(i).find('.pic1').css({
                'opacity': 0
            }).next('.pic2').css({
                marginLeft: '75px',
                'opacity': 0
            });
        }

        if (i == 2) {
            oLi.eq(previ).find('.pic1').stop(true, true).animate({
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'opacity': 0
                }, 800);

            oLi.eq(nexti).find('.pic1').stop(true, true).animate({
                    'bottom': '-470px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'top': 0,
                    'opacity': 0
                }, 800);

            oLi.eq(i).find('.pic1').css({
                marginLeft: '-600px',
                'opacity': 0
            }).next('.pic2').css({
                marginLeft: '200px',
                top: '120px',
                'opacity': 0
            });
        }

        if (i == 3) {
            oLi.eq(previ).find('.pic1').stop(true, true).animate({
                    marginLeft: '-600px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    marginLeft: '200px',
                    top: '120px',
                    'opacity': 0
                }, 800);

            oLi.eq(nexti).find('.pic1').stop(true, true).animate({
                    'top': '-300px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'marginLeft': '150px',
                    'opacity': 0
                }, 800);

            oLi.eq(i).find('.pic1').css({
                'bottom': '-470px',
                'opacity': 0
            }).next('.pic2').css({
                'top': 0,
                'opacity': 0
            });
        }

        if (i == 4) {
            oLi.eq(previ).find('.pic1').stop(true, true).animate({
                    'bottom': '-470px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'top': 0,
                    'opacity': 0
                }, 800);

            oLi.eq(nexti).find('.pic1').stop(true, true).animate({
                    'marginLeft': '50px',
                    'top': '-50px',
                    'opacity': 0
                }, 600)
                .next('.pic2').delay(500).animate({
                    'top': 0,
                    'opacity': 0
                }, 800);

            oLi.eq(i).find('.pic1').css({
                'marginLeft': '-525px',
                'top': '-300px',
                'opacity': 0
            }).next('.pic2').css({
                'marginLeft': '150px',
                'opacity': 0
            });
        }
    },
    endFun: function(i, c, s, t, m) {
        var oLi = m.find('li');
        if (i === 0) {
            oLi.eq(0).find('.pic1').stop(true, true).animate({
                marginLeft: '-100px',
                top: '96px',
                opacity: 1
            }, 800);
            oLi.eq(0).find('.pic2').stop(true, true).animate({
                top: '100px',
                opacity: 1
            }, 800);
        }

        if (i === 1) {
            oLi.eq(i).find('.pic1').stop(true, true).animate({
                opacity: 1
            }, 800);
            oLi.eq(i).find('.pic2').stop(true, true).animate({
                marginLeft: '75px',
                opacity: 1
            }, 800);
        }

        if (i === 2) {
            oLi.eq(i).find('.pic1').stop(true, true).animate({
                marginLeft: '-537px',
                opacity: 1
            }, 800);
            oLi.eq(i).find('.pic2').stop(true, true).animate({
                marginLeft: '-53px',
                top: '8px',
                opacity: 1
            }, 800);
        }

        if (i === 3) {
            oLi.eq(i).find('.pic1').stop(true, true).animate({
                bottom: 0,
                opacity: 1
            }, 800);
            oLi.eq(i).find('.pic2').stop(true, true).animate({
                top: '150px',
                opacity: 1
            }, 800);
        }

        if (i === 4) {
            oLi.eq(i).find('.pic1').stop(true, true).animate({
                top: '90px',
                opacity: 1
            }, 800, 'easeOutBounce');
            oLi.eq(i).find('.pic2').stop(true, true).animate({
                marginLeft: '70px',
                opacity: 1
            }, 800);
        }
    }
});
