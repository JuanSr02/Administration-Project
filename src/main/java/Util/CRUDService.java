package Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CRUDService<T> {
    private final Class<T> type;

    public CRUDService(Class<T> type) {
        this.type = type;
    }

    public void create(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    public T read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(type, id);
        }
    }

    public List<T> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM " + type.getName(), type).list();
        }
    }

    public void update(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    public void delete(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }
}

