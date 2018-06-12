/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;

import com.bumblebee.ejb.DatabaseBean;
import com.bumblebee.model.Article;
import com.bumblebee.model.Articlesize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Stefanie Langhammer
 */
@Named
@ApplicationScoped
public class ArticleCtrl implements Serializable {

    @EJB
    DatabaseBean databaseBean;

    private List<Article> articles;
    private List<Article> accessoires;

    private Map<String, List<Article>> articleMap;

    public ArticleCtrl() {
        articleMap = new HashMap<>();

        this.articles = new ArrayList<>();
        this.accessoires = new ArrayList<>();
    }

    @PostConstruct
    public void fillArticles() {
        this.articles = databaseBean.getAllArticles();
        
//        this.accessoires = databaseBean.getOnePrimecategory("Accessoires");

        articleMap.put("Accessoires", databaseBean.getOnePrimecategory("Accessoires"));
        articleMap.put("Kleider", databaseBean.getOnePrimecategory("Kleider"));
        articleMap.put("Oberteile", databaseBean.getOnePrimecategory("Oberteile"));
        articleMap.put("Schuhe", databaseBean.getOnePrimecategory("Schuhe"));

        articleMap.put("Brillen", databaseBean.getOneSubcategory("Brillen"));
        articleMap.put("Parfüm", databaseBean.getOneSubcategory("Parfüm"));
        articleMap.put("Taschen", databaseBean.getOneSubcategory("Taschen"));
        articleMap.put("Business", databaseBean.getOneSubcategory("Business"));
        articleMap.put("Casual", databaseBean.getOneSubcategory("Casual"));
        articleMap.put("Maxikleider", databaseBean.getOneSubcategory("Maxikleider"));
        articleMap.put("Party", databaseBean.getOneSubcategory("Party"));
        articleMap.put("Blusen", databaseBean.getOneSubcategory("Blusen"));
        articleMap.put("Pullover", databaseBean.getOneSubcategory("Pullover"));
        articleMap.put("Shirts", databaseBean.getOneSubcategory("Shirts"));
        articleMap.put("Tunika", databaseBean.getOneSubcategory("Tunika"));
        articleMap.put("Boots", databaseBean.getOneSubcategory("Boots"));
        articleMap.put("High Heels", databaseBean.getOneSubcategory("High Heels"));
        articleMap.put("Pumps", databaseBean.getOneSubcategory("Pumps"));
        articleMap.put("Sneaker", databaseBean.getOneSubcategory("Sneaker"));

        accessoires = articleMap.get("Accessoires");

        
    }

    public Map<String, List<Article>> getArticleMap() {
        return articleMap;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public DatabaseBean getDatabaseBean() {
        return databaseBean;
    }

    public void setDatabaseBean(DatabaseBean databaseBean) {
        this.databaseBean = databaseBean;
    }

    public List<Article> getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(List<Article> accessoires) {
        this.accessoires = accessoires;
    }

    public void setArticleMap(Map<String, List<Article>> articleMap) {
        this.articleMap = articleMap;
    }

   

}
