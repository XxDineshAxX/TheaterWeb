<%@ page import="com.da.dao.TheaterDAO, java.io.IOException, java.sql.SQLException, javax.servlet.ServletException, 

 java.security.NoSuchAlgorithmException,  java.security.MessageDigest,

 java.sql.Connection,
 java.sql.DriverManager,
 java.sql.ResultSet,
 java.sql.SQLException,
 java.sql.Statement
" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <!-- This is Comment 1 -->
  <%--This is Comment2 --%>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color:  grey;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
      background-color: Red;
      color:  grey;
	  
  }
  
  .bg-4 { 
      background-color: white; 
      color:  grey;
  }
  .container-fluid {
      padding-top: 70px;
      padding-bottom: 70px;
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
	  color: blue;
  }
  .navbar-nav  li a:hover {
      color: blue !important;
  }
  </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Cinemark</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        
        
      </ul>
    </div>
  </div>
</nav>

<!-- First Container -->
<div height="900" width="100%" class="container-fluid bg-1 text-center">
  <h3>Cinemark</h3>
<form action="cancel.html" method= "Post">


		 <%TheaterDAO td = new TheaterDAO();
		 for(int x = 0;x < td.getNumOfScreens(); x++){
			 int c = x+1;
			 %>  <input type="radio" name="screenID" value="<%td.getNumOfScreens();%>"> Screen<%=c%><br>
			 <%
		 } %>
						<input type= "submit" value= "Choose Screen">
			
		</form>
		 	
			
		

</div>



<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
  <p>Cinemark.co</a></p> 
</footer>

</body>
</html>
