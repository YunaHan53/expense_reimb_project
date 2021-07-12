package ers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.sql.Connection;

import con.ConnectionUtil;
import services.UserServicesImp;

public class Tests {
	private UserServicesImp usi;
	
	@Test
    public void testConnection() {
    	Connection con = ConnectionUtil.getConnection();
    	assertNotNull(con);
    }
    
	@Test
    void login() {
    	assertEquals("MrSponge", usi.login("MrSponge", "krusty", "manager").getFirstName());
    }
    
	@Test
	void register() {
		assertEquals(false,usi.register(-1, null, null, null, null, null, null, null));
	}
    
}
