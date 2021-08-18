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

/**
 *
 * @author tasmi
 */
public class CartDAO {
    
     private static PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7,ps8,ps9,ps10,ps11;
    
    static
    {
        try{
        ps1=DBConnection.getConnection().prepareStatement("select 1 from cart_details where email=? and bookid=?");
        ps2=DBConnection.getConnection().prepareStatement("select * from cart_details where email=? and bookid=?");
        ps3=DBConnection.getConnection().prepareStatement("update cart_details set quantity=?,total=? where email=? and bookid=?");
        ps4=DBConnection.getConnection().prepareStatement("insert into cart_details values(?,?,?,?,?)");
        ps5=DBConnection.getConnection().prepareStatement("select sum(total) from cart_details where email=?");
        ps6=DBConnection.getConnection().prepareStatement("select distinct bookid from cart_details where email=?");
        ps7=DBConnection.getConnection().prepareStatement("select quantity from cart_details where bookid=?");
        ps8=DBConnection.getConnection().prepareStatement("select count(*) from cart_details where email=?");
        ps9=DBConnection.getConnection().prepareStatement("update cart_details set quantity=? ,total=? where email=? and bookid=?");
        ps10=DBConnection.getConnection().prepareStatement("delete from cart_details where email=? and bookid=?");
        ps11=DBConnection.getConnection().prepareStatement("delete from cart_details where email=? ");
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static boolean searchBook(String email,String bookid)throws SQLException
    {
        ps1.setString(1, email);
        ps1.setString(2, bookid);
        return ps1.executeQuery().next();
    }
    
    public static CartDetailsDTO getCartDetailsByIds(String email,String bookid)throws SQLException
    {
        ps2.setString(1, email);
        ps2.setString(2, bookid);
        CartDetailsDTO cart=null;
        ResultSet rs=ps2.executeQuery();
        if(rs.next())
        {
            cart=new CartDetailsDTO(email,bookid,rs.getInt(3),rs.getDouble(4),rs.getDouble(5));
        }
        return cart;
    }
    public static boolean updateCart(int quantity,Double total,String email,String bookid)throws SQLException
    {
        ps3.setInt(1, quantity);
        ps3.setDouble(2, total);
        ps3.setString(3, email);
        ps3.setString(4, bookid);
        return ps3.executeUpdate()==1;
    }
    
    public static boolean addToCart(CartDetailsDTO cart)throws SQLException
    {
        ps4.setString(1, cart.getEmail());
        ps4.setString(2, cart.getBookid());
        ps4.setInt(3, cart.getQuantity());
        ps4.setDouble(4,cart.getPrice());
        ps4.setDouble(5,cart.getTotal());
        return ps4.executeUpdate()==1;
    }
    
    public static double getCartTotal(String email)throws SQLException
    {
        ps5.setString(1, email);
        double total=0;
        ResultSet rs=ps5.executeQuery();
        if(rs.next())
        {
            total=rs.getDouble(1);
        }
        return total;
    }
    
    public static ArrayList<String> getBookIdsFromCart(String email)throws SQLException
    {
        ps6.setString(1, email);
        ArrayList<String> bookidList=new ArrayList<>();
        ResultSet rs=ps6.executeQuery();
        while (rs.next())
        {
            bookidList.add(rs.getString(1));
        }
        return bookidList;
    }
     public static int getQuantityByBookId(String bookid)throws SQLException
    {
        ps7.setString(1, bookid);
        int quantity=0;
        ResultSet rs=ps7.executeQuery();
        if(rs.next())
        {
            quantity=rs.getInt(1);
        }
        return quantity;
    }
     
     public static int getNumberOfBooks(String email)throws SQLException
    {
        ps8.setString(1, email);
        int number=0;
        ResultSet rs=ps8.executeQuery();
        if(rs.next())
        {
            number=rs.getInt(1);
        }
        return number;
    }
     
     public static boolean updateQuantity(int quantity,double price,String email,String bookid)throws SQLException
    {
        ps9.setInt(1, quantity);
        ps9.setDouble(2,quantity*price);
        ps9.setString(3, email);
        ps9.setString(4, bookid);
        return ps9.executeUpdate()==1;
    }
     public static boolean removeBook(String email,String bookid)throws SQLException
    {
        ps10.setString(1, email);
        ps10.setString(2, bookid);
        return ps10.executeUpdate()==1;
    }
     
    public static boolean deleteFromCart(String email)throws SQLException
    {
        ps11.setString(1, email);
        return ps11.executeUpdate()==1;
    }
}
