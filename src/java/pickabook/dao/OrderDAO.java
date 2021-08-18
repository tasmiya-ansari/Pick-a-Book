/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pickabook.dbutil.DBConnection;
import pickabook.dto.CartDetailsDTO;
import pickabook.dto.OrderDetailsDTO;

/**
 *
 * @author tasmi
 */
public class OrderDAO {

    private static PreparedStatement ps1, ps2,ps3,ps4,ps5;

    static {
        try {
            ps1 = DBConnection.getConnection().prepareStatement(" select max(orderid) from order_details");
            ps2 = DBConnection.getConnection().prepareStatement(" select * from cart_details where bookid in (select bookid from cart_details where email=?)");
            ps3 = DBConnection.getConnection().prepareStatement("insert into order_details values(?,?,?,?,?,?,?)");
            ps4 = DBConnection.getConnection().prepareStatement("select o.orderid,o.email,u.username,o.bookid,o.quantity,u.mobile_no,u.address,u.city,u.state,o.total from order_details o ,user_details u where o.email=u.email");
            ps5 = DBConnection.getConnection().prepareStatement("delete from order_details where orderid=?");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
     public static String getNewOrderId()throws SQLException
    {
        ResultSet rs=ps1.executeQuery();
        rs.next();
        String oid=rs.getString(1);
        if(oid==null)
            return "O-101";
        else
        {
            int id=Integer.parseInt(oid.substring(2));
            return "O-"+(id+1);
        }
    }

    public static ArrayList<CartDetailsDTO> getItemsFromCart(String email) throws SQLException {
        ps2.setString(1, email);
        ArrayList<CartDetailsDTO> cartbooks = new ArrayList<>();
        ResultSet rs = ps2.executeQuery();
        while (rs.next()) {
            CartDetailsDTO book = new CartDetailsDTO(email, rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5));
            cartbooks.add(book);
        }
        return cartbooks;
    }
    
    public static boolean placeOrder(ArrayList<CartDetailsDTO> cartbooks)throws SQLException 
    {
        boolean result=true;
        for(CartDetailsDTO book:cartbooks)
        {
            ps3.setString(1,getNewOrderId() );
            ps3.setString(2, book.getEmail());
            ps3.setString(3, book.getBookid());
            ps3.setInt(4, book.getQuantity());
            ps3.setDouble(5, book.getPrice());
            ps3.setDouble(6, book.getTotal());
            ps3.setString(7,"COD");
            if (ps3.executeUpdate()!=1)
                result=false;
       }
        return result;
    }
    public static ArrayList<OrderDetailsDTO> getAllOrdersDetails() throws SQLException {
        ArrayList<OrderDetailsDTO> orderList = new ArrayList<>();
        ResultSet rs = ps4.executeQuery();
        while (rs.next()) {
            OrderDetailsDTO order = new OrderDetailsDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9), rs.getDouble(10), "Cash on delivery");
            orderList.add(order);
        }
        return orderList;
    }
    
    public static boolean deleteOrder(String orderid)throws SQLException
    {
        ps5.setString(1, orderid);
        return ps5.executeUpdate()==1;
    }
}
