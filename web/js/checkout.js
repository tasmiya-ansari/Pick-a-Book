// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
//    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
})

function getDetails(email) {
    data = {email: email};
    $.post("GetUserDetailsControllerServlet", data, function (responseText) {
        let details = JSON.parse(responseText);
        $("#email").val(details.email);
        $("#email").prop("disabled", true);
        $("#username").val(details.username);
        $("#username").prop("disabled", true);
        $("#mobile").val(details.mobile);
        $("#address").val(details.address);
        $("#city").val(details.city);
        var st = details.state;
        var state = document.getElementById(st);
        state.setAttribute("selected", true);
        var country = document.getElementById("India");
        country.setAttribute("selected", true);
    });
}


function placeOrder(email)
{
    var value = ($('input[name="paymentMethod"]:checked', '#form1').val());
    if (value === "credit" || value === "debit" || value === "paypal")
        swal("The chosen payment method is not available!", "Kindly choose other method.", "error");
    else
    {
        data = {id:"addorder", email:email};
        $.post("OrderControllerServlet", data, function(responseText){
        var result = responseText.trim();
            if (result ==='true')
            {
                obj = {id:"deletefromcart", email:email};
                $.post("OrderControllerServlet",obj, function(responseText){
                var ans = responseText.trim();
                if (ans === 'true')
                {
                    swal("Order placed successfully!", "Keep buying.", "success").then((value) => {
                        window.location.href = "index.html";
                    });
                }
            
            });
        }

        });
    }
}