<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>IStone_index_admin</title>
	<link rel="stylesheet" href="css/index.css">
	
    <!--[if IE]>
        <script>
            (function(){if(!/*@cc_on!@*/0)return;var e = "abbr,article,aside,audio,canvas,datalist,details,dialog,eventsource,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(','),i=e.length;while(i--){document.createElement(e[i])}})()
        </script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="login">
			<p>IStone管理员登录</p>
			<form action = "/IStoneJavaServer/denglu.do" method="post">
			<div class="information">
				<input name="adminID" type="text" placeholder="  用 户 名">
			    <input name="passWord" type="password" placeholder="  密    码">
			</div>
			<div class="action">
				<input type="reset" value="重 置" class="reset">
			   <input type="submit" value="登 录" class="submit">
			   </form>
			</div>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>
