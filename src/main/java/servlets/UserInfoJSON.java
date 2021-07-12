package servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import con.ConnectionUtil;

public class UserInfoJSON {

	public static void main(String[] args) throws IOException {
        viewUserInfo(11);
    }

    @SuppressWarnings("unchecked")
    public static void viewUserInfo(int userId) throws IOException {
        
    	Connection con = ConnectionUtil.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM userregister WHERE userId = ? ");
            
			ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            // Create a JSON document, to represent your table, by instantiating the JSONObject
            // class of the json-simple library.
            JSONObject jsonObject = new JSONObject();

            // Store your employee records in a JSON array
            JSONArray empArray = new JSONArray();
            while(rs.next()) {
                // Create a JSON object to store your records in
                JSONObject empObjs = new JSONObject();
                empObjs.put("UserId", rs.getString("UserId"));
                empObjs.put("FirstName", rs.getString("FirstName"));
                empObjs.put("LastName", rs.getString("LastName"));
                empObjs.put("UserName", rs.getString("UserName"));
                empObjs.put("Email", rs.getString("Email"));
                empObjs.put("JobPosition", rs.getString("JobPosition"));
                empArray.add(empObjs);
            }
            // After adding all the required records of the JSON array, add it to the parent JSON object
            jsonObject.put("Employee_Data", empArray);
            // Write the JSON object, named empObjs, to a file using FileReader
            FileWriter file = new FileWriter("userInfoJSON.json");
            file.write(jsonObject.toJSONString());
            file.close();

        } catch (SQLException e) {
            System.out.println("Skipped the try section.");
            e.printStackTrace();
        }
    }
}
