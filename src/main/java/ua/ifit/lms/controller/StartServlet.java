package ua.ifit.lms.controller;

import ua.ifit.lms.dao.entity.User;
import ua.ifit.lms.dao.repository.UserRepository;
import ua.ifit.lms.view.IndexSingletonView;
import ua.ifit.lms.view.MainView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StartServlet", urlPatterns = {"/", "/main"}, loadOnStartup = 1)
public class StartServlet extends HttpServlet {
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if ( request.getParameter("email") != null ) {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByEmailByPassword(request.getParameter("email"),
                    request.getParameter("password"));
            if ( user == null ) {
                out.write("Please Login Again");
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("/lobby/index");
            }
        }

        MainView mainView = new MainView();
        User currentUser = (User) session.getAttribute("user");
        out.println(mainView.getHtml(currentUser));
    }


    @Override
    public void init() throws ServletException {
        super.init();
        String path = getServletContext().getRealPath("html/");
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        indexSingletonView.setPath(path);

        // log file config

    }
}