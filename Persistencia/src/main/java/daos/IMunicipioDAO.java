/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import Exception.PersistenciaException;
import com.mycompany.modelo.Municipio;
import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IMunicipioDAO {
 
        public List<Municipio> obtenerMunicipios() throws PersistenciaException;

}
