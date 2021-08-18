<%-- 
    Document   : c-index
    Created on : 26 May, 2021, 4:07:20 PM
    Author     : tasmi
--%>

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
    <title>Admin | Add Categories</title>
</head>

<body>
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
                <a href="admin.addcategories.jsp" class="btn">Add Categories</a>
                <a href="admin.managecategories.jsp" class="btn">Manage Categories</a>
            </div>

            <div class="content">
                <h2 class="section-title">Add Category</h2>
                <form action="Admin Panel/categories/c-create.jsp">
                    <div>
                        <label>Name</label>
                        <input type="text" name="Name" class="text-input">
                    </div>
                    <div>
                        <label>Description</label>
                        <textarea name="body" id="body"></textarea>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-big">Add Post</button>
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
    <script src="./js/admin-script.js"></script>
</body>

</html>