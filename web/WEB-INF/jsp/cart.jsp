<%-- 
    Document   : cart
    Created on : Feb 2, 2017, 4:14:44 PM
    Author     : Viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<c:if test="${err eq 'error'}">
    <script>
        window.alert("Item already exist in cart");
    </script>
</c:if>    
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shopping Cart</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
     <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Search Products</h2>
                        <form action="#">
                            <input type="text" placeholder="Search products...">
                            <input type="submit" value="Search">
                        </form>
                    </div>
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Products</h2>
                        <div class="thubmnail-recent">
                            <img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                    </div>
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Recent Posts</h2>
                        <ul>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="checkout.htm">
                            <c:if test="${not empty list}">
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                            
                                            <th class="product-thumbnail">&nbsp;</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="ob" items="${list}" varStatus="i">
                                        <c:forEach var="ob1" items="${ob}">
                                        <tr class="cart_item">
                                            
                                            <td class="product-thumbnail">
                                                <a href="single-product.htm?pid=${ob1.pid}"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="img/product-thumb-2.jpg"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="single-product.htm?pid=${ob1.pid}">${ob1.name}</a> 
                                            </td>

                                            <td class="product-price">
                                                <a href="single-product.htm?pid=${ob1.pid}"><span class="amount">Rs.${ob1.price}</span></a> 
                                            </td>
                                                
                                            <td class="product-quantity">
                                                <div class="quantity">
                                                    <input type="number" size="4" class="input-text qty text" name="${i.count}" required min="1" value="1" step="1"/>
                                                    <input type="hidden" value="${ob1.pid}" name="pid${i.count}"/>
                                                </div>
                                            </td>
                                            
                                        
                                            
                                        </tr>
                                        <tr>
                                            <td class="actions" colspan="6">
                                                <a href="movetowishlist.htm?pid1=${ob1.pid}"><input type="button" class="add_to_cart_button" value="Move To WishList"/></a>
                                                <a href="removefromcart.htm?pid1=${ob1.pid}"><input type="button" class="add_to_cart_button" value="Remove From Cart"/></a>
                                                <!--<input type="submit" value="Move To WishList" name="update_cart" class="button">
                                                <input type="submit" value="Remove Item" name="proceed" class="checkout-button button alt wc-forward">-->
                                            </td>
                                        </tr>
                                    </c:forEach>    
                                    </c:forEach>
                                        <!--<input type="hidden" name="count" value=""/>-->
                                        <tr>
                                            <td class="actions" colspan="6">
                                                <input type="submit" value="Proceed To Checkout" name="checkout" class="button">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </c:if>
                            <c:if test="${empty list}">
                                <h3>Cart is empty</h3>
                            </c:if>
                            </form>

                            <div class="cart-collaterals">


                            <div class="cross-sells">
                                <h2>You may be interested in...</h2>
                                <ul class="products">
                                    <li class="product">
                                        <a href="single-product.html">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="img/product-2.jpg">
                                            <h3>Ship Your Idea</h3>
                                            <span class="price"><span class="amount">£20.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="single-product.html">Select options</a>
                                    </li>

                                    <li class="product">
                                        <a href="single-product.html">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="img/product-4.jpg">
                                            <h3>Ship Your Idea</h3>
                                            <span class="price"><span class="amount">£20.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="single-product.html">Select options</a>
                                    </li>
                                </ul>
                            </div>








                            </div>
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>
    
<jsp:include page="footer.jsp"></jsp:include>