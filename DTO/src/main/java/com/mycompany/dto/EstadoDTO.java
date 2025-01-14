package com.mycompany.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jl4ma
 */
public class EstadoDTO {
     private String nombre;
    private List<MunicipioDTO> municipios;

    public EstadoDTO(String nombre) {
        this.nombre = nombre;
        municipios = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<MunicipioDTO> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipioDTO> municipio) {
        this.municipios = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.nombre);
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
        final EstadoDTO other = (EstadoDTO) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    

}


