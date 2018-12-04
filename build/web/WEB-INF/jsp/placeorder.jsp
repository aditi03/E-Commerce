<%-- 
    Document   : placeorder
    Created on : Mar 16, 2017, 10:38:31 PM
    Author     : Viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
        <jsp:include page="header.jsp"></jsp:include>
        
        <c:if test="${requestScope.congo eq 'true'}">
        <script>
            window.alert("Your order has been placed successfully HAPPY SHOPPING!");
        </script>
        </c:if>
        <table border='1'>
            <thead>
                <th>
                   Product ID
                </th>
                <th>
                    Quantity
                </th>
            </thead>
            <tr>
             
            <c:forEach var="i" items="${sessionScope.pid}">
                <td>${i}</td>
            </c:forEach>    
                
            <c:forEach var="i" items="${sessionScope.quantity}">
                <td>${i}</td>
            </c:forEach>
            
            
            </tr>
        </table>
        <jsp:include page="footer.jsp"></jsp:include>
