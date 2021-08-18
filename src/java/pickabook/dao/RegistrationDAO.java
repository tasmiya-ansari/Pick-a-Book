/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import pickabook.dbutil.DBConnection;
import pickabook.dto.UserDetailsDTO;

/**
 *
 * @author tasmi
 */
public class RegistrationDAO {
    
    private static PreparedStatement ps1,ps2;
    
    static
    {
        try{
        ps1=DBConnection.getConnection().prepareStatement("select * from user_details where email=?");
        ps2=DBConnection.getConnection().prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?)");
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static boolean searchUser(String email)throws SQLException
    {
        ps1.setString(1, email);
        return ps1.executeQuery().next();//ResultSet rs=ps.executeQuery();return rs.next();
    }
    
    public static boolean registerUser(UserDetailsDTO ud)throws SQLException
    {
        ps2.setString(1,ud.getEmail());
        ps2.setString(2,ud.getPassword());
        ps2.setString(3,ud.getUsername());
        ps2.setLong(4, ud.getMobile_no());
        ps2.setString(5,ud.getAddress());
        ps2.setString(6,ud.getCity());
        ps2.setString(7,ud.getState()); ps2.setString(8,"customer");
        return ps2.executeUpdate()==1;
    }
    
}
