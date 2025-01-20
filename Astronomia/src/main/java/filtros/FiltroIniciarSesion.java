/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jl4ma
 */
public class FiltroIniciarSesion implements Filter {
    
    private static final boolean debug = true;
    private static final String[] RUTAS_PUBLICAS = {"index.jsp","registrarse.jsp","resources/styles/registrarse.css","resources/styles/login.css","resources/imgs/fondo.jpg","resources/imgs/galaxia.webp", "IniciarSesion","CerrarSesion", "RegistrarUsuario", "CerrarSesion", "RegistrarUsuario"};


    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public FiltroIniciarSesion() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FiltroIniciarSesion:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FiltroIniciarSesion:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
         log("FiltroIniciarSesion:doFilter()");
     }

     HttpServletRequest httpRequest = (HttpServletRequest) request;
     HttpServletResponse httpResponse = (HttpServletResponse) response;

     String ruta = this.getRutaSolicitada(httpRequest);
     boolean urlPrivada = this.esURLPrivada(ruta);
     boolean logueado = this.estaLogueado(httpRequest);

     try {
         if (!logueado && urlPrivada && !ruta.equals("/index.jsp")) {
             httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
         } else {
             chain.doFilter(request, response);
         }
     } catch (Exception e) {
         sendProcessingError(e, response);  // Usa tu método para manejar errores
     }
 }
    

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("FiltroIniciarSesion:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("FiltroIniciarSesion()");
        }
        StringBuffer sb = new StringBuffer("FiltroIniciarSesion(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
     
     if (stackTrace != null && !stackTrace.equals("")) {
         try {
             response.setContentType("text/html");
             PrintStream ps = new PrintStream(response.getOutputStream());
             PrintWriter pw = new PrintWriter(ps);                
             pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); 
             pw.print("<h1>Ha ocurrido un error</h1>\n<pre>\n");                
             pw.print(stackTrace);                
             pw.print("</pre></body>\n</html>");
             pw.close();
             ps.close();
             response.getOutputStream().close();
         } catch (Exception ex) {
         }
     } else {
         try {
             PrintStream ps = new PrintStream(response.getOutputStream());
             t.printStackTrace(ps);
             ps.close();
             response.getOutputStream().close();
         } catch (Exception ex) {
         }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
    private boolean estaLogueado(HttpServletRequest httpRequest) {
        HttpSession sesion = httpRequest.getSession(false);

        return (sesion != null && sesion.getAttribute("usuario") != null);
    }
    
    
    //Verifica si la ruta a la que se quiere acceder es privada.
    private boolean esURLPrivada(String ruta) {
        for (String url : RUTAS_PUBLICAS) {
            if (ruta.startsWith("/" + url)) {
                return false;
            }
        }

        return true;
    }
    
    //Obtiene la ruta a la que se desea acceder.
    private String getRutaSolicitada(HttpServletRequest httpRequest) {
        String uriSolicitada = httpRequest.getRequestURI();

        String ruta = uriSolicitada.substring(httpRequest.getContextPath().length());

        return ruta;
    }
    
}
