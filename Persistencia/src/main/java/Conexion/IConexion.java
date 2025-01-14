/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManager;

/**
 *
 * @author jl4ma
 */
public interface IConexion {
    /**
     * Método para crear una conexión con la base de datos.
     *
     * @return Un objeto del tipo EntityManager.
     */
    public EntityManager crearConexion();
}
