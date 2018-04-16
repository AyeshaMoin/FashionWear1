<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transactional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%--      <%@ include file="nav.jsp"%> --%>
  <title>FashionWear</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <c:url value="/resources/images" var="img"/>
   <c:url value="/resources/css" var="css"/>
    <c:url value="/resources/js" var="js"/>
  <title>Home</title>
  <style>
  body {
    background: linear-gradient(to bottom, #3399ff 0%,  #ff99cc
 100%); 
  }
  div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float:auto;
    width: 250px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}

   .hover1:hover
  {
    background-color: black;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;

  
  }
   footer {
  	width: 100%;
    color: black;
    background-color:white;
    text-align: center;
    
  
}
a {
text-decoration: none;
}
</style>

</head>
<c:url value="/resources/images/" var="img"/>
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

 
<!--  <div class="nav"> -->
<!--     <ul> -->
<%-- <%--     <li><a href="<c:url value="/Home"/>"/>HOME</a></li> --%> 
<!--      <li>Categories</li> -->
<%--     <c1:forEach items="${lcat }" var="cat1"></c1:forEach> --%>
<!--   <!--  <li><a href="http://localhost:8080/Frontend/Product">PRODUCT</a></li>--> 
<!--   <!-- <li><a href=product.html">MensWear</a></li> --> 
<!--   <!-- <li><a href=product.html">WomensWear</a></li> --> 
<!--   <!-- <li><a href=product.html">KidsWear</a></li> --> 
<%--   <c1:if test="${pageContext.request.userPrincipal.name!=null }"> --%>
<%--   <security:authorize access="hasRole('ROLE_ADMIN')"> --%>
<!--   <li id="dropdown"> -->
<!--   <a href="javascript:void(0)" id="dropbtn">ADMIN</a> -->
<!--   <div id ="dropdown-content"> -->
<%--   <a href="<c:url value="/category"/>">ADD CATEGORY</a> --%>
<%--   <a href="<c:url value="/product"/>">ADD PRODUCT</a> --%>
<%--   <a href="<c:url value="/supplier"/>">ADD SUPPLIER</a> --%>
<!--   </div> -->
<!--   </li> -->
<%--   </security:authorize></c1:if> --%>
<!--    </ul> -->
<!--   </div> -->
<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
      <li data-target="#myCarousel" data-slide-to="6"></li>
     </ol>
   
    <div class="carousel-inner">

      <div class="item active">
        <img src="<c:url value="/resources/images/im101.jpg"/>" alt="Lehenga" class="responsive" style="width:1250px;height:450px;">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/im102.jpg"/>" alt="party wear" style="width:1250px;height:450px;">
      </div>
      <div class="item">
        <img src="<c:url value="/resources/images/3.jpg"/>" alt="Salwar suit" style="width:1250px; height:450px;">
      </div>
       <div class="item">
        <img src="<c:url value="/resources/images/4.jpg"/>" alt="Formal wear" style="width:1250px;height:450px;">
      </div>
       <div class="item">
        <img src="<c:url value="/resources/images/5.jpg"/>" alt="Party FashionWear" style="width:1250px;height:450px;">
      </div>
       <div class="item">
        <img src="<c:url value="/resources/images/2.jpg"/>" alt="children wear" style="width:1250px; height:450px;">
      </div>
        <div class="item">
        <img src="<c:url value="/resources/images/1.jpg"/>" alt="Party FashionWear" style="width:1250px;height:450px;">
      </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
    </div>
    <div>
    <h1>LIST OF ITEMS</h1>
    <div class="responsive">
    <div class="gallery">
   <c1:forEach items="${products}" var="pro">
    <a href="<c:url value="/ViewProducts"/>"></a><img src="${img}/${pro.getProId()}.jpg" alt="List of  items" width="300" height="200">
    <div class="desc">${pro.getName()}</div>
    
  <button type="submit" ><a href="<c:url value="/addtocart/${pro.getProId()}"/>">Add To Cart</a></button>
</c1:forEach>
    </div>
   
    </div></div></div>
   
<footer>Copyright &copy; 2017-2018 FashionWear.com,contact us @ facebook, twitter</footer>


</body>
</html>

    