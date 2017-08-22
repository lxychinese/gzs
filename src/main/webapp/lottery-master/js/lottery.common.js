/* 设置背景图片的位置（按需求将一张大背景适配给3个窗口）*/
var setBg = function(pos){
	var h = $(window).height(), w = $(window).width(), ml;
	if(h*2 > w){
		w = h*6;
	}else{
		w = w*3;
	}
	if(pos == 'center'){
		ml = -w/3;
	}
	if(pos == 'left'){
		ml = 0;
	}
	if(pos == 'right'){
		ml = -w/3*2; 
	}
	$('.bgarea').css({'height':h, 'width': w,'margin-left':ml});	
};
$(function(){
	var pos = $('.lottery').attr('pos');
	setBg(pos);
	$(window).resize(function(event) {
		setBg(pos);
	});
});
		