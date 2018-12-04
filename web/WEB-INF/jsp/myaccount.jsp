<%-- 
    Document   : myaccount
    Created on : May 4, 2017, 2:45:58 PM
    Author     : Viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>My Account</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="#">
                            <c:if test="${not empty list}">
                                <table cellspacing="0" class="shop_table cart">
                                    <tr>
                                        <td>EmailId</td>
                                        <td>${list.emailid}</td>
                                    </tr>
                                    <tr>
                                        <td>First Name</td>
                                        <td>${list.fname}</td>
                                    </tr>
                                    <tr>
                                        <td>Last Name</td>
                                        <td>${list.lname}</td>
                                    </tr>
                                    <tr>
                                        <td>Phone No.</td>
                                        <td>${list.phno}</td>
                                    </tr>
                                    <tr>
                                        <td>Address</td>
                                        <td>${list.addr}</td>
                                    </tr>
                                    <tr>
                                        <td>City</td>
                                        <td>${list.city}</td>
                                    </tr>
                                    <tr>
                                        <td>State</td>
                                        <td>${list.state}</td>
                                    </tr>
                                    <tr>
                                        <td>Pincode</td>
                                        <td>${list.pincode}</td>
                                    </tr>
                                    
                                </table>
                            </c:if>
                                <button class="add_to_cart_button" formaction="resetpassword.htm">Reset Password</button>
                            </form>

                            
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>    
