/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.UsuarioBean;
import com.mycompany.dto.AdministradorDTO;
import com.mycompany.dto.NormalDTO;
import com.mycompany.dto.UsuarioDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jl4ma
 */
public class IniciarSesion extends HttpServlet {

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
        IFachada accesoDatos = new Fachada();
        String correo = request.getParameter("correo");
        String contrasenia = request.getParameter("contra");

        try {
            UsuarioDTO usuario = accesoDatos.obtenerUsuario(correo, contrasenia);
            if (usuario != null) {
                String tipo = "";
                if (usuario instanceof NormalDTO) {
                    tipo = "normal";
                } else if (usuario instanceof AdministradorDTO) {
                    tipo = "administrador";
                }
                UsuarioBean bean = new UsuarioBean(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getCiudad(), usuario.getAvatar(), tipo);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", bean);
                response.sendRedirect(request.getContextPath() + "/inicio.jsp");
            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (FachadaException e) {
            System.out.println("Error al iniciar sesión");
            request.setAttribute("error", "Ocurrió un error durante el inicio de sesión");
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
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
