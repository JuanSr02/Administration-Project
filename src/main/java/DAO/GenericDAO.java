package DAO;

import jakarta.persistence.*;
import java.util.List;

public class GenericDAO<T> {
    private final Class<T> entityClass;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T read(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public List<T> readAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public long contarPropiedadesPorPersona(int personaID) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT COUNT(*) FROM " + entityClass.getSimpleName() + " AS p WHERE p.duenio = :personaID OR p.inquilino = :personaID",
                            Long.class
                    ).setParameter("personaID", personaID)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
}

