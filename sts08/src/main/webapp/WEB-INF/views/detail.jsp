<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
<script type="text/javascript" src="../webjars/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="../webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar" style="background-color: #cccccc;">
		<div class="container-fluid">
			<a class="navbar-brand" href="../">Navbar</a>
			<p class="navbar-text">
				<a href="../">HOME</a>
				<a href="./">EMP</a>
				<a href="./add">EMP_Add</a>
				<c:if test="${sessionScope.result eq true }">
					<a href="../logout/">LOGOUT</a>
				</c:if>
				<c:if test="${sessionScope.result eq null }">
					<a href="../login/">LOGIN</a>
				</c:if>				
			</p>
			<c:if test="${sessionScope.result }">
				<p class="navbar-text">${sessionScope.user }</p>
			</c:if>
		</div>
	</nav>
	<div class="container ">
		<form action="./${empno }" method="post">
			<input type="hidden" name="_method" value="put">
			<div class="mb-3">
				<label for="empno" class="form-label">empno</label> 
				<input type="text" class="form-control" id="empno" name="empno" value="${bean.empno }" readonly>
			</div>
			<div class="mb-3">
				<label for="ename" class="form-label">ename</label> 
				<input type="text" class="form-control" id="ename" name="ename" value="${bean.ename }" >
			</div>
			<div class="mb-3">
				<label for="sal" class="form-label">sal</label> 
				<input type="text" class="form-control" id="sal" name="sal" value="${bean.sal }" >
			</div>
			<div class="mb-3">
				<label for="job" class="form-label">job</label> 
				<input type="text" class="form-control" id="job" name="job" value="${bean.job }" >
			</div>
			<div>
			<button type="submit" class="btn btn-primary">edit</button>
			<button type="button" class="btn btn-danger">delete</button>
			<button type="reset" class="btn btn-default">reset</button>
			<button type="button" class="btn btn-default" onclick="history.back()">back</button>
			</div>
		</form>
	</div>
</body>
</html>