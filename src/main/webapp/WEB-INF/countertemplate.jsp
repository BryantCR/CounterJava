<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Counter</title>
		<link rel="stylesheet" href="style.css" />
		<link rel="stylesheet" href="./css/style.css"/>
	</head>
	<body>
		<h2>
			You have visited <a>localhost:8080/</a> <c:out value="${count}"></c:out> times
		</h2>
		<a href="/">Test another visit?</a>
		<script src="./js/Alert.js"></script>
	</body>
</html>
