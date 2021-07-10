package ers;

import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mockito;

import servlets.LoginServlet;

public class Test extends Mockito{

    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("username")).thenReturn("WizardHowl");
        when(request.getParameter("pass_word")).thenReturn("ilovesophie");

        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(writer);

//        LoginServlet loginServlet = new LoginServlet();
        new LoginServlet().doPost(request, response);
//        loginServlet.doGet(request,response);
        String result = sw.getBuffer().toString().trim();
        assertTrue(sw.toString().contains("My expected string"));
        //assertEquals(result, new String("User validated"));
    }
}
