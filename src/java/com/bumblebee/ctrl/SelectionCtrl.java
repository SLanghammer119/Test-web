/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;

import com.bumblebee.model.Article;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Stefanie Langhammer
 */
@Named
@SessionScoped
public class SelectionCtrl implements Serializable{
    
    @Inject
    ArticleCtrl articleCtrl;
    
    private Article selectedarticle;
    
    private List<Article> selectedList;

    public SelectionCtrl() {
    }
    
    @PostConstruct
    public void init(){
        selectedarticle = new Article();
        selectedList = new ArrayList<>();
  
    }

    public Article getSelectedarticle() {
        return selectedarticle;
    }

    public void setSelectedarticle(Article selectedarticle) {
        this.selectedarticle = selectedarticle;
    }

    public List<Article> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Article> selectedList) {
        this.selectedList = selectedList;
    }

    public void fillselectedList (String cat){
        selectedList = articleCtrl.getArticleMap().get(cat);
//        System.out.println("SelectedList(" + cat + "): " + selectedList.size());
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("details.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SelectionCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    
    
    
    
    
    
}
