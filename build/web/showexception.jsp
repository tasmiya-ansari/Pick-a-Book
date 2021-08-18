<%-- 
    Document   : showexception
    Created on : 30 May, 2021, 2:01:43 AM
    Author     : tasmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Exception ex=(Exception)request.getAttribute("exception");
    System.out.println("Exception is : " +ex);//server pr msg
    out.println("Some Exception occured "+ ex.getMessage());//client pr msg
    
%>
