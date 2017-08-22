/*
* Lucky Draw for HAIXUE 2016-04-23
* By Cynthia Cheng
*/

var luckyDraw = (function(){
	var configMap = {
			 grandPrize: 1,
			 firstPrize: 3,
			 secondPrize: 6,
			 Third: 120,
			 peopleArr:null,
			 peopleArrLen: 0,
			 luckyArr:[],
			 clearInterval:undefined,
			 running: false
		},
		jqueryMap = {
			$container : null,


		},
		loadPeopleRandom, loadPeople, stopLoadPeople, 
		getLuckyPeople, selectfrom, induceLucky, initModule;

		/*随机加载*/
		loadPeopleRandom = function(){
			var ul = jqueryMap.$container.find('.candidate ul');
			ul.find('li').remove();
			configMap.clearInterval = setInterval(function(){
				loadPeople(ul);
			},100);	
		};
		/* 随机加载 */
		loadPeople = function(ul){
			for(var i = 0; i<6;i++){
				var index = selectfrom(0,configMap.peopleArr.length-1);
				ul.prepend('<li>'+configMap.peopleArr[index]._id+'</li>');
			}
		};
		stopLoadPeople = function(){
			clearInterval(configMap.clearInterval);
		};
		/* 抽奖 */
		getLuckyPeople = function( num,prizeType){
			var con = jqueryMap.$container.find('.show-lucky');
			con.append('<h2>'+prizeType+num+'名</h2>');
			for(var i = 0;i < num; i++){
				var index = selectfrom(0,configMap.peopleArr.length-1),j = i+1;
				var luck = configMap.peopleArr[index]._id;
				con.append('<div>'+j+': '+luck+'</div>');
				configMap.luckyArr.push(luck);
				configMap.peopleArr.splice(index,1);
				configMap.peopleArrLen = configMap.peopleArr.length;
				console.log(configMap.luckyArr);
			}	
			
		};
		/* 生成随机数 */
		selectfrom = function(lowValue,highValue){
			var choice = highValue-lowValue+1;
			return Math.floor(Math.random()*choice+lowValue);
		};

		/* 导出数据到本地文件 */
		induceLucky = function(){
			if(navigator.userAgent.indexOf('Windows') > 0){
				var fso = new ActiveXObject("Scripting.FileSystemObject");
				//var f = fso.OpenTextFile("c:\\文件名.txt", ForReading, false); //读文件
				var tf = fso.createtextfile("E:\\lucky.txt",true);
				//echo(f.ReadLine());读一行
				// 填写数据，并增加换行符
				//tf.WriteLine("Testing 1, 2, 3.") ;
				// 增加3个空行
				//tf.WriteBlankLines(3);
				// 填写一行，不带换行符
				//tf.Write ("我是深情小建.");
				for(var i = 0; i < configMap.luckyArr.length; i++ ){
					tf.WriteLine(configMap.luckyArr[i]);
				}
				// 关闭文件
				tf.Close();
			}else if( navigator.userAgent.indexOf('Mac OS X') > 0 ){

			}
		};
		/* 初始化 */
		initModule = function( $container ){
			jqueryMap.$container = $container;
			configMap.peopleArr = $.makeArray(luckyDraw.fake.getPeopleList());
			configMap.peopleArrLen = configMap.peopleArr.length;
			var ul = jqueryMap.$container.find('.candidate ul');
			loadPeople(ul);
			//loadPeopleRandom();
			getLuckyPeople(2,'三等奖');
			//setTimeout('stopLoadPeople()',6000);
			
		};

	return { initModule : initModule };

}());

Array.prototype.baoremove = function(dx) 
{ 
    if(isNaN(dx)||dx>this.length){return false;} 
    this.splice(dx,1); 
} 