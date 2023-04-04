/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hung
 */
public class CardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CardServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String url = "/index.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String action = request.getParameter("action");
        String url = "/index.jsp";
        if (action.equals("check")) {
            // get parameters from the request
            String owner = request.getParameter("owner");
            String card_type = request.getParameter("card_type");
            String card_number = request.getParameter("card_number");
            int cvc = Integer.parseInt(request.getParameter("cvc"));
            String expire_date = request.getParameter("expire_date");
            float charge = cardCharge(owner, card_type, card_number, cvc, expire_date);
            System.out.println("charge: " + charge);
            if (charge > 0) {
                request.setAttribute("charge", "$" + charge);
            } else {
                request.setAttribute("charge", "no card found");
            }
        }
        getServletContext()
                .getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static float cardCharge(java.lang.String owner, java.lang.String cardType, java.lang.String cardNumber, int cvc, java.lang.String expireDate) {
        nhom08.CreditCardService_Service service = new nhom08.CreditCardService_Service();
        nhom08.CreditCardService port = service.getCreditCardServicePort();
        return port.cardCharge(owner, cardType, cardNumber, cvc, expireDate);
    }

}
