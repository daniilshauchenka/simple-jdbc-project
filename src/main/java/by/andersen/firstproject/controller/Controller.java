package by.andersen.firstproject.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter("command");
        Command command = provider.getCommand(commandName);
        request.setAttribute(RequestParam.JSP_PREV_QUERY_PARAM_NAME, request.getHeader("referer"));
        command.execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter("command");
        request.setAttribute(RequestParam.JSP_PREV_QUERY_PARAM_NAME,
                request.getAttribute("javax.servlet.forward.query_string"));
        Command command = provider.getCommand(commandName);
        command.execute(request, response);
    }



}
