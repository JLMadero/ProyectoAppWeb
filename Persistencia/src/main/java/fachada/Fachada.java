/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Conexion.Conexion;
import Conexion.IConexion;
import Exception.FachadaException;
import Exception.PersistenciaException;
import Factory.AbstractDAOFactory;
import Factory.DAOFactory;
import com.mycompany.dto.AdministradorDTO;
import com.mycompany.dto.AncladoDTO;
import com.mycompany.dto.ComentarioDTO;
import com.mycompany.dto.ComunDTO;
import com.mycompany.dto.EstadoDTO;
import com.mycompany.dto.MunicipioDTO;
import com.mycompany.dto.NormalDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import com.mycompany.modelo.Administrador;
import com.mycompany.modelo.CategoriaPost;
import com.mycompany.modelo.Comentario;
import com.mycompany.modelo.Estado;
import com.mycompany.modelo.Municipio;
import com.mycompany.modelo.Normal;
import com.mycompany.modelo.Post;
import com.mycompany.modelo.Usuario;
import daos.IComentarioDAO;
import daos.IPostDAO;
import daos.IUsuarioDAO;
import encriptador.AESEncriptador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jl4ma
 */
public class Fachada implements IFachada {

    private IConexion conexion;
    private AbstractDAOFactory fabrica;

    private IUsuarioDAO usuariosDAO;
    private IPostDAO postsDAO;
    private IComentarioDAO comentariosDAO;

    public Fachada() {
        conexion = new Conexion();
        fabrica = new DAOFactory(conexion);

        usuariosDAO = fabrica.getUsuarioDAO();
        postsDAO = fabrica.getPostDAO();
        comentariosDAO = fabrica.getComentarioDAO();
    }

    @Override
    public void registrarUsuario(UsuarioDTO usuariodto) throws FachadaException {
        try {
            Usuario usuarioExistente;
            usuarioExistente = usuariosDAO.buscarUsuario(usuariodto.getCorreo());
            if (usuarioExistente != null) {
                throw new FachadaException("El correo que ingresó ya está registrado.");
            }
        } catch (PersistenciaException ex) {
            throw new FachadaException(ex.getMessage());
        }

        Normal usuario = new Normal(
                usuariodto.getCorreo(),
                usuariodto.getNombres(),
                usuariodto.getApellidoPaterno(),
                usuariodto.getApellidoMaterno(),
                usuariodto.getNombreUsuario(),
                AESEncriptador.encriptar(usuariodto.getContrasenia()),
                usuariodto.getTelefono(),
                usuariodto.getAvatar(),
                usuariodto.getCiudad(),
                usuariodto.getFechaNacimiento(),
                usuariodto.getGenero(),
                new Municipio(1L, usuariodto.getMunicipio().getNombre(), new Estado(1L, usuariodto.getMunicipio().getEstado().getNombre())));

        try {
            usuariosDAO.registrarUsuario(usuario);
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se pudo publicar el usuario.");
        }
    }

    @Override
    public void publicarPost(PostDTO post) throws FachadaException {
        CategoriaPost categoria;
        switch (post.getCategoria().toUpperCase()) {
            case "NOTICIAS":
                categoria = CategoriaPost.NOTICIAS;
                break;
            case "FENOMENO":
                categoria = CategoriaPost.FENOMENOS;
                break;
            case "PLANETAS":
                categoria = CategoriaPost.PLANETAS;
                break;
            case "DESCUBRIMIENTOS":
                categoria = CategoriaPost.DESCUBRIMIENTO;
                break;
            default:
                categoria = CategoriaPost.INICIO;
        }

        try {
            UsuarioDTO usuarioDTO = post.getUsuario();
            Usuario usuario = usuariosDAO.buscarUsuario(usuarioDTO.getCorreo());

            Post nuevoPost = new Post("Comun", post.getFechaHoraCreacion(), post.getTitulo(), post.getSubtitulo(), post.getContenido(), post.getImagen(), categoria, usuario);
                   
            postsDAO.publicarPost(nuevoPost);
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se pudo publicar el post.");
        }
    }
    @Override
    public void publicarPostAnclado(PostDTO post) throws FachadaException {
        CategoriaPost categoria;
        switch (post.getCategoria().toUpperCase()) {
            case "NOTICIAS":
                categoria = CategoriaPost.NOTICIAS;
                break;
            case "FENOMENO":
                categoria = CategoriaPost.FENOMENOS;
                break;
            case "PLANETAS":
                categoria = CategoriaPost.PLANETAS;
                break;
            case "DESCUBRIMIENTOS":
                categoria = CategoriaPost.DESCUBRIMIENTO;
                break;
            default:
                categoria = CategoriaPost.INICIO;
        }

        try {
            UsuarioDTO usuarioDTO = post.getUsuario();
            Usuario usuario = usuariosDAO.buscarUsuario(usuarioDTO.getCorreo());

            Post nuevoPost = new Post("Anclado", post.getFechaHoraCreacion(), post.getTitulo(), post.getSubtitulo(), post.getContenido(), post.getImagen(), categoria, usuario);
            postsDAO.publicarPost(nuevoPost);
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se pudo publicar el post.");
        }
    }

    @Override
    public void eliminarPost(Long id, UsuarioDTO usuario) throws FachadaException {
        try {
            Post postExistente = postsDAO.obtenerPostPorID(id);

            if (postExistente == null) {
                throw new FachadaException("El post no existe.");
            }

            /**
             * Si el usuario que quiere borrar el post no es el dueño o un
             * administrador, se lanza excepción.
             */
            if (!postExistente.getUsuario().getCorreo().equals(usuario.getCorreo()) && !(usuario instanceof AdministradorDTO)) {
                throw new FachadaException("No tiene permisos para borrar este post.");
            }

            postsDAO.eliminarPost(postExistente);

        } catch (PersistenciaException ex) {
            throw new FachadaException("No se pudo eliminar el post.");
        }
    }
    
    public void editarPost(PostDTO postDTO, UsuarioDTO usuario) throws FachadaException{
        try {
            Post postExistente = postsDAO.obtenerPostPorID(postDTO.getId());

            if (postExistente == null) {
                throw new FachadaException("El post no existe.");
            }

            /**
             * Si el usuario que quiere editar el post no es el dueño o un
             * administrador, se lanza excepción.
             */
            if (!postExistente.getUsuario().getCorreo().equals(usuario.getCorreo()) && !(usuario instanceof AdministradorDTO)) {
                throw new FachadaException("No tiene permisos para editar este post.");
            }

            CategoriaPost categoria;
            switch (postDTO.getCategoria().toUpperCase()) {
            case "NOTICIAS":
                categoria = CategoriaPost.NOTICIAS;
                break;
            case "FENOMENO":
                categoria = CategoriaPost.FENOMENOS;
                break;
            case "PLANETAS":
                categoria = CategoriaPost.PLANETAS;
                break;
            case "DESCUBRIMIENTOS":
                categoria = CategoriaPost.DESCUBRIMIENTO;
                break;
            default:
                categoria = CategoriaPost.INICIO;
        }

            postExistente.setTitulo(postDTO.getTitulo());
            postExistente.setSubtitulo(postDTO.getSubtitulo());
            postExistente.setContenido(postDTO.getContenido());
            postExistente.setCategoria(categoria);
            postExistente.setImagen(postDTO.getImagen());

            postsDAO.editarPost(postExistente);
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se pudo editar el post.");
        }
    }

    @Override
    public void comentarPost(ComentarioDTO comentarioDTO, PostDTO postDTO) throws FachadaException {
        try {
            // Obtenemos la entidad de Post.
            Post post = postsDAO.obtenerPostPorID(postDTO.getId());
            if (postDTO.getTipoPost().equalsIgnoreCase("Comun")) {
                Normal usuario = (Normal) usuariosDAO.buscarUsuario(comentarioDTO.getUsuario().getCorreo());

            Comentario comentario = new Comentario(
                    comentarioDTO.getFechaHora(),
                    comentarioDTO.getContenido(),
                    post,
                    usuario);
            comentariosDAO.publicarComentario(comentario);
            } else if (postDTO.getTipoPost().equalsIgnoreCase("Anclado")) {
                // Error si se trata comentar un post anclado.
                throw new FachadaException("No se pueden comentar posts anclados.");
            }

            
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarComentario(ComentarioDTO comentarioDTO, UsuarioDTO usuario) throws FachadaException {
        try {
            Comentario comentario = comentariosDAO.obtenerComentario(comentarioDTO.getId());

            if (comentario == null) {
                throw new FachadaException("El comentario no existe.");
            }

            /**
             * Si el usuario que quiere borrar el post no es el dueño o un
             * administrador, se lanza excepción.
             */
            if (!comentario.getUsuario().getCorreo().equals(usuario.getCorreo()) && !(usuario instanceof AdministradorDTO)) {
                throw new FachadaException("No tiene permisos para borrar este comentario.");
            }

            comentariosDAO.eliminarComentario(comentario);
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se pudo eliminar el comentario.");
        }
    }

    @Override
    public void responderComentario(ComentarioDTO respuestaDTO, ComentarioDTO comentarioDTO) throws FachadaException {
        try {
            // Obtenemos la entidad de Comentario.
            Comentario comentario = comentariosDAO.obtenerComentario(comentarioDTO.getId());

            // Buscamos la entidad del usuario que comentó.
            Normal usuario = (Normal) usuariosDAO.buscarUsuario(respuestaDTO.getUsuario().getCorreo());

            Comentario respuesta = new Comentario(
                    respuestaDTO.getFechaHora(),
                    respuestaDTO.getContenido(),
                    comentario,
                    usuario);
            comentariosDAO.publicarComentario(respuesta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para obtener un usuario dados un correo y contraseña.
     *
     * @param correo Correo del usuario.
     * @param contrasenia Contraseña del usuario.
     * @return
     * @throws FacadeException
     */
    @Override
    public UsuarioDTO obtenerUsuario(String correo, String contrasenia) throws FachadaException {
        try {
            // Encriptamos la contraseña recibida.
            contrasenia = AESEncriptador.encriptar(contrasenia);

            // Mandamos a buscar un usuario con el correo y la contraseña.
            Usuario usuario = usuariosDAO.obtenerUsuarioCorreoContra(correo, contrasenia);

            if (usuario != null) {
                // Convertimos el usuario de entidad a DTO.
                UsuarioDTO usuarioDTO = null;
                EstadoDTO estadoDTO = new EstadoDTO(usuario.getMunicipio().getEstado().getNombre());
                MunicipioDTO municipioDTO = new MunicipioDTO(usuario.getMunicipio().getNombre(), estadoDTO);
                if (usuario instanceof Normal) {
                    usuarioDTO = new NormalDTO(
                            usuario.getNombres(),
                            usuario.getApellidoPaterno(),
                            usuario.getApellidoMaterno(),
                            usuario.getCorreo(),
                            usuario.getContrasenia(),
                            usuario.getTelefono(),
                            usuario.getNombreUsuario(),
                            usuario.getAvatar(),
                            usuario.getCiudad(),
                            usuario.getFechaNacimiento(),
                            usuario.getGenero(),
                            convertirPostsAPostsDTO(usuario.getPosts()),
                            municipioDTO);
                } else if (usuario instanceof Administrador) {
                    usuarioDTO = new AdministradorDTO(
                            usuario.getNombres(),
                            usuario.getApellidoPaterno(),
                            usuario.getApellidoMaterno(),
                            usuario.getCorreo(),
                            usuario.getContrasenia(),
                            usuario.getTelefono(),
                            usuario.getNombreUsuario(),
                            usuario.getAvatar(),
                            usuario.getCiudad(),
                            usuario.getFechaNacimiento(),
                            usuario.getGenero(),
                            convertirPostsAPostsDTO(usuario.getPosts()),
                            municipioDTO);
                }

                // Retornamos el usuario.
                return usuarioDTO;
            } else {
                return null;
            }
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se encontró ningún usuario con los datos proporcionados.");
        }
    }

    /**
     * Método para obtener un usuario dado un correo.
     *
     * @param correo Correo del usuario.
     * @return
     * @throws FacadeException
     */
    @Override
    public UsuarioDTO obtenerUsuario(String correo) throws FachadaException {
        try {
            // Mandamos a buscar un usuario con el correo y la contraseña.
            Usuario usuario = usuariosDAO.buscarUsuario(correo);

            // Convertimos el usuario de entidad a DTO.
            UsuarioDTO usuarioDTO = null;
            EstadoDTO estadoDTO = new EstadoDTO(usuario.getMunicipio().getEstado().getNombre());
            MunicipioDTO municipioDTO = new MunicipioDTO(usuario.getMunicipio().getNombre(), estadoDTO);
            if (usuario instanceof Normal) {
                usuarioDTO = new NormalDTO(
                        usuario.getNombres(),
                        usuario.getApellidoPaterno(),
                        usuario.getApellidoMaterno(),
                        usuario.getCorreo(),
                        usuario.getContrasenia(),
                        usuario.getTelefono(),
                        usuario.getNombreUsuario(),
                        usuario.getAvatar(),
                        usuario.getCiudad(),
                        usuario.getFechaNacimiento(),
                        usuario.getGenero(),
                        convertirPostsAPostsDTO(usuario.getPosts()),
                        municipioDTO);
            } else if (usuario instanceof Administrador) {
                usuarioDTO = new AdministradorDTO(
                        usuario.getNombres(),
                        usuario.getApellidoPaterno(),
                        usuario.getApellidoMaterno(),
                        usuario.getCorreo(),
                        usuario.getContrasenia(),
                        usuario.getTelefono(),
                        usuario.getNombreUsuario(),
                        usuario.getAvatar(),
                        usuario.getCiudad(),
                        usuario.getFechaNacimiento(),
                        usuario.getGenero(),
                        convertirPostsAPostsDTO(usuario.getPosts()),
                        municipioDTO);
            }

            // Retornamos el usuario.
            return usuarioDTO;
        } catch (PersistenciaException ex) {
            throw new FachadaException("No se encontró ningún usuario con los datos proporcionados.");
        }
    }

    /**
     * Método para obtener todos los posts por categoría y convertirlos a DTO.
     *
     * @param categoria Categoría por la cuál se filtrarán los posts, si es null
     * se obtendrán todos los posts.
     * @return Una lista con todos los posts encontrados.
     */
    @Override
    public List<PostDTO> obtenerPostsPorCategoria(CategoriaPost categoria) throws FachadaException {
        List<PostDTO> postsDTO = null;
        try {
            // Se obtienen los posts.
            List<Post> posts = postsDAO.obtenerPostsPorCategoria(categoria);
            // Se convierten a DTO.
            postsDTO = convertirPostsAPostsDTO(posts);
        } catch (PersistenciaException ex) {
            throw new FachadaException(ex.getMessage());
        }
        return postsDTO;
    }

    /**
     * Método para convertir los posts de entidad a DTO.
     *
     * @param posts Lista de posts a convertir.
     * @return Una lista con los posts convertidos.
     */
    private List<PostDTO> convertirPostsAPostsDTO(List<Post> posts) {
        List<PostDTO> postsDTO = new ArrayList<>();
        for (Post post : posts) {
            postsDTO.add(convertirPostAPostDTO(post));
            // Si el post es común, se obtiene el usuario que lo publicó.
        }
        return postsDTO;
    }

    private PostDTO convertirPostAPostDTO(Post post) {
        
          PostDTO postDTO = new PostDTO(
                    post.getId(),
                    post.getFechaHoraCreacion(),
                    post.getTipoPost(),
                    post.getTitulo(),
                    post.getSubtitulo(),
                    post.getContenido(),
                    post.getCategoria().toString(),
                    post.getImagen(),
                    convertirComentariosAComentariosDTO(post.getComentarios()),
                    convertirUsuarioAUsuarioDTO(post.getUsuario())
                    );
        
        // Si el post es común, se obtiene el usuario que lo publicó.
        return postDTO;
    }

    /**
     * Método para convertir un usuario de entidad a DTO.
     *
     * @param usuario Usuario a convertir.
     * @return Usuario convertido en DTO.
     */
    public UsuarioDTO convertirUsuarioAUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = null;
        EstadoDTO estadoDTO = new EstadoDTO(usuario.getMunicipio().getEstado().getNombre());
        MunicipioDTO municipioDTO = new MunicipioDTO(usuario.getMunicipio().getNombre(), estadoDTO);
        if (usuario instanceof Normal) {
            usuarioDTO = new NormalDTO(
                    usuario.getNombres(),
                    usuario.getApellidoPaterno(),
                    usuario.getApellidoMaterno(),
                    usuario.getCorreo(),
                    usuario.getContrasenia(),
                    usuario.getTelefono(),
                    usuario.getNombreUsuario(),
                    usuario.getAvatar(),
                    usuario.getCiudad(),
                    usuario.getFechaNacimiento(),
                    usuario.getGenero(),
                    municipioDTO);
        } else {
            usuarioDTO = new AdministradorDTO(
                    usuario.getNombres(),
                    usuario.getApellidoPaterno(),
                    usuario.getApellidoMaterno(),
                    usuario.getCorreo(),
                    usuario.getContrasenia(),
                    usuario.getTelefono(),
                    usuario.getNombreUsuario(),
                    usuario.getAvatar(),
                    usuario.getCiudad(),
                    usuario.getFechaNacimiento(),
                    usuario.getGenero(),
                    municipioDTO);
        }

        return usuarioDTO;
    }

    private List<ComentarioDTO> convertirComentariosAComentariosDTO(List<Comentario> comentarios) {
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        if (comentarios == null || comentarios.isEmpty()) {
            return comentariosDTO;
        }
        for (Comentario comentario : comentarios) {
            comentariosDTO.add(convertirComentarioAComentarioDTO(comentario));
        }
        return comentariosDTO;
    }

    private ComentarioDTO convertirComentarioAComentarioDTO(Comentario comentario) {
        if (comentario == null) {
            return null;
        }
        ComentarioDTO comentarioDTO;
        comentarioDTO = new ComentarioDTO(
                comentario.getId(),
                comentario.getFechaHora(),
                comentario.getContenido(),
                convertirComentariosAComentariosDTO(comentario.getRespuestas()),
                (comentario.getRespuesta() != null) ? acortarComentarioDTO(comentario.getRespuesta()) : null,
                (comentario.getPost() != null) ? acortarPostDTO(comentario.getPost()) : null,
                (NormalDTO) convertirUsuarioAUsuarioDTO(comentario.getUsuario()));
        return comentarioDTO;
    }

    private ComentarioDTO acortarComentarioDTO(Comentario comentario) {
        ComentarioDTO comentarioCorto = new ComentarioDTO(
                comentario.getId(),
                comentario.getFechaHora(),
                comentario.getContenido(),
                (NormalDTO) convertirUsuarioAUsuarioDTO(comentario.getUsuario()));
        return comentarioCorto;
    }

    private PostDTO acortarPostDTO(Post post) {
        PostDTO postCorto = new PostDTO(
                post.getId(),
                post.getFechaHoraCreacion(),
                post.getContenido(),
                (NormalDTO) convertirUsuarioAUsuarioDTO(post.getUsuario()));
        return postCorto;
    }

    @Override
    public PostDTO obtenerPostID(Long id) throws FachadaException {
        try {
            Post post = postsDAO.obtenerPostPorID(id);

            PostDTO postDTO = convertirPostAPostDTO(post);

            if (postDTO.getTipoPost().equalsIgnoreCase("Comun")) {
                System.out.println("Comun");
            } else if (postDTO.getTipoPost().equalsIgnoreCase("Anclado")) {
                System.out.println("Anclado");
            } else {
                System.out.println("Ninguno");
            }
            return postDTO;
        } catch (PersistenciaException ex) {
            throw new FachadaException(ex.getMessage());
        }
    }

    @Override
    public ComentarioDTO obtenerComentarioID(Long id) throws FachadaException {
        try {
            Comentario comentario = comentariosDAO.obtenerComentario(id);

            return convertirComentarioAComentarioDTO(comentario);
        } catch (PersistenciaException ex) {
            throw new FachadaException(ex.getMessage());
        }
    }

    @Override
    public List<PostDTO> obtenerPostsPorUsuario(String correo) throws FachadaException {
        List<PostDTO> postsDTO = null;
        try {
            Usuario usuario = usuariosDAO.buscarUsuario(correo);

            // Se obtienen los posts.
            List<Post> posts = postsDAO.obtenerPostsUsuario(usuario);
            // Se convierten a DTO.
            postsDTO = convertirPostsAPostsDTO(posts);
        } catch (PersistenciaException ex) {
            throw new FachadaException(ex.getMessage());
        }
        return postsDTO;
    }

    @Override
    public void anclarPost(Long idPost, String correoAdmin) throws FachadaException {
        try {
            Post comun = null;
            try {
                comun = postsDAO.obtenerPostPorID(idPost);
                if (comun.getTipoPost().equalsIgnoreCase("Anclado")) {
                    throw new FachadaException("El post que trata de anclar ya está anclado.");
                }
                comun.setTipoPost("Anclado");
            } catch (ClassCastException cce) {
                throw new FachadaException("El post que trata de anclar ya está anclado.");
            }

            Administrador admin = (Administrador) usuariosDAO.buscarUsuario(correoAdmin);
            
            if (admin!=null) {
                 postsDAO.anclarPost(comun);
            }else{
                throw new FachadaException("No tiene permiso de anclar el post");
            }

           
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para desanclar un post anclado.
     *
     * @param idPost El id del post que se quiere desanclar.
     * @throws FacadeException Si el post que se quiere desanclar no es del tipo
     * anclado.
     */
    @Override
    public void desanclarPost(Long idPost) throws FachadaException {
        try {
            Post anclado = null;
            try {
                anclado = postsDAO.obtenerPostPorID(idPost);
            } catch (ClassCastException cce) {
                throw new FachadaException("El post que trata de desanclar no está anclado.");
            }

            Post comun = new Post(
                    anclado.getId(), "Comun", anclado.getFechaHoraCreacion(), anclado.getTitulo(), anclado.getSubtitulo(), anclado.getContenido(), anclado.getImagen(), anclado.getCategoria(), anclado.getComentarios(), anclado.getUsuario());

            postsDAO.desanclarPost(comun);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaException.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public Long obtenerUltimoPost() throws FachadaException {
        try {
            return postsDAO.obtenerUltimoPostPorUsuario();
        } catch (PersistenciaException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
