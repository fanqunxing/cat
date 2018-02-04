<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>fans-stars</title>
	<link rel="shortcut icon" href="img/favicon.ico"/>
	<link rel="bookmark" href="img/favicon.ico"/>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/public.css">
	<link rel="stylesheet" href="css/login.css">
	<script src="../lib/jquery-1.12.2.min.js"></script>
	<script src="js/common.js"></script>
</head>
<body>
<div class="content">
	<!-- 标题 -->
	<h1 class="header-text">欢迎登录</h1>

	<div class="form-content">
		<div class="form-username">
			<input type="text" 
				class="form-username" 
				id="form-username" 
				placeholder="手机号/邮箱/用户名" />
		</div>
		<div class="form-pazzword">
			<input type="password"
				class="form-pazzword" 
				id="form-pazzword" 
				placeholder="密码"/>
		</div>

		<div class="service-pazzword clearfix">
			<div class="remember-pazzword floatLeft clearfix">
				<span id="remember-pazzword-selected" class="remember-pazzword-selected floatLeft"></span>
				<span class="remember-pazzword-text floatLeft">记住密码</span>
			</div>

			<a href="/cat/index/addUser.jsp" class="add-user floatRight">立即注册</a>
			<a href="#" class="forget-pazzword floatRight">忘记密码？</a>
		</div>

		<div id="login-button" class="login-button">登录</div>

		<div class="use-other-account clearfix">
			<span class="use-other-account-text floatLeft">
				使用社交账号登录：
			</span>
			<span class="use-other-account-icon margin-left">
				<a href="" class="qq"></a>
			</span>
			<span class="use-other-account-icon margin-left">
				<a href="" class="wetchat"></a>
			</span>
			<span class="use-other-account-icon margin-left">
				<a href="" class="xinlang"></a>
			</span>
			<span class="use-other-account-icon">
				<a href="" class="baidu"></a>
			</span>
		</div>
	</div>
</div>

<script src="js/login.js"></script>
</body>
</html>