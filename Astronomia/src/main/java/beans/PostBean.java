/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class PostBean {
    private Long id;
    private UsuarioBean usuario;
    private Calendar fechaHoraCreacion;
    private String tipoPost;
    private String titulo;
    private String subtitulo;
    private String contenido;
    private String categoria;
    private String imagen;
    private List<ComentarioBean> comentarios;

    public PostBean(Long id, UsuarioBean usuario, Calendar fechaHoraCreacion, String tipoPost, String titulo, String subtitulo, String contenido, String categoria, String imagen, List<ComentarioBean> comentarios) {
        this.id = id;
        this.usuario = usuario;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.tipoPost = tipoPost;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.imagen = imagen;
        this.comentarios = comentarios;
    }

    
    

    public PostBean() {
    }

    public String getTipoPost() {
        return tipoPost;
    }

    public void setTipoPost(String tipoPost) {
        this.tipoPost = tipoPost;
    }
    

    
    

    public Long getId() {
        return id;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public Calendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public List<ComentarioBean> getComentarios() {
        return comentarios;
    }
}
