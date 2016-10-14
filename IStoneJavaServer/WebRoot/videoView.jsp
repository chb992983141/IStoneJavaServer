<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="nth.sky.notifyInfo.po.Report"%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>IStone管理员系统</title>
	<link rel="stylesheet" href="css/videoView.css">
	<link rel="stylesheet" href="css/video.css">
	<script type="text/javascript" src="http://ajax.Microsoft.com/ajax/jQuery/jquery-1.7.1.min.js"><!--
/* 	function queryNext(list){
	   var next = 
	   document.getElementById("next").innerHTML;
	} */
	</script>
	<% 
List<Report> list = (List)request.getAttribute("report"); 
Report form = (Report) list.get(0); 
%> 
</head>
<body>
	<div class="header"></div>
	<div class="login">
		<form><h2>IStone管理员系统</h2></form>
		<div id="manaInfo">
			<ul>
				<li><a href="#">管理员信息</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
	</div>
	<div class="menu">
		<ul >
            <li id="current"><a href="queryUserReport.do" role="tab" data-toggle="tab">视频管理</a></li>
            <li><a href="querySysInfoByState.do" role="tab" data-toggle="tab">信息管理</a></li>
            <li><a href="queryUserFB.do" role="tab" data-toggle="tab">举报管理</a></li>
            <li><a href="music.jsp" role="tab" data-toggle="tab">背景音乐管理</a></li>
            <li><a href="label.jsp" role="tab" data-toggle="tab">标签管理</a></li>
        </ul>
	</div>
           <div class="namelist">
            		<p>被举报视频信息</p>
            		<div class="info">
            		<div class="User">
            			<h6>举报人ID:<span id="next"><%out.println(form.getInformerID());%></span></h6>
            			<br>
            		</div>
            			<div class="show">
            				<h4>123123<%out.println(form.getNotes());%></h4>
            			</div>
            			<div class="choose">
            				<input type="button" value="<" <%-- onclick="queryNext()" --%> class="bu">
            				<input type="button" value=">" class="but">
            			</div>
            		</div>
            	</div>
            	<div class="videoplayer">
            		<div class="video-controll">
                              <video src="男神.mp4" controls="controls">          
                        </div>
            		<div class="select">
            			<input type="button" value="通过" class="t">
            			<input type="button" value="删除" class="d">
            		</div>
            	</div>
            </div>     
</body>
</html>
