package servlets;

import java.sql.*;

import con.ConnectionUtil;

public class Validate {
    public static boolean checkUser(String userName,String pass) 
    {
        boolean st =false;
        try {
    		Connection con = ConnectionUtil.getConnection();

            PreparedStatement ps = con.prepareStatement("select userName,pass from UserRegister where userName=? and pass=?");
            ps.setString(1, userName);
            ps.setString(2, pass);
                        
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}

