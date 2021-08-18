<%-- 
    Document   : b-create
    Created on : May 26, 2021, 1:27:55 PM
    Author     : hp
--%>

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
    <link rel="shortcut icon" type="image/png" href="./images/favicon.ico">
 
    <title>Admin | Add Books</title>
</head>

<body onload="addValue()">
    <div class="header">
        <div class="navbar">
            <div class="logo">
                <a href="index.html"><img src="./images/logo.png" alt=""></a>
            </div>
            <nav>
                <a href="#" class="btn" onclick="logout()" id="logout">Logout</a>
            </nav>
        </div>
    </div>

    <!-- Admin wrapper -->
    <div class="admin-wrapper">
        <!-- Left side -->
        <div class="left-sidebar">
            <ul>
                <ul>
                <li><a href="admin.managebooks.jsp">Manage Books</a></li>
                <li><a href="admin.manageusers.jsp">Manage Users</a></li>
                <li><a href="admin.managecategories.jsp">Manage Categories</a></li>
                <li><a href="admin.manageorders.jsp">Manage Orders</a></li>
            </ul>
            </ul>
        </div>
        <!-- Admin Content -->
        <div class="admin-content">
            <div class="button-group">
     
                <a href="admin.managebooks.jsp" class="btn">Manage Books</a>
            </div>

            <div class="content">
                <h2 class="section-title">Add Books</h2>
                <form id="form1" enctype="multipart/form-data" class="form" method="post">
                    <div class="form-control">
                        <label>Book Id</label>
                        <input  type="text" id="bookid" class="text-input" >
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Title</label>
                        <input type="text" id="title" class="text-input" >
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Author</label>
                        <input type="text" id="author" class="text-input" >
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Description</label><br>
                        <textarea id="body" class="text-input" rows="6"></textarea>
                        <small>Error message</small>
                    </div>
                    
                    <div class="form-control">
                        <label>Image</label>
                        <input type="file" id="image" class="text-input" name="imagename">
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
                        <input type="text" id="price" class="text-input" >
                        <small>Error message</small>
                    </div>
                    <div>
                        <input id="input" type="button" value="Add Book" onclick="addBook()"/>
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
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/logout.js"></script>
     <script src="js/addbooks.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- script/s -->
</body>

</html>