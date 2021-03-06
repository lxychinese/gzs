
/* lottery */
var lottery = (function($){
	var 
		configMap = {
			$container : null,
			indexArr: [],
			peopleArr  : [],
			luckyArr : [],
			peopleArrLen : 0,
			lock: false,
			current: null,
			timer: 6,
			keycode : {
				'48' : { 'class' : 'grand',  'total' : 1 },
				'49' : { 'class' : 'first',  'total' : 3 },
				'50' : { 'class' : 'second', 'total' : 6 },
				'51' : { 'class' : 'third',  'total' : 6},
				'52' : { 'class' : 'third',  'total' : 9}
			}
		},
		initmodule;
	/*
	*定时随机加载
	*obj指定当前奖项
	*/
	loadPeopleRandom = function(){
		configMap.clearInterval = setInterval(function(){
			loadPeople(configMap.current, configMap.timer);
		},10);		
	};
	/* 
	* 根据生成的随机数组加载
	* obj指定当前奖项
	* timer每次加载的个数
	*/
	loadPeople = function(obj,timer){
		var ul = obj.find('.candidate');
		
		configMap.indexArr = selectfrom(0,configMap.peopleArr.length-1,timer),
		ul.find('li').remove();
		for(var i = 0; i<timer;i++){
			var index = configMap.indexArr[i], people = configMap.peopleArr[index], html, imgsrc, name;
			imgsrc = people.img_src;
			name = people.name;
			html = '<li>'
					+'<img src="images/img-border1.png" alt="">'
					+'<div class="person_image">'
						+'<div class="hexagon hexagon1">'
							+'<div class="hexagon-in1">'
								+'<div class="hexagon-in2">'
									+'<img src="'+imgsrc+'" alt="">'
								+'</div>'
							+'</div>'
						+'</div>'
					+'</div>';
			
				html += '<div class="name">'+name+'</div>';
			
			html += '</li>';
			ul.prepend(html);
		}
	};
	stopLoadPeople = function(){
		clearInterval(configMap.clearInterval);
	};
	/* 
	* 选择一定范围内去重的随机数
	* lowValue,highValue指定随机数范围如 0-32
	* timer指定返回的随机数个数
	* 返回格式为数组
	*/
	selectfrom = function(lowValue,highValue,timer){
			var arr = [];
			for(var i =0;;i++){
				if(arr.length<timer){ 
          			generateRandom(); 
    			}else{ 
      				break; 
   				} 
			}
			function generateRandom(){ 
			    var rand = getRandom();
			    for(var j = 0 ; j < arr.length; j++){ 
			        if(arr[j] == rand){ 
			            return false; 
			        }      
			    } 
			    arr.push(rand); 
			} 
			function getRandom(){
				var choice = highValue-lowValue+1;
				return Math.floor(Math.random()*choice+lowValue);
			}
			return arr;

	};
	/*
	* 更换奖项
	* 键盘操作【0:特等奖; 1:一等奖; 2:二等奖; 3: 三等奖】
	* CTRL + DELETE （ MAC环境 ）重置
	* 空格抽奖/结束抽奖
	*/
	keyEvent = function(){
		$(document).on('keydown', function(e){
			console.log(e.keyCode)
			var k = configMap.keycode[e.keyCode];
			if( !!k ){
				if(!configMap.lock){
					var obj = $('.'+k.class);
					obj.show().siblings('section').hide();
					loadPeople(obj,k.total);
					configMap.current = obj;
					configMap.timer = k.total;
				}
			}else if(e.ctrlKey && e.keyCode == 8){
				lottery.localStorage.clear();
				configMap.winLeft.close();
				configMap.winRight.close();
				window.location.reload();
			}
		});
		$(document).on('keydown.lazyloader',function(e) {
		
			if(e.keyCode == 32){//空格键
				if(!configMap.lock){
					//开始抽奖
					console.log(configMap.peopleArr.length);
					if(configMap.peopleArr.length < configMap.timer){
						alert('候选人数未达到中奖人数！');
						configMap.lock = false;
					}else{
						loadPeopleRandom();
						configMap.lock = true;
					}
				}else{
					//结束抽奖
					var key = configMap.current.attr('class'), num;
					
					if(key == 'third'){
						configMap.thirdCon ++;
						if(configMap.thirdCon == 5){
							alert('已抽完设定获奖人数');
							configMap.lock = false;
							return;
						}
						num = configMap.timer*(configMap.thirdCon-1);
					}
					for(var i=0;i<configMap.timer;i++){
						var index = configMap.indexArr[i], people = configMap.peopleArr[index];
						configMap.luckyArr.push(people);
						configMap.peopleArr[index] = null;
						if( key == 'third'){
							var id = i+num;
							//lottery.localStorage.set(key+'_'+id,people._id+","+people.name+','+people.img_src);
						}else{
							//lottery.localStorage.set(key+'_'+i,people._id+","+people.name+','+people.img_src);
						}
					//	console.log(people._id+","+people.name+','+people.img_src);

					}
					stopLoadPeople();
					showLucky();
					adjustArr();
					configMap.lock = false;
				}
			}
		});
	};
	showLucky = function(){
		
		
	};
	/* 抽奖结束后调整候选池人选 */
	adjustArr = function(){
		var arr = configMap.peopleArr;
		for(var i =0;i < configMap.luckyArr.length; i++){
			arr.remove(null);
			//console.log(arr[i]);
			//console.log(i);	
		}
		configMap.peopleArr = arr;
		configMap.peopleArrLen = arr.length;
	};
	initModule = function($container){
		configMap.$container = $container;
		configMap.current = $('.third');
		configMap.peopleArr = $.makeArray(lottery.fake.getPeopleList());
		configMap.peopleArrLen = configMap.peopleArr.length;
		loadPeople(configMap.current, configMap.timer);
		keyEvent();
		lottery.localStorage.init();
		configMap.winLeft = window.open('lottery-left.html');
		configMap.winRight = window.open('lottery-right.html');
	};

	return {initModule: initModule};
}(jQuery));

Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
	if (this[i] == val) return i;
	}
	return -1;
};
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};