<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<h1>Welcome</h1>
	<%String name = (String)request.getAttribute("name"); 
	if(name!=null){
	%>
	<h2><%= name %></h2>
	<%} %>
	
</body>
</html>