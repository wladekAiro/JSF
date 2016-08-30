/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author wladek
 */
import entities.*;
import java.util.List;
import org.hibernate.Session;

public class CountryiesDao extends BaseDao {
    
    Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();

    public CountryiesDao() {
    }

    public Countries create(Countries co) {

        save(co);

        return co;
    }

    public void delete(Countries co) {
        try{
            session.beginTransaction();
            session.delete(co);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public Countries updtate(Countries co) {

       try{
            session.beginTransaction();
            session.update(co);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return co;
    }

    public List<Countries> getAll() {
        return getResultList(getEntityManager().createQuery("FROM Countries c"), 0, 10);
    }
    
    
    public void save(Countries co){
        try{
            session.beginTransaction();
            session.save(co);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
