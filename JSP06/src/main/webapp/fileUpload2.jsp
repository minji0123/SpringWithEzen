<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<h1>파일 업로드 예제</h1>
	<hr>
	<div>
	<form name="fileUpload" method="post" action="fileupload" enctype="multipart/form-data">
		<p>업로드 파일 선택: </p> <input type="file" name="upfile"/>
		<p>파일설명: </p> <input type="text" name="updesc"/>
		
		<input type="submit" value="업로드"/>
		
	</form>
	</div>
</body>
</html>