<%-- 
    Document   : registrationresponse
    Created on : 25 May, 2021, 4:10:24 PM
    Author     : tasmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            boolean result=(boolean)request.getAttribute("result");
            boolean userfound=(boolean)request.getAttribute("userfound");
           
            if(userfound==true)
                out.println("uap");
            else if(result==true)
                out.println("success");
            else
                out.println("error");
        %>
