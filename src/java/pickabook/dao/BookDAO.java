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
import pickabook.dto.BookDetailsDTO;

/**
 *
 * @author tasmi
 */
public class BookDAO {
     private static PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7,ps8;
    static
    {
        try{
        ps1=DBConnection.getConnection().prepareStatement("select max(bookid) from book_details");
        ps2=DBConnection.getConnection().prepareStatement("Insert into book_details values(?,?,?,?,?,?,?)");
        ps3=DBConnection.getConnection().prepareStatement("Select * from book_details order by bookid");
        ps4=DBConnection.getConnection().prepareStatement("select * from book_details where bookid=?");
        ps5=DBConnection.getConnection().prepareStatement("select * from book_details where category=?");
        ps6=DBConnection.getConnection().prepareStatement("update book_details set title=?,author=?,description=?,price=?,category=?,imagename=? where bookid=?");
        ps7=DBConnection.getConnection().prepareStatement("delete from book_details where bookid=?");
        ps8=DBConnection.getConnection().prepareStatement("select price from book_details where bookid=?");
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static String getNewBookId()throws SQLException
    {
        ResultSet rs=ps1.executeQuery();
        rs.next();
        String bid=rs.getString(1);
        if(bid==null)
            return "B-101";
        else
        {
            int id=Integer.parseInt(bid.substring(2));
            return "B-"+(id+1);
        }
    }
    
    public static boolean addBook(BookDetailsDTO obj) throws SQLException
    {
        ps2.setString(1,obj.getBookid());
        ps2.setString(2,obj.getTitle());
        ps2.setString(3,obj.getAuthor());
        ps2.setString(4,obj.getDescription());
        ps2.setDouble(5,obj.getPrice());
        ps2.setString(6,obj.getCategory());
        ps2.setString(7,obj.getImagename());
        return ps2.executeUpdate()==1;
    }
      
    public static ArrayList<BookDetailsDTO> getAllBookDetails() throws SQLException
    {
        ArrayList<BookDetailsDTO> bookList=new ArrayList<>();
        ResultSet rs=ps3.executeQuery();
        while(rs.next())
        {
            BookDetailsDTO book=new BookDetailsDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
            bookList.add(book);
        }
        return bookList;
    }

    public static BookDetailsDTO getBookDetailsByBookId(String bookid) throws SQLException
    {
        ps4.setString(1, bookid);
        BookDetailsDTO book=null;
        ResultSet rs=ps4.executeQuery();
        while(rs.next())
        {
            book=new BookDetailsDTO(bookid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
        }
        return book;
    }
    
     public static ArrayList<BookDetailsDTO> getAllBookDetailsByCategory(String category) throws SQLException
    {
        ps5.setString(1, category);
        ArrayList<BookDetailsDTO> bookList=new ArrayList<>();
        ResultSet rs=ps5.executeQuery();
        while(rs.next())
        {
            BookDetailsDTO book=new BookDetailsDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),category,rs.getString(7));
            bookList.add(book);
        }
        return bookList;
    }
     
     public static boolean updateBook(BookDetailsDTO obj) throws SQLException
    {
        ps6.setString(7,obj.getBookid());
        ps6.setString(1,obj.getTitle());
        ps6.setString(2,obj.getAuthor());
        ps6.setString(3,obj.getDescription());
        ps6.setDouble(4,obj.getPrice());
        ps6.setString(5,obj.getCategory());
        ps6.setString(6,obj.getImagename());
        return ps6.executeUpdate()==1;
    }
     public static boolean deleteBook(String bookid) throws SQLException
    {
        ps7.setString(1,bookid);
        return ps7.executeUpdate()==1;
    }
     
     public static double getBookPriceByBookId(String bookid) throws SQLException
    {
        ps8.setString(1,bookid);
        double price=0;
        ResultSet rs=ps8.executeQuery();
        while(rs.next())
            price=rs.getDouble(1);
        return price;
    }
}
