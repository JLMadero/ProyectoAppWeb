/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import daos.IComentarioDAO;
import daos.IEstadoDAO;
import daos.IMunicipioDAO;
import daos.IPostDAO;
import daos.IUsuarioDAO;

/**
 *
 * @author jl4ma
 */
public  abstract class AbstractDAOFactory {

    public abstract IComentarioDAO getComentarioDAO();

    public abstract IPostDAO getPostDAO();

    public abstract IUsuarioDAO getUsuarioDAO();
    
    public abstract IMunicipioDAO getMunicipioDAO();
    
    public abstract IEstadoDAO getEstadoDAO();
}