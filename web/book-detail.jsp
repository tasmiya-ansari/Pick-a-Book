<%-- 
    Document   : book-detail
    Created on : 31 May, 2021, 7:56:49 PM
    Author     : tasmi
--%>

<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="pickabook.dao.BookDAO"%>
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
        <link rel="stylesheet" href="./css/styles.css">
        <link rel="stylesheet" href="./css/book-detail.css">
        <link rel="shortcut icon" type="image/png" href="./images/favicon.ico">
        <title>Pick-a-Book | Product Details</title>
    </head>

    <body>
        <div class="header">
            <div class="navbar">
                <div class="logo">
                    <a href="index.html"><img src="./images/logo.png" alt=""></a>
                </div>
                <nav>
                    <ul class="menu-items">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="explore.jsp">Explore</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="login.html">Account</a></li>
                        <li><a href="#" onclick="logout()" id="logout">Log out</a></li>
                    </ul>
                </nav>
                <a href="cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
                <i class="fa fa-bars menu-icon" aria-hidden="true" id="menu-icon"></i>
            </div>
        </div>
        <%
            String bookid = request.getParameter("bid");
            BookDetailsDTO book = BookDAO.getBookDetailsByBookId(bookid);
        %>
        <div class="container single-product">
            <div class="row">
                <div class="column">
                    <img src="./images/books/<%= book.getImagename()%>" alt="">
                </div>
                <div class="column">
                    <h2><%= book.getTitle()%> -<span class="author"><%= book.getAuthor()%></span></h2>
                    <h4>&#8377; <%=  book.getPrice()%>/-</h4>
                    <!--                <input type="number" value="1">-->
                    <a href="#" class="btn" onclick="addToCart('<%=  book.getBookid()%>')" style="margin-left: 150px;"><i>Add to Cart</i></a>
                    <h3>Product Details <i class="fa fa-indent"></i></h3>
                    <br>
                    <p><%=  book.getDescription()%></p>

                </div>
            </div>
        </div>

        <!-- footer -->
        <footer class="footer bg-dark">
            <div class="f-container grid grid-3">
                <div>
                    <h1>Pick-a-Book</h1>
                    <p>Copyright &copy; 2021</p>
                </div>
                <nav>
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="explore.jsp">Explore</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="register.html">Account</a></li>
                    </ul>
                </nav>
                <div class="social">
                    <a href="#"><i class="fab fa-github fa-2x"></i></a>
                    <a href="#"><i class="fab fa-facebook fa-2x"></i></a>
                    <a href="#"><i class="fab fa-instagram fa-2x"></i></a>
                    <a href="#"><i class="fab fa-twitter fa-2x"></i></a>
                </div>
            </div>
        </footer>

        <!-- script/s -->
        <script src="./js/cart.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/logout.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>

</html>
