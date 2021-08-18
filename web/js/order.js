function deleteOrder(orderid)
{
    data={id:"deleteorder",orderid:orderid};
    $.post("OrderControllerServlet",data,function(responseText){
       let str=responseText.trim();
       if(str==="successfully!")
            swal("Order deleted "+str,"","success").then((value)=>{
            window.location.href="admin.manageorders.jsp";
            });
        else
            swal(str+" to delete order!","Try Again.","error").then((value)=>{
            window.location.href="admin.manageorders.jsp";
            });
    });
}

