let form, cid, cname;
function showAddCategoryForm() {
    let form = $("#form")[0];
    let div = document.getElementById("showaddcategoryform");
    if (div !== null)
    {
        form.removeChild(div);
    } else
    {
        var newdiv = document.createElement("div");
        newdiv.setAttribute("id", "showaddcategoryform");
        newdiv.setAttribute("style", "width:40%;margin-left:30%;");
        newdiv.innerHTML = "<h2 class='section-title'>Add Category</h2>\n\
        <label>Category Id</label><input  type='text' id='cid' name='Category Id' class='text-input' >\n\
        <br>\n\
        <label>Category Name</label><input type='text' id='cname' name='Category Name' class='text-input'>\n\
        <br>\n\
        <input id='input' type='button' value='Add Category' onclick='addCategory()' style='width:100%;'/>";

        form.appendChild(newdiv);
        //fetching categoryid from DB
        data = {id: "getcategoryid"};
        $.post("AddCategoryControllerServlet", data, function (responseText) {
            $("#cid").val(responseText.trim());
            $("#cid").prop("readonly", true);
        });
    }
}

function addCategory()
{

    if (validateDetails() === true)
    {
        data = {id: "addcategory", categoryid: cid.value, categoryname: cname.value};
        let xhr = $.post("AddCategoryControllerServlet", data, processResponse);
        xhr.fail(handleError);
    }
}
function processResponse(responseText, textStatus, xhr) {
    let result = responseText.trim();
    if (result === "success")
        swal("Category added successfully!", "", "success").then((value) => {
            window.location.href = "admin.managecategories.jsp";
        });
    else if (result === "cap")
        swal("Category already present!", "Please enter another category.", "error").then((value) => {
            window.location.href = "admin.managecategories.jsp";
        });
    else
        swal("Unable to add category!", "Try Again.", "error").then((value) => {
            window.location.href = "admin.managecategories.jsp";
        });
}
function handleError(xhr) {
    swal("Error!", "Problem in server communication:" + xhr.statusText, "error");
}

function validateDetails()
{
    form = document.getElementById('form');
    cid = document.getElementById('cid');
    cname = document.getElementById('cname');
    if (cid.value === '' || cname.value === '')
    {
        swal("Category name required!", "", "error");
        return false;
    } else
        return true;
}

//// show error message
//function showError(input, message) {
//    console.log("error");
//    const div = input.parentElement;
//    console.log(div);
//    const formControl=div.parentElement;
//    console.log(formControl);
//    formControl.className = 'form-control error';
//    const small = div.querySelector('small');
//    small.innerText = message;
//}
//
//// Show success
//function showSuccess(input) {
//    console.log("success");
//    const formControl = input.parentElement.parentElement;
//    formControl.setClassName='form-control success';
////    formControl.className = 'form-control success';
//    console.log(formControl);
//}
//
//// Check required fields
//function checkRequired(inputArr) {
//    let emptyfound=false;
//    inputArr.forEach(function (input) {
//        console.log(input.value.trim());
//        if (input.value.trim()==='') 
//        {
//            console.log(input.value);
//            
//            console.log('Inside if');
//            emptyfound=true;
//            showError(input,`${getFieldName(input)} is required`);
//        }
//        else 
//        {
//            console.log(input.value);
//            console.log('Inside else');
//            showSuccess(input);   
//        }
//    });
//    if(emptyfound===false)
//        return true;
//    else
//        return false;
//}
//
//// check input length
//function checkLength(input, min, max) {
//    if (input.value.length < min) {
//        showError(input, `${getFieldName(input)} must be atleast ${min} characters`);
//        return false;
//    }
//    else if (input.value.length > max) {
//        showError(input, `${getFieldName(input)} must be less thax ${max} characters`);
//        return false;
//    }
//    else {
//        showSuccess(input);
//        return true;
//    }
//}
//
//// Get field name
//function getFieldName(input) {
//    return input.id.charAt(0).toUpperCase() + input.id.slice(1);
//}
//
//

function showCategoryDeatils(categoryid) {
    let form = $("#form")[0];
    let div = document.getElementById("showaddcategoryform");
    if (div !== null)
    {
        form.removeChild(div);
    } else
    {
        var newdiv = document.createElement("div");
        newdiv.setAttribute("id", "showaddcategoryform");
        newdiv.setAttribute("style", "width:40%;margin-left:30%;");
        newdiv.innerHTML = "<h2 class='section-title'>Edit Category</h2>\n\
        <label>Category Id</label><input  type='text' id='cid' name='Category Id' class='text-input' >\n\
        <br>\n\
        <label>Category Name</label><input type='text' id='cname' name='Category Name' class='text-input'>\n\
        <br>\n\
        <input id='input' type='button' value='Edit Category' onclick='editCategory()' style='width:100%;'/>";
        form.appendChild(newdiv);

        $("#cid").val(categoryid);
        $("#cid").prop("disabled", true);
        data = {id: "getdetails", categoryid: categoryid};
        $.post("EditCategoryControllerServlet", data, function (data) {
            let categoryname = data.trim();
            $("#cname").val(categoryname);
        });
    }
}
function editCategory()
{
    if (validateDetails() === true) {
        let cid = $("#cid").val();
        let cname = $("#cname").val();
        data = {id: "editcategory", cid: cid, cname: cname};
        $.post("EditCategoryControllerServlet", data, function (data) {
            let str = data.trim();
            if (str === "successfully!")
                swal("Category updated " + str, "", "success").then((value) => {
                    window.location.href = "admin.managecategories.jsp";
                });
            else
                swal(str + " to update category!", "", "error").then((value) => {
                    window.location.href = "admin.managecategories.jsp";
                });
        });
    }
}
function deleteCategory(categoryid)
{
    data={categoryid:categoryid}; 
    $.post("DeleteCategoryControllerServlet",data,function(data){
       let str=data.trim();
       if(str==="successfully!")
            swal("Category deleted "+str,"","success").then((value)=>{
            window.location.href="admin.managecategories.jsp";
            });
        else
            swal(str+" to delete category!","Try Again.","error").then((value)=>{
            window.location.href="admin.managecategories.jsp";
            });
    });
}