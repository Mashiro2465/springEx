<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp"%>
	</div>
	<form method="post">

		<label>제목</label> <input type="text" name="title"
			value="${view.title}" /><br /> <label>작성자</label> <input
			type="text" name="writer" value="${view.writer}" /><br /> <label>내용</label>
		<textarea cols="50" rows="5" name="content"> ${view.content} </textarea>
		<br />

		<!--<button type="submit">작성</button>-->

	</form>

	<hr />
	<div>
		<a href="/board/modify?bno=${view.bno}">게시물 수정</a> <a
			href="/board/delete?bno=${view.bno}">게시물 삭제</a>
	</div>

	<!-- 게시물 끝 -->
	<div id="reply">
		<ol class="replyList">
			<c:forEach items="${repList}" var="repList">
				<li>
					<p>
						작성자 : ${repList.writer}<br /> 작성 날짜 :
						<fmt:formatDate value="${repList.regDate}" pattern="yyyy-MM-dd" />
					</p>

					<p>${repList.content}</p>
					<p>
						<a href="/reply/modify?bno=${view.bno}&amp;rno=${repList.rno}">수정</a>
						<a href="/reply/delete?rno=${repList.rno}">삭제</a>
					</p>

					<hr />
				</li>
			</c:forEach>
		</ol>
	</div>

	<div>

		<form method="post" action="/reply/write">

			<p>
				<label>댓글 작성자</label> <input type="text" name="writer">
			</p>
			<p>
				<textarea rows="5" cols="50" name="content"></textarea>
			</p>
			<p>
				<input type="hidden" name="bno" value="${view.bno}">
				<button type="submit">댓글 작성</button>
			</p>
		</form>

	</div>


</body>
</html>