<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h1>글 수정</h1>
	<p>
		<a href="./app/post/list">글 목록</a>
	</p>
	<form action="./app/post/modify?postId=${post.postId}" method="post">
		<p>제목 :</p>
		<p>
			<input type="text" name="title" maxlength="100" style="width: 100%;"
				value="${post.title}" required>
		</p>
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required>${post.content}</textarea>
		</p>
		<p>
			<button type="submit">수정</button>
			<button type="button" onclick="history.back();">취소</button>
		</p>
		<input type="hidden" name="postId" value=${post.postId}" />
	</form>
</body>
</html>