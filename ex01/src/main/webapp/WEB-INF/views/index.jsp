<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<p><a href="/board/list">게시물 목록</a></p>
	<p><a href="/board/write">게시물 작성</a></p>
	<p><a href="/board/uploadForm">파일 업로드</a></p>
	
<c:if test = "${member == null }" >
	
	
	<form role="form" method="post" autocomplete="off" action="/member/login">
	<p>
		<label for="userID">아이디</label>
		<input type="text" id="userID" name="userID"/>
	</p>
	<p>
		<label for="userPW">비밀번호</label>
		<input type="password" id="userPW" name="userPW" />
	</p>
	<p><button type="submit">로그인</button></p>
	<p><a href="/member/register">회원가입</a></p>
	
</form>
</c:if>

<c:if test="${msg == false}">
<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력하세요.</p>
</c:if>

<c:if test="${member != null}">
	<p>${member.userName} 님 환영합니다. </p>
	<a href="member/withdrawal">회원탈퇴</a>
	<a href="member/update">회원정보 수정</a> 
	<a href="member/logout">로그아웃</a> 
	</c:if>
	

</body>
</html>