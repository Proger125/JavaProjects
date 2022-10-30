package edu.bsu.session.web_07;

import edu.bsu.session.web_07.dao.ResidentDaoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "residents", value = "/residents")
public class ResidentsServlet extends HttpServlet {

    public static final String ADD = "Add";

    public static final String DELETE = "Delete";
    public static final String SUBMIT = "submit";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("residentBean", new ResidentDaoBean());
        resp.sendRedirect("residents.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
