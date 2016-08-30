/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Countries;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.*;

@ManagedBean(name ="coutrycontroller")
@SessionScoped
public class CountryController {
    
    private List<Countries> lst = new ArrayList<Countries>();

    public List<Countries> getLst() {
        
        CountryiesDao dao = new CountryiesDao();
        
        return dao.getAll();
    }

    public void setLst(List<Countries> lst) {
        this.lst = lst;
    }
    
    private Countries country = new Countries();

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }
    
    public void remove(Countries co){
        CountryiesDao dao = new CountryiesDao();
        dao.delete(co);
    }
    
    public String insert(){
        CountryiesDao dao = new CountryiesDao();
        dao.save(country);
        return "index";
    }
}
