<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<title>ユーザ一覧</title>
</head>
<body>

	<header>
		<div class="logout" align="right">
			<span class="user" style="font-size: 15; margin-right: 5px;">${sessionScope.userinfo.name}さん</span>
			<a href="LogoutServlet" style="font-size: 15px;">ログアウト</a>
		</div>
	</header>


	<div class="container">

		<h1 align="center">ユーザ一覧</h1>
		<p align="right">
			<a href="NewUserEntryServlet">新規登録</a>
		</p>
		<form action="UserListServlet" method="post" class="search-area">
			<p>
				<b>ログインID</b>&emsp;&emsp;<input type="text" name="login_id">
			</p>
			<p>
				<b>ユーザ名</b>&emsp;&emsp;<input type="text" name="user">
			</p>
			<p>
				<b>生年月日</b>&emsp;&emsp;<input type="date" name="birth1"
					placeholder="年/月/日"> ～<input type="date" name="birth2"
					placeholder="年/月/日">
			</p>
			<p align="right">
				<input type="submit" value="検索">
			</p>
		</form>

		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th scope="col">ログインID</th>
					<th scope="col">ユーザ名</th>
					<th scope="col">生年月日</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userlist}">
					<tr>
						<td>${user.login_id}</td>
						<td>${user.name}</td>
						<td>${user.birth_date}</td>
						<td><c:if test="${userinfo.login_id == 'admin'}">
								<a class="btn btn-primary" href="UserDateServlet?id=${user.id}"
									role="button">詳細</a>
								<a class="btn btn-success"
									href="UserDateUpdateServlet?id=${user.id}" role="button">更新</a>
								<a class="btn btn-danger" href="UserDaleteServlet?id=${user.id}"
									role="button">削除</a>
							</c:if> <c:if test="${userinfo.login_id != 'admin'}">
								<a class="btn btn-primary" href="UserDateServlet?id=${user.id}"
									role="button">詳細</a>
								<c:if
									test="${sessionScope.userinfo.id==user.id}">
									<a class="btn btn-success"
										href="UserDateUpdateServlet?id=${user.id}" role="button">更新</a>
								</c:if>

							</c:if></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>


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


	</div>
</body>
</html>