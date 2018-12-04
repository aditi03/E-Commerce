<%-- 
    Document   : header
    Created on : Jan 26, 2017, 6:44:18 PM
    Author     : Aditi Dandekar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insilico</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li>Hello, Admin</li>
                            <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <c:if test="${message eq 'admin'}">
                            <li><a href="adminhome.htm"><i class="fa fa-user"></i>Dashboard</a></li>
                            </c:if>
                            
                            <c:if test="${message eq 'warehouse'}">
                            <li><a href="whome.htm"><i class="fa fa-user"></i>Dashboard</a></li>
                            </c:if>

                            <li><a href="login.htm"><i class="fa fa-user"></i>Login</a></li>
                            <li><a href="registration.htm"><i class="fa fa-user"></i>Register</a></li>
                        
                        </ul>    
                </div>
            </div>
        </div>
    </div>
       </div><!-- End header area -->
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="index.html">I<span>nsilico</span></a></h1>
                    </div>
                </div>
                
                <div class="col-sm-6">
                    <div class="shopping-item">
                        <a href="cart.htm">Cart - <span class="cart-amunt">$800</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                    </div>
                    <div class="col-sm-6"></div>
                    
                    <div class="shopping-item">
                        <a href="wishlist.htm"> WishList     <i class="glyphicon glyphicon-heart"></i></a>
                    </div>
                </div>
            </div> 
            </div>
        
    </div> <!-- End site branding area -->

    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>  
                </div> 
                 <form action="#">
                            <div class="nav-fill">
                                <div class="nav-search-field">
                            
                                <i class="glyphicon glyphicon-search"></i>
                                <input type="field-keywords" placeholder="Search" tabindex="50" class="nav-input">
                                <input type="submit" value="Search">
                            </div></div></form>
                       
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                          <li>
                           <!--form here-->  
                          </li>        
                        <li>
                            <a>                  </a> 
                        </li>
                        
                        <li class="active"><a href="home.htm">Home</a></li>
                      
			                  

  <li class="dropdown">
      <button class="dropbtn"><b>ELECTRONICS</b></button>
  <div class="dropdown-content">
      <a href="home.htm">Home Appliances</a>
    <a href="#">Mobile and Tablet</a>
    <a href="#">Computers</a>
  </div>
  </li>
  
    <li class="dropdown">
        <button class="dropbtn"><b>CLOTHING</b></button>
  <div class="dropdown-content">
      <a href="home.htm">Women</a>
      <a href="">Men</a>
   </div>
  </li>
  <li><a href=home.htm>Books</a></li>                      
  <li><a href="">Contact</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
