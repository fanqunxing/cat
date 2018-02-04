<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>fans-stars</title>
	<link rel="shortcut icon" href="img/favicon.ico"/>
	<link rel="bookmark" href="img/favicon.ico"/>
	<link rel="stylesheet" href="css/public.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/addUser.css">
	<script src="../lib/jquery-1.12.2.min.js"></script>
	<script src="js/common.js"></script>
</head>
<body>
<div class="content">
	<div class="user-title">
		<div class="user-log"></div>
		<div class="user-text">注册</div>
	</div>

	<div class="username js-form-item clearfix">
		<span class="username-icon floatLeft"><i></i></span>
		<span class="username-input floatLeft">
			<input id="username" type="text" placeholder="用户名">
		</span>
	</div>

	<div class="imail js-form-item clearfix">
		<span class="imail-icon floatLeft"><i></i></span>
		<span class="imail-input floatLeft">
			<input id="imail" type="text" placeholder="邮箱">
		</span>
	</div>

	<div class="pazzword js-form-item clearfix">
		<span class="pazzword-icon floatLeft"><i></i></span>
		<span class="pazzword-input floatLeft">
			<input id = "pazzword"  type="password" placeholder="密码">
		</span>
	</div>

	<div class="pazzworded js-form-item clearfix">
		<span class="pazzworded-icon floatLeft"><i></i></span>
		<span class="pazzworded-input floatLeft">
			<input id="pazzworded" type="pazzworded" placeholder="确认密码">
		</span>
	</div>

	<div id="submit-btn" class="add-submit-btn">
		注册
	</div>
</div>
<script src = "js/addUser.js"></script>
</body>
</html>