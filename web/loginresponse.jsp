<%-- 
    Document   : loginresponse
    Created on : 25 May, 2021, 8:26:21 PM
    Author     : tasmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String email=(String)request.getAttribute("email");
    String result=(String)request.getAttribute("result");
    
if(email!=null && result!=null)
{
    HttpSession sess= request.getSession();//arg me true ya false nhi qk hme session chahiye hi chahiye
    sess.setAttribute("email", email);//for other pages to decide whether they are geing accessed directly or after login.
    String url="";
    
    if(result.equalsIgnoreCase("Admin"))
    {
       url="AdminControllerServlet;jsessionid="+sess.getId();//jb session bnta h to ek cookie bnta h wo cookie browser ko milta h jo wo sendback krta h server ko lekin is baar request browser nhi ajax send krega or ajax cookie nhi bhejega //jsessionid bhi bhejenge qk ajax se redirect krenge 
        
    }
    else 
    {
       url="CustomerControllerServlet;jsessionid="+sess.getId(); 
    }
    out.println(url);
}
else
    out.println("error");

%>