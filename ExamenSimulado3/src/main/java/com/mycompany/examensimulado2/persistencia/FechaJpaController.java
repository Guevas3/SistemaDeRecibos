

package com.mycompany.examensimulado2.persistencia;

import com.mycompany.examensimulado2.modelo.Fecha;
import com.mycompany.examensimulado2.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author mauro
 */
public class FechaJpaController implements Serializable {

    public FechaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public FechaJpaController() {
        emf = Persistence.createEntityManagerFactory("persisJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fecha fecha) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(fecha);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fecha fecha) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            fecha = em.merge(fecha);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = fecha.getIdFecha();
                if (findFecha(id) == null) {
                    throw new NonexistentEntityException("The fecha with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fecha fecha;
            try {
                fecha = em.getReference(Fecha.class, id);
                fecha.getIdFecha();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fecha with id " + id + " no longer exists.", enfe);
            }
            em.remove(fecha);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fecha> findFechaEntities() {
        return findFechaEntities(true, -1, -1);
    }

    public List<Fecha> findFechaEntities(int maxResults, int firstResult) {
        return findFechaEntities(false, maxResults, firstResult);
    }

    private List<Fecha> findFechaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fecha.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Fecha findFecha(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fecha.class, id);
        } finally {
            em.close();
        }
    }

    public int getFechaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fecha> rt = cq.from(Fecha.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
