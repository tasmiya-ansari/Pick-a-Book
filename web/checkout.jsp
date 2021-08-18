<%-- 
    Document   : checkout
    Created on : 7 Jun, 2021, 7:35:41 PM
    Author     : tasmi
--%>

<%@page import="pickabook.dto.UserDetailsDTO"%>
<%@page import="pickabook.dao.UserDAO"%>
<%@page import="pickabook.dto.BookDetailsDTO"%>
<%@page import="pickabook.dao.BookDAO"%>
<%@page import="pickabook.dao.CartDAO"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/checkout.css">
        <!--    <link rel="stylesheet" href="./css/styles.css">-->
        <link rel="shortcut icon" type="image/png" href="./images/favicon.ico">
        <title>Pick-a-Book | Checkout</title>
    </head>

    <body>
        <div class="header">
            <div class="navbar">
                <div class="logo">
                    <a href="index.html"><img src="./images/logo.png" alt=""></a>
                </div>
                <nav>
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="explore.jsp">Explore</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="login.html">Account</a></li>
                        <li><a href="#" onclick="logout()">Log out</a></li>
                    </ul>
                </nav>
                <a href="cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
            </div>

            <!-- Checkout page html -->




            <style>
                .bd-placeholder-img {
                    font-size: 1.125rem;
                    text-anchor: middle;
                    -webkit-user-select: none;
                    -moz-user-select: none;
                    user-select: none;
                }

                @media (min-width: 768px) {
                    .bd-placeholder-img-lg {
                        font-size: 3.5rem;
                    }
                }
            </style>


            <!-- Custom styles for this template -->
        </head>
        <%
            String email = (String) session.getAttribute("email");
            if (email == null) {
                response.sendRedirect("login.html");
                return;
            }
        %>
        <body class="bg-light" onload="getDetails('<%= email%>')">

            <div class="container">
                <main>
                    <div class="py-5 text-center">
                        <h2>Checkout</h2>
                    </div>

                    <div class="row g-5">
                        <div class="col-md-5 col-lg-4 order-md-last">
                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                                <span class="text-primary">Your cart</span>
                                <span class="badge bg-primary rounded-pill"><%= CartDAO.getNumberOfBooks(email)%></span>
                            </h4>

                            <%
                                ArrayList<String> bookidList = CartDAO.getBookIdsFromCart(email);
                                for (String bookid : bookidList) {
                                    BookDetailsDTO book = BookDAO.getBookDetailsByBookId(bookid);
                                    int quantity = CartDAO.getQuantityByBookId(bookid);
                            %>

                            <ul class="list-group mb-3">
                                <li class="list-group-item d-flex justify-content-between lh-sm py-3">
                                    <div>
                                        <h6 class="my-0"><%= book.getTitle()%> ( <%= quantity%> )</h6>
                                    </div>
                                    <span class="text-muted">₹ <%= (quantity * book.getPrice())%></span>
                                </li>

                                <%

                                    }
                                %>

                                <li class="list-group-item d-flex justify-content-between py-4">
                                    <span>Total (₹)</span>
                                    <strong>₹ <%= CartDAO.getCartTotal(email)%></strong>
                                </li>
                            </ul>

                        </div>
                        <div class="col-md-7 col-lg-8">
                            <h4 class="mb-3">Billing address</h4>
                            <form class="needs-validation" novalidate id="form1">
                                <div class="row g-3">
                                    <!--                                    <div class="col-sm-6">
                                                                            <label for="firstName" class="form-label">First name</label>
                                                                            <input type="text" class="form-control" id="firstName" placeholder="" value=""
                                                                                required>
                                                                            <div class="invalid-feedback">
                                                                                Valid first name is required.
                                                                            </div>
                                                                        </div>
                                    
                                                                        <div class="col-sm-6">
                                                                            <label for="lastName" class="form-label">Last name</label>
                                                                            <input type="text" class="form-control" id="lastName" placeholder="" value=""
                                                                                required>
                                                                            <div class="invalid-feedback">
                                                                                Valid last name is required.
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-12">
                                        <label for="username" class="form-label">Email</label>
                                        <div class="input-group has-validation">
                                            <span class="input-group-text">@</span>
                                            <input type="text" class="form-control" id="email" placeholder="you@example.com"
                                                   required  >
                                            <div class="invalid-feedback">
                                                Your email is required.
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="email" class="form-label">Username</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="username" placeholder="" required >
                                            <div class="invalid-feedback">
                                                Your username is required.
                                            </div>
                                        </div>
                                    </div>
                                            
                                    <div class="col-12">
                                        <label for="mobile" class="form-label">Mobile Number</label>
                                        <input type="text" class="form-control" id="mobile" placeholder="123456789"
                                               required>
                                        <div class="invalid-feedback">
                                            Please enter your mobile number.
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="address" class="form-label">Address</label>
                                        <input type="text" class="form-control" id="address" placeholder="1234 Main St"
                                               required>
                                        <div class="invalid-feedback">
                                            Please enter your shipping address.
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="address2" class="form-label">Address 2 <span
                                                class="text-muted">(Optional)</span></label>
                                        <input type="text" class="form-control" id="address2"
                                               placeholder="Apartment or suite">
                                    </div>

                                    <div class="col-md-5">
                                        <label for="country" class="form-label">City</label>
                                        <input type="text" class="form-control" id="city"
                                               placeholder="city">
                                        <div class="invalid-feedback">
                                            Please enter a valid city.
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="state" class="form-label">State</label>
                                        <select class="form-select" id="state" required>
                                            <option value="">Choose...</option>
                                            <option id="Andhra Pradesh">Andhra Pradesh</option>
                                            <option id="Arunachal Prades">Arunachal Pradesh</option>
                                            <option id="Assam">Assam</option>
                                            <option id="Bihar">Bihar</option>
                                            <option id="Chattisgrah">Chattisgrah</option>
                                            <option id="Chandigarh">Chandigarh</option>
                                            <option id="Dehli">Dehli</option>
                                            <option id="Goa">Goa</option>
                                            <option id="Gujarat">Gujarat</option>
                                            <option id="Haryana">Haryana</option>
                                            <option id="Himachal Pradesh">Himachal Pradesh</option>
                                            <option id="Jharkand">Jharkand</option>
                                            <option id="Karnataka">Karnataka</option>
                                            <option id="Kerala">Kerala</option>
                                            <option id="Madhya Pradesh">Madhya Pradesh</option>
                                            <option id="Maharashtra">Maharashtra</option>
                                            <option id="Manipur">Manipur</option>
                                            <option id="Meghalaya">Meghalaya</option>
                                            <option id="Mizoram">Mizoram</option>
                                            <option id="Nagaland">Nagaland</option>
                                            <option id="Odisa">Odisa</option>
                                            <option id="Punjab">Punjab</option>
                                            <option id="Rajasthan">Rajasthan</option>
                                            <option id="Skikkim">Skikkim</option>
                                            <option id="Tamil Nadu">Tamil Nadu</option>
                                            <option id="Telangana">Telangana</option>
                                            <option id="Tripura">Tripura</option>
                                            <option id="Uttar Pradesh">Uttar Pradesh</option>
                                            <option id="Uttarakhand">Uttarakhand</option>
                                            <option id="West Bengal">West Bengal</option>
                                        </select>
                                        <div class="invalid-feedback">
                                            Please provide a valid state.
                                        </div>
                                    </div>
                                            <div class="col-md-5">
                                        <label for="country" class="form-label">Country</label>
                                        <select class="form-select" id="country" required >
                                            <option value="">Choose...</option>
                                            <option id="India">India</option>
                                        </select>
                                        <div class="invalid-feedback">
                                            Please select a valid country.
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-3">
                                                                            <label for="zip" class="form-label">Zip</label>
                                                                            <input type="text" class="form-control" id="zip" placeholder="" required>
                                                                            <div class="invalid-feedback">
                                                                                Zip code required.
                                                                            </div>
                                                                        </div>-->
                                </div>

                                <hr class="my-4">

                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="same-address">
                                    <label class="form-check-label" for="same-address">Shipping address is the same as
                                        my
                                        billing address</label>
                                </div>

                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="save-info">
                                    <label class="form-check-label" for="save-info">Save this information for next
                                        time</label>
                                </div>

                                <hr class="my-4">

                                <h4 class="mb-3">Payment</h4>

                                <div class="my-3">
                                    <div class="form-check">
                                        <input id="credit" name="paymentMethod" type="radio" class="form-check-input"
                                               required value="credit">
                                        <label class="form-check-label" for="credit">Credit card</label>
                                    </div>
                                    <div class="form-check">
                                        <input id="debit" name="paymentMethod" type="radio" class="form-check-input"
                                               required value="debit">
                                        <label class="form-check-label" for="debit">Debit card</label>
                                    </div>
                                    <div class="form-check">
                                        <input id="paypal" name="paymentMethod" type="radio" class="form-check-input"
                                               required value="paypal">
                                        <label class="form-check-label" for="paypal">PayPal</label>
                                    </div>
                                    <div class="form-check">
                                        <input id="cod" name="paymentMethod" type="radio" class="form-check-input"
                                               checked required value="cod">
                                        <label class="form-check-label" for="cod">Cash on Delivery</label>
                                    </div>
                                </div>



                                <hr class="my-4">
                                
                                <input type="button" class="w-100 btn btn-primary btn-lg" value="Continue to checkout" onclick="placeOrder('<%= email%>')"> 
<!--                                <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>-->
                            </form>
                        </div>
                    </div>
                </main>
            </div>




            <!-- footer -->
            <footer class="footer bg-d">
                <div class="f-container gd gd-3">
                    <div>
                        <h1>Pick-a-Book</h1>
                        <p>Copyright &copy; 2021</p>
                    </div>
                    <nav>
                        <ul>
                            <li><a href="index.html">Home</a></li>
                            <li><a href="explore.jsp">Explore</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="login.html">Account</a></li>
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
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
            <script src="./js/checkout.js"></script>
            <script src="./js/logout.js"></script>
            <script src="js/jquery.js"></script>
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        </body>

</html>
