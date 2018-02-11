package by.gorovtsov.alutask.dao;

import by.gorovtsov.alutask.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {
    protected static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    private  Class<T> entityClass;

    public BaseDao() {
        ParameterizedType parameterizedSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedSuperclass.getActualTypeArguments()[0];
    }

    public Long saveOrUpdate(T objectToSave, Session session) {

        session.saveOrUpdate(objectToSave);

        return objectToSave.getId();
    }

    public T findById(Long id, Session session) {

        T result = session.get(entityClass, id);
        return result;
    }

    public List<T> findAll() {
        Session session = SESSION_FACTORY.openSession();
        String simpleClassName = entityClass.getSimpleName();

        List<T> result = session.createQuery("select o from " + simpleClassName + " o", entityClass)
                .getResultList();
        return result;
    }

    public void delete(T objectToDelete, Session session) {
        String simpleClassName = entityClass.getSimpleName();
        session.beginTransaction();
        session.createQuery("delete from " + simpleClassName + " o where o.id = :entityId")
                .setParameter("entityId", objectToDelete.getId())
                .executeUpdate();

        session.getTransaction().commit();
    }
}