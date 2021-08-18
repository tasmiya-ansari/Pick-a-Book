<%
    Boolean isupdated=(Boolean)request.getAttribute("isupdated");
    Boolean isinserted=(Boolean)request.getAttribute("isinserted");
    if(isupdated!=null && isinserted==null){
        if(isupdated)
        {
            out.println("isupdated");
        }
        else
        {
            out.println("notupdated");
        }
    }
    else if(isupdated==null && isinserted!=null){
        if(isinserted)
        {
            out.println("isinserted");
        }
        else
        {
            out.println("notinserted");
        }
    }
        
%>