/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class PostDTO {
     private Long id;
    private Calendar fechaHoraCreacion;
    private String titulo;
    private String subtitulo;
    private String contenido;
    private String categoria;
    private String imagen;
    private List<ComentarioDTO> comentarios;
    private UsuarioDTO usuario;

    /**
     * Constructor para un PostDTO nuevo.
     *
     * @param fechaHoraCreacion
     * @param titulo
     * @param subtitulo
     * @param contenido
     * @param categoria
     * @param usuario
     */
    public PostDTO(Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, String categoria, UsuarioDTO usuario, String imagen) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.usuario = usuario;
        if (imagen.isBlank()) {
            imagen = "";
        }
        this.imagen = imagen;
        this.comentarios = new LinkedList<>();
    }

    /**
     * Constructor para un PostDTO existente.
     *
     * @param id ID del post.
     * @param fechaHoraCreacion
     * @param titulo
     * @param subtitulo
     * @param contenido
     * @param categoria
     * @param usuario
     */
    public PostDTO(Long id, Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, String categoria, UsuarioDTO usuario, List<ComentarioDTO> comentarios, String imagen) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.usuario = usuario;
        if (imagen.isBlank()) {
            imagen = "";
        }
        this.imagen = imagen;
        this.comentarios = comentarios;
    }

    /**
     * Constructor para un PostDTO existente.
     *
     * @param id ID del post.
     * @param fechaHoraCreacion
     * @param titulo
     * @param subtitulo
     * @param contenido
     * @param categoria
     * @param usuario
     */
    public PostDTO(Long id, Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, String categoria, UsuarioDTO usuario, String imagen) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.categoria = categoria;
        if (imagen.isBlank()) {
            imagen = "";
        }
        this.imagen = imagen;
        this.usuario = usuario;
    }

    public PostDTO(Long id, Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, String imagen, List<ComentarioDTO> comentarios, UsuarioDTO usuario) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    public PostDTO(Long id, Calendar fechaHoraCreacion, String contenido, NormalDTO usuario) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.contenido = contenido;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "PostDTO{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", subtitulo=" + subtitulo + ", contenido=" + contenido + ", categoria=" + categoria + ", imagen=" + imagen + ", comentarios=" + comentarios + ", usuario=" + usuario + '}';
    }
    
    
}
