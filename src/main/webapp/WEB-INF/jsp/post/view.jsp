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
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 보기</h2>
	<p>
		<a href="./app/post/list">글목록</a>
	</p>
	<p>
		<c:if test="${post.userId == sessionScope.MEMBER.memberId }">
			<a href="./app/post/updateForm?postId=${post.postId }">글수정</a>
			<a href="./app/post/delete?postId=${post.postId }"
				onclick="return confirmDelete();">글삭제</a>
		</c:if>
	</p>
	<hr />
	<p>
		<span>${post.postId }</span> | <span style="font-weight: bold;">${post.title }</span>
	</p>
	<p>
		<span>${post.cdate }</span> | <span>${post.name }</span>
	</p>
	<hr />
	<p>${post.contentHtml }</p>
	<hr />
</body>
</html>