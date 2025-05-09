

package com.mycompany.examensimulado2.persistencia;

import com.mycompany.examensimulado2.modelo.Recibo;
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
public class ReciboJpaController implements Serializable {

    public ReciboJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ReciboJpaController() {
        emf = Persistence.createEntityManagerFactory("persisJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recibo recibo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recibo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recibo recibo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recibo = em.merge(recibo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = recibo.getIdComprobante();
                if (findRecibo(id) == null) {
                    throw new NonexistentEntityException("The recibo with id " + id + " no longer exists.");
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
            Recibo recibo;
            try {
                recibo = em.getReference(Recibo.class, id);
                recibo.getIdComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recibo with id " + id + " no longer exists.", enfe);
            }
            em.remove(recibo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recibo> findReciboEntities() {
        return findReciboEntities(true, -1, -1);
    }

    public List<Recibo> findReciboEntities(int maxResults, int firstResult) {
        return findReciboEntities(false, maxResults, firstResult);
    }

    private List<Recibo> findReciboEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recibo.class));
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

    public Recibo findRecibo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recibo.class, id);
        } finally {
            em.close();
        }
    }

    public int getReciboCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recibo> rt = cq.from(Recibo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
