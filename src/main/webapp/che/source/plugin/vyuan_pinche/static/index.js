var index_obj={
		index_init:function(){
			can_click = 1;
			$(".driver").click(function(){
				var start = $("input[name='start']").val();
				var end = $("input[name='end']").val();
				var stime = $("input[name='stime']").val();		
				if(start == '' && end == '' && stime == ''){
					global_obj.win_alert('请填写搜索信息');return false;
				}else{
					$.post('?s=Carpool/search',{start:start,end:end,stime:stime},function(data){
						if(data.ret == 1){		
								window.location.href = '?s=Carpool/driversearch';
						}else{
							global_obj.win_alert(data.msg);
						}
					},'json');
				}
			});
			$(".passenger").click(function(){
				var start = $("input[name='start']").val();
				var end = $("input[name='end']").val();
				var stime = $("input[name='stime']").val();		
				if(start == '' && end == '' && stime == ''){
					global_obj.win_alert('请填写搜索信息');return false;
				}else{
					$.post('?s=Carpool/search',{start:start,end:end,stime:stime},function(data){
						if(data.ret == 1){		
								window.location.href = '?s=Carpool/passengersearch';
						}else{
							global_obj.win_alert(data.msg);
						}
					},'json');
				}
			});
			$(".line").click(function(){
				var start = $("input[name='start']").val();
				var end = $("input[name='end']").val();
				var stime = $("input[name='stime']").val();		
				if(start == '' && end == '' && stime == ''){
					global_obj.win_alert('请填写搜索信息');return false;
				}else{
					$.post('?s=Carpool/search',{start:start,end:end,stime:stime},function(data){
						if(data.ret == 1){		
								window.location.href = '?s=Carpool/linesearch';
						}else{
							global_obj.win_alert(data.msg);
						}
					},'json');
				}
			});
		},

}