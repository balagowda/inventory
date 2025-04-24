<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="register.css">
</head>
<body>
	<div class="wrapper">
	<%String msg = (String)request.getAttribute("msg"); 
		if(msg!=null){
	%>
	<h4 class="link"><%= msg %></h4><br>
	<%} %>
	
    <div class="title">
      Login
    </div>
    <form method="post" action="user">
    <div class="form">
       <div class="inputfield">
          <label>User Name</label>
          <input type="text" class="input" name="name" required>
       </div>  
       <div class="inputfield">
          <label>Password</label>
          <input type="password" class="input" name="password" required>
       </div>  
      <div class="inputfield">
      	<input type="hidden" name="action" value="login"/>
        <input type="submit" value="Login" class="btn">
      </div>
    </div>
     </form><br>
     <p class="link">Don't have an account? <a href="register.jsp">Register</a></p>
</div>
</body>
</html>