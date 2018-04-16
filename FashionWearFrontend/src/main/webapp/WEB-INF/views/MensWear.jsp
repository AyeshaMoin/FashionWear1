<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mens Wear</title>
<%@ include file="Nav.jsp"%>
<c:url value="/resources/images" var="img"/>
<meta content="noindex, nofollow" name="robots">
<style>
div.gallery {
    border: 1px solid #ccc;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 200px;;
    height: 200px;
}

div.desc {
    padding: 15px;
    text-align: center;
}

* {
    box-sizing: border-box;
}

.responsive {
    padding: 0 6px;
    float: left;
    width: 24.99999%;
}

@media only screen and (max-width: 700px){
    .responsive {
        width: 49.99999%;
        margin: 6px 0;
    }
}

@media only screen and (max-width: 500px){
    .responsive {
        width: 100%;
    }
}



input[type=submit] {
    background-color: #33ccff;
    border: 1px solid black;
    color: black;
    padding: 16px 32px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
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

<div class="gallery">
<c1:forEach items="${products}" var="pro">
<img src="<c:url value='/resources/images/${pro.getProId()}.jpg'/>"/>
<div>${pro.getDescription()}</div>
<div>${pro.getName()}</div>
<div>${pro.getPrice()}</div>
<div>${pro.getQuantity()}</div>
<form action="<c:url value='/addtocart/${pro.getProId()}'/>" method="post">
<input type="submit" class="addtocartbtn">Add to cart</form>
</c1:forEach>
</div>

<!--  <div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-1.webp">
    <img src="/k:/Ayesha%20Niit/images/im-1.webp" alt="Cream jacket" width="300" height="200">
  </a>
  <div class="desc">This Beige color Jacket Over A Shirt And Trouser</div>
<div class="price" style="text-align:center">Price:Rs.2500/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-2.webp">
    <img src="/k:/Ayesha%20Niit/images/im-2.webp" alt="Beige" width="600" height="400">
  </a>
  <div class="desc"> Beige jodhpuri made in finest cotton based fabric for the special days!</div>
<div class="price" style="text-align:center">Price:Rs.2200/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-3.webp">
    <img src="/k:/Ayesha%20Niit/images/im-3.webp" alt="black jacket" width="600" height="400">
  </a>
  <div class="desc"> Jute based black colour jute jacket with black piping on corners to match with kurtas</div>
<div class="price" style="text-align:center">Price:Rs.3500/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-4.webp">
    <img src="/k:/Ayesha%20Niit/images/im-4.webp" alt="Blue jacket" width="600" height="400">
  </a>
  <div class="desc">Made from high class poly blend brocade fabric,the elegant design makes it look sober</div>
<div class="price" style="text-align:center">Price:Rs.2000/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-5.webp">
    <img src="/k:/Ayesha%20Niit/images/im-5.webp" alt="Maroon pyjama" width="600" height="400">
  </a>
  <div class="desc"> Maroon Color Dupion Silk Kurta Churidar Pyjami </div>
<div class="price" style="text-align:center">Price:Rs.2400/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-6.webp">
    <img src="/k:/Ayesha%20Niit/images/im-6.webp" alt="white Dhoti" width="600" height="400">
  </a>
  <div class="desc">Plain White Dhoti and kurta set to look your best for all occassions. </div>
<div class="price" style="text-align:center">Price:Rs.1500/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-7.webp">
    <img src="/k:/Ayesha%20Niit/images/im-7.webp" alt="Black jacket" width="600" height="400">
  </a>
  <div class="desc">Black Solid black Waist Coat Jacket Over A Shirt And Trouser. </div>
<div class="price" style="text-align:center">Price:Rs.1900/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-8.webp">
    <img src="/k:/Ayesha%20Niit/images/im-8.webp" alt="Purple Sherwani" width="600" height="400">
  </a>
  <div class="desc">Purple Color Jacquard Block Printed Round Collar Full Sleeves Sherwani</div>
<div class="price" style="text-align:center">Price:Rs.2300/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-9.webp">
    <img src="/k:/Ayesha%20Niit/images/im-9.webp" alt="Pink jacket" width="600" height="400">
  </a>
  <div class="desc">sleeveless Nehru Jacket,a stylish pick to be paired with a kurta pyjama. </div>
<div class="price" style="text-align:center">Price:Rs.2600/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div>
</div>
<div class="responsive">
<div class="gallery">
  <a target="_blank" href="/k:/Ayesha%20Niit/images/im-10.webp">
    <img src="/k:/Ayesha%20Niit/images/im-10.webp" alt="Gold jacket" width="600" height="400">
  </a>
  <div class="desc">Gold Color Cotton V Neck Sleeveless Readymade Waistcoat</div>

</div><div class="price" style="text-align:center">Price:Rs.2800/-</div>
<form action="/action_page.php">
  <input type="submit" name="submit" value="VIEW">
  <input type="submit" value="ADD TO CART">
</form>
</div> -->
</body>
</html>