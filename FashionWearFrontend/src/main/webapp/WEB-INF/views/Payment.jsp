<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

   <c:url value="/resources/css" var="css"/>
    <c:url value="/resources/js" var="js"/>
 <c:url value="/resources/css" var="css"/>
  <title>Payment</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" media="all">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet" media="all">
  <script src="${js}/jquery.js"></script>
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script> -->
<!--   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>
 var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope, $http){
	 $http.get("http://localhost:8080/FashionWearFrontend/SendMail")
	 });
 </script>
<style>
  body {
    background: linear-gradient(to bottom, #3399ff 0%,  #ff99cc
 100%); 
 margin-right:100px;
 padding:0px;
 width:1365px;
  }
  div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float:auto;
    width: 180px;
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
  <%@ include file="Nav.jsp"%> 
  
    <link type="text/css" href="${css}/form.css" rel="stylesheet">
</head>
 <c:url value="/resources/images" var="img"/>
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
          <button class="btn btn-default" type="submit" style="width:50px;height:34px;">
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

<div class="container">
   <center><h2>Pay</h2></center>
  <p><strong>Note:</strong> please <strong>Select</strong> The  payment method in order to complete your order </p>
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Cash on Delivery</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
        <c:url value="/payment" var="e"/>
          <form:form action="${e}" method="post" id="myForm">
          <div class="checkbox">
             <input type="checkbox"  name="cod" value="1" name="pay"  data-toggle="collapse" data-target="#demo" >cod
              <div id="demo" class="collapse">
   					 One time password has been sent to your mail id<br>
   					 
   					Enter the otp : <input ng-app="myApp" ng-controller="myCtrl" type="text"  name="otp"> 
  			</div>
             </div>
             <input type="submit" class="button" value="pay">
          </form:form>   
        </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Pay by Card</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse in">
        <div class="panel-body"><div class="container">
    
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="credit-card-div">
                <div class="panel panel-default">
                    <div class="panel-heading">

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <h5 class="text-muted"> Credit Card Number</h5>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <input type="text" class="form-control" placeholder="0000" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <input type="text" class="form-control" placeholder="0000" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <input type="text" class="form-control" placeholder="0000" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <input type="text" class="form-control" placeholder="0000" />
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font"> Expiry Month</span>
                                <input type="text" class="form-control" placeholder="MM" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font">  Expiry Year</span>
                                <input type="text" class="form-control" placeholder="YY" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font">  CCV</span>
                                <input type="text" class="form-control" placeholder="CCV" />
                            </div>
 </div>
                        <div class="row ">
                            <div class="col-md-12 pad-adjust">

                                <input type="text" class="form-control" placeholder="Name On The Card" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 pad-adjust">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" checked class="text-muted"> Save details for fast payments. <a href="#">Learn More</a>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                <input type="submit" class="btn btn-danger" value="CANCEL" />
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                <input type="submit" class="btn btn-warning btn-block" value="PAY NOW" />
                            </div>
                        </div>

                    </div>
                </div>
            </div>
          
        </div>
    </div>
</div> </div>
    </div>
    
    </div>

</div>

                           
<!-- <form class="form" style="width:500px; height:470px; padding:5px; margin-bottom:50px;margin-top:10px;">
  <div class="container" style=" margin-bottom:50px;margin-top:10px;">
  <h2>Payment</h2>
  <div class="panel-group" id="accordion" style="margin-left:20px; margin-right:750px; margin-bottom:50px; margin-top:10px;">
  <div class="panel panel-default">
  <div class="panel-heading">
  <h4 class="panel-title">
  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"  style="text-decoration:none;">Cash On Delivery</a><br>
  </h4>
  </div>
  <div id="collapse1" class="panel-collapse collapse in">OTP:<input type="text" name="otp"><br><br>
 <div class="panel-body"> Order confirmed and will be delivered in 5 or 6 working days<br><br></div>
  </div>
  </div>
  <div class="panel panel-default">
  <div class="panel heading">
  <h4 class="panel-title">
  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" style="text-decoration:none;">Card Payment</a>
  </h4>
  </div>
  <div id="collapse2" class="panel-collapse collapse">
  <div class="panel-body">
 <label class="radio-inline"><input type="radio" name="payment" value="img"><img src="<c:url value="/resources/images/visa.jpg"/>" alt="Avatar" width="80px" height="60px"></label>
 <label class="radio-inline"><input type="radio" name="payment" value="img"><img src="<c:url value="/resources/images/rupay.jpg"/>" alt="Avatar" width="80px" height="60px"></label>
 <label class="radio-inline"><input type="radio" name="payment" value="img"><img src="<c:url value="/resources/images/sbrupay.jpg"/>" alt="Avatar" width="80px" height="60px"></label><br><br>
  Card_no<input class="radio-inline" type="text" name="cardno"><br><br>
  CVV:<input class="radio-inline" type="text" name="cvv"><br><br></div>
  </div>
  </div>
  <div class="panel panel-default">
  <div class="panel-heading">
  <h4 class="panel-title">
  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" style="text-decoration:none;">Paytm Karo</a>
  </h4>
  </div>
  <div id="collapse3" class="panel-collapse collapse">
  <div class="panel-body">
  Paytm_Number:<label class="radio-inline"><input class="radio-inline" type="text" name="phnum"></label><br><br>
  </div>
  </div>
  </div>
  </div>
  </div>
  </form> -->
  </body>
  </html>
  