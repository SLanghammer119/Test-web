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
import java.util.List;
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

    private Article article;
    private List<Article> articles;
    private List<Article> accessoires;
    private List<Article> dresses;
    private List<Article> tops;
    private List<Article> shoes;

    private List<Article> sunglasses;
    private List<Article> parfume;
    private List<Article> bags;

    private List<Article> business;
    private List<Article> casual;
    private List<Article> maxi;
    private List<Article> party;

    private List<Article> blouses;
    private List<Article> pullover;
    private List<Article> shirts;
    private List<Article> tunics;

    private List<Article> boots;
    private List<Article> pumps;
    private List<Article> highheels;
    private List<Article> sneaker;
    
    private List<Article> selectedList;

    
    public ArticleCtrl() {
        this.articles = new ArrayList<>();
        this.accessoires = new ArrayList<>();
        this.dresses = new ArrayList<>();
        this.tops = new ArrayList<>();
        this.shoes = new ArrayList<>();

        this.sunglasses = new ArrayList<>();
        this.parfume = new ArrayList<>();
        this.bags = new ArrayList<>();

        this.business = new ArrayList<>();
        this.casual = new ArrayList<>();
        this.maxi = new ArrayList<>();
        this.party = new ArrayList<>();

        this.blouses = new ArrayList<>();
        this.pullover = new ArrayList<>();
        this.shirts = new ArrayList<>();
        this.tunics = new ArrayList<>();

        this.blouses = new ArrayList<>();
        this.pullover = new ArrayList<>();
        this.shirts = new ArrayList<>();
        this.tunics = new ArrayList<>();

        this.boots = new ArrayList<>();
        this.pumps = new ArrayList<>();
        this.highheels = new ArrayList<>();
        this.sneaker = new ArrayList<>();

    }

    @PostConstruct
    public void fillArticles() {
        this.articles = databaseBean.getAllArticles();
        this.accessoires = databaseBean.getOnePrimecategory("Accessoires");
        this.dresses = databaseBean.getOnePrimecategory("Kleider");
        this.tops = databaseBean.getOnePrimecategory("Oberteile");
        this.shoes = databaseBean.getOnePrimecategory("Schuhe");

        this.sunglasses = databaseBean.getOneSubcategory("Brillen");
        this.parfume = databaseBean.getOneSubcategory("Parfume");
        this.bags = databaseBean.getOneSubcategory("Taschen");

        this.business = databaseBean.getOneSubcategory("Business");
        this.casual = databaseBean.getOneSubcategory("Casual");
        this.maxi = databaseBean.getOneSubcategory("Maxikleider");
        this.party = databaseBean.getOneSubcategory("Party");

        this.business = databaseBean.getOneSubcategory("Blusen");
        this.casual = databaseBean.getOneSubcategory("Pullover");
        this.maxi = databaseBean.getOneSubcategory("Shirts");
        this.party = databaseBean.getOneSubcategory("Tunika");

        this.boots = databaseBean.getOneSubcategory("Boots");
        this.pumps = databaseBean.getOneSubcategory("Pumps");
        this.highheels = databaseBean.getOneSubcategory("High Heels");
        this.sneaker = databaseBean.getOneSubcategory("Sneaker");

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(List<Article> accessoires) {
        this.accessoires = accessoires;
    }

    public List<Article> getDresses() {
        return dresses;
    }

    public void setDresses(List<Article> dresses) {
        this.dresses = dresses;
    }

    public List<Article> getTops() {
        return tops;
    }

    public void setTops(List<Article> tops) {
        this.tops = tops;
    }

    public List<Article> getShoes() {
        return shoes;
    }

    public void setShoes(List<Article> shoes) {
        this.shoes = shoes;
    }

    public List<Article> getSunglasses() {
        return sunglasses;
    }

    public void setSunglasses(List<Article> sunglasses) {
        this.sunglasses = sunglasses;
    }

    public List<Article> getParfume() {
        return parfume;
    }

    public void setParfume(List<Article> parfume) {
        this.parfume = parfume;
    }

    public List<Article> getBags() {
        return bags;
    }

    public void setBags(List<Article> bags) {
        this.bags = bags;
    }

    public List<Article> getBusiness() {
        return business;
    }

    public void setBusiness(List<Article> business) {
        this.business = business;
    }

    public List<Article> getCasual() {
        return casual;
    }

    public void setCasual(List<Article> casual) {
        this.casual = casual;
    }

    public List<Article> getMaxi() {
        return maxi;
    }

    public void setMaxi(List<Article> maxi) {
        this.maxi = maxi;
    }

    public List<Article> getParty() {
        return party;
    }

    public void setParty(List<Article> party) {
        this.party = party;
    }

    public List<Article> getBlouses() {
        return blouses;
    }

    public void setBlouses(List<Article> blouses) {
        this.blouses = blouses;
    }

    public List<Article> getPullover() {
        return pullover;
    }

    public void setPullover(List<Article> pullover) {
        this.pullover = pullover;
    }

    public List<Article> getShirts() {
        return shirts;
    }

    public void setShirts(List<Article> shirts) {
        this.shirts = shirts;
    }

    public List<Article> getTunics() {
        return tunics;
    }

    public void setTunics(List<Article> tunics) {
        this.tunics = tunics;
    }

    public List<Article> getBoots() {
        return boots;
    }

    public void setBoots(List<Article> boots) {
        this.boots = boots;
    }

    public List<Article> getPumps() {
        return pumps;
    }

    public void setPumps(List<Article> pumps) {
        this.pumps = pumps;
    }

    public List<Article> getHighheels() {
        return highheels;
    }

    public void setHighheels(List<Article> highheels) {
        this.highheels = highheels;
    }

    public List<Article> getSneaker() {
        return sneaker;
    }

    public void setSneaker(List<Article> sneaker) {
        this.sneaker = sneaker;
    }

    public List<Article> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Article> selectedList) {
        this.selectedList = selectedList;
    }
    
    
    
    

}
