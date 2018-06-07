<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>ログイン画面</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">ログイン画面</h1>
	<br>

	<c:if test="${errMsg != null}">
		<div class="alert alert-danger" role="alert">
			<p align="center""text-danger">${errMsg}</p>

		</div>
	</c:if>
	<form action="LoginServlet" method="post">
		<p align="center">
			<b>ログインID</b>&emsp;&emsp;<input type="text" name="login_id">
		</p>
		<p align="center">
			<b>パスワード</b>&emsp;&emsp;<input type="password" name="pass">
		</p>
		<p align="center">
			<input type="submit" value="ログイン">
		</p>
	</form>
</body>
</html>