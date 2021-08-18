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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author tasmi
 */
public class GetBookImageControllerServlet extends HttpServlet {

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
        PrintWriter out=response.getWriter();
        try
        {
            
            DiskFileItemFactory df=new DiskFileItemFactory();
            ServletFileUpload sfu=new ServletFileUpload(df);
            ServletRequestContext src=new ServletRequestContext(request);
            List<FileItem> multiList=sfu.parseRequest(src);
            
            InputStream ins=null;
            String imagename=null;
            
            for(FileItem fit:multiList)//fit me textual data bhi ho skta h ya fr image
                //isliye ek methos h isFormFileld which returns true if obj me textual data h or false if obj me image h
            {
                if(!fit.isFormField())//image
                {
                    
                    ins=fit.getInputStream();
                    String key=fit.getFieldName();//name of input field conataining the image
                    imagename=fit.getName();//image name
                } 
                //code for uploading the image in books folder inside image folder
                //finding path to the required directory to upload image
                String path=request.getRealPath("images")+File.separator+"books"+File.separator+imagename;
                
//              //Uploading the image
                FileOutputStream fos=new FileOutputStream(path);
               
//               //reading data
                byte []data=new byte[ins.available()];
                ins.read(data);
                
//            //writing data
                fos.write(data);
                fos.close();
            
                out.println(imagename);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in GetBookImageCandidateController");
            ex.printStackTrace();
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
