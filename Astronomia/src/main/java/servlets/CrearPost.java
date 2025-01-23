/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.UsuarioBean;
import com.mycompany.dto.AncladoDTO;
import com.mycompany.dto.ComunDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author jl4ma
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class CrearPost extends HttpServlet {

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

        String titulo = request.getParameter("titulo");
        String tipoPost = request.getParameter("opciones");
        String cuerpo = request.getParameter("contenido");
        UsuarioDTO usuario = null;
        try {
            usuario = accesoDatos.obtenerUsuario(((UsuarioBean) request.getSession().getAttribute("usuario")).getCorreo());
        } catch (FachadaException ex) {
            Logger.getLogger(CrearPost.class.getName()).log(Level.SEVERE, null, ex);
        }

        String rutaRelativa = "";
// PROCESAMIENTO DE LA IMAGEN
        try {
            if (!request.getPart("imagenPost").getSubmittedFileName().isBlank()) {
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
        try {
            
            String ancla = request.getParameter("isAnclado");
            
            if (ancla == null) {
                PostDTO postNuevo = new PostDTO(Calendar.getInstance(), "Comun", titulo, "", cuerpo,tipoPost , rutaRelativa, usuario);
               accesoDatos.publicarPost(postNuevo); 
            }else{
                PostDTO postNuevo = new PostDTO(Calendar.getInstance(), "Anclado", titulo, "", cuerpo,tipoPost , rutaRelativa, usuario);
                 accesoDatos.publicarPostAnclado(postNuevo);
                
            }
            
            
        } catch (FachadaException ex) {
            System.out.println("Error al crear la publicacion");
        }

        HttpSession session = request.getSession();
        String returnTo = (String) session.getAttribute("returnTo");

        if (returnTo != null) {
            session.removeAttribute("returnTo");
            response.sendRedirect(returnTo);
        } else {
            response.sendRedirect("inicio.jsp");
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
