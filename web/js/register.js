let form,username,email,password,password2,mobile_no,address,city,state;


function addUser()
{ 
    form = document.getElementById('form');
    username = document.getElementById('username');
    email = document.getElementById('email');
    password = document.getElementById('password');
    password2 = document.getElementById('password2');
    mobile_no = document.getElementById('mobileno');
    address = document.getElementById('address');
    city = document.getElementById('city');
    state = document.getElementById('state');


     if(validateDetails()===true)
    {
        let data={username:username.value ,email:email.value, password:password.value ,mobileno:mobile_no.value , address:address.value , city:city.value ,state:state.value };
        let xhr=$.post("RegistrationControllerServlet",data,processResponse);
        xhr.fail(handleError);
    }
}
function processResponse(responseText,textStatus,xhr){
    let str=responseText.trim();
    if(str==="success")
    {
        swal("Registration successful!","You can now login.","success");//agr setTimeOut nhi use krenge to swal ka alg thread chlta h or window.location ka alg...user error msg padh bhi nhi paya or redirect hogya...thus we wait for 3 sec
        setTimeout(redirectUser,3000);
    }    
    else if(str==="uap")
        swal("Email id already present!","Try different email id.","error");
    else
        swal("Registration failed!","Try Again","error");
}
function handleError(xhr){
    swal("Error!","Problem in server communication:"+xhr.statusText,"error");
}

function validateDetails()
{
    if(checkRequired([username, email, password, password2,mobile_no,address,city,state]) && checkLength(username, 3, 30) && checkLength(password, 8, 25) && checkEmail(email) && checkPwMatch(password, password2) && checkMobile(mobile_no) && checkLength(address,5,30) && checkLength(city,4,20) && checkLength(state,2,20))
    {
        return true;
    }
    else 
        return false;
}

// show error message
function showError(input, message) {
    const formControl = input.parentElement;
    formControl.className = 'form-control error';
    const small = formControl.querySelector('small');
    small.innerText = message;
}

// Show success
function showSuccess(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

// Check if email is valid
function checkEmail(input) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (re.test(input.value.trim())) {
        showSuccess(input);
        return true;
    }
    else {
        showError(input, 'Email is not valid');
        return false;
    }
}

// Check required fields
function checkRequired(inputArr) {
    let emptyfound=false;
    inputArr.forEach(function (input) {
        if (input.value.trim()==='') 
        {
            emptyfound=true;
            showError(input,`${getFieldName(input)} is required`);
        }
        else 
        {
            showSuccess(input);   
        }
    });
    if(emptyfound===false)
        return true;
    else
        return false;
}

// check input length
function checkLength(input, min, max) {
    if (input.value.length < min) {
        showError(input, `${getFieldName(input)} must be atleast ${min} characters`);
        return false;
    }
    else if (input.value.length > max) {
        showError(input, `${getFieldName(input)} must be less thax ${max} characters`);
        return false;
    }
    else {
        showSuccess(input);
        return true;
    }
}

//  check password match
function checkPwMatch(input1, input2) {
    if (input1.value===input2.value) {
        showSuccess(input1);
        showSuccess(input2);
        return true;
    }
    else{
        showError(input2, 'Passwords do not match.');
        return false;
    }
        
}

// Get field name
function getFieldName(input) {
    return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}

// validate mobileno
function checkMobile(input)
{
  var phoneno = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
  if (phoneno.test(input.value.trim())) {
        showSuccess(input);
        return true;
    }
    else {
        showError(input, 'Mobile Number is not valid');
        return false;
    }         
}
function redirectUser()
{
    window.location.href="login.html";//redirection through js
}