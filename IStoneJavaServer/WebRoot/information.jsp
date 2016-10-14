<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>IStone管理员系统</title>
	<link rel="stylesheet" href="css/videoView.css">
	<link rel="stylesheet" href="css/information.css">
</head>
<body>
	<div class="header"></div>
	<div class="login">
		<h2>IStone管理员系统</h2>
		<div id="manaInfo">
			<ul>
				<li><a href="#">管理员信息</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
	</div>
	<div class="menu">
		<ul >
            <li ><a href="videoView.jsp" role="tab" data-toggle="tab">视频管理</a></li>
            <li id="current"><a href="information.jsp" role="tab" data-toggle="tab">信息管理</a></li>
            <li><a href="report.jsp" role="tab" data-toggle="tab">举报管理</a></li>
            <li><a href="music.jsp" role="tab" data-toggle="tab">背景音乐管理</a></li>
            <li><a href="label.jsp" role="tab" data-toggle="tab">标签管理</a></li>
   
        </ul>
	</div>

	<div class="namelist">
            		<div class="put">
            			<div class="put-title">发布公告</div>
            			<textarea name="" id="" cols="52" rows="20"></textarea>
            			<div class="s">
            				<input type="reset" value="清除" class="t">
            			    <input type="button" value="发布" class="d">
            			</div>
            			
            		</div>
            	</div>
            	<div class="videoplayer">
            		<div class="history-put">
            			<div class="history-put-title">历史公告</div>
            			<ol>
            			<li><a href="">视圈来袭，你，准备好了吗?</a></li>
            			<li><a href="">仲夏男神季，爆出你身边的男神吧！</a></li>
            			<li><a href="">萌娃萌宠萌萌的夏天</a></li>
            			<li><a href="">二货逗趣欢乐度暑假</a></li>
            		</ol>
            		</div>
            		<div class="history-re">
            			<div class="history-put-title">历史反馈</div>
            			<ol>
            			<li><a href="">视圈超级好用的</a></li>
            			<li><a href="">UI很漂亮</a></li>
            			<li><a href="">拍出来的效果就像拍大片儿！</a></li>
            			<li><a href="">话题超级有趣！点赞！</a></li>
            		</ol>
            		</div>
            	</div>
            </div>

</body>
</html>
            