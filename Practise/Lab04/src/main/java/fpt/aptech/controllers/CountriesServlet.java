package fpt.aptech.controllers;

import fpt.aptech.dal.CountriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienKim
 */
public class CountriesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            CountriesDAO dao = new CountriesDAO();
            String action = request.getParameter("action");
            if (action == null) {
                request.setAttribute("list", dao.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("Create")) {
                // create
                String name = request.getParameter("txtName");
                int pop = Integer.parseInt(request.getParameter("txtPop"));
                dao.addCountries(name, pop);
                response.sendRedirect("CountriesServlet");
            } else if (action.equals("delete")){ // đặt bên index 
                String cId = request.getParameter("id");
                int id = Integer.parseInt(cId);
                dao.deleteCountries(id);
                response.sendRedirect("CountriesServlet");
                
            }else{
                out.println("No dothing");
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
