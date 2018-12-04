<%-- 
    Document   : showstock
    Created on : May 4, 2017, 12:30:17 PM
    Author     : Viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
    <div class="woocommerce">
        <form method="post" action="#">
            <table cellspacing="0" class="shop_table cart">
                <thead>
                    <tr>
                        
                        
                        <th class="product-name">Product ID</th>
                        <th class="product-price">Stock</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ob" items="${list}">
                        <tr class="cart_item">
                            <td class="product-thumbnail">
                                ${ob.id.pid}
                            </td>
                            
                            
                            <td class="product-thumbnail">
                                ${ob.stock}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

<jsp:include page="footer.jsp"></jsp:include>