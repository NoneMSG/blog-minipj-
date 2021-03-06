<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("newLine","\n");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
<style type="text/css">
#imgview{
	background:300px 300px no-repeat;
	width: 300px;
	height: 250px;
}
</style>
</head>
<body>
	<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${mbvo.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${fn:replace(mbvo.content, newLine, "<br>") }
							</div>
							
							<c:choose>
								<c:when test="${mbvo.fileType == '.mp4' || mbvo.fileType == '.avi'  }">
									<video width="320" height="240" controls>
									<source src="${pageContext.request.contextPath }${mbvo.path}" type="video/mp4">
									</video>
								</c:when>
								<c:when test="${mbvo.fileType =='.jpg' || mbvo.fileType =='.png' }">
									<img id="imgview" src="${pageContext.request.contextPath }${mbvo.path}">
								</c:when>
								
							</c:choose>
							
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath }/mediaboard">글목록</a>
					<a href="${pageContext.servletContext.contextPath }/mediaboard/modify/${mbvo.no}">글수정</a>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp" >
			<c:param name="menu" value="mediaboard"/>
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp" >
		</c:import>
	</div>
</body>
</html>