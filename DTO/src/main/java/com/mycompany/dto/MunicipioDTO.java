/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jl4ma
 */
public class MunicipioDTO {
    
    private String nombre;
    private List<UsuarioDTO> usuarios;
    private EstadoDTO estado;

    public MunicipioDTO(String nombre, EstadoDTO estado) {
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nombre);
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
        final MunicipioDTO other = (MunicipioDTO) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "MunicipioDTO{" + "nombre=" + nombre + ", usuarios=" + usuarios + ", estado=" + estado + '}';
    }
    
    
}
