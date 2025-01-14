/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jose Madero
 */
@Entity
@Table(name = "administradores")
public class Administrador extends Usuario implements Serializable {

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.PERSIST)
    private List<Anclado> postsAnclados;

    /**
     * Constructor vacío.
     */
    public Administrador() {
    }

    public Administrador(String correo, String nombres, String apellidoPaterno, String apellidoMaterno, String nombreUsuario, String contrasenia, String telefono, String avatar, String ciudad, Calendar fechaNacimiento, String genero, Municipio municipio) {
        super(correo, nombres, apellidoPaterno, apellidoMaterno, nombreUsuario, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio);
    }

    public List<Anclado> getPostsAnclados() {
        return postsAnclados;
    }

    public void setPostsAnclados(List<Anclado> postsAnclados) {
        this.postsAnclados = postsAnclados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Administrador{");
        sb.append("nombres=").append(nombres);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", correo=").append(correo);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", telefono=").append(telefono);
        sb.append(", avatar=").append(avatar);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }

}
