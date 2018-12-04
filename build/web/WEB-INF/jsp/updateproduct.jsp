<%-- 
    Document   : newjsp
    Created on : Jan 26, 2017, 5:04:24 PM
    Author     : Helisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="adminheader.jsp"></jsp:include>    
     <!-- End product widget area -->
     <c:forEach var="ob" items="${list}">
     ${list}
      
     <form action="verifupdateymobtab.htm?pid=${ob.pid}"  method="post">
    
     PID : ${ob.pid}  </br> 
     Product name : <input type="text" id="pnm" name="pnm" value="${ob.name}" required autofocus></br>
     Price : <input type="number" step="0.01" id="price" name="price" value="${ob.price}" class="form-control" required autofocus></br>
     <!--Discount : <input type="number" id="discount" name="discount" value="${ob.product.discount}" class="form-control" required autofocus> %</br>-->
     Count : <input type="text" id="count" name="count" value="${ob.count}" required autofocus></br>
     Model : <input type="text" id="model" name="model" value="${ob.model}" required autofocus></br>
     Ram : <input type="number" id="Ram" name="ram" value="${ob.ram}" autofocus></br>
     Rom : <input type="number" id="rom" name="rom" value="${ob.rom}" autofocus></br>
     Screen_size : <input type="text" id="screensize" value="${ob.screenSize}" name="screensize" autofocus></br>
     Front cam : <input type="number" step="0.01" id="fc" name="fc" value="${ob.frontCam}"  autofocus></br>
     Rare cam : <input type="number" step="0.01" id="rc" name="rc" value="${ob.rearCam}" autofocus></br>
     Battery : <input type="number" id="battery"  name="battery" value="${ob.battery}" autofocus></br>
     Processor : <input type="text" id="processor" name="processor" value="${ob.processor}" required autofocus></br>
     Color : <input type="text" id="color"  name="color" value="${ob.color}" required autofocus></br>
     Os : <input type="text" id="os" name="os" value="${ob.os}" required autofocus></br>
     Company : <input type="text" id="company" value="${ob.company}" name="company"  autofocus></br>
     Con_Tech : <input type="text" id="con_tech" value="${ob.conTech}" name="con_tech" autofocus></br>
     Warranty : <input type="text" id="warranty" name="warranty" value="${ob.warranty}" autofocus></br>
     Special Features : <input type="text" id="spf" name="spf" value="${ob.specialFeaturs}" autofocus></br>
     Weight : <input  type="number" step="0.01" id="weight" value="${ob.weight}" name="weight" autofocus></br>
     whats In box : <input type="text" id="inbox" name="inbox" value="${ob.inbox}" autofocus></br>
     <input type="submit" name="Submit"></br>
     
     </form>
     </c:forEach>
     <jsp:include page="footer.jsp"></jsp:include>