<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>메인</title>
</head>
<body>
	<p>환영합니다.</p>
	<c:choose>
		<c:when test="${!empty sessionScope.USER }">
			<!-- 로그인 했을 경우 -->
			<p>userId: ${USER.userId }, email: ${USER.email }, name:
				${USER.name }</p>
			<p>
				<a href="./app/logout">[로그아웃]</a>
			</p>
		</c:when>
		<c:otherwise>
			<!-- 로그인 하지 않았을 경우 -->
			<p>
				<a href="./app/loginForm">[로그인]</a>
			</p>
		</c:otherwise>
</c:choose>
	<p>
		<a href="./app/post/list">[글 목록]</a>
	</p>
</body>
</head>
</html>