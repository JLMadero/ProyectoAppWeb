/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Exception.FachadaException;
import beans.UsuarioBean;
import com.mycompany.dto.EstadoDTO;
import com.mycompany.dto.MunicipioDTO;
import com.mycompany.dto.NormalDTO;
import com.mycompany.dto.UsuarioDTO;
import fachada.Fachada;
import fachada.IFachada;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class RegistrarUsuario extends HttpServlet {

    
    
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
        String nombre = request.getParameter("nombre");
        String apellidoM = request.getParameter("materno");
        String apellidoP = request.getParameter("paterno");
        
        String nombreUsuario = request.getParameter("usuario");
        String correo = request.getParameter("correo");
        String contrasenia = request.getParameter("contra");
        String Confirmarcontrasenia = request.getParameter("confirmar");
        String telefono = request.getParameter("telefono");
        String ciudad = request.getParameter("ciudad");
        String genero = request.getParameter("genero");
        if(contrasenia.equalsIgnoreCase(Confirmarcontrasenia)){
            
        //PROCESAMIENTO DE LA IMAGEN
        // Se crea la ruta del directorio donde se almacenarán las imagenes
        String rutaDirectorio = getServletContext().getRealPath("/avatares");
        File directorioAvatares = new File(rutaDirectorio);

        // Se crea el directorio si no existe
        if (!directorioAvatares.exists()) {
            directorioAvatares.mkdir();
        }

        // Se obtiene el archivo
        Part avatar = request.getPart("avatar");

        // Se obtiene la referencia del archivo (nombre del archivo)
        String referencia = avatar.getSubmittedFileName();
        
        // Ruta completa donde se almacenará el archivo en el servidor
        String rutaAvatar = rutaDirectorio + File.separator + referencia;
        
        // Se almacena el archivo en el directorio
        avatar.write(rutaAvatar);
        
        // Guardar la ruta relativa que será accesible por la aplicación web
        String rutaRelativa = "avatares/" + referencia;
        request.getSession().setAttribute("avatar", rutaRelativa);
        //FIN PROCESAMIENTO IMAGEN

        String fechaNacimientoStr = request.getParameter("fechaN");

        Calendar fechaNacimiento = Calendar.getInstance();
        String[] dateParts = fechaNacimientoStr.split("-");
        fechaNacimiento.set(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]) - 1, Integer.parseInt(dateParts[2]));
        EstadoDTO estado = new EstadoDTO(request.getParameter("estado"));
        MunicipioDTO municipio = new MunicipioDTO(request.getParameter("municipio"), estado);

        UsuarioDTO usuario = new NormalDTO(nombre, apellidoP, apellidoM, correo, contrasenia, telefono, nombreUsuario, rutaRelativa, ciudad, fechaNacimiento, genero, municipio);
        System.out.println("HOLA DESDE EL SERVLET");
        try {
            String tipo = "normal";
            System.out.println("REGISTRO DE USUARIO SERVLET");
            accesoDatos.registrarUsuario(usuario);
            UsuarioBean bean = new UsuarioBean(nombreUsuario, correo, ciudad, rutaRelativa, tipo);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", bean);
            response.sendRedirect("index.jsp");
        } catch (FachadaException e) {
            System.out.println("EXCEPCION");
            this.getServletContext()
                    .getRequestDispatcher("/registrarse.jsp")
                    .forward(request, response);
        }
        
        }else{
                response.sendRedirect("registrarse.jsp");
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
