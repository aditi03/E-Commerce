<%-- 
    Document   : forgotpwd
    Created on : May 4, 2017, 5:35:10 PM
    Author     : Viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="forgotpassword.htm">
                                <table cellspacing="0" class="shop_table cart">
                                    <tr>
                                        <td>Email Address</td>
                                        <td><input type="email" name='email'/></td>
                                    </tr>
                                    
                                </table>
                                <button class="add_to_cart_button" type='submit'>Send Email</button>
                            </form>

                            
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
