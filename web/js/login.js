let email ,password;

function connectUser()
{ 
    form = document.getElementById('form');
    email = document.getElementById('email');
    password = document.getElementById('password');
     if(validateDetails())
    {
        let data={email:email.value, password:password.value};
        let xhr=$.post("LoginControllerServlet",data,processResponse);
        xhr.fail(handleError);
    }
}
function processResponse(responseText){
    if(responseText.trim()==="error")
    {
        swal("Login Denied!","Please enter correct userid/password.","error");
        return;
    }
    //we now have 2 possibilities..either response is from show exception.jsp or from loginresponse.jsp 
    
    else if(responseText.trim().indexOf("jsessionid")!==-1)//checking if from loginresponse.jsp
    {
       let pr=swal("Login Accepted!","","success");
        pr.then((value)=>{                             
            window.location=responseText.trim();       
        }); 
    }
    else
    {
        swal("Access Denied!","Some problem occured "+responseText,"error");
    }
}
function handleError(xhr){
    swal("Error!","Problem in server communication:"+xhr.statusText,"error");
}

function validateDetails()
{
    if(checkRequired([email, password]) && checkEmail(email) && checkLength(password, 8, 25))
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

// Get field name
function getFieldName(input) {
    return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}
