<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
	<!--basic_css-->
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
	<style type="text/css">
		body {
			background-image: url('img/001.jpg');
			background-position: 14px 14px;
			background-repeat: no-repeat;
			background-position: center center;
			background-attachment: fixed;
			background-size: cover;
		}

		.layui-input {
			height: 45px;
			width: 87%;
			padding-left: 5px;
			font-size: 16px;
			display: inline-block;
		}

		.layui-btn {
			height: 45px;
			color: white;
		}

		.captcha-input {
			height: 45px;
			padding-left: 5px;
			font-size: 16px;
		}

		.layui-form {
			width: 30%;
			height: 60%;
			margin: 0 auto;
			margin-top: 7%;
			padding: 15px 28px 0px;
			background: #fff;
		}

		.layui-input-block {
			margin-left: 0;
		}

		.layui-input-block a {
			color: blue;
			float: right;
			line-height: 30px;
			font-size: 14px;
		}

		h1 {
			text-align: center;
			color: #1d598e;
		}

		input.text {
			text-align: center;
			padding: 10px 20px;
			width: 300px;
		}

		#canvas {
			float: right;
			margin-right: 1%;
			display: inline-block;
			border: 1px solid #ccc;
			border-radius: 5px;
			cursor: pointer;
		}

		.code {
			width: 400px;
			margin: 0 auto;
		}

		.input-val {
			width: 60%;
			background: #ffffff;
			height: 2.8rem;
			border-radius: 5px;
			border: none;
			border: 1px solid rgba(0, 0, 0, .2);
		}
		a:link {
			text-decoration: none ;color: white;
		}

	</style>
</head>
<body>
<form class="layui-form" action="/StuGradeManagerSystem_war/login" id="loginForm" method="post">
	<div class="layui-form-item">
		<h1>Student Management System</h1>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<span class="decrib">Account：</span>&nbsp&nbsp &nbsp<input type="text" name="id"
													 placeholder="Please input account" autocomplete="off" class="layui-input"
													 autofocus required>
		</div>
	</div>

	<div class="layui-form-item">
		<div class="layui-input-block">
			<span class="decrib">Password：</span> <input type="password"
													 name="password" placeholder="Please input password" autocomplete="off"
													 class="layui-input" required>
		</div>
	</div>

	<div class="layui-form-item">
		<div class="layui-input-block">
			<span class="decrib">Type：</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" name="status"
													 placeholder="Please input type" autocomplete="off" class="layui-input"
													 list="list" required>
			<datalist id="list">
				<option>student</option>
				<option>teacher</option>
				<option>admin</option>
			</datalist>
		</div>
	</div>

	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-normal layui-btn-fluid"
					id="submit">login</button>
		</div>
		<div style="height: 30px;">

		</div>
	</div>


</form>
</body>
<script src="layui/layui.js"></script>
<script src="layui/jquery.min.js"></script>

</html>