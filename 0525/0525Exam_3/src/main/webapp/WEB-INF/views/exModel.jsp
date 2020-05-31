<%@page import="com.jslhrd.domain.SampleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Model : ${list}
	<br>
	name: ${sampleDTO.name}
	<br>
	age: ${sampleDTO.age}

</body>
</html>