<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<!-- css files -->
	<link rel="stylesheet" href="home-resources/css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
	<link rel="stylesheet" href="home-resources/fontawesome/all.css"> <!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- fonts -->
	<link rel="stylesheet" href="home-resources/font/text-font/font-awesome.min.css" />
	<link href="home-resources/font/font.css' rel='stylesheet" type="text/css">
	<!-- //fonts -->
</head>
<body>
	<div class="center-container">
		<!--header-->
		<div class="header-w3l">
			<div class="logo">
				<a href="HomeForward"><img src="home-resources/images/logovnu.png" height="80px"/></a>
			</div>
			<h1>Hệ thống khảo sát sinh viên</h1>
		</div>
		<!--//header-->
		
		<!-- main -->
		<div class="main-content-agile">
			<div class="sub-main-w3">	
				<div class="wthree-pro">
					<h2>Đăng nhập</h2>
				</div>
				<form action="HomeController" method="post">
					<div class="pom-agile">
						<input class="user" type="text" placeholder="Tên truy cập" name="username" required>
						<span class="icon1"><i class="fas fa-user-graduate"></i></span>
					</div>
					
					<div class="pom-agile">
						<input  class="pass" type="password" placeholder="Mật khẩu" name="password" required>
						<span class="icon2"><i class="fas fa-unlock-alt"></i></span>
					</div>
					
					<div class="msg-login">
						<h4>
							<c:if test="${msgLogin != null}">
								${msgLogin}
							</c:if>
						</h4>
					</div>
					
					<div class="sub-w3l">
						<div class="right-w3l">
							<input type="submit" value="Đăng nhập">
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--//main-->
		
		<!--footer-->
		<div class="footer">
			<p>Bài tập lớn môn <a href="https://uet.vnu.edu.vn/~thanhld/2018f-int3306-1.htm">phát triển ứng dụng web</a></p>
		</div>
		<!--//footer-->
	</div>
</body>
</html>