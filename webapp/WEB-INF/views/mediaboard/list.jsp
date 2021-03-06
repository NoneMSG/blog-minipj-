<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="a" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
					<input type="hidden" value="search">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>	
					
					<c:forEach items="${map.list }" var="vo" varStatus="status">		
					<tr>
						<td>${map.totalCount - (map.currentPage - 1)*map.listSize - status.index }</td>
						
						<td class="left">
							<a href="${pageContext.request.contextPath }/mediaboard/view${vo.no }?p=${map.currentPage }&kwd=${map.keyword }">${vo.title }</a>
						</td>
						<td>${vo.userName }</td>
						<td>${vo.hit }</td>
						<td>${vo.regDate }</td>
						<td>
							<c:choose>
								<c:when test="${(not empty authUser && authUser.no == vo.userNo) || authUser.role=='ADMIN'}">
								<a href="${pageContext.request.contextPath }/mediaboard/delete/${vo.no}?p=${map.currentPage }" class="del">삭제</a>
							</c:when>
								<c:otherwise>
									 &nbsp;
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
				
				<div class="pager">
					<ul>
						<c:if test="${map.prevPage > 0 }" >
							<li><a href="${pageContext.request.contextPath }/mediaboard?p=${map.prevPage }">◀</a></li>
						</c:if>
						
						<c:forEach begin="${map.beginPage }" end="${map.beginPage + map.listSize - 1 }" var="page">
							<c:choose>
								<c:when test="${map.endPage < page }">
									<li>${page }</li>
								</c:when> 
								<c:when test="${map.currentPage == page }">
									<li class="selected">${page }</li>
								</c:when>
								<c:otherwise> 
									<li><a href="${pageContext.request.contextPath }/mediaboard?p=${page }">${page }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${map.nextPage > 0 }" >
							<li><a href="${pageContext.request.contextPath }/mediaboard?p=${map.nextPage }">▶</a></li>
						</c:if>	
					</ul>
				</div>								
				
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath }/mediaboard/write${map.pageCount}" id="new-book">글쓰기</a>
				</div>			
					
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="menu" value="mediaboard"/>
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>