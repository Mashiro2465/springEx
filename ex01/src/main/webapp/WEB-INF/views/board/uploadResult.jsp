<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<meta charset="UTF-8">
<title>파일</title>
</head>
<body>
	<script type="text/javascript">
		let result = '${savedName}';
		
		parent.addFilePath(result);
	</script>
</body>
</html>