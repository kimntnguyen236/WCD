package fpt.aptech.dal;

import fpt.aptech.bean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienKim
 */
public class ThienKimServlet extends HttpServlet  { //implements Runnable

//    List<ThienKim> list;
//    ThienKimDAO dao;
//
//    // dùng để khởi tạo
//    @Override
//    public void init() throws ServletException {
//        super.init(); //To change body of generated methods, choose Tools | Templates.
//        Thread thread = new Thread(this);
//        thread.start();
//    }
//    
//    @Override
//    public void run() {
//        list = dao.findAll();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ThienKimServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            ThienKimDAO dao = new ThienKimDAO();
            String action = request.getParameter("action");
            if (action == null) {
//                run();
                List<ThienKim> list = dao.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("Create")) {
                ThienKim course = new ThienKim();
                String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                String pass = request.getParameter("txtPass");
                boolean role = Boolean.parseBoolean(request.getParameter("txtRole"));
                double salary = Double.parseDouble(request.getParameter("txtSalary"));
                // gọi hàm dựng 4 tham số : ThienKim (tạo hàm dựng 4 tham số) -> gọi ra
                course.setId(id);
                course.setPassword(pass);
                course.setName(name);
                course.setRole(role);
                course.setSalary(salary);
                dao.addCourse(course);
                response.sendRedirect("ThienKimServlet");
            } else if (action.equals("delete")) {
                String cid = request.getParameter("id"); // id lấy từ index.jsp chỗ delete=id....
                dao.deleteCourse(cid);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ThienKimServlet");
            } else if (action.equals("details")) {
                String cid = request.getParameter("id");
                ThienKim c = dao.findOne(cid);
                request.setAttribute("c", c);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }
            else if(action.equals("update"))
            {   
                //update page
                String cid = request.getParameter("id");
                //String cid = request.getParameter("txtID");
                request.setAttribute("c", dao.findOne(cid)); //do bien ra jsp
                request.getRequestDispatcher("update.jsp").forward(request, response); // phai gui ca request lan response
            }
            else if(action.equals("UpdateThienKim"))
            {   
               //update course
               String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                String pass = request.getParameter("txtPass");
                boolean role = Boolean.parseBoolean(request.getParameter("txtRole"));
                double salary = Double.parseDouble(request.getParameter("txtSalary"));
               ThienKim c = new ThienKim();
               c.setId(id);
               c.setPassword(pass);
               c.setName(name);
               c.setRole(role);
               c.setSalary(salary);
               dao.updateCourse(c);
               response.sendRedirect("ThienKimServlet");
            }else {
                // do nothing
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
