<%-- 
    Document   : getbooksresponse
    Created on : 1 Jun, 2021, 12:35:43 AM
    Author     : tasmi
--%>
<%@page import="pickabook.helper.Helper"%>
<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<BookDetailsDTO> bookList=(ArrayList<BookDetailsDTO>)request.getAttribute("bookList");
    String str="";
    for (BookDetailsDTO book : bookList) 
    {
        str= str+ "<article class='menu-item'>\n"
                + "<img src='./images/books/"+ book.getImagename()+"' class='photo' alt='menu item'>\n"
                + "<div class='item-info'>\n"
                + "<header>\n"
                + "<h4>"+book.getTitle()+"</h4>\n"
                + "<h4 class='price'>&#8377; "+ book.getPrice()+"</h4>\n"
                + " </header>\n"
                + "<p class='item-text'>"+Helper.get150words(book.getDescription())+"</p>\n"
                + "<a href='book-detail.jsp?bid="+book.getBookid()+"' class='btn'>View More</a>\n"
                + "</div>\n"
                + "</article> ";
    }
    out.println(str);
%>