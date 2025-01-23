/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import Exception.PersistenciaException;
import com.mycompany.modelo.Comentario;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IComentarioDAO {
    
    public Comentario obtenerComentario(Long id) throws PersistenciaException;
    public List<Comentario> obtenerTodosComentarios() throws PersistenciaException;
    public List<Comentario> obtenerComentariosPost(Long id) throws PersistenciaException;
    public void eliminarComentario(Comentario comentario) throws PersistenciaException;
    public void publicarComentario(Comentario comentario) throws PersistenciaException;
    public void responderComentario(Comentario comentario) throws PersistenciaException;
}
