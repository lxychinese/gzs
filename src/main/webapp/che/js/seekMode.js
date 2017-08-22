;
(function() {
	"use strict";

	var seekMode = new Vue({
		el : '#seekMode',
		data : {
			// 发布拼车信息
			postCarpoolInfo : {
				name : null,
				phone : null,
				user_count : 1,// 座位或人默认为1
				type : 1,// 默认拼车类型
				from_place : null,
				to_place : null,
				mid_place : null,
				start_time : null,
				car : null,
				note : null,
				code : null
			},
			// 是否勾选免责声明
			isRead : false,
			// 验证表单有效性
			formValidation : false,
			// 发布金额，默认-1
			post_cost : -1,
		},
		filters : {
			formatMoney : function(value) {
				return "¥" + value.toFixed(2);
			}

		},
		watch : {
			postCarpoolInfo : {
				handler : function(watchDataList) {
					for ( var item in watchDataList) {
						if (watchDataList[item]) {
							localStorage[item] = watchDataList[item];
						}
					}
				},
				deep : true
			}
		},
		created : function() {

		},
		methods : {
			toggleRead : function() {
				this.isRead ? this.isRead = false : this.isRead = true;
			},
			postData : function(type) {
				this.postCarpoolInfo.type = type;
				var that = this;
				// 验证提交的表单
				checkForm(type);
				if (this.formValidation) {
					var shade = layer.open({
						type : 2,
						shadeClose : true
					});
					$.ajax({
						url : "/che/save",
						method : "POST",
						data : {
							name : that.postCarpoolInfo.name,
							phone : that.postCarpoolInfo.phone,
							from_place : that.postCarpoolInfo.from_place,
							to_place : that.postCarpoolInfo.to_place,
							mid_place : that.postCarpoolInfo.mid_place,
							start_time : that.postCarpoolInfo.start_time,
							user_count : that.postCarpoolInfo.user_count,
							note : that.postCarpoolInfo.note,
							type : that.postCarpoolInfo.type,
							fz : that.postCarpoolInfo.fz,
							car : that.postCarpoolInfo.car,
							code : that.postCarpoolInfo.code
						},
						success : function(res) {
							if (res.success) {
								layer.open({
									content : res.msg,
									skin : 'msg',
									time : 5
								});
								window.location = "index.htm";
							} else {
								layer.close(shade);
								layer.open({
									content : res.msg,
									skin : 'msg',
									time : 5
								});
							}

						}
					});
				} else {
					if (!that.isRead) {
						layer.open({
							content : '未勾选《微信拼车平台免责声明》',
							skin : 'msg',
							time : 2
						});
					} else {
						layer.open({
							content : '发布信息不完整',
							skin : 'msg',
							time : 2
						});
					}
				}
			},
			closeNotice : function(e) {
				$(e.currentTarget).parent().fadeOut(200);
			}
		},
	});
	Vue.filter('dateFmt', function(value) {
		return "¥" + value;
	});
	function checkForm(type) {
		for ( var item in seekMode.postCarpoolInfo) {
			if (seekMode.postCarpoolInfo[item] === null && item !== "note"
					&& item !== "name" && item !== "mid_place"
					&& item !== "car"&& item !== "fz") {
				seekMode.formValidation = false;
				return false;
			} else if (!seekMode.isRead) {
				seekMode.formValidation = false;
				return false;
			} else {
				seekMode.formValidation = true;
			}
		}
	}

	// 是否在微信浏览器中打开
	function isWeixin() {
		var ua = navigator.userAgent.toLowerCase();
		var iswx = ua.indexOf('micromessenger') != -1;
		return iswx;
	}

	// 查询浏览器参数
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	}

})();