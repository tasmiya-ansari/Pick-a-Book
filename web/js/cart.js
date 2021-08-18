function addToCart(bookid){
     $.post("ConfirmLoginControllerServlet",function(responseText){
       var email=responseText.trim();
       if (email==="null")
       {
           swal("Login/Sign Up required to add items to cart !","","error").then((value)=>{
            window.location.href="login.html";
            });
       }
       else{
            data={bookid:bookid};
            $.post("AddToCartControllerServlet",data,function(responseText){
                let str=responseText.trim();
                if(str==="isupdated")
                    swal("Quantity of book increased in cart!","","success");
                else if(str==="not updated")
                    swal("Unable to increase quantity of book in cart!","Try Again.","error");
                else if(str==="isinserted")
                    swal("Book added to cart successfully!","","success");
                else if(str==="notinserted")
                    swal("Unable to add book to cart!","Try Again","error");
                else
                    swal("Some Error Occured!","Try Again","error");
            });
        }
    });
}
function updateQuantity(bookid,email){
    let bid=bookid;
    let quantity=$("input#"+bid).val();
    data={id:"updatequantity",bookid:bookid,email:email,quantity:quantity};
            $.post("UpdateCartControllerServlet",data,function(responseText){
                 let str=responseText.trim();
                if(str==="success")
                    window.location="cart.jsp";
            });
}

function removeBook(bookid,email)
{
    console.log("inside remove");
     data={id:"removebook",bookid:bookid,email:email}; 
    $.post("UpdateCartControllerServlet",data,function(data){
       let str=data.trim();
       if(str==="success")
            window.location="cart.jsp";
            });
}

function proceedToCheckout(quantity){
    if(quantity==='0')
    {
        swal("There is no book in cart!","Add books to cart.","error").then((value) => {
                        window.location.href = "explore.jsp";
                    });
    }
    else
        window.location="checkout.jsp";
}


