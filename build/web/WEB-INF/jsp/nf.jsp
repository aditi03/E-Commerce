<%-- 
    Document   : notification
    Created on : Mar 16, 2017, 5:43:23 AM
    Author     : Helisha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/bootstrap.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
`   <script src="js/nf.js"></script>
    <script>
        $("[data-toggle=popover]").popover({
        html: true, 
            content: function() {
            return $('#popover-content').html();
            }
        });

    </script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
 
    <div><h4 class="menu-title">Notifications</h4>
    </div>
    <li class="divider"></li>
   <div>
       <c:forEach var="ob" items="${list}">
       <li class="divider"></li>
       <div>
       <tr>
           <td><h4>From:</h4></td>
            <td><h5><font color="blue">NAME: ${ob.userByFromEmailid.fname} ${ob.userByFromEmailid.lname}</font></br>
                    ${ob.userByFromEmailid.emailid}</h5>
            </td>
            </tr>
            <tr>
                <td><h4>Product</h4></td>
                <td><a href="single-product.htm?pid=${ob.product.pid}"><font face="verdana" size="4" color="green">${ob.product.name}  Price : ${ob.product.price} Discount : ${ob.product.discount}</font> </a></td>
</a></td>
       </tr>
    </div>
       <hr size="30">
       <hr>
       </c:forEach>
   </div>
     
    <li class="divider"></li>
    <div> <li><h4><a href="home.htm">Home</a></h4></li></div>
  </ul>
  

</body>
</html>