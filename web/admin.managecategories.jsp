<%-- 
    Document   : c-create
    Created on : 26 May, 2021, 4:06:15 PM
    Author     : tasmi
--%>
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
    
    <title>Admin | Manage Categories</title>
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
                <input type="button" class="btn" onclick="showAddCategoryForm()" value="Add Category">
<!--                <a href="admin.managecategories.jsp" class="btn">Manage Categories</a>-->
            </div>
            
            <form id="form">
                
            </form>
                    

            <div class="content">
                <h2 class="section-title">Manage Categories</h2>
                <table>
                    <thead>
                        <th>Category Id</th>
                        <th>Category Name</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </thead>
                    <tbody>
<%
    ArrayList<CategoryDetailsDTO> categoryList=CategoryDAO.getCategoryDetails();
    for(CategoryDetailsDTO c:categoryList){
%>
<tr><td><%= c.getCategoryid()%></td><td><%= c.getCategoryname()%></td>
        <td><a href="#" class="edit" onclick="showCategoryDeatils('<%= c.getCategoryid()%>')">Edit</a></td>
        <td><a href="#" class="delete" onclick="deleteCategory('<%= c.getCategoryid()%>')">Delete</a></td></tr>
<%                
    }
%>
    
                    </tbody>
                </table>
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
    <script src="js/jquery.js"></script>
    <script src="js/addcategory.js"></script>
    <script src="js/logout.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- script/s -->
    
</body>

</html>