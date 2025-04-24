<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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
      Registration Form
    </div>
    <form method="post" action="user">
    <div class="form">
       <div class="inputfield">
          <label>Full Name</label>
          <input type="text" class="input" name="name" required>
       </div>  
       <div class="inputfield">
          <label>Password</label>
          <input type="password" class="input" name="password" required>
       </div>  
        <div class="inputfield">
          <label>Gender</label>
          <div class="custom_select">
            <select name="gender">
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
          </div>
       </div> 
        <div class="inputfield">
          <label>Email Address</label>
          <input type="text" class="input" name="email" required>
       </div> 
      <div class="inputfield">
          <label>Phone Number</label>
          <input type="text" class="input" name="phone" required>
       </div> 
      <div class="inputfield">
          <label>Address</label>
          <textarea class="textarea" name="address" required></textarea>
       </div> 
      <div class="inputfield">
          <label>Postal Code</label>
          <input type="text" class="input" name="postal" required>
       </div> 
      <div class="inputfield">
      	<input type="hidden" name="action" value="register"/>
        <input type="submit" value="Register" class="btn">
      </div>
    </div>
     </form><br>
     <p class="link">Have have an account? <a href="login.jsp">Login</a></p>
</div>
</body>
</html>