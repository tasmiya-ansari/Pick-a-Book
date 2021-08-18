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
import pickabook.dto.UserDetailsDTO;

/**
 *
 * @author tasmi
 */
public class UserDAO {
    private static PreparedStatement ps1,ps2;
    
    static
    {
        try{
        ps1=DBConnection.getConnection().prepareStatement("select * from user_details where email=?");
        ps2=DBConnection.getConnection().prepareStatement("select * from user_details");
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static UserDetailsDTO getUserDetailsById(String email)throws SQLException
    {
        ps1.setString(1, email);
        ResultSet rs=ps1.executeQuery();
        rs.next();
        UserDetailsDTO user=new UserDetailsDTO(email,rs.getString(2),rs.getString(3),Long.parseLong(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
        return user;
    }
    public static ArrayList<UserDetailsDTO> getAllUserDetails()throws SQLException
    {
        ResultSet rs=ps2.executeQuery();
        ArrayList<UserDetailsDTO> userList=new ArrayList<>();
        while(rs.next())
        {
            UserDetailsDTO user=new UserDetailsDTO(rs.getString(1),rs.getString(2),rs.getString(3),Long.parseLong(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
            userList.add(user);
        }
        System.out.println(userList);
        return userList;
    }
}
