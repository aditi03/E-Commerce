<%-- 
    Document   : newjsp
    Created on : Jan 26, 2017, 5:04:24 PM
    Author     : Helisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminheader.jsp"></jsp:include>    
<form action="searchmobtab.htm" method="post">
    <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" name="search" placeholder="Search for Mobile/Tablet...">
      <span class="input-group-btn">
        <button class="btn btn-default"  type="submit">Go!</button>
      </span>
      </form>
      
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
<jsp:include page="footer.jsp"></jsp:include>