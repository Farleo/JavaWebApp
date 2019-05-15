package ua.ifit.lms.controller;

import ua.ifit.lms.dao.entity.User;
import ua.ifit.lms.dao.repository.UserRepository;
import ua.ifit.lms.view.LoginView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        UserRepository userRepository = new UserRepository();
        LoginView loginView = new LoginView();
        // get user credentials
        switch (request.getPathInfo()) {
            case "/login":
            case "/login/":
                User currentUser = (User) session.getAttribute("user");
                if (currentUser != null) {
                    response.sendRedirect("/lobby/index");
                    return;
                }

                if (request.getParameter("email") != null &&
                        request.getParameter("password") != null) {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");

                    // test repository
                    User user = userRepository.getUserByEmailByPassword(email, password);
                    // check if a user successfully logged in
                    if (user != null) {
                        session.setAttribute("user", user);
                        response.sendRedirect("/lobby/index");
                    } else {
                        out.println(loginView.getLoginPage(null));
                    }
                } else {
                    out.println(loginView.getLoginPage(null));
                }
                break;
            case "/logout":
            case "/logout/":
                session.setAttribute("user", null);
                response.sendRedirect("/main");
                break;
            case "/register":
            case "/register/":
                out.println(loginView.getRegisterPage(null));
                if (request.getParameter("email") != null &&
                        request.getParameter("password") != null &&
                        request.getParameter("name") != null) {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String name = request.getParameter("name");

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    User user = new User(0, email, password, name, dtf.format(now), dtf.format(now));
                    userRepository.saveUser(user);
                }
                break;
            default:
                out.println("<html><head><title>MyServlet</title></head><body>");
                out.write("<H1>Hello Servlet World! User!</H1>");
                out.write("URI   \t" + request.getPathInfo());
                out.println("</body>");
                out.println("</html>");
        }
    }
}
