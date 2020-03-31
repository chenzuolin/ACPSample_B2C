var App = (function($) {
	var app = {};

	/**
	 * 打开第三方分享页面
	 * @param {String} url 页面路径
	 * @param {Object} data 需要分享的JSON信息 
	 */
	app.openShare = function(url, data) {
		$.openWindow(url, url, {
			show: {
				duration: 100,
				aniShow: 'none'
			},
			waiting: {
				//autoShow: false
			},
			styles: {
				height: '40%',
				bottom: 0,
				top: '60%',
				background: "rgba(0,0,0,0.6)"
			},
			extras: {
				jsonData: data
			}
		});
	}

	/**
	 * 第三方登录
	 * @param {String} type 登录平台 qq weixin sinaweibo
	 * @param {Function} Fun 登录成功后的回调函数 参数 {info,outLogin}
	 */
	app.authLogin = function(type, Fun) {
		var auths = null;

		var callback = function(ser) {
			Fun && Fun({
				info: ser.userInfo,
				outLogin: function() {
					authLogout(ser);
				}
			});
		}

		plus.nativeUI.showWaiting();
		plus.oauth.getServices(function(services) {
			auths = services;
			var ts = getServer(type);
			login(ts);
			setTimeout(function() {
				plus.nativeUI.closeWaiting();
			}, 800);
		}, function(e) {
			plus.nativeUI.closeWaiting();
			mui.toast("获取登录服务失败：" + e.message + " - " + e.code);
		});

		//获取登陆服务
		function getServer(type) {
			var len = auths.length;
			for(var i = 0; i < len; i++) {
				if(auths[i].id == type) {
					return auths[i];
				}
			}
			return null;
		}

		// 登录操作
		function login(s) {
			if(!s.authResult) {
				s.login(function(e) {
					mui.toast(s.description + " 登录认证成功！");
					authUserInfo(s);
				}, function(e) {
					mui.toast(s.description + " 登录认证失败！");
				});
			} else {
				mui.toast(s.description + " 已经登录认证！");
			}
		}

		// 登录认证信息
		function authUserInfo(s) {
			s.getUserInfo(function(e) {
				callback(s);
				// authLogout(s);
			}, function(e) {
				mui.toast("获取用户信息失败：" + e.message + " - " + e.code);
			});
		}

		//注销
		function authLogout(s) {
			if(s && s.authResult) {
				s.logout(function(e) {
					console.log(s.description + " 注销登录认证成功！");
				}, function(e) {
					console.log(s.description + " 注销登录认证失败！");
				});
			}
		}

	}

	/**
	 * 获取网络类型
	 */
	app.getNetwork = function() {
		var networkTypes = {};
		networkTypes[plus.networkinfo.CONNECTION_UNKNOW] = "unknow"; //未知
		networkTypes[plus.networkinfo.CONNECTION_NONE] = "none"; //未连接
		networkTypes[plus.networkinfo.CONNECTION_ETHERNET] = "line"; //有线网络
		networkTypes[plus.networkinfo.CONNECTION_WIFI] = "wifi"; //wifi
		networkTypes[plus.networkinfo.CONNECTION_CELL2G] = "2g"; //2g
		networkTypes[plus.networkinfo.CONNECTION_CELL3G] = "3g"; //3g
		networkTypes[plus.networkinfo.CONNECTION_CELL4G] = "4g"; //4g
		return networkTypes[plus.networkinfo.getCurrentType()];
	}
	
	/**
	 * 下载文件
	 * @param {String} url 文件地址
	 */
	app.downFile = function(url){
		var fileUrl = 's';
		
		return fileUrl;
	}
	
	/**
	 * 打开wifi
	 */
	app.openWifi = function(){
		if($.os.ios){
			plus.runtime.openURL("prefs:root=WIFI");//ios需要手动打开
		}else if($.os.android){
			var Context = plus.android.importClass("android.content.Context");
		    var WifiManager = plus.android.importClass("android.net.wifi.WifiManager")
		    var wifiManager = plus.android.runtimeMainActivity().getSystemService(Context.WIFI_SERVICE);
		    wifiManager.setWifiEnabled(true);//false 为关闭
		}
	}
	
	/**
	 * Input获取焦点 弹出软键盘
	 * @param {HTMLInputElement} inputElem 
	 */
	app.showSoftInput = function(inputElem) {
		if(!inputElem){
			return;
		}
		if(!inputElem.id){
			this.input.id = inputElem.id = 'InputDefultId'; 
		}
		
		var nativeWebview ,imm, InputMethodManager;
		var initNativeObjects = function() {
			if($.os.android) {
				var main = plus.android.runtimeMainActivity();
				var Context = plus.android.importClass("android.content.Context");
				InputMethodManager = plus.android.importClass("android.view.inputmethod.InputMethodManager");
				imm = main.getSystemService(Context.INPUT_METHOD_SERVICE);
			    plus.android.importClass(nativeWebview);
			    nativeWebview.requestFocusFromTouch();
			    //强制显示软键盘 
			    //imm.showSoftInput(nativeWebview,InputMethodManager.SHOW_FORCED);
			    imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
				
			} else {
				nativeWebview.plusCallMethod({
		           "setKeyboardDisplayRequiresUserAction": false
		        });
			}
		};
		
		
		$.plusReady(function(){
			if(document.activeElement.id === inputElem.id){
				return;
			}
			nativeWebview = plus.webview.currentWebview().nativeInstanceObject();
			initNativeObjects();
			setTimeout(function() {
				inputElem.focus();
			}, 200);
		});
		
		
	}
	
	
	//更新应用资源 
	app.installWgt = function(path){
	    plus.nativeUI.showWaiting("安装wgt文件...");
	    plus.runtime.install(path,{},function(){
	        plus.nativeUI.closeWaiting();
	        console.log("安装wgt文件成功！");
	        plus.nativeUI.alert("应用资源更新完成！",function(){
	            plus.runtime.restart();
	        });
	    },function(e){
	        plus.nativeUI.closeWaiting();
	        console.log("安装wgt文件失败["+e.code+"]："+e.message);
	        plus.nativeUI.alert("安装wgt文件失败["+e.code+"]："+e.message);
	    });
	}

	return app;
}(mui));