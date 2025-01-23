/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.ComentarioBean;
import beans.PostBean;
import beans.UsuarioBean;
import com.mycompany.dto.AncladoDTO;
import com.mycompany.dto.ComentarioDTO;
import com.mycompany.dto.ComunDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import com.mycompany.modelo.CategoriaPost;
import fachada.Fachada;
import fachada.IFachada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jl4ma
 */
public class Noticias extends HttpServlet {

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
        System.out.println("HOLA DESDE SERVLET NOTICIAS");
       IFachada accesoDatos = new Fachada();
        try {
            List<PostDTO> posts = accesoDatos.obtenerPostsPorCategoria(CategoriaPost.NOTICIAS);
            
            List<PostBean> postBeans = posts.stream()
                    .map(this::toBean)
                    .collect(Collectors.toList());

            request.setAttribute("posts", postBeans);
            System.out.println("SERVLET POSTS ");
            request.getRequestDispatcher("noticias.jsp").forward(request, response);
        } catch (FachadaException ex) {
            Logger.getLogger(Noticias.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar los posts.");
        }
    }
    
    private PostBean toBean(PostDTO dto) {
        if (dto == null) {
            return null;
        }

        IFachada accesoDatos = new Fachada();
        try {
            List<ComentarioDTO> com = accesoDatos.obtenerComentariosPost(dto.getId());
            if(!com.isEmpty()){
                dto.setComentarios(com);
            }
            
        } catch (FachadaException ex) {
        }
        // Convierte comentarios
        List<ComentarioBean> comentarios = dto.getComentarios() != null
                ? dto.getComentarios().stream().map(this::toBean).collect(Collectors.toList())
                : null;

        String tipo = "";
        if (dto.getTipoPost().equalsIgnoreCase("Comun")) {
            tipo = "comun";
        } else if (dto.getTipoPost().equalsIgnoreCase("Anclado")) {
            tipo = "anclado";
        }
        return new PostBean(dto.getId(), toBean(dto.getUsuario()), dto.getFechaHoraCreacion(), tipo, dto.getTitulo(), dto.getSubtitulo(), dto.getContenido(),dto.getCategoria(), dto.getImagen(), comentarios);
    }

    /**
     * Convierte un ComentarioDTO a un ComentarioBean.
     */
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

    /**
     * Convierte un UsuarioDTO a un UsuarioBean.
     */
    private UsuarioBean toBean(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }
        return new UsuarioBean(
                dto.getNombreUsuario(),
                dto.getCorreo(),
                dto.getCiudad(),
                dto.getAvatar(),
                dto.getGenero()
        );
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
