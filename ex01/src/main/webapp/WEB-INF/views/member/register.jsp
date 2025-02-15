<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

 <title>게시판</title> 
 
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>

<form role="form" method="post" autocomplete="off">
 <p>
  <label for="userID">아이디</label>
  <input type="text" id="userID" name="userID" />
  <button type="button" class="IDCheck">아이디 확인</button>

 </p>  
  <p class ="result">
 	<span class="msg">아이디를 확인해주십시오.</span>
 </p>
 <p>
  <label for="userPW">패스워드</label>
  <input type="password" id="userPW" name="userPW" />
 </p>
 <p>
  <label for="userName">닉네임</label>
  <input type="text" id="userName" name="userName" />
 </p>
 <p>
   <button type="submit" id="submit" disabled="disabled">가입</button>  
 </p>
 <p>
  <a href="/">처음으로</a>
 </p>
 
</form>

<script>
$(".IDCheck").click(function(){
	
	var query = {userID : $("#userID").val()};
	
	$("#userID").keyup(function(){
		   $(".result .msg").text("아이디를 확인해주십시오.");
		   $(".result .msg").attr("style", "color:#000");
		   
		   $("#submit").attr("disabled", "disabled");
		   
		});
	
	$.ajax({
		url : "/member/IDCheck",
		type : "post",
		data : query,

		success : function(data) {
			
			if(data == 1){
				$(".result .msg").text("사용불가");
				$(".result .msg").attr("style","color:#f00")
				
				$("#submit").attr("disabled", "disabled");
			} else{
				$(".result .msg").text("사용가능");
				$(".result .msg").attr("style", "color:#00f")
				
				$("#submit").removeAttr("disabled");
			}
		}
	
	}); // ajax 끝
});
</script>


</body>
</html>