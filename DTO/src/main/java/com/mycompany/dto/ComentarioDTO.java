/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public class ComentarioDTO {
    
    private Long id;
    private Calendar fechaHora;
    private String contenido;
    private List<ComentarioDTO> respuestas;
    private ComentarioDTO respuesta;
    private PostDTO post;
    private NormalDTO usuario;

    public ComentarioDTO() {
    }
    
    /**
     * Constructor para cuando se responde un post.
     * @param fechaHora
     * @param contenido
     * @param usuario 
     */
    public ComentarioDTO(Calendar fechaHora, String contenido, PostDTO post, NormalDTO usuario) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.post = post;
        this.respuesta = null;
        this.usuario = usuario;
    }
    
    /**
     * Constructor para cuando se responde una respuesta.
     * @param fechaHora
     * @param contenido
     * @param usuario 
     */
    public ComentarioDTO(Calendar fechaHora, String contenido, ComentarioDTO respuesta, NormalDTO usuario) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.respuesta = respuesta;
        this.post = null;
        this.usuario = usuario;
    }

    public ComentarioDTO(Long id, Calendar fechaHora, String contenido, List<ComentarioDTO> respuestas, ComentarioDTO respuesta, PostDTO post, NormalDTO usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.respuestas = respuestas;
        this.respuesta = respuesta;
        this.post = post;
        this.usuario = usuario;
    }

    public ComentarioDTO(Long id, Calendar fechaHora, String contenido, List<ComentarioDTO> respuestas, NormalDTO usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.respuestas = respuestas;
        this.usuario = usuario;
    }

    public ComentarioDTO(Long id, Calendar fechaHora, String contenido, NormalDTO usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<ComentarioDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<ComentarioDTO> respuestas) {
        this.respuestas = respuestas;
    }

    public ComentarioDTO getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(ComentarioDTO respuesta) {
        this.respuesta = respuesta;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public NormalDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(NormalDTO usuario) {
        this.usuario = usuario;
    }
}
