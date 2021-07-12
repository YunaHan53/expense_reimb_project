package ers;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import con.ConnectionUtil;

public class Test {
	
    public void testConnection() {
    	Connection con = ConnectionUtil.getConnection();
    	assertNotNull(con);
    }
    
    
}
