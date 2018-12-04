<%-- 
    Document   : newjsp
    Created on : Jan 26, 2017, 5:04:24 PM
    Author     : Aditi Dandekar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    
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
  
<jsp:include page="adminheader.jsp"></jsp:include>    
     <!-- End product widget area -->
     <form action="verifymobtab.htm">
         PID : <input type="text" id="pid" name="pid" placeholder="Product Id"  required autofocus> </br>
     Product name : <input type="text" id="pnm" name="pnm"  required autofocus></br>
     Price : <input type="number" step="0.01" id="price" name="price" class="form-control" required autofocus></br>
     Discount : <input type="number" id="discount" name="discount" class="form-control" required autofocus> %</br>
     Count : <input type="text" id="count" name="count" required autofocus></br>
     Model : <input type="text" id="model" name="model" required autofocus></br>
     Ram : <input type="number" id="Ram" name="ram" autofocus></br>
     Rom : <input type="number" id="rom" name="rom" autofocus></br>
     Screen_size : <input type="text" id="screensize" name="screensize" autofocus></br>
     Front cam : <input type="number" step="0.01" id="fc" name="fc"  autofocus></br>
     Rare cam : <input type="number" step="0.01" id="rc" name="rc" autofocus></br>
     Battery : <input type="number" id="battery"  name="battery" autofocus></br>
     Processor : <input type="text" id="processor" name="processor"  required autofocus></br>
     Color : <input type="text" id="color"  name="color" required autofocus></br>
     Os : <input type="text" id="os" name="os"  required autofocus></br>
     Company : <input type="text" id="company" name="company"  autofocus></br>
     Con_Tech : <input type="text" id="con_tech" name="con_tech" autofocus></br>
     Warranty : <input type="text" id="warranty" name="warranty"  autofocus></br>
     Special Features : <input type="text" id="spf" name="spf"  autofocus></br>
     Weight : <input  type="number" step="0.01" id="weight"  name="weight" autofocus></br>
     whats In box : <input type="text" id="inbox" name="inbox" autofocus></br>
     <input type="submit" name="Submit"></br>
     </form>
     <jsp:include page="footer.jsp"></jsp:include>