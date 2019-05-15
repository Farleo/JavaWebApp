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

        // save note
//        if ( request.getParameter("title") != null ) {
//            Note note = new Note();
//            note.setTitle(request.getParameter("title"));
//            note.setText(request.getParameter("note"));
//            note.setNoteType(request.getParameter("typenote"));
//            note.setColorText(request.getParameter("colorFont"));
//            note.setColorBackground(request.getParameter("background"));
//            note.setUser_id(user.getId());
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            note.setDateEdited(timestamp.toString());
//            noteRepository.saveNote(note);
//        }

        LobbyView lobbyView = new LobbyView();
        switch (request.getPathInfo()) {
            case "/index":
                String html = lobbyView.getIndex(user, lobbyRepository.getPublicRooms());
                System.out.println("Lobby html: " + html);
                out.println(html);
                break;
            case "/edit":
//                Note note = noteRepository.getNotesById(Long.parseLong(request.getParameter("id")));
//                out.println(noteView.getExistingNote(note));
                break;
            default:
                out.println(lobbyView.getHtml(user));
        }


    }
}