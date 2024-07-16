<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>

<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<style>
	iframe{
		width: 0px;
		height: 0px;
		border: 0px;
	
	}


</style>


</head>
<body>
	<form id = 'form1' action="uploadForm" method="post"
	enctype="multipart/form-data" target="zeroFrame">
		<input type="file" name="file"> <input type="submit">
	
	
	</form>
	
	<iframe name="zeroFrame"></iframe>
	
	<script type="text/javascript">
		function addFilePath(msg) {
			alert(msg);
			document.getElementById("form1").reset();
			
		}
	
	</script>
</body>
</html>