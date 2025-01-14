/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jose Madero
 */
@Entity
@Table(name = "comunes")
public class Comun extends Post implements Serializable {

    public Comun() {
    }

    /**
     * Constructor para un Post Común nuevo.
     *
     * @param fechaHoraCreacion La fecha y hora de creación del post.
     * @param titulo El titulo del post
     * @param subtitulo El subtitulo del post
     * @param contenido El contenido del post
     * @param categoria La categoría del post
     * @param usuario El usuario que creó el post
     */
    public Comun(Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, CategoriaPost categoria, Usuario usuario, String imagen) {
        super(
                fechaHoraCreacion,
                titulo,
                subtitulo,
                contenido,
                categoria,
                usuario, 
                imagen);
    }

    /**
     * Constructor para un Post Común ya existente.
     *
     * @param id
     * @param fechaHoraCreacion La fecha y hora de creación del post.
     * @param titulo El titulo del post
     * @param subtitulo El subtitulo del post
     * @param contenido El contenido del post
     * @param categoria La categoría del post
     * @param usuario El usuario que creó el post
     * @param comentarios Los comentarios del post
     */
    public Comun(Long id, Calendar fechaHoraCreacion, String titulo, String subtitulo, String contenido, CategoriaPost categoria, List<Comentario> comentarios, Usuario usuario, String imagen) {
        super(
                id,
                fechaHoraCreacion,
                titulo,
                subtitulo,
                contenido,
                categoria,
                comentarios,
                usuario, 
                imagen);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comun{");
        sb.append("comentarios=").append(comentarios);
        sb.append(", usuario=").append(usuario);
        sb.append('}');
        return sb.toString();
    }

}
