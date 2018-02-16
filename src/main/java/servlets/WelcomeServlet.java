package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", value = "/jokes", initParams = {@WebInitParam(name="APPLICATION_NAME", value = "")})
public class WelcomeServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Inicjujemy servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //chcemy by out sie wywolywal tylko wtedy gdy param value=true czyli zwroci stringa z web.xml
        //pobieramy parametr z konfiguracji
        String logRequestParam = getInitParameter("LOG-REQUEST");
        if ("true".equalsIgnoreCase(logRequestParam)) {
            System.out.println("Wpadlo zadanie na ten adres.");
        }

        PrintWriter out = resp.getWriter();
        out.println("hello");
        resp.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Niszczymy servlet");
    }


}
