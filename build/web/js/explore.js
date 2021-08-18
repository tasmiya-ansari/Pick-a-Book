function getBooks(elem)
{
    let category=elem.id;
    
   data={category:category}; 
   $.post("GetBooksControllerServlet",data,function(responseText){
       var str=responseText.trim();
       var div=document.getElementById("showbooks");
        div.innerHTML=str;
    });
}
function getAllBooks(){
    data={category:"All"}; 
   $.post("GetBooksControllerServlet",data,function(responseText){
       var str=responseText.trim();
       var div=document.getElementById("showbooks");
        div.innerHTML=str;
        });
}


