<%-- 
    Document   : mobile
    Created on : Mar 14, 2017, 9:23:55 PM
    Author     : Aditi Dandekar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="wheader.jsp"></jsp:include>    
     <!-- End product widget area -->
     <table cell-spacing="0" class="shop_table cart">
     <thead>
            <tr>
        <th>PID</th>
        <th>Discount</th>
        <th>Price</th>
        </tr>
        </thead>
<c:forEach var="m" items="${list}">
    
        
        <tbody>
            <tr class="cart_item">
                <td class="product-name"><a href="stock.htm?pid=${m.pid}">${m.pid}</a></td>
            
                <td class="product-name"><a href="stock.htm?pid=${m.pid}">${m.discount}</a></td>
            
                <td class="product-name"><a href="stock.htm?pid=${m.pid}">${m.price}</a></td>
            </tr>
        </tbody>
        </c:forEach>
    </table>

     
<jsp:include page="footer.jsp"></jsp:include>