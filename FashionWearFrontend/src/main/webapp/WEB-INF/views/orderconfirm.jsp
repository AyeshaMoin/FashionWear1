<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> --%>
<html>
<head>
<c:url value="/resources/image" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
<link href="${css}/bootstrap.min.css">
<link href="external.css" rel="stylesheet">
<link type="text/css" href="${css}/external.css" rel="stylesheet">
<title>Order Confirmation</title>

<style>
table, th, td {
    
    border: 1px solid black;
    border-collapse: collapse;
	
}

.ts
{
width:1000px;
position:relative;
top:100px;
}
button {
    background-color:skyblue ;
    
    
    padding: 10px 25px;
    border: none;
    cursor: pointer;
    width:10%;
    border-radius:4px;
    position:relative;
    top:200px;
    left:700px;
}
</style>
 <%@ include file="Nav.jsp"%>
 </head>
<body>
<nav class="navbar navbar-inverse" style="background: linear-gradient(to bottom, #ff0066 0%, #ff0066 100%);
    font-size: 18px;">
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
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white; margin-top:0px;"><span class="hover1"><a href="<c:url value="/"/>" style="color:white;">Home</a></span></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white; margin-top:30px;"><span class="hover1">Products</span><span class="caret"></span></a>
        <c1:forEach items="${lcat}" var="Fashion">
        
       <ul class="dropdown-menu">
        <li><a href="<c:url value='/dispcategory/${Fashion.getCatId()}'/>">${Fashion.getCatName()}</a></li>
        </ul> </c1:forEach>
      </li>

      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"  style="color: white;"><span class="hover1"><a href="<c:url value="/About"/>" style="color:white;">About us</a></span></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white;"><span class="hover1"><a href="<c:url value="/Contact"/>" style="color:white;">Contact</a></span></a></li>
      <c1:if test="${pageContext.request.userPrincipal!=null}">
      <security:authorize access="hasRole('ROLE_ADMIN')">
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: white;"><span class="hover1">Admin</span><span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="<c:url value="/category"/>">Add Category</a></li>
            <li> <a href="<c:url value="/product"/>">Add Product</a></li>
             <li><a href="<c:url value="/Supplier"/>">Add Supplier</a></li>
           </ul></security:authorize></c1:if>
         </li>
         </ul>
        
        
         <!--<ul class="container">
         <a href="#" style="margin-left:700px; color:white;" >
          <span class="glyphicon glyphicon-shopping-cart"></span>Cart
        </a>
      </ul>-->
  <ul class="nav navbar-nav navbar-right" style="margin-left:450px; margin-top:-40px; color:white; font-size:30px;">
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

<li style="float:right;"><a href="<c:url value="/j_spring_security_logout" />" style="color:white;"> Logout</a></li>
<li style="float:right;color:white;">
 <a href="<c:url value="/viewcart"/>"><i class="fa fa fa-shopping-cart" style="color:white;"></i></a>
 <label id="cart-badge" class="badge" style="color:yellow;">${items}</label>
</li>
  <li style="float:right;color:white;font-size:18px;border:none;">Welcome ${pageContext.request.userPrincipal.name}</li>
  </c1:if>
  
</ul>
</ul>

     <form class="navbar-form navbar-right" action="/action_page.php">
      <div class="input-group">
      
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
            </button>
        </div>
      </div>
    </form>
  </div>
  <ul class="nav navbar-nav navbar-right" style="margin-right:50px; margin-top:-120px; color:white; font-size:30px;">
  <span class="fa fa-shopping-cart" aria-hidden="true"></span> 
  <i class="fa fa-twitter"></i>
  <i class="fa fa-google"></i>
  <i class="fa fa-facebook"></i>
  <i class="fa fa-linkedin"></i>
  <i class="fa fa-pinterest"></i>
  </ul>
</nav>

<h2 style="position:relative;top:90px;">Billing Address</h2>
<table  class="ts" style="width:100%">
  <tr>
    <th style="text-align:center">EMAIL</th>
    <th style="text-align:center">MOBILE NO </th>
    <th style="text-align:center">CITY</th>
	<th style="text-align:center">COUNTRY</th>
	<th style="text-align:center">HOUSE NUMBER</th>
	<th style="text-align:center">PINCODE</th>
  </tr>


  <tr>
   <td style="text-align:center">${billing.getEmail()}</td>
   <td style="text-align:center">${billing.getMobile_No()}</td>
   <td style="text-align:center">${user.getCity()}</td>
   <td style="text-align:center">${billing.getCountry()}</td>
   <td style="text-align:center">${billing.user.getHouse_No()}</td>
   <td style="text-align:center">${billing.getPincode()}</td>
 </tr>
 </table><br></br><br></br>
 <h2 style="position:relative;top:100px">Shipping Address</h2>
<table  class="ts" style="width:100%">
  <tr>
    <th style="text-align:center">NAME</th>
    <th style="text-align:center">EMAIL</th>
	<th style="text-align:center">MOBILE NO</th>
    <th style="text-align:center">CITY</th>
	<th style="text-align:center">COUNTRY</th>
	<th style="text-align:center">HOUSE NUMBER</th>
	<th style="text-align:center">PINCODE</th>
	<th style="text-align:center">SHIPPING ID</th>
  </tr> 
  <tr>
  <td style="text-align:center">${shippingAddress.getFirst_Name()}${shippingAddress.getLast_Name()}</td>
  <td style="text-align:center">${shippingAddress.getEmail()}</td>
  <td style="text-align:center">${shippingAddress.getMobile_No()}</td>
  <td style="text-align:center">${shippingAddress.getCity()}</td>
  <td style="text-align:center">${shippingAddress.getCountry()}</td>
  <td style="text-align:center">${shippingAddress.getHouse_No()}</td>
  <td style="text-align:center">${shippingAddress.getPinCode()}</td>
  <td style="text-align:center">${shippingAddress.getShipping_Id()}</td>
  </table><br></br><br></br>
  
  
  <table  class="ts" style="width:100%">
  <tr>
    <th style="text-align:center">PRODUCT IMAGE</th>
	<th style="text-align:center">PRODUCT NAME</th>
	<th style="text-align:center">DESCRIPTION</th>
	<th style="text-align:center">CATEGORY NAME</th>
	<th style="text-align:center">SELLER NAME</th>
	<th style="text-align:center">PRICE</th>
  </tr>
  <c1:if test="${prot!=null}">
  <tr> 
  <td><img src="<c:url value='/resources/images/${prot.getProId()}.jpg'/>" style="width:120px; height:100px;left:100px;bottom:1px;"></td>
  <td style="text-align:center">${prot.getName()}</td>
  <td style="text-align:center">${prot.getDescription()}</td>
  <td style="text-align:center">${prot.getCategory().getCatName()}</td>
  <td style="text-align:center">${prot.getSupplier().getName()}</td>
  <td style="text-align:center">${prot.getPrice()}</td>
  </tr></c1:if>


  

<%-- <c1:if test="${prot==null}"> --%>
<%--      <c1:forEach items="${cartItem1}" var="car"> --%>
<!--      <tr> -->
<%--      <td style="text-align:center"><img src="<c:url value='/resources/Images/${car.getProduct().getPid()}.jpg'/>" style="width:px; height:100px;left:100px;bottom:1px;"></td> --%>
<%--      <td style="text-align:center">${car.getProduct().getPname()}</td> --%>
<%--      <td style="text-align:center">${car.getProduct().getCategory().getCname()}</td> --%>
<%--      <td style="text-align:center">${car.getProduct().getSupplier().getSname()}</td> --%>
<%--      <td style="text-align:center">${car.getProduct().getPprice()}</td> --%>
<%--      </tr></c1:forEach></c1:elif> --%>

<c1:if test="${prot==null}">
<c1:forEach items="${cartItems}" var="car">
 <tr>
     <td style="text-align:center"><img src="<c:url value='/resources/Images/${car.getProduct().getProId()}.jpg'/>" style="width:px; height:100px;left:100px;bottom:1px;"></td>
     <td style="text-align:center">${car.getProduct().getName()}</td>
     <td style="text-align:center">${car.getProduct().getDescription()}</td>
     <td style="text-align:center">${car.getProduct().getCategory().getcatName()}</td>
     <td style="text-align:center">${car.getProduct().getSupplier().getName()}</td>
     <td style="text-align:center">${car.getProduct().getPrice()}</td>
    </tr>
    </c1:forEach>
</c1:if>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<p>Total Price=Rs${p.getPrice()}</p>
<h2>Order will be delivered to you in 7 bussiness days</h2>
<div>
<a href="<c:url value="/previous"/>"class="btn btn default ">Previous</a>
</div>
<div>
<a href="<c:url value="/pay"/>">Pay</a>
</div>
</body>
</html>


