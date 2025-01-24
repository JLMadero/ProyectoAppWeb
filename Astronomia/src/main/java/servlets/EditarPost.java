/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.UsuarioBean;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.JSONObject;

/**
 *
 * @author jl4ma
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class EditarPost extends HttpServlet {

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
        System.out.println("EditarPsot");
        System.out.println("EditarPsot");
        System.out.println("EditarPsot");
        IFachada accesoDatos = new Fachada();

        // Leer el cuerpo del JSON enviado por el cliente
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        // Convertir el cuerpo de la solicitud en un objeto JSON
        JSONObject json = new JSONObject(sb.toString());

        try {
            // Extraer datos del JSON
            Long postId = Long.valueOf(json.getInt("postId")); // ID del post
            String titulo = json.getString("titulo");         // Nuevo título
            String contenido = json.getString("contenido");   // Contenido del post
            String categoria = json.optString("opciones", ""); // Opcional: Categoría del post
            String nombreImagen = json.getString("imagenPost");
            String rutaRelativa = "";
// PROCESAMIENTO DE LA IMAGEN
            try {
                if (!nombreImagen.isBlank()) {
                    // Ruta del directorio donde se almacenarán las imágenes
                    String rutaDirectorio = getServletContext().getRealPath("/resources/imgs/imagenesPost");
                    File directorioImagenesPost = new File(rutaDirectorio);

                    // Crear el directorio si no existe
                    if (!directorioImagenesPost.exists()) {
                        directorioImagenesPost.mkdir();
                    }

                    // Obtener el archivo
                    Part imagen = request.getPart("imagenPost");

                    // Referencia del archivo (nombre del archivo)
                    String referencia = imagen.getSubmittedFileName();

                    // Ruta completa donde se almacenará el archivo en el servidor
                    String rutaImagen = rutaDirectorio + File.separator + referencia;

                    // Almacenar el archivo en el directorio
                    imagen.write(rutaImagen);

                    // Guardar la ruta relativa accesible por la aplicación web
                    rutaRelativa = "imgs/imagenesPost/" + referencia;
                    request.getSession().setAttribute("imagen", rutaRelativa);
                }
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
// FIN PROCESAMIENTO IMAGEN
            // Obtener el usuario actual desde la sesión
            UsuarioDTO usuario = accesoDatos.obtenerUsuario(
                    ((UsuarioBean) request.getSession().getAttribute("usuario")).getCorreo()
            );

            // Crear un objeto PostDTO para actualizar
            PostDTO postDTO = new PostDTO(Calendar.getInstance(), "Comun", titulo, "", contenido, categoria, rutaRelativa, usuario);

            // Editar el post usando la fachada
            accesoDatos.editarPost(postDTO, usuario);

            // Redirigir al usuario después de la operación
            response.sendRedirect("iniciar.jsp");
        } catch (FachadaException ex) {
            Logger.getLogger(EditarPost.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al editar el post");
        } catch (Exception ex) {
            Logger.getLogger(EditarPost.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error en el procesamiento del JSON");
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
        System.out.println("EditarPsot POST");
        System.out.println("EditarPsot");
        System.out.println("EditarPsot");
        IFachada accesoDatos = new Fachada();
        // Leer el cuerpo del JSON enviado por Fetch API
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        // Convertir a un objeto JSON
        JSONObject json = new JSONObject(sb.toString());

        // Extraer datos del JSON
        Long postId = Long.valueOf(json.getInt("postId"));
        UsuarioDTO usuario = null;
        try {
            usuario = accesoDatos.obtenerUsuario(((UsuarioBean) request.getSession().getAttribute("usuario")).getCorreo());
        } catch (FachadaException ex) {
            Logger.getLogger(CrearPost.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            request.setAttribute("posts", accesoDatos.obtenerPostID(postId));
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditarPost.jsp");
            dispatcher.forward(request, response);
        } catch (FachadaException ex) {
            Logger.getLogger(ComentarPost.class.getName()).log(Level.SEVERE, null, ex);
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
