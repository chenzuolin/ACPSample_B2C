window.onload =function(){
	var xhr = new XMLHttpRequest();
		xhr.open('POSt','http://www.sumengkx.com/ACPSample_B2C/YizhucejiudianServlet');
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(this.readyState != 4) return;
			var num = this.responseText;
			document.getElementsByTagName("cite")[0].innerHTML=num;
		}
		var xhr = new XMLHttpRequest();
		xhr.open('POSt','http://www.sumengkx.com/ACPSample_B2C/YizhucekuaidiyuanServlet');
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(this.readyState != 4) return;
			var num = this.responseText;
			document.getElementsByTagName("cite")[1].innerHTML=num;
		}
		var xhr = new XMLHttpRequest();
		xhr.open('POSt','http://www.sumengkx.com/ACPSample_B2C/YituisongxiaoxiServlet');
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(this.readyState != 4) return;
			var num = this.responseText;
			document.getElementsByTagName("cite")[2].innerHTML=num;
		}
		var xhr = new XMLHttpRequest();
		xhr.open('POSt','http://www.sumengkx.com/ACPSample_B2C/YifasonggonggaoServlet');
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(this.readyState != 4) return;
			var num = this.responseText;
			document.getElementsByTagName("cite")[3].innerHTML=num;
		}
		var xhr = new XMLHttpRequest();
		xhr.open('POSt','http://www.sumengkx.com/ACPSample_B2C/WeiquerenshouhuoServlet');
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(this.readyState != 4) return;
			var num = this.responseText;
			document.getElementsByTagName("cite")[4].innerHTML=num;
		}
		var xhr = new XMLHttpRequest();
		xhr.open('POSt','http://www.sumengkx.com/ACPSample_B2C/TuijiancaipinServlet');
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(this.readyState != 4) return;
			var num = this.responseText;
			document.getElementsByTagName("cite")[5].innerHTML=num;
		}
}
