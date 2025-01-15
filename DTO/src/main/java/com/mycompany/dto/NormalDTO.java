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
public class NormalDTO extends UsuarioDTO {

    private List<ComentarioDTO> comentarios;

    public NormalDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, MunicipioDTO municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, nombreUsuario, avatar, ciudad, fechaNacimiento, genero, municipio);
    }

    public NormalDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, List<PostDTO> posts, MunicipioDTO municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, nombreUsuario, avatar, ciudad, fechaNacimiento, genero, posts, municipio);
    }

    public NormalDTO(String correo, String nombreUsuario) {
        super(correo, nombreUsuario);
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    
}
