<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">

<title>ユーザ新規</title>
</head>
<body>
	<header>
		<div class="logout" align="right">
			<span class="user" style="font-size:15;margin-right:5px;">${sessionScope.userinfo.name}さん</span>
			<a href="LogoutServlet" style="font-size:15px;">ログアウト</a>
		</div>
	</header>
	<h1 align="center">ユーザ新規登録</h1>
	<br>

	<c:if test="${fail != null}">
		<div class="alert alert-danger" role="alert">
			<p align="center""text-danger">${fail}</p>
		</div>
	</c:if>
	<form action="NewUserEntryServlet" method="post" class="search-area">
		<p>
			<b>ログインID&emsp;&emsp;</b><input type="text" name="login_id">
		</p>
		<p>
			<b>パスワード</b>&emsp;&emsp;<input type="password" name="pass1">
		</p>
		<p>
			<b>パスワード(確認)</b>&emsp;&emsp;<input type="password" name="pass2">
		</p>
		<p>
			<b>ユーザ名</b>&emsp;&emsp;<input type="text" name="username">
		</p>
		<p>
			<b>生年月日</b>&emsp;&emsp;<input type="date" name="birthdate">
		</p>
		<p align ="center">
			<input type="submit" value="登録">
		</p>
		</form>
		<p align="left">
			<a href="UserListServlet"><u>戻る</u></a>

			<!-- Optional JavaScript -->
			<!-- jQuery first, then Popper.js, then Bootstrap JS -->
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
				integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
				integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
				crossorigin="anonymous"></script>

</body>
</html>