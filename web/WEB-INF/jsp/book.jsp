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
<c:forEach var="m" items="${list}">
    <table cell-spacing="0">
        <tbody>
            <tr>
                <td>${m.pid}</td>
            </tr>
            <tr>
                <td>${m.discount}</td>
            </tr>
            <tr>
                <td>${m.price}</td>
            </tr>
        </tbody>
    </table>
</c:forEach>
     
<jsp:include page="footer.jsp"></jsp:include>