/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import Exception.PersistenciaException;
import com.mycompany.modelo.Anclado;
import com.mycompany.modelo.CategoriaPost;
import com.mycompany.modelo.Comun;
import com.mycompany.modelo.Post;
import com.mycompany.modelo.Usuario;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IPostDAO {
    
    public Post obtenerPostPorID(Long id) throws PersistenciaException;
    public List<Post> obtenerTodosPosts() throws PersistenciaException;
    public List<Post> obtenerPostsPorCategoria(CategoriaPost categoria) throws PersistenciaException;
    public List<Post> obtenerPostsUsuario(Usuario usuario) throws PersistenciaException;
    public void publicarPost(Post post) throws PersistenciaException;
    public void editarPost(Post post) throws PersistenciaException;
    public void eliminarPost(Post post) throws PersistenciaException;
    public Post buscarPostPorAtributos(Post post) throws PersistenciaException;
    public void anclarPost(Comun postComun, Anclado postAnclado) throws PersistenciaException;
    public void desanclarPost(Comun comun, Anclado anclado) throws PersistenciaException;
}
