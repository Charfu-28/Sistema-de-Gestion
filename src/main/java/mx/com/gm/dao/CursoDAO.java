package mx.com.gm.dao;

import java.util.List;
import javax.persistence.Query;
import mx.com.gm.domain.Curso;

public class CursoDAO extends GenericDAO {

    public List<Curso> listar() {
        String hql = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
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

    public void modificar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);  //Sincroniza el estado del objeto con la BD
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

    public void eliminar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso));  //Sincroniza el estado del objeto con la BD
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

    public Object buscarCurso(Curso curso) {
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());
    }
}
