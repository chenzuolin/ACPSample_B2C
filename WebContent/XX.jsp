<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>

<script type="text/javascript">
            var goEasy = new GoEasy({appkey: 'BC-8a96434d730f45de9a73cdfe101b398f'});
                               goEasy.subscribe({
                        channel: 'GoEasy',
                        onMessage: function(message){
                            alert('接收到消息:'+message.content);
                        }
              });
 </script>
</head>
<body>
</body>
</html>