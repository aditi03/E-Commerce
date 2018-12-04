<%-- 
    Document   : newjsp
    Created on : Jan 26, 2017, 5:04:24 PM
    Author     : Helisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminheader.jsp"></jsp:include>    
     
    <form action="verifylaptop.htm">
     PID : <input type="text" id="pid" name="pid" placeholder="Product Id"  required autofocus> </br>
     Product name : <input type="text" id="pnm" name="pnm"  required autofocus></br>
     Price : <input type="number" step="0.01" id="price" name="price" class="form-control" required autofocus></br>
     Discount : <input type="number" id="discount" name="discount" class="form-control" required autofocus> %</br>
     Count : <input type="text" id="count" name="count" required autofocus></br>
     Model : <input type="text" id="model" name="model" required autofocus></br>
     Ram : <input type="number" id="Ram" name="ram" autofocus></br>
     series : <input type="number" id="series" name="series" autofocus></br>
     Screen_size : <input type="text" id="screensize" name="screensize" autofocus></br>
     HD : <input type="text" id="hd" name="hd"  autofocus></br>
     Model year : <input type="number" id="model_year" name="model_year" autofocus></br>
     Battery : <input type="number" id="battery"  name="battery" autofocus></br>
     Processor : <input type="text" id="processor" name="processor"  required autofocus></br>
     Color : <input type="text" id="color"  name="color" required autofocus></br>
     Os : <input type="text" id="os" name="os"  required autofocus></br>
     Company : <input type="text" id="company" name="company"  autofocus></br>
     Graphic card : <input type="text" id="graphic_card" name="graphic_card" autofocus></br>
     Warranty : <input type="text" id="warranty" name="warranty"  autofocus></br>
     ports : <input type="text" id="ports" name="ports"  autofocus></br>
     Weight : <input  type="number" step="0.01" id="weight"  name="weight" autofocus></br>
     prospeed : <input type="text" id="prospeed" name="prospeed" autofocus></br>
     procount : <input type="number" id="procount" name="procount" autofocus></br>
     protype : <input type="text" id="protype" name="protype" autofocus></br>
     <input type="submit" name="Submit"></br>
     </form>
    
<jsp:include page="footer.jsp"></jsp:include>