package ua.ifit.lms.controller;

import ua.ifit.lms.dao.entity.User;
import ua.ifit.lms.view.IndexSingletonView;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "RoomServlet", urlPatterns = {"/room/*"}, asyncSupported = true)
public class RoomServlet extends HttpServlet {
    private List<AsyncContext> contexts = new LinkedList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AsyncContext> aContexts = new ArrayList<>(this.contexts);
        this.contexts.clear();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String name = user.getName();
        String msg = request.getParameter("msg");
        String currentMessages = (String) request.getServletContext().getAttribute("message");
        String htmlMsg = "<p><b>"+name+"</b><br/>"+msg+"</p>";

        if(currentMessages != null) {
            currentMessages = htmlMsg + currentMessages;
        } else{
            currentMessages = htmlMsg;
        }

        request.getServletContext().setAttribute("message", currentMessages);

        for(AsyncContext context : aContexts){
            try(PrintWriter writer = context.getResponse().getWriter()){
                writer.println(htmlMsg);
                writer.flush();
                context.complete();
            }catch (Exception ex){

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.setTimeout(10*60*1000);
        contexts.add(asyncContext);
    }
}