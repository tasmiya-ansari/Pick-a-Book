<%@page import="pickabook.dto.UserDetailsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.JSONObject" %>
<%
    
    UserDetailsDTO user = (UserDetailsDTO) request.getAttribute("user");
    JSONObject json=new JSONObject();
    json.put("email",user.getEmail());
    json.put("username",user.getUsername());
    json.put("mobile",user.getMobile_no());
    json.put("address",user.getAddress());
    json.put("city",user.getCity());
    json.put("state",user.getState());
    out.println(json); 
%>