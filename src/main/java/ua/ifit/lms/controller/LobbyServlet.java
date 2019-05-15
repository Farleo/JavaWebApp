package ua.ifit.lms.controller;

import ua.ifit.lms.dao.entity.User;
import ua.ifit.lms.dao.repository.LobbyRepository;
import ua.ifit.lms.view.LobbyView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LobbyServlet", urlPatterns = {"/lobby/*"})
public class LobbyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/main");
            return;
        }

        LobbyRepository lobbyRepository = new LobbyRepository();

        LobbyView lobbyView = new LobbyView();
        switch (request.getPathInfo()) {
            case "/index":
                String html = lobbyView.getIndex(user, lobbyRepository.getPublicRooms());
                System.out.println("Lobby html: " + html);
                out.println(html);
                break;
            default:
                out.println(lobbyView.getHtml(user));
        }


    }
}