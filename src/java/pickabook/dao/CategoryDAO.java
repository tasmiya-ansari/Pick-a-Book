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
import pickabook.dto.CategoryDetailsDTO;

public class CategoryDAO {
    
    
     private static PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7,ps8;
    static
    {
        try{
        ps1=DBConnection.getConnection().prepareStatement("select max(categoryid) from category_details");
        ps2=DBConnection.getConnection().prepareStatement("Insert into category_details values(?,?)");
        ps3=DBConnection.getConnection().prepareStatement("Select distinct categoryname from category_details");
        ps4=DBConnection.getConnection().prepareStatement("select * from category_details where categoryname=?");
        ps5=DBConnection.getConnection().prepareStatement("select * from category_details order by categoryid");
        ps6=DBConnection.getConnection().prepareStatement("update category_details set categoryname=? where categoryid=?");
        ps7=DBConnection.getConnection().prepareStatement("delete from category_details where categoryid=?");
        ps8=DBConnection.getConnection().prepareStatement("select categoryname from category_details where categoryid=?");
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static String getNewCategoryId()throws SQLException
    {
        ResultSet rs=ps1.executeQuery();
        rs.next();
        String cid=rs.getString(1);
        if(cid==null)
            return "C-101";
        else
        {
            int id=Integer.parseInt(cid.substring(2));
            return "C-"+(id+1);
        }
    }
    
    public static boolean addCategory(CategoryDetailsDTO obj) throws SQLException
    {
        ps2.setString(1,obj.getCategoryid());
        ps2.setString(2,obj.getCategoryname());
        return ps2.executeUpdate()==1;
    }
    
    public static ArrayList<String> getCategory()throws SQLException
    {
        ArrayList<String> categoryList=new ArrayList<>();
        ResultSet rs=ps3.executeQuery();
        while(rs.next())
        {
            categoryList.add(rs.getString(1));
        }
        return categoryList;
    }
    public static boolean searchCategory(String categoryname)throws SQLException
    {
        ps4.setString(1, categoryname);
        return ps4.executeQuery().next();//ResultSet rs=ps.executeQuery();return rs.next();
    }
    
    public static ArrayList<CategoryDetailsDTO> getCategoryDetails()throws SQLException
    {
        ArrayList<CategoryDetailsDTO> categoryList=new ArrayList<>();
        ResultSet rs=ps5.executeQuery();
        while(rs.next())
        {
            CategoryDetailsDTO cd=new CategoryDetailsDTO();
            cd.setCategoryid(rs.getString(1));
            cd.setCategoryname(rs.getString(2));
            categoryList.add(cd);
        }
        return categoryList;
    }
    
     public static boolean updateCategory(CategoryDetailsDTO obj) throws SQLException
    {
        ps6.setString(2,obj.getCategoryid());
        ps6.setString(1,obj.getCategoryname());
        return ps6.executeUpdate()==1;
    }
     public static boolean deleteCategory(String categoryid) throws SQLException
    {
        ps7.setString(1,categoryid);
        return ps7.executeUpdate()==1;
    }
     public static String getCategoryNameByCategoryId(String categoryid) throws SQLException
    {
        ps8.setString(1,categoryid);
        ResultSet rs=ps8.executeQuery();
        if(rs.next())
            return rs.getString(1);
        else
            return null;
    }
}
