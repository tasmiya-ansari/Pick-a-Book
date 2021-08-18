/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pickabook.dao.CartDAO;
import pickabook.dao.OrderDAO;
import pickabook.dto.CartDetailsDTO;

/**
 *
 * @author tasmi
 */
public class OrderControllerServlet extends HttpServlet {

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
        RequestDispatcher rd=null;
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        try {
            if (id.equals("addorder")) {
                ArrayList<CartDetailsDTO> cartbooks=OrderDAO.getItemsFromCart(email);
                boolean added=OrderDAO.placeOrder(cartbooks);
                out.println(added);
            }
            else if(id.equals("deletefromcart")){
                boolean deleted=CartDAO.deleteFromCart(email);
                out.println(deleted);
            }
            else if(id.equals("deleteorder")){
                boolean result=OrderDAO.deleteOrder(request.getParameter("orderid"));
                if(result)
                    out.println("successfully!");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in OrderControllerServlet");
            ex.printStackTrace();
            rd=request.getRequestDispatcher("showexception.jsp");
            request.setAttribute("exception", ex);
        }
        finally{
            if(rd!=null)
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
