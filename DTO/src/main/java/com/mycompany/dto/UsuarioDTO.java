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
public class UsuarioDTO {
    
     private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contrasenia;
    private String telefono;
    private String nombreUsuario;
    private String avatar;
    private String ciudad;
    private Calendar fechaNacimiento;
    private String genero;
    private List<PostDTO> posts;
    private MunicipioDTO municipio;

    public UsuarioDTO() {

    }

    public UsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, MunicipioDTO municipio) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;
    }
    
    public UsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, String nombreUsuario, String avatar, String ciudad, Calendar fechaNacimiento, String genero, List<PostDTO> posts, MunicipioDTO municipio) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.posts = posts;
        this.municipio = municipio;
    }

    public UsuarioDTO(String correo, String nombreUsuario) {
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public MunicipioDTO getMunicipio() {
        return municipio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }
}
