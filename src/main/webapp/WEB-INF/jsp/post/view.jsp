<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<h2>글 보기</h2>
	<p>
		<a href="./app/post/list">글목록</a>
			<a href="./app/post/edit?postId=${post.postId }">글수정</a>
			<a href="./app/post/delete?postId=${post.postId }"
				onclick="return confirmDelete();">글삭제</a>
	</p>
	<hr />
	<p>
		<span>${post.postId }</span> | <span style="font-weight: bold;">${post.name }</span>
	</p>
	<hr />
	<p>${post.contentHtml }</p>
	<hr />
</body>
</html>