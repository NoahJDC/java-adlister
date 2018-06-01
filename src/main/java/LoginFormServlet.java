import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginFormServlet", urlPatterns = "/test")
public class LoginFormServlet extends HttpServlet{
    protected void getForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println("<h1>Hello, World!</h1>");
    }
}
