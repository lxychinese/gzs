



lottery.localStorage = (function(){
	var get, set;

	get = function( key ){
		return window.localStorage.getItem( key ) || '';
	};
	set = function( key, val ){
		window.localStorage.setItem( key, val );
	};
	clear = function(){
		window.localStorage.clear();
	};
	init = function(){
		if(!window.localStorage){
			alert('This browser does NOT support localStorage.');
		}
	};
	return {
		init: init,
    	get : get,
    	set : set,
    	clear:clear
  	};

}());