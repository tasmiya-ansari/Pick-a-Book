/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pickabook.dao.CategoryDAO;
import pickabook.dao.RegistrationDAO;
import pickabook.dto.CategoryDetailsDTO;

/**
 *
 * @author tasmi
 */
public class AddCategoryControllerServlet extends HttpServlet {

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
        String id=(String)request.getParameter("id");
            
        if(id !=null && id.equals("getcategoryid"))//mtlb phli baar req aayi h i.e. id ke liye
        {
            try
            {
                String categoryid=CategoryDAO.getNewCategoryId();
                out.println(categoryid);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                RequestDispatcher rd=request.getRequestDispatcher("showexception.jsp");
                request.setAttribute("exception", ex);
                rd.forward(request,response);
            }
        }
        else if(id!=null && id.equals("addcategory"))
        {
            boolean result=false,categoryfound=false;
            try
            {
                if(!CategoryDAO.searchCategory(request.getParameter("categoryname")))//user not found thus register
                {
                    CategoryDetailsDTO c=new CategoryDetailsDTO();
                    c.setCategoryid(request.getParameter("categoryid"));
                    c.setCategoryname(request.getParameter("categoryname"));
                    result=CategoryDAO.addCategory(c);
                }
                else{
                     categoryfound=true;
                }
               if(categoryfound==true)
                out.println("cap");
                else if(result==true)
                out.println("success");
                else
                out.println("error");
            }
            catch(Exception ex)
            {
                System.out.println("Exception in AddCategoryControllerServlet");
                ex.printStackTrace();
                RequestDispatcher rd=request.getRequestDispatcher("showexception.jsp");
                request.setAttribute("exception", ex);
                rd.forward(request,response);
            }
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
