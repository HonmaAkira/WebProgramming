<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
<title>ユーザ削除</title>
</head>
<body>
	<header>
		<div class="logout" align="right">
			<span class="user" style="font-size:15;margin-right:5px;">${sessionScope.userinfo.name}さん</span>
			<a href="LogoutServlet" style="font-size:15px;">ログアウト</a>
		</div>
	</header>
	<h1 align="center">ユーザ削除確認</h1>
	<p align="center">
		ログインID：${user.login_id}<br> を本当に削除してよろしいでしょうか。
	</p>
	<br>
	<br>
	<form action="UserDaleteServlet" method="post">
		<p align="center">
			<input type="hidden" name="id" value="${user.id} }"> <a
				class="btn btn-primary" href="UserListServlet" role="button">キャンセル</a>
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal">OK</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">${user.name}さん</h5>
        <button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        本当に${user.name}さんのデータを削除します。よろしいですか？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
        <input button type="submit" class="btn btn-primary" value ="OK"></button>
      </div>
    </div>
  </div>
</div>
			<p align="left">
		<a href="UserListServlet"><u>戻る</u></a>

		</form>
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