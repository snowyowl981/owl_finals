<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<h2>글 등록</h2>
	<p>
		<a href="./app/post/list">글 목록</a>
	</p>
	<form action="./app/post/add" method="post">
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>
		<p>
			<button type="submit">등록</button>
		</p>
	</form>
</body>
</html>