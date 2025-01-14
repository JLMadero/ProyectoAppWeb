/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Conexion.IConexion;
import daos.ComentarioDAO;
import daos.EstadoDAO;
import daos.IComentarioDAO;
import daos.IEstadoDAO;
import daos.IMunicipioDAO;
import daos.IPostDAO;
import daos.IUsuarioDAO;
import daos.MunicipioDAO;
import daos.PostDAO;
import daos.UsuarioDAO;

/**
 *
 * @author jl4ma
 */
public class DAOFactory extends AbstractDAOFactory {
    
    private IConexion conexion;
    
    public DAOFactory(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @return
     */
    @Override
    public IComentarioDAO getComentarioDAO() {
        return new ComentarioDAO(conexion);
    }

    /**
     *
     * @return
     */
    @Override
    public IEstadoDAO getEstadoDAO() {
        return new EstadoDAO(conexion);
    }

    /**
     *
     * @return
     */
    @Override
    public IMunicipioDAO getMunicipioDAO() {
        return new MunicipioDAO(conexion);
    }

    /**
     *
     * @return
     */
    @Override
    public IPostDAO getPostDAO() {
        return new PostDAO(conexion);
    }

    /**
     *
     * @return
     */
    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO(conexion);
    }
}
