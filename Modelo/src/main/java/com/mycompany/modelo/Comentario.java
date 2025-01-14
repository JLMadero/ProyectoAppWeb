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

    @OneToMany(mappedBy = "respuesta", cascade = CascadeType.PERSIST)
    private List<Comentario> respuestas;

    @ManyToOne
    @JoinColumn(name = "id_respuesta")
    private Comentario respuesta;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Normal usuario;

    public Comentario() {
    }

    public Comentario(Calendar fechaHora, String contenido, Comun comun, Normal normal) {
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
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.fechaHora);
        hash = 47 * hash + Objects.hashCode(this.contenido);
        hash = 47 * hash + Objects.hashCode(this.respuestas);
        hash = 47 * hash + Objects.hashCode(this.respuesta);
        hash = 47 * hash + Objects.hashCode(this.post);
        hash = 47 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        if (!Objects.equals(this.respuestas, other.respuestas)) {
            return false;
        }
        if (!Objects.equals(this.respuesta, other.respuesta)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comentario{");
        sb.append("fechaHora=").append(fechaHora);
        sb.append(", contenido=").append(contenido);
        sb.append(", comentarios=").append(respuestas);
        sb.append(", respuesta=").append(respuesta);
        sb.append(", post=").append(post);
        sb.append(", usuario=").append(usuario);
        sb.append('}');
        return sb.toString();
    }

}