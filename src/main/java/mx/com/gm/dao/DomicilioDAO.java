package mx.com.gm.dao;

import java.util.List;
import javax.persistence.Query;
import mx.com.gm.domain.Domicilio;

public class DomicilioDAO extends GenericDAO {

    public List<Domicilio> listar() {
        String hql = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertar(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
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

    public void modificar(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);  //Sincroniza el estado del objeto con la BD
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

    public void eliminar(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));  //Sincroniza el estado del objeto con la BD
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

    public Object buscarDomicilio(Domicilio domicilio) {
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
}
