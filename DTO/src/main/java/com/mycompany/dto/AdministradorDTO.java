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
public class AdministradorDTO extends UsuarioDTO{
    
    private List<AncladoDTO> postsAnclados;

    public AdministradorDTO(List<AncladoDTO> postsAnclados, String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, MunicipioDTO municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, nombreUsuario, avatar, ciudad, fechaNacimiento, genero, municipio);
        this.postsAnclados = postsAnclados;
    }

    public AdministradorDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, List<PostDTO> posts, MunicipioDTO municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, nombreUsuario, avatar, ciudad, fechaNacimiento, genero, posts, municipio);
    }
    
    public AdministradorDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, MunicipioDTO municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, nombreUsuario, avatar, ciudad, fechaNacimiento, genero, municipio);
    }

    public List<AncladoDTO> getPostsAnclados() {
        return postsAnclados;
    }
    
}
