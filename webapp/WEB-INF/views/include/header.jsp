<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
#mypic{
	position:relative;
	background-size:25px 25px ;
	background:no-repeat;
	height:50px ; 
	width: 50px ;
	bottom:20px;
	padding-left: 370px;
	
}
</style>
		<div id="header">
			<h1>MySite</h1>
			<ul >
				<c:choose>
					<c:when test="${empty authUser }">
						<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a><li>
						<li><a href="${pageContext.servletContext.contextPath }/user/join">회원가입</a><li>
					</c:when>
					<c:otherwise>
						
						<li><a href="${pageContext.servletContext.contextPath }/user/modify">회원정보수정</a><li>
						<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a><li>
						<li>${authUser.name }님 안녕하세요 ^^;</li>
						<div><img id="mypic" src="${pageContext.request.contextPath }${authUser.path }"></div>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>