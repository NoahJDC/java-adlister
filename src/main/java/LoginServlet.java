import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private String message;
    private int counter = 0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("password")) {
                response.sendRedirect("/profile");
            }
            else {
                message = "Username or password is incorrect. Please try again";
                request.setAttribute("message", message);
                counter++;
                request.setAttribute("counter", counter);
                if(counter>=2){
                    message = "Too many attempts. Try again.";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        }
    }
}

//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//            if (username.equals("admin") && password.equals("password")) {
//                    response.sendRedirect("/profile");
//                    } else {
//             request,getRequestDispatcher("/login.jsp").forward(request, response)
//    }