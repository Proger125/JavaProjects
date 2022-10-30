package edu.bsu.kr.kr_26_05;

import edu.bsu.kr.kr_26_05.dao.PaymentDao;

import java.io.*;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    private final PaymentDao paymentDao = new PaymentDao();

    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        changeLocal(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("payments", paymentDao.getAll());
        request.setAttribute("max_payment", paymentDao.getPaymentWithMaxSumTaxes());
        request.setAttribute("count_tax_payments", paymentDao.getCountOfTaxPayments());
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    private void changeLocal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("locale");
        request.setAttribute("payments", paymentDao.getAll());
        request.setAttribute("max_payment", paymentDao.getPaymentWithMaxSumTaxes());
        request.setAttribute("count_tax_payments", paymentDao.getCountOfTaxPayments());
        Locale loc = new Locale(locale);
        request.getSession().setAttribute("locale", loc);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    public void destroy() {
    }
}