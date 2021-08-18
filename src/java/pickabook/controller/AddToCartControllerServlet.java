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
import javax.servlet.http.HttpSession;
import pickabook.dao.BookDAO;
import pickabook.dao.CartDAO;
import pickabook.dto.CartDetailsDTO;

/**
 *
 * @author tasmi
 */
public class AddToCartControllerServlet extends HttpServlet {

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
        HttpSession sess=request.getSession();
        String email=(String)sess.getAttribute("email");
        String bookid=request.getParameter("bookid");
        int quantity=1;
        double book_price=0;
        double book_total=0;
        double cart_total=0;
        
        try{
            //retrieving bookprice by bookid
            book_price=BookDAO.getBookPriceByBookId(bookid);
            book_total=book_price;
            
            //checking whether book is already present in cart or not
            boolean bookexist=CartDAO.searchBook(email,bookid);
            if(bookexist)
            {
                CartDetailsDTO cart=CartDAO.getCartDetailsByIds(email, bookid);
                if(cart!=null){
                    cart_total=cart.getTotal();
                    cart_total+=book_total;
                    quantity=cart.getQuantity();
                    quantity++;
                    //updating record in cart
                    boolean isupdated=CartDAO.updateCart(quantity, cart_total, email, bookid);
                        request.setAttribute("isupdated",isupdated);
                        rd=request.getRequestDispatcher("addtocartresponse.jsp"); 
                }   
            }
            //book doesnot alreay exist in cart thus record has to be inserted
            else
            {
                 CartDetailsDTO cart=new CartDetailsDTO(email, bookid,quantity,book_price,book_total);
                 boolean isinserted=CartDAO.addToCart(cart);
                 request.setAttribute("isinserted",isinserted);
                 rd=request.getRequestDispatcher("addtocartresponse.jsp");
            }
        
        }
        catch(Exception ex)
        {
            System.out.println("Exception in AddToCartControllerServlet");
            ex.printStackTrace();
            rd=request.getRequestDispatcher("showexception.jsp");
            request.setAttribute("exception", ex);
        }
        finally
        {
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
