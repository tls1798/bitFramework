<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>File upload page</h1>
	<form action="./upload" method="post" enctype="multipart/form-data">
		<div>
			<label>msg</label>
			<input type="text" name="msg"/>
		</div>
		<div>
			<label>file</label>
			<input type="file" name="file"/>
		</div>
		<div>
			<button>전송</button>
		</div>
	</form>
</body>
</html>