<%-- 
    Document   : explore
    Created on : 31 May, 2021, 4:00:44 PM
    Author     : tasmi
--%>

<%@page import="pickabook.dao.CategoryDAO"%>
<%@page import="pickabook.helper.Helper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="pickabook.dao.BookDAO"%>
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
        <link rel="stylesheet" href="./css/explore.css">
        <link rel="shortcut icon" type="image/png" href="./images/favicon.ico">
        <title>Pick-a-Book | Explore Books</title>
    </head>

    <body onload="getAllBooks()">
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
            </div>
        </div>

        <!-- Explore page main section -->
        <section class="menu">
            <!-- title -->
            <div class="title">
                <h2>Explore Books</h2>
                <div class="underline"></div>
            </div>
            <!-- filter buttons -->
            <div class="btn-container">
                <button class="filter-btn" type="button" data-id="All" onclick="getBooks(this)" id="All">All</button>
                <%
                    ArrayList<String> categoryList = CategoryDAO.getCategory();
                    for (String c : categoryList) {
                %>
                <button class="filter-btn" type="button" data-id="<%=c%>" id="<%=c%>" onclick="getBooks(this)"><%=c%></button>
                <%                 }
                %>
            </div>
            <!-- books -->
            <div class="section-center" id="showbooks">
                <!-- Single item -->

                <!-- End of Single item -->
            </div>  
        </section>

        <!--         Page navigation buttons 
                <div class="page-btn-container">
                    <a href="explore.html" class="pg-btn"><span>1</span></a>
                    <a href="explore-pg2.html" class="pg-btn"><span>2</span></a>
                    <a href="explore-pg3.html" class="pg-btn"><span>3</span></a>
                    <a href="explore-pg4.html" class="pg-btn"><span>4</span></a>
                    <a href="#" class="pg-btn" id="next-btn"><span><i class="fa fa-arrow-right"></i></span></a>
                </div>-->

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
        <script src="js/jquery.js"></script>
        <script src="js/explore.js"></script>
        <script src="js/logout.js"></script>
    </body>

</html>