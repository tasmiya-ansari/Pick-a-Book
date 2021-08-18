<%-- 
    Document   : cart
    Created on : 2 Jun, 2021, 7:17:58 PM
    Author     : tasmi
--%>

<%@page import="pickabook.helper.Helper"%>
<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="pickabook.dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pickabook.dao.CartDAO"%>
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
        <link rel="stylesheet" href="./css/cart.css">
        <link rel="shortcut icon" type="image/png" href="./images/favicon.ico">
        <title>Pick-a-Book | Cart</title>
    </head>

    <body>
        <%
            String email = (String) session.getAttribute("email");
            if (email == null) {
                response.sendRedirect("login.html");
                return;
            }
        %>
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

        <!-- Cart -->
        <h2 class="section-title">Shopping Cart</h2>
        <div class="container">
            <div class="cart">
                <div class="products">
                    <%
                        ArrayList<String> bookidList = CartDAO.getBookIdsFromCart(email);
                        for (String bookid : bookidList) {
                            BookDetailsDTO book = BookDAO.getBookDetailsByBookId(bookid);
                            int quantity = CartDAO.getQuantityByBookId(bookid);
                    %>
                    <div class="product">
                        <img src="images/books/<%= book.getImagename()%>">
                        <div class="product-info">
                            <h3 class="product-name"><%= book.getTitle()%><span class="author">-<%= book.getAuthor()%></span></h3>
                            <h4 class="product-price">&#8377; <%= book.getPrice()%></h4>
                            <p class="product-quantity">Qnt: <input type="number" id='<%= book.getBookid()%>' value="<%= quantity%>" min="1" onchange="updateQuantity('<%= book.getBookid()%>', '<%= email%>')"><br><br>
                            <p class="product-quantity"> <%= Helper.get150words( book.getDescription()) %> </p>  
                            <a href="#" class="btn" onclick="removeBook('<%=book.getBookid()%>', '<%= email%>')"><span class="fas fa-trash"></span> Remove</a>
                        </div>
                    </div>
                    <%

                        }
                    %>
                </div>
                <div class="cart-total">
                    <p>
                        <span>Total Price</span>
                        <span><%= CartDAO.getCartTotal(email)%></span>
                    </p>
                    <p>
                        <span>Number of Items</span>
                        <span><%= CartDAO.getNumberOfBooks(email)%></span>
                    </p>
                    <p>
                        <span>You Save</span>
                        <span>5%</span>
                    </p>
                    <a href="#" onclick="proceedToCheckout('<%= CartDAO.getNumberOfBooks(email)%>')">Proceed to Checkout</a>
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
        <script src="js/cart.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/logout.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>

</html>
