package edu.bsu.session.web_07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


@WebServlet(name = "hello", value = "/")
public class HelloServlet extends HttpServlet {

    private int step;

    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private String houseNumber;

    private String email;

    private String phoneNumber;

    public void init() {
        this.step = 1;
        this.firstName = "";
        this.lastName = "";
        this.city = "";
        this.street = "";
        this.houseNumber = "";
        this.email = "";
        this.phoneNumber = "";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (step == 1) {
            this.firstName = req.getParameter("first-name");
            this.lastName = req.getParameter("last-name");
            this.step = 2;
            req.getSession().setAttribute("firstName", firstName);
            req.getSession().setAttribute("lastName", lastName);
            setStep(req);
        } else if (step == 2) {
            this.city = req.getParameter("city");
            this.street = req.getParameter("street");
            this.houseNumber = req.getParameter("house-number");
            if (!houseNumber.isBlank()) {
                Integer.parseInt(houseNumber);
            }
            String direction = req.getParameter("direction");
            if (direction.equals("Prev")) {
                this.step = 1;
            } else {
                this.step = 3;
            }
            req.getSession().setAttribute("city", city);
            req.getSession().setAttribute("street", street);
            req.getSession().setAttribute("houseNumber", houseNumber);
            setStep(req);
        } else if (step == 3) {
            this.email = req.getParameter("email");
            this.phoneNumber = req.getParameter("phone-number");
            String direction = req.getParameter("direction");
            if (direction.equals("Prev")) {
                this.step = 2;
            } else {
                this.step = 4;
            }
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("phoneNumber", phoneNumber);
            setStep(req);
        } else if (step == 4) {
            this.step = 3;
            setStep(req);
        }
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        setStep(request);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    private void setStep(HttpServletRequest request) {
        request.getSession().setAttribute("step", step);
    }

    public void destroy() {
    }
}