/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.UsuarioBean;
import com.mycompany.dto.NormalDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jl4ma
 */
public class PerfilUsuario extends HttpServlet {

    private IFachada accesoDatos;

    @Override
    public void init() throws ServletException {
        accesoDatos = new Fachada();  // Inicialización del acceso a datos.
    }

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
        System.out.println("HOLA, LLEGASTE AL SERVLET MI PERFIL - GET");
        try {
            // Obtiene los posts asociados al usuario.
            List<PostDTO> listaPosts = accesoDatos.obtenerPostsPorUsuario(((UsuarioBean) request.getSession().getAttribute("usuario")).getCorreo());
            request.setAttribute("listaPosts", listaPosts);

            // Redirige a la página perfil.jsp.
            RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);
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
        System.out.println("HOLA, LLEGASTE AL SERVLET MI PERFIL - POST");
        try {
            UsuarioDTO usuario = (NormalDTO) request.getSession().getAttribute("usuario");
            List<PostDTO> listaPosts = accesoDatos.obtenerPostsPorCategoria(null);  // Aquí puedes manejar la categoría deseada.
            request.setAttribute("listaPosts", listaPosts);

            // Si usuario es null, se redirige a index.jsp.
            if (usuario == null) {
                request.setAttribute("error", "Usuario no autenticado");
                this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);
        } catch (FachadaException e) {
            System.out.println("Error al manejar el POST");
            request.setAttribute("error", "Ocurrió un error al procesar los datos");
            this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "PerfilUsuario servlet";
    }
}
