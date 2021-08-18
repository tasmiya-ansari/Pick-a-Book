<%-- 
    Document   : admin.mangeusers
    Created on : 8 Jun, 2021, 1:50:13 AM
    Author     : tasmi
--%>

<%@page import="pickabook.dto.UserDetailsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pickabook.dao.UserDAO"%>
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
        <title>Admin | Manage Users</title>
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
                <!--            <div class="button-group">
                                <a href="c-create.html" class="btn">Add Users</a>
                                <a href="c-index.html" class="btn">Manage Users</a>
                            </div>-->
                <div class="content">
                    <h2 class="section-title">Manage Users</h2><br><br>
                    <table>
                        <thead>
                        <th>S.NO</th>
                        <th>Email</th>
                        <th>Username</th>
                        <th>Mobile No</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>State</th>
                        <!--                        <th colspan="2">Action</th>-->
                        </thead>
                        <tbody>
                            <%
                                ArrayList<UserDetailsDTO> userList = UserDAO.getAllUserDetails();
                                int count = 1;
                                for (UserDetailsDTO user : userList) {

                            %>
                            <tr>
                                <td><%= count%></td>
                                <td><%= user.getEmail()%></td>
                                <td><%= user.getUsername()%></td>
                                <td><%= user.getMobile_no()%></td>
                                <td><%= user.getAddress()%></td>
                                <td><%= user.getCity()%></td>
                                <td><%= user.getState()%></td>
                                <!--                                <td><a href="#" class="edit">Edit</a></td>
                                                                <td><a href="#" class="delete">Delete</a></td>-->
                            </tr>
                            <%
                                    count++;
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
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/logout.js"></script>
    </body>

</html>
