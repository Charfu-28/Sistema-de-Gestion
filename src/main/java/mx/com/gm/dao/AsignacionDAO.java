package mx.com.gm.dao;

import java.util.List;
import javax.persistence.Query;
import mx.com.gm.domain.Asignacion;

public class AsignacionDAO extends GenericDAO {

    public List<Asignacion> listar() {
        String hql = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void modificar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);  //Sincroniza el estado del objeto con la BD
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void eliminar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));  //Sincroniza el estado del objeto con la BD
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public Object buscarAsignacion(Asignacion asignacion) {
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }
}
