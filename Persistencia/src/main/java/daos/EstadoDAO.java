/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.IConexion;
import Exception.PersistenciaException;
import com.mycompany.modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author jl4ma
 */
public class EstadoDAO implements IEstadoDAO {
    
    private IConexion conexion;
    
    public EstadoDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Estado> obtenerEstados() throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
            TypedQuery<Estado> query = entityManager.createQuery(criteria);

            List<Estado> estados = query.getResultList();

            return estados;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron consultar los estados.");
        } finally {
            entityManager.close();
        }
    }
    
}
