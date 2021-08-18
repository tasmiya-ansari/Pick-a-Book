/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pickabook.dbutil.DBConnection;
import pickabook.dto.UserDTO;

/**
 *
 * @author tasmi
 */
public class LoginDAO {
    private static PreparedStatement ps;
    static
    {
        try{
        ps=DBConnection.getConnection().prepareStatement("select usertype from user_details where email=? and password=?");
       
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static String validateUser(UserDTO user)throws SQLException
    {
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return rs.getString(1);
        else
            return null;
    }
    
}
