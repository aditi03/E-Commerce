<%-- 
    Document   : adminregister
    Created on : Mar 14, 2017, 3:58:14 PM
    Author     : Aditi Dandekar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    
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
    
    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    </head>
    <body>
        <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" method="post" action="verifyadminregister.htm">
                <span id="reauth-email" class="reauth-email"></span>
                <h1><p style="text-align:center"><label><b>Registration</b></label></p></h1>
                <input type="text" id="fn" name="fn" placeholder="First Name" class="form-control" required autofocus>
                <input type="text" id="ln" name="ln"placeholder="Last Name" class="form-control" required autofocus>
                <input type="tel" id="tel" pattern="^\d{10}$" name="pn" placeholder="Phone No" class="form-control" required autofocus>
                <br/>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email" required autofocus>
           
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <br/>
                <!-- pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})" -->
                <textarea name="address" cols="30" rows="3" placeholder="Address"></textarea>
                <br/>
                <input type="text" name="city" class="form-control" placeholder="City" required>
                <br/>
                <input type="text" name="state" class="form-control" placeholder="State" required>
                <br/>
                <input type="number" size="6" name="pincode" placeholder="Pincode" class="form-control" required>
                <br/>
                <button class="btn btn-lg btn-primary btn-block btn-signin" name="register" value="Register" type="submit"><a href="verifyregistration.htm">Register</a></button>
            </form><!-- /form -->
        </div><!-- /card-container -->
    </div><!-- /container -->
    </body>
</html>
