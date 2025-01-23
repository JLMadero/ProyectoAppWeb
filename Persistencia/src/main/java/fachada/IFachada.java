/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import Exception.FachadaException;
import com.mycompany.dto.AncladoDTO;
import com.mycompany.dto.ComentarioDTO;
import com.mycompany.dto.ComunDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import com.mycompany.modelo.CategoriaPost;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IFachada {
    
    public void registrarUsuario(UsuarioDTO usuario) throws FachadaException;

    public void publicarPost(PostDTO post) throws FachadaException;
    
    public void publicarPostAnclado(PostDTO post) throws FachadaException;

    public void eliminarPost(Long id, UsuarioDTO usuario) throws FachadaException;
    
    public void editarPost(PostDTO postDTO, UsuarioDTO usuario) throws FachadaException;

    public void comentarPost(ComentarioDTO comentarioDTO, PostDTO postDTO) throws FachadaException;

    public void eliminarComentario(ComentarioDTO comentario, UsuarioDTO usuario) throws FachadaException;

    public void responderComentario(ComentarioDTO respuesta, ComentarioDTO comentario) throws FachadaException;

    public UsuarioDTO obtenerUsuario(String correo, String contrasenia) throws FachadaException;

    public UsuarioDTO obtenerUsuario(String correo) throws FachadaException;

    public List<PostDTO> obtenerPostsPorCategoria(CategoriaPost categoria) throws FachadaException;

    public List<PostDTO> obtenerPostsPorUsuario(String correo) throws FachadaException;

    public PostDTO obtenerPostID(Long id) throws FachadaException;
    
    public Long obtenerUltimoPost() throws FachadaException;

    public ComentarioDTO obtenerComentarioID(Long id) throws FachadaException;

    public void anclarPost(Long idPost, String correoAdmin) throws FachadaException;

    public void desanclarPost(Long idPost) throws FachadaException;
}
