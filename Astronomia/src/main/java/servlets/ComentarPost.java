/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.UsuarioBean;
import com.google.gson.Gson;
import com.mycompany.dto.ComentarioDTO;
import com.mycompany.dto.NormalDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servlets.CrearPost;

/**
 *
 * @author jl4ma
 */
@WebServlet("/ComentarioServlet")
public class ComentarPost extends HttpServlet {

    private IFachada accesoDatos;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        accesoDatos = new Fachada();
        gson = new Gson();
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
          response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    PrintWriter out = response.getWriter();
    Map<String, String> respuesta = new HashMap<>();

    try {
        // Obtener usuario de la sesión
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new Exception("Usuario no autenticado");
        }
        
        UsuarioBean usuarioSesion = (UsuarioBean) session.getAttribute("usuario");
        NormalDTO usuarioActual = (NormalDTO) accesoDatos.obtenerUsuario(usuarioSesion.getCorreo());

        if (usuarioActual == null) {
            throw new Exception("Usuario no autenticado");
        }

        // Leer JSON del cuerpo de la solicitud
        BufferedReader reader = request.getReader();
        ComentarioDTO comentarioDTO = gson.fromJson(reader, ComentarioDTO.class);

        // Validaciones
        if (comentarioDTO == null || comentarioDTO.getContenido() == null || comentarioDTO.getContenido().trim().isEmpty()) {
            throw new Exception("El contenido del comentario no puede estar vacío");
        }

        // Completar datos del comentario
        comentarioDTO.setUsuario(usuarioActual);
        comentarioDTO.setFechaHora(Calendar.getInstance());

        // Guardar comentario
        accesoDatos.comentarPost(comentarioDTO, comentarioDTO.getPost());

        // Respuesta de éxito
        respuesta.put("status", "success");
        respuesta.put("message", "Comentario agregado correctamente");
        response.setStatus(HttpServletResponse.SC_CREATED);

    } catch (Exception e) {
        // Manejo de errores
        respuesta.put("status", "error");
        respuesta.put("message", e.getMessage());
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    // Enviar respuesta
    out.print(gson.toJson(respuesta));
    out.flush();
    

//        IFachada fachada = new Fachada();
//        Gson gson = new Gson();
//        try {
//            String contenido = request.getParameter("contenido");
//            Long postId = Long.parseLong(request.getParameter("postId"));
//            UsuarioDTO usuario = null;
//            try {
//            usuario = fachada.obtenerUsuario(((UsuarioBean) request.getSession().getAttribute("usuario")).getCorreo());
//        } catch (FachadaException ex) {
//            Logger.getLogger(CrearPost.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//            ComentarioDTO comentarioDTO = new ComentarioDTO();
//            comentarioDTO.setContenido(contenido);
//            comentarioDTO.setFechaHora(Calendar.getInstance());
//            comentarioDTO.setUsuario(new NormalDTO(usuario.getNombres(), usuario.getApellidoPaterno(), usuario.getApellidoMaterno(), usuario.getCorreo(), usuario.getContrasenia(), usuario.getTelefono(), usuario.getNombreUsuario(), usuario.getAvatar(), usuario.getCiudad(), usuario.getFechaNacimiento(), usuario.getGenero(), usuario.getMunicipio()));
//            
//
//            
//
//            fachada.comentarPost(comentarioDTO, fachada.obtenerPostID(postId));
//
//       
//            response.sendRedirect("descubrimiento.jsp");
//        
//        
//    }   catch (FachadaException ex) {
//            Logger.getLogger(ComentarPost.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        PrintWriter out = response.getWriter();
//        Map<String, String> respuesta = new HashMap<>();
//
//        try {
//            // Obtener usuario de la sesión
//            HttpSession session = request.getSession(false);
//            UsuarioBean usuarioSesion = (UsuarioBean) session.getAttribute("usuario");
//
//            NormalDTO usuarioActual = (NormalDTO) fachada.obtenerUsuario(usuarioSesion.getCorreo());
//
//            if (usuarioActual == null) {
//                throw new Exception("Usuario no autenticado");
//            }
//
//            // Leer JSON del cuerpo de la solicitud
//            BufferedReader reader = request.getReader();
//            ComentarioDTO comentarioDTO = gson.fromJson(reader, ComentarioDTO.class);
//
//            // Validaciones
//            if (comentarioDTO == null) {
//                throw new Exception("Datos de comentario inválidos");
//            }
//
//            if (comentarioDTO.getContenido() == null || comentarioDTO.getContenido().trim().isEmpty()) {
//                throw new Exception("El contenido del comentario no puede estar vacío");
//            }
//
//            // Completar datos del comentario
//            comentarioDTO.setUsuario(usuarioActual);
//            comentarioDTO.setFechaHora(Calendar.getInstance());
//
//            // Guardar comentario
//            fachada.comentarPost(comentarioDTO, comentarioDTO.getPost());
//
//            // Respuesta de éxito
//            respuesta.put("status", "success");
//            respuesta.put("message", "Comentario agregado correctamente");
//            response.setStatus(HttpServletResponse.SC_CREATED);
//
//        } catch (Exception e) {
//            // Manejo de errores
//            respuesta.put("status", "error");
//            respuesta.put("message", e.getMessage());
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        }
//
//        out.print(gson.toJson(respuesta));
//        out.flush();
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
