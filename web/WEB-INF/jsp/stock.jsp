<%-- 
    Document   : stock
    Created on : Mar 14, 2017, 10:22:19 PM
    Author     : Aditi Dandekar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="wheader.jsp"></jsp:include>    
     <!-- End product widget area -->
     <form action="addstock.htm" class="form-signin">
         <input type="number" maxlength="4" min="1" class="form-control" name="stock">
         <input type="hidden" name="pid" value="${requestScope.pid}">
             <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Submit</button>
         
     </form>
<jsp:include page="footer.jsp"></jsp:include>