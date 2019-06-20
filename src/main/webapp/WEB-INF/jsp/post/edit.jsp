<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<h2>글 수정</h2>
	<form action="./app/post/update" method="post">
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required>${post.content }</textarea>
		</p>
		<p>
			<button type="submit">등록</button>
			<button type="button" onclick="history.back();">취소</button>
		</p>
		<input type="hidden" name="postId" value="${post.postId }" />
	</form>
</body>
</html>