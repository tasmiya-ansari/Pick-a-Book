<%-- 
    Document   : b-index.jsp
    Created on : May 26, 2021, 1:24:34 PM
    Author     : hp
--%>
<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="pickabook.dao.BookDAO"%>
<%@page import="pickabook.dao.CategoryDAO"%>
<%@page import="pickabook.dbutil.DBConnection"%>
<%@page import="pickabook.dto.CategoryDetailsDTO"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="js/jquery.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">   
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#mytable').DataTable();
        });
    </script>

    <title>Admin | Manage Books</title>
</head>

<body>
    
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
                <li><a href="admin.managebooks.jsp">Manage Books</a></li>
                <li><a href="admin.manageusers.jsp">Manage Users</a></li>
                <li><a href="admin.managecategories.jsp">Manage Categories</a></li>
                <li><a href="admin.manageorders.jsp">Manage Orders</a></li>
            </ul>
        </div>
        <!-- Admin Content -->
        <div class="admin-content">
            <div class="button-group">
                <input type="button" class="btn" onclick="getBookId()" value="Add Books">
            
            </div>

            <div class="content">
                <h2 class="section-title">Manage Books</h2>
                <table id="mytable">
                    <thead>
                        <th>Book Id</th>
                        <th>Title</th>
                        <th>Author</th>
<!--                        <th>Category </th>-->
<!--                        <th>Price</th>-->
                        <th>Edit</th>
                        <th>Delete</th>
                    </thead>
                    <tbody>
<%
        ArrayList<BookDetailsDTO> bookList=BookDAO.getAllBookDetails();
    for(BookDetailsDTO book:bookList){
%>
<tr><td><%=book.getBookid()%></td><td><%= book.getTitle() %></td>
    <td><%= book.getAuthor()%></td>
<!--    <td><%= book.getCategory() %></td>-->
<!--    <td><%= book.getPrice() %></td>-->
        <td><a href="admin.editbooks.jsp?bookid=<%=book.getBookid()%>" class="edit"> Edit</a></td>
        <td><a href="#" class="delete" onclick="deleteBook('<%=book.getBookid()%>')"> Delete</a></td></tr>
<%                
    }
%>

    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
   


<!--     footer-->
<!--    <footer class="footer bg-dark">
        <div class="f-container grid grid-3">
            <div>
                <h1>Pick-a-Book | Admin Panel</h1>
            </div>
        </div>
    </footer> -->

<script src="js/addbooks.js"></script>
<script src="js/logout.js"></script>

    
</body>

</html>
