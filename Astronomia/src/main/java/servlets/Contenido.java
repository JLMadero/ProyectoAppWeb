/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.ComentarioBean;
import beans.UsuarioBean;
import com.mycompany.dto.ComentarioDTO;
import com.mycompany.dto.PostDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jl4ma
 */
public class Contenido extends HttpServlet {

    private IFachada accesoDatos;

    @Override
    public void init() throws ServletException {
        accesoDatos = new Fachada();  // Inicialización del acceso a datos.
    }
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
        System.out.println("HOLA, LLEGASTE AL SERVLET COMENTARIO - GET");
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            // Obtiene los posts asociados al usuario.
            List<ComentarioDTO> comentarios = accesoDatos.obtenerComentariosPost(id);
            
            List<ComentarioBean> postBeans = comentarios.stream()
                    .map(this::toBean)
                    .collect(Collectors.toList());
            request.setAttribute("listaComentarios",postBeans );

            String referer = request.getHeader("Referer");
        
        // Validar si el Referer existe
        if (referer != null) {
            // Redirigir a la página que envió la solicitud
            response.sendRedirect("descubrimientos.jsp");
        } else {
            // Si no hay Referer, redirigir a una página por defecto
            response.sendRedirect("inicio.jsp");
        }
        } catch (FachadaException e) {
            System.out.println("Error al obtener posts");
            request.setAttribute("error", "Ocurrió un error al obtener los posts");
            this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
        }
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
    
    private ComentarioBean toBean(ComentarioDTO dto) {
        if (dto == null) {
            return null;
        }
        return new ComentarioBean(
                dto.getId(),
                dto.getUsuario().getNombreUsuario(),
                dto.getFechaHora().getTime().toString(),
                dto.getContenido(),
                null //Aun no se pueden poner respustas saluditos
        );
    }

}
