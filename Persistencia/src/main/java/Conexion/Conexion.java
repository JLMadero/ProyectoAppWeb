/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jl4ma
 */
public class Conexion implements IConexion {

    @Override
    public EntityManager crearConexion() {
        // Creamos el EntityManagerFactory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DbAstro");
        
        // Creamos el EntityManager.
        EntityManager em = emf.createEntityManager();

        // Retornamos el EntityManager.
        return em;
    }
}
