/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import Exception.PersistenciaException;
import com.mycompany.modelo.Estado;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IEstadoDAO {
    
        public List<Estado> obtenerEstados() throws PersistenciaException;

}
