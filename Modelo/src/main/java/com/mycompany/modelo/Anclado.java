/*
 * Anclado.java
 */
package com.mycompany.modelo;

import com.mycompany.modelo.Post;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jose Madero
 */
@Entity
@Table(name = "anclados")
public class Anclado extends Post implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_administrador", nullable = false)
    private Administrador administrador;
    
    /**
     * Constructor vacío.
     */
    public Anclado() {
    }
    
    /**
     * Constructor para un Post Anclado.
     *
     * @param id ID del post.
     * @param fechaHoraCreacion La fecha y hora de creación del post.
     * @param titulo El titulo del post
     * @param subtitulo El subtitulo del post
     * @param contenido El contenido del post
     * @param categoria La categoría del post
     * @param comentarios Los comentarios del post
     * @param usuario El usuario que creó el post
     */
    public Anclado(Long id, Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, CategoriaPost categoria, List<Comentario> comentarios, Usuario usuario, Administrador administrador, String imagen) {
        super(id, fechaHoraCreacion, titulo, subtitulo, contenido, categoria, comentarios, usuario, imagen);
        this.administrador = administrador;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Anclado{");
        sb.append('}');
        return sb.toString();
    }

}