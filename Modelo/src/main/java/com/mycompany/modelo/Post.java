/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoPost")
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_creacion", nullable = false)
    protected Calendar fechaHoraCreacion;

    @Column(name = "titulo", nullable = false)
    protected String titulo;

    @Column(name = "subtitulo", nullable = true)
    protected String subtitulo;

    @Column(name = "contenido", nullable = false)
    protected String contenido;

    @Column(name = "imagen", nullable = true, length = 500)
    protected String imagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    protected CategoriaPost categoria;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    protected List<Comentario> comentarios;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    protected Usuario usuario;

    public Post() {
    }

    /**
     * Constructor para un Post nuevo.
     *
     * @param fechaHoraCreacion La fecha y hora de creación del post.
     * @param titulo El titulo del post
     * @param subtitulo El subtitulo del post
     * @param contenido El contenido del post
     * @param categoria La categoría del post
     * @param usuario El usuario que creó el post
     * @param imagen La imagen del post
     */
    public Post(Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, CategoriaPost categoria, Usuario usuario, String imagen) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.usuario = usuario;
        this.imagen = imagen;
        this.comentarios = new LinkedList<>();
    }

    /**
     * Constructor para un Post ya existente.
     *
     * @param id ID del post.
     * @param fechaHoraCreacion La fecha y hora de creación del post.
     * @param titulo El titulo del post
     * @param subtitulo El subtitulo del post
     * @param contenido El contenido del post
     * @param categoria La categoría del post
     * @param usuario El usuario que creó el post
     * @param comentarios Los comentarios del post
     * @param imagen La imagen del post
     */
    public Post(Long id, Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, CategoriaPost categoria, List<Comentario> comentarios, Usuario usuario, String imagen) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.usuario = usuario;
        this.imagen = imagen;
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Calendar fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public CategoriaPost getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPost categoria) {
        this.categoria = categoria;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fechaHoraCreacion);
        hash = 97 * hash + Objects.hashCode(this.titulo);
        hash = 97 * hash + Objects.hashCode(this.subtitulo);
        hash = 97 * hash + Objects.hashCode(this.contenido);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.usuario);
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
        final Post other = (Post) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.subtitulo, other.subtitulo)) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraCreacion, other.fechaHoraCreacion)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

}
