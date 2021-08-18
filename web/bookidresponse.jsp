<%-- 
    Document   : bookidresponse
    Created on : 31 May, 2021, 3:12:07 PM
    Author     : tasmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            String bookid=(String)request.getAttribute("bookid");
            out.println(bookid);
%>