/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pickabook.dao.LoginDAO;
import pickabook.dto.UserDTO;

/**
 *
 * @author tasmi
 */
public class LoginControllerServlet extends HttpServlet {

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
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        UserDTO user=new UserDTO(email,password);
        try{
            String result=LoginDAO.validateUser(user);
            request.setAttribute("result",result);
            request.setAttribute("email",email);//qk loginresponse is userid ko session me set krega...agr ye bnda login krgya to session start thus isi ke bad admincontrolller votercontrolller verify kr paenge ki login krke aa rha h ya direct aa rha h...sesssion tracking se check krenge
            rd=request.getRequestDispatcher("loginresponse.jsp");
        }
        catch(Exception ex)
        {
            System.out.println("Exception in LoginControllerServlet");
            rd=request.getRequestDispatcher("showexception.jsp");
            request.setAttribute("exception", ex);
        }
        finally
        {
            rd.forward(request,response);
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
