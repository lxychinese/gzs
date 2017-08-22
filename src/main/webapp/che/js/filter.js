;(function(){
	"use strict";
	new Vue({
		el : '#filter',
		data : {
			filterData:{type:0,from_place:null,to_place:null,mid_place:null,start_time:null,user_count:null,page:1}
		},
	
		methods : {
		
			filterAction : function(){
				layer.open({
					content: "正在开发中,敬请期待",
					skin: 'msg',
					time: 2
				});
				
			}
			
		}
	});
	

})();