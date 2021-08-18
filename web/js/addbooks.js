let form,bookid,title,author,descripion,image,category,price;
//retrieving auto generated bookid from AddBookControllerServlet

function getBookId(){
   data={id:"getbookid"}; 
   $.post("BookIdControllerServlet",data,function(responseText){
       var str=parseInt(responseText.trim().substring(2));
       //sending the bookid as querystring
       var query="admin.addbooks.jsp?bookid=B-"+str;
       window.location=query;
    });
}

function addValue(){
    //retrieving querystring
    const urlParams = new URLSearchParams(window.location.search);
    const bookid = urlParams.get('bookid');
    $("#bookid").val(bookid);
    $("#bookid").prop("disabled",true);
}

function addBook()
{ 
    form1 = $('#form1')[0];
    bookid =  $('#bookid')[0];
    title =  $('#title')[0];
    author =  $('#author')[0];
    description= $('#body')[0];
    image =  $('#image')[0];
    category = $('#category')[0];
    price = $('#price')[0];
     if(validateDetails()===true)
    {
        var data=new FormData(form1);//img val se nhi milegi
    //iske liye js ke pas class form data  h wo bolti h agr use form obj'dede to wo esa obj return kregi jo us form ki image rakhega
    //form ke andar jitna binary data h use us var me dal degi
    //is line se img copy hokr ja rhi h us variable me jiska naam h data..jitne binary dta hote sb usme chle jate
    data.append("bookid",bookid.value);
    data.append("title",title.value);
    data.append("author",author.value);
    data.append("description",description.value);
    data.append("category",category.value);
    data.append("price",price.value);
    
    $.ajax({
        type:"POST",
        enctype:'multipart/form-data',
        url:"AddNewBookControllerServlet",
        data:data,
        processData:false,//process data false mtlb processing server end pr hogi hm nhi kr rhe
        contentType:false,
        cache:false,
        timeout:600000,//using timeout becuse alot of data is geing sent so server might take some time to process it
        success:function(data){
            let str=data;
            swal("Book inserted "+str,"","success").then((value)=>{
            window.location.href="admin.managebooks.jsp";
            });
        },
        error:function(e){
            swal(e+"to add book!","Try again.","error");
        }   
    });
 }
    }

//checking input
function validateDetails()
{
    if(checkRequired([bookid,title,author,description,image,category,price]) && checkLength(title, 1, 50) && checkLength(author, 3, 20) && checkLength(description,10,500) && checkLength(price, 2, 5) &&checkLength(category, 3, 20) && checkLength(image, 3, 50))
        return true;
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


function deleteBook(bookid)
{
    data={bookid:bookid}; 
    $.post("DeleteBookControllerServlet",data,function(data){
       let str=data.trim();
       if(str==="successfully!")
            swal("Book deleted "+str,"","success").then((value)=>{
            window.location.href="admin.managebooks.jsp";
            });
        else
            swal(str+" to delete book!","Try Again.","error").then((value)=>{
            window.location.href="admin.managebooks.jsp";
            });
    });
}

