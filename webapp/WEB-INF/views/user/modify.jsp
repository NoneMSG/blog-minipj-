<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath }/user/modify" enctype="multipart/form-data">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${userVo.getName() }">

					<label class="block-label" for="email">이메일</label>
					<h3>${userVo.getEmail() }</h3>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<label class="block-label">사진 URL</label>
					<img id="profile" src="${pageContext.request.contextPath }${userVo.path }">
					<input type="file" name="file1">
					
					<input type="submit" value="수정하기">
					
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>

<c:if test="${param.result== 'success' }">
<script>
	alert( "정상적으로 수정 하였습니다." );
</script>
</c:if>

</html>