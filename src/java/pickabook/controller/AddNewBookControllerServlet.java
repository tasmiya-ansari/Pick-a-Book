/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import pickabook.dao.BookDAO;
import pickabook.dto.BookDetailsDTO;

/**
 *
 * @author tasmi
 */
public class AddNewBookControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd=null;
        try
        {
            //data ajax send kr rha h FormData class ke through..ye class string style me data end nhi krti..wo bgejti h as object of FileItem class..jitna data utne fileitems
            //parameters ko retrive krne me HttpServletRequest koi help nhi kr skti...ek or class h ServletFileUpload
            DiskFileItemFactory df=new DiskFileItemFactory();
            ServletFileUpload sfu=new ServletFileUpload(df);
            ServletRequestContext src=new ServletRequestContext(request);
            List<FileItem> multiList=sfu.parseRequest(src);
            
            ArrayList<String> objList=new ArrayList<>();
            InputStream ins=null;
            String imagename=null;
            
            for(FileItem fit:multiList)//fit me textual data bhi ho skta h ya fr image
                //isliye ek methos h isFormFileld which returns true if obj me textual data h or false if obj me image h
            {
                if(fit.isFormField())//textual data
                {
                    String value=fit.getString();//filled info
                    String fname=fit.getFieldName();//key..name of the input field
                    objList.add(value);
//                    System.out.println("Inside if");
//                    System.out.println(fname+":"+value);
                }
                else//image
                {
                    ins=fit.getInputStream();
                    String key=fit.getFieldName();//name of input field conataining the image
                    imagename=fit.getName();//image name
//                    System.out.println("Inside else");
//                    System.out.println(key+":"+imagename);
                }
            } 
            //data will be sent to the servlet in the same order irrespective of the number of times its being sent
            //Inside else..imagename:the-archer.jpeg..Inside if..bookid:B-102..Inside if..title:title..Inside if..author:author
            //Inside if/..description:description..Inside if..category:Mystery..Inside if..price:500

            
            //Creating book object to be inserted into DB
            BookDetailsDTO book=new BookDetailsDTO(objList.get(0),objList.get(1),objList.get(2),objList.get(3),Double.parseDouble(objList.get(5)),objList.get(4),imagename);
            
            //code for uploading the image in books folder inside image folder
            //finding path to the required directory to upload image
            String path=request.getRealPath("images")+File.separator+"books"+File.separator+imagename;
//                
//            //Uploading the image
            FileOutputStream fos=new FileOutputStream(path);
//                
//            //reading data
            byte []data=new byte[ins.available()];
            ins.read(data);
                
//            //writing data
            fos.write(data);
            fos.close();
                
//            System.out.println(path);
//            
            //Inserting book
            boolean result=BookDAO.addBook(book);
                
                if(result)
                    rd=request.getRequestDispatcher("success.jsp");
                else
                    rd=request.getRequestDispatcher("failure.jsp");

        }
        catch(Exception ex)
        {
            System.out.println("Exception in AddNewBookControllerServlet");
            ex.printStackTrace();
        }
        finally
        {
            if(rd!=null)
                rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
