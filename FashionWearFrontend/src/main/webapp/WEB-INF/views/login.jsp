<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login form</title>
<%@ include file="Nav.jsp"%>
<meta content="noindex, nofollow" name="robots">
<c:url value="/resources/css" var="css"/>
<link type="text/css" href="${css}/external.css" rel="stylesheet">
<style>
#first {
  margin-right:0px;
}
input {
    width:300px;
    height:40px;
  
    margin-bottom:10px;
}
.border table,.border td,.border th{
border-collapse: collapse;
border:1px solid black;
}
input[type=text]{
	width:300px;
	height:27px;
	margin-top:10px;
	padding:18px;
	margin-bottom:0px;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse" style="background: linear-gradient(to bottom, #ff0066 0%, #ff0066 100%);
    font-size: 18px;margin-bottom:10px;">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#" style="color:white;"><h2>FashionWear</h2></a>
       
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white;"><span class="hover1">Home</span></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white; "><span class="hover1">Products</span><span class="caret"></span></a>
        <c1:forEach items="${lcat}" var="Fashion">
        
       <ul class="dropdown-menu">
        <li><a href="<c:url value='/dispcategory/${Fashion.getCatId()}'/>">${Fashion.getCatName()}</a></li>
        </ul> </c1:forEach>
      </li>

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"  style="color: white;"><span class="hover1">About us</span></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white;"><span class="hover1">Contact</span></a></li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white;"><span class="hover1">Admin</span><span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="<c:url value="/category"/>">Add Category</a></li>
            <li> <a href="<c:url value="/product"/>">Add Product</a></li>
             <li><a href="<c:url value="/Supplier"/>">Add Supplier</a></li>
           </ul>
         </li>
         </ul>
        
        
         <!--<ul class="container">
         <a href="#" style="margin-left:700px; color:white;" >
          <span class="glyphicon glyphicon-shopping-cart"></span>Cart
        </a>
      </ul>-->
  <ul class="nav navbar-nav navbar-right" style="margin-left:450px; margin-top:-40px; color:white; font-size:30px">
  <i class="fa fa-shopping-cart" aria-hidden="true"></i> 
  <i class="fa fa-twitter"></i>
  <i class="fa fa-google"></i>
  <i class="fa fa-facebook"></i>
  <i class="fa fa-linkedin"></i>
  <i class="fa fa-pinterest"></i>
  </ul>
</div>
</li>
   </ul>
    <ul class="nav navbar-nav navbar-right">
      <c1:if test="${pageContext.request.userPrincipal.name==null}">
      <li class="dropdown"><a href="<c:url value="/user"/>" style="color: white;"><span class="glyphicon glyphicon-user"><span class="hover1">Signup</span></span></a></li>
      <li class="dropdown"><a href="<c:url value="/login"/>" style="color: white;"><span class="glyphicon glyphicon-log-in"><span class="hover1">Login</span></span></a></li>
      </c1:if>
      <c1:if test="${pageContext.request.userPrincipal.name!=null}">

<li style="float:right;"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
<li style="float:right;">
 <a href="<c:url value="/viewcart"/>"><i class="fa fa fa-shopping-cart"></i></a>
 <label id="cart-badge" class="badge">${items}</label>
</li>
  <li style="float:right;color:white;font-size:18px;border:none;">Welcome ${pageContext.request.userPrincipal.name}</li>
  </c1:if>
  
</ul>
</ul>

     <form class="navbar-form navbar-right" action="/action_page.php">
      <div class="input-group">
      
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit" style="width:40px;height:38px;margin-bottom:10px;margin-top:10px;">
            <i class="glyphicon glyphicon-search"></i>
            </button>
        </div>
      </div>
    </form>
  </div>
</nav>
<div id="first">
<img id="logo" src="">
<h1>Login Form</h1><br>
<c:url value="/j_spring_security_check" var="log"/>
<form action="${log}" method="post" >
<label>User Name :</label>
<input name="j_username" placeholder="UserName" type="text">
<label>Password:</label>
<input name="j_password" placeholder="Password" type="password">
<input name="submit" type="submit" value="Submit">
<input name="reset" type="Reset" value="Cancel">
</form>
</div>
</body>
</html>