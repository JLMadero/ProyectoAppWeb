/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia;

import Conexion.Conexion;
import Conexion.IConexion;
import Exception.FachadaException;
import Exception.PersistenciaException;
import Factory.AbstractDAOFactory;
import Factory.DAOFactory;
import com.mycompany.dto.ComentarioDTO;
import com.mycompany.dto.ComunDTO;
import com.mycompany.dto.EstadoDTO;
import com.mycompany.dto.MunicipioDTO;
import com.mycompany.dto.NormalDTO;
import com.mycompany.dto.PostDTO;
import com.mycompany.dto.UsuarioDTO;
import com.mycompany.modelo.Administrador;
import com.mycompany.modelo.CategoriaPost;
import com.mycompany.modelo.Estado;
import com.mycompany.modelo.Municipio;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import fachada.Fachada;
import fachada.IFachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author jl4ma
 */
public class Persistencia {

    public static void main(String[] args) throws FachadaException, PersistenciaException {
         // Instancia de la fachada
        Fachada fachada = new Fachada();
        Calendar fecha = Calendar.getInstance();

        // Probar registrarUsuario
//        UsuarioDTO nuevoUsuario = new UsuarioDTO("jose luis", "madero", "lopez", "madero@gmail.com", "123", "6441393608", "Madero", "foto", "obregon", fecha, "masculino", new MunicipioDTO("cajeme", new EstadoDTO("Sonora")));
//        fachada.registrarUsuario(nuevoUsuario);
//        System.out.println("Usuario registrado: " + (fachada.obtenerUsuario("madero@gmail.com")));

        
      
        // Probar para el inicio de sesion
        UsuarioDTO usuarioBuscado = fachada.obtenerUsuario("madero@gmail.com", "123");
//        System.out.println("Usuario encontrado: " + (usuarioBuscado != null ? usuarioBuscado : "No encontrado"));
        
        
        //publicar post
//        fachada.publicarPost(new ComunDTO(fecha, "omg", "", "asfasfaff", "FENOMENO", usuarioBuscado, "FOTO"));
//        
//        System.out.println(fachada.obtenerPostID(2L));
//        
//        //comentar post
//        fachada.comentarPost(new ComentarioDTO(fecha, "afasfasf", new ComentarioDTO(), new NormalDTO("madero@gmail.com", "Madero")), fachada.obtenerPostID(6L));

//        System.out.println(fachada.obtenerComentarioID(1L));
//        
//        //eliminar comentario
//        fachada.eliminarComentario(new ComentarioDTO(6L, fecha, "", new NormalDTO("", "")), usuarioBuscado);

            //eliminar post
//            fachada.eliminarPost(5L, usuarioBuscado);

            // comentar comentario
//            fachada.responderComentario(new ComentarioDTO(fecha, "asfasf", fachada.obtenerPostID(6L), new NormalDTO("madero@gmail.com", "Madero")), fachada.obtenerComentarioID(8L));
       
            //anclar
//              IConexion conexion = new Conexion();
//                 AbstractDAOFactory fabrica = new DAOFactory(conexion);
//                 fabrica.getUsuarioDAO().registrarUsuario(new Administrador("maderito@", "a", "b", "c", "Made", "123", "1", "foto", "obre", fecha, "m", new Municipio(1L, "ASASF", new Estado("afaf"))));
                 
//            fachada.anclarPost(1L, "maderito@");
//            fachada.desanclarPost(4l);

                //obtener post por categoria
//                List<PostDTO> postCategoria = new ArrayList<>();
//               postCategoria =  fachada.obtenerPostsPorCategoria(CategoriaPost.FENOMENOS);
//               for(PostDTO categoria: postCategoria){
//                   if (categoria!=null) {
//                       System.out.println(categoria);
//                   }
//               }

                //obtener post por usuario
//                List<PostDTO> post = new ArrayList<>();
//                post = fachada.obtenerPostsPorUsuario("madero@gmail.com");
//                for(PostDTO p: post){
//                    if(p!=null){
//                        System.out.println(p);
//                    }
//                }
                
        
    }
}
