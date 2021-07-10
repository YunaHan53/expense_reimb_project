package con;

//import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
//		Properties props = new Properties();
//		FileInputStream fis = null;
		Connection con = null;
		try {
//			fis = new FileInputStream("db.properties");
//			props.load(fis);
//
//			// load the Driver Class
//			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// create the connection now
//			con = DriverManager.getConnection(props.getProperty("DB_URL"),
//					props.getProperty("DB_USERNAME"),
//					props.getProperty("DB_PASSWORD"));
			
			con = DriverManager.getConnection(
			"jdbc:oracle:thin:@mydb.cmxlom4fkhtu.us-east-2.rds.amazonaws.com:1521:ORCL",
			"admin", "rootroot");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
