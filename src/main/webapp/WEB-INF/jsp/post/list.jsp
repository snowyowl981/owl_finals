<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
<style type="text/css">
table {
	margin-top: 10px;
	border-collapse: collapse;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	width: 100%;
}
th, td {
	padding: 5px 0;
	text-align : center;
}
th {
	border-bottom: 1px solid gray;
}
</style>
</head>
<body>
	<h2>글 목록</h2>
	<p>
		<a href="./app/post/form">[글쓰기]</a>
		<a href="./">[돌아가기]</a>
	</p>
	<p>전체 ${totalCount }건</p>
	<form action="./app/post/list">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 50 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>학번</th>
				<th>등록자</th>
				<th>내용</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${postList}">
				<tr>
					<td>${post.postId }</td>
					<td>${post.userId }</td>
					<td>${post.name }</td>
					<td><a href="./app/post/view?postId=${post.postId }">${post.content }</a></td>
					<td>${post.sweet }<a href="./app/post/sweet?postId=${post.postId }">좋아요</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>