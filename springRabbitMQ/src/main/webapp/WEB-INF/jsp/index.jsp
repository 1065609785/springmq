<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

var websocket;

// 首先判断是否 支持 WebSocket
 if('WebSocket' in window) {
     websocket = new WebSocket("ws://192.168.31.205:8085/springTest/testHandler?userId=zhaoshouyun");
 } else if('MozWebSocket' in window) {
     websocket = new MozWebSocket("ws://192.168.31.205:8085/springTest/testHandler?userId=zhaoshouyun");
 } else {
     websocket = new SockJS("http://192.168.31.205:8085/springTest/socketJs/testHandler?userId=zhaoshouyun");
 }

 // 打开连接时
 websocket.onopen = function(evnt) {
     console.log("  websocket.onopen  ");
 };

 // 收到消息时
 websocket.onmessage = function(evnt) {
     //alert(evnt.data);
	 var para=document.createElement("p");
		var node=document.createTextNode(evnt.data);
		para.appendChild(node);
		var div = document.getElementById('dive')
		div.appendChild(para);
 };

 websocket.onerror = function(evnt) {
     console.log("  websocket.onerror  ");
 };

 websocket.onclose = function(evnt) {
     console.log("  websocket.onclose  ");
 };


function say(){
	 //客户端主动发消息
	 websocket.send(document.getElementById('msg').value);
}

</script>
</head>
<body>
<input type="text" value="" id="msg"><button onclick="say()"></button>
<div id="dive">

</div>
</body>
</html>