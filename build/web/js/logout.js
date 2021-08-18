function logout(){
    $.post("ConfirmLoginControllerServlet",function(responseText){
       var email=responseText.trim();
       if (email==="null")
        {
            //redirecting to the same page if not logged in
            var path = (window.location.pathname + location.search).substr(1);//foe getting the complete path along with query string
            var page = path.split("/").pop();
            console.log(page);
            window.location.href=page; 
        }
        else
        {
            $.post("LogOutControllerServlet");
            window.location.href="login.html";
        }
            
    });
}


