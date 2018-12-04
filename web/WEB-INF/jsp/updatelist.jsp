<%-- 
    Document   : viewlist
    Created on : Mar 12, 2017, 11:35:47 AM
    Author     : Viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
    <div class="woocommerce">
        <form method="post" action="#">
            <table cellspacing="0" class="shop_table cart">
                <thead>
                    <tr>
                        
                        <th class="product-thumbnail">&nbsp;</th>
                        <th class="product-name">Product</th>
                        <th class="product-price">Price</th>
                        <th class="product-quantity">Discount</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ob" items="${list}">
                        <tr class="cart_item">
                            <td class="product-thumbnail">
                                <img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="img/product-thumb-2.jpg">
                            </td>
                            <!--<input type="hidden" name="pid" value="${ob.pid}"/>-->
                            
                            <td class="product-name">
                               <c:out value="${ob.name}"/>
                            </td>

                            <td class="product-price">
                                <span class="amount"><c:out value="${ob.price}"/></span>
                            </td>

                            <td class="product-subtotal">
                                <span class="amount">${ob.product.discount}</span>
                            </td>
                            <td class="product-subtotal">
                                <span class="amount"><a href="updateproduct.htm?pid=${ob.pid}">UPDATE</a></span>
                            </td>
                            <td class="product-subtotal">
                                <span class="amount"><a href="removeproduct.htm?pid=${ob.pid}">REMOVE</a></span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
<jsp:include page="footer.jsp"></jsp:include>