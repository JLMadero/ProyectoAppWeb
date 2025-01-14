/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import Exception.PersistenciaException;
import com.mycompany.modelo.Usuario;

/**
 *
 * @author jl4ma
 */
public interface IUsuarioDAO {
    
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException;
    
    public Usuario buscarUsuario(String correo) throws PersistenciaException;

    public Usuario obtenerUsuarioCorreoContra(String contrasenia, String correo) throws PersistenciaException;
}
