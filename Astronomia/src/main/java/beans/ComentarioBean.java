/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class ComentarioBean implements Serializable {
    
    private Long id;
    private String nombreUsuario;
    private String fechaComentario;
    private String contenido;
    private List<ComentarioBean> respuesta;

    public ComentarioBean() {
    }

    public ComentarioBean(Long id, String nombreUsuario, String fechaComentario, String contenido, List<ComentarioBean> respuesta) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.fechaComentario = fechaComentario;
        this.contenido = contenido;
        this.respuesta = respuesta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenid(String contenido) {
        this.contenido = contenido;
    }

    public List<ComentarioBean> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<ComentarioBean> respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "ComentarioBean{" + "nombreUsuario=" + nombreUsuario + ", fechaComentario=" + fechaComentario + ", contenido=" + contenido + '}';
    }
}
