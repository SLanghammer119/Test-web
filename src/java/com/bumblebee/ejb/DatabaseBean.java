/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ejb;


import com.bumblebee.model.Article;
import com.bumblebee.model.Articlesize;
import com.bumblebee.model.Customer;
import com.bumblebee.model.Primecategory;
import com.bumblebee.model.Subcategory;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stefanie Langhammer
 */
@Stateless
public class DatabaseBean implements Serializable{

 @PersistenceContext(name = "Onlineshop_BumblebeePUM")
    private EntityManager emanag;

    public DatabaseBean() {
    }


  
    public void saveRegister(Customer customer) {
        if (customer.getCustid()!= 0) {

        } else {
            emanag.persist(customer);
        }
    }
    
    public List<Article> getAllArticles() {
        Query q = emanag.createNamedQuery("Article.findAll", Article.class);
        return q.getResultList();
    }    
    
    public List<Article> getOnePrimecategory(String primename){
        Query q = emanag.createNamedQuery("Articles.findByPrimecategory", Article.class);
        q.setParameter("primename", primename);
        return q.getResultList();
    }
    
    
    public List<Article> getOneSubcategory(String subcategory){
        Query q = emanag.createNamedQuery("Articles.findBySubcategory", Article.class);
        q.setParameter("subcatname", subcategory);
        return q.getResultList();
    }
    
    public List<Article> getAllAccessoires(String primename){
        Query q = emanag.createNamedQuery("Articles.findByPrimecategory", Article.class);
        q.setParameter("primename", primename);
        return q.getResultList();
    }
    
    public Customer getCustomer(String email) {
        Query q = emanag.createNamedQuery("Customer.findByEmail", Customer.class);
        q.setParameter("email", email);
        return (Customer) q.getSingleResult();
    }
    
    public List<Articlesize> getAllSizes(){
        Query q = emanag.createNamedQuery("Articlesize.findAll", Articlesize.class);
        return q.getResultList();
    }
    



}

