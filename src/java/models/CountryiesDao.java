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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class CountryiesDao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("wladek"); 

    public EntityManager getEntityManager(){

        return emf.createEntityManager();

    }
    
    public CountryiesDao(){
        
    }
    
    public List<Countries> getAll(){
        return getResultList(getEntityManager().createQuery("FROM Countries c") , 0 , 10);
    }
    
    public <T> List<T> getResultList(Query query,Integer offSet, Integer limit){
		List<T> values = null;
		
		if(limit==null || offSet==null){
			values = query.getResultList();
		}else{
			values = query.setFirstResult(offSet).setMaxResults(limit).getResultList();
		}
		
		return values;
	}
}
