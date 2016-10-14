<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>测试springmvc中上传的实现</title>
	</head>
	<body>
<form action="saveVideo.do" method="post" enctype="multipart/form-data" >
			<input type="file" name="file" />
			<input type="submit" value="upload" />
		</form>
