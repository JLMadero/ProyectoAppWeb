/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jose Madero
 */
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id;

    @Column(name = "fechaHora", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaHora;

    @Column(name = "contenido", nullable = false, length = 200)
    private String contenido;

    @OneToMany(mappedBy = "respuesta", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Comentario> respuestas;

    @ManyToOne
    @JoinColumn(name = "id_respuesta")
    private Comentario respuesta;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Normal usuario;

    public Comentario() {
    }

    public Comentario(Calendar fechaHora, String contenido, Post comun, Normal normal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.post = comun;
        this.usuario = normal;
    }

    public Comentario(Calendar fechaHora, String contenido, Comentario respuesta, Normal usuario) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.respuesta = respuesta;
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

    public List<Comentario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Comentario> respuestas) {
        this.respuestas = respuestas;
    }

    public Comentario getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Comentario Respuesta) {
        this.respuesta = Respuesta;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Normal getUsuario() {
        return usuario;
    }

    public void setUsuario(Normal usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", respuestas=" + respuestas + ", respuesta=" + respuesta + ", post=" + post + ", usuario=" + usuario + '}';
    }

    

    

}