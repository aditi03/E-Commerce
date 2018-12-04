<%-- 
    Document   : sbook
    Created on : Mar 8, 2017, 12:04:27 PM
    Author     : Aditi Dandekar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="adminheader.jsp"></jsp:include>

     <!-- End product widget area -->
     
     
     <div class="container">
         
         <div class="card card-container">
     <form class="form-signin" action="bookcontroller.htm" enctype="multipart/form-data">
                <span id="reauth-email" class="reauth-email"></span>
                <p id="profile-name" class="profile-name-card"></p>
                <input type="text" class="form-control" placeholder="Name" required autofocus name="name">
                <input type="number" class="form-control" placeholder="Price" required name="price">
                <input type="number" class="form-control" placeholder="Discount in percentage" required name="discount">
                
                <input type="text" class="form-control" placeholder="Author" required name="author">
                <input type="text" class="form-control" placeholder="Publication" required name="publication">
                <p class="form-row form-row-wide">
                    <select name="genre">
                        <option value="">Genre</option>
                        <option value="fiction">Fiction</option>
                        <option value="comedy">Comedy</option>
                        <option value="comedy">Study</option>
                        <option value="drama">Drama</option>
                        <option value="horror">Horror</option>
                        <option value="non-fiction">Non-fiction</option>
                        <option value="romance">Romance</option>
                        <option value="fantasy">Fantasy</option>
                </select>
                </p>
                <input type="text" class="form-control" placeholder="Language" required name="language">
                <input type="number" class="form-control" placeholder="Rank" required name="rank">
                <input type="textbox" class="form-control" placeholder="Description"  name="description">
                
                <select id="n_img" name="n_img">
                    <option id="0">0</option>
                    <option id="1">1</option>
                    <option id="2">2</option>
                    <option id="3">3</option>
                    <option id="4">4</option>
                    <option id="5">5</option>
                </select>
                <input type="button" onclick="addFields()" value='Submit'>
                
                <div id='container'></div>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Submit</button>
                ${message}
            </form>
             </div>
         </div>
                
                <script type='text/javascript'>
                    function addFields(){
                        var num=document.getElementById("n_img").value;
                        var container=document.getElementById("container");
                        while(container.hasChildNodes())
                        {
                            container.removeChild(container.lastChild);
                        }
                        for(i=0;i<num;i++)
                        {
                            container.appendChild(document.createTextNode("Image"+(i+1)));
                            var input=document.createElement("input");
                            input.type="file";
                            input.name="file";
                            input.id="file";
                            container.appendChild(input);
                            container.appendChild(document.createElement("br"));
                        }
                        /*var b1=input=document.createElement("input");
                        b1.type="button";
                        b1.value="submit";*/
                    }
                    </script>
<jsp:include page="footer.jsp"></jsp:include>

