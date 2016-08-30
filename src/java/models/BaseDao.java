/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wladek
 */
public class BaseDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("wladek");

    @PersistenceContext
    public EntityManager getEntityManager() {

        return emf.createEntityManager();

    }

    public void save(Object entity) {
        getEntityManager().persist(entity);
    }

    public void delete(Object entity) {
        getEntityManager().remove(entity);
    }
    
     public void merge(Object entity) {
		getEntityManager().merge(entity);
	}

    public <T> List<T> getResultList(Query query, Integer offSet, Integer limit) {
        List<T> values = null;

        if (limit == null || offSet == null) {
            values = query.getResultList();
        } else {
            values = query.setFirstResult(offSet).setMaxResults(limit).getResultList();
        }

        return values;
    }

    public <T> T getById(Class<T> clazz, int id) {

        return getEntityManager().find(clazz, id);
    }

    public <T> T getSingleResultOrNull(Query query) {
        T value = null;
        try {
            value = (T) query.getSingleResult();
        } catch (Exception e) {
            if (!(e instanceof NoResultException)) {
                e.printStackTrace();
            }

        }

        return value;
    }
}
