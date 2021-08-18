<%-- 
    Document   : admin.editbooks
    Created on : 1 Jun, 2021, 3:48:35 PM
    Author     : tasmi
--%>

<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="pickabook.dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pickabook.dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/admin.css">
    <script src="js/editbooks.js"></script>
    <script src="js/jquery.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <title>Admin | Update Books</title>
</head>

<body >
    <div class="header">
        <div class="navbar">
            <div class="logo">
                <a href="index.html"><img src="./images/logo.png" alt=""></a>
            </div>
            <nav>
                <a href="#" class="btn">Logout</a>
            </nav>
        </div>
    </div>

    <!-- Admin wrapper -->
    <div class="admin-wrapper">
        <!-- Left side -->
        <div class="left-sidebar">
            <ul>
                <li><a href="admin.managebooks.jsp">Manage Books</a></li>
                <li><a href="#">Manage Users</a></li>
                <li><a href="admin.managecategories.jsp">Manage Categories</a></li>
            </ul>
        </div>
        <!-- Admin Content -->
        <div class="admin-content">
            <div class="button-group">
     
                <a href="admin.managebooks.jsp" class="btn">Manage Books</a>
            </div>
<%
        String bookid=request.getParameter("bookid");
        BookDetailsDTO book=BookDAO.getBookDetailsByBookId(bookid);
%>
            <div class="content">
                <h2 class="section-title">Edit Books</h2>
                <form id="form1" enctype="multipart/form-data" class="form" method="post">
                    <div class="form-control">
                        <label>Book Id</label>
                        <input  type="text" id="bookid" class="text-input" value="<%= bookid%>" disabled>
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Title</label>
                        <input type="text" id="title" class="text-input" value="<%= book.getTitle() %>">
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Author</label>
                        <input type="text" id="author" class="text-input" value="<%= book.getAuthor() %>">
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Description</label><br>
                        <textarea id="body" class="text-input" rows="6" ><%= book.getDescription() %></textarea>
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Image</label>
                        <input type="file" id="image" class="text-input" name="imagename" onchange="getImage()">
                        <div style="height: 250px;width: 250px;" ><img  id="viewimage" src="images/books/<%= book.getImagename() %>" style="height: 250px;width: 250px;"/></div>
                        <small>Error message</small>
                    </div>
                    <div class="form-control">
                        <label>Categories</label>
                        <select id="category" class="text-input" >
 <%
    ArrayList<String> categoryList=CategoryDAO.getCategory();
    for(String c:categoryList){
%> 
        <option value="<%= c%>"><%= c%></option>
<%
   }
%>
</select>
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Price</label>
                        <input type="text" id="price" class="text-input" value="<%= book.getPrice() %>">
                        <small>Error message</small>
                    </div>
                    <div>
                        <input id="input" type="button" value="Edit Book" onclick="editBook()"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

    
    <!-- footer
    <footer class="footer bg-dark">
        <div class="f-container grid grid-3">
            <div>
                <h1>Pick-a-Book | Admin Panel</h1>
            </div>
        </div>
    </footer> -->

    <!-- script/s -->
    <script src="https://cdn.ckeditor.com/ckeditor5/27.1.0/classic/ckeditor.js"></script>
<!--    <script src="./js/admin-script.js"></script>-->
</body>

</html>
