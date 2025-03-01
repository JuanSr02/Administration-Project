package DAO;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.annotations.processing.Find;
import org.hibernate.Hibernate;


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
            return (long) em.createNativeQuery("SELECT COUNT(*) FROM propiedad AS p WHERE p.duenio = :personaID OR p.inquilino = :personaID").setParameter("personaID", personaID)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }


    public PropiedadDAO getPropiedadConFotos(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            PropiedadDAO propiedad = em.find(PropiedadDAO.class, id);
            if (propiedad != null) {
                Hibernate.initialize(propiedad.getFotos()); // Forzar carga de fotos
            }
            return propiedad;
        } finally {
            em.close();
        }
    }

}

