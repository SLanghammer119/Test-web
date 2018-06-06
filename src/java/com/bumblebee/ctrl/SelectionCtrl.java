/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;

import com.bumblebee.model.Article;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Stefanie Langhammer
 */
@Named
@SessionScoped
public class SelectionCtrl implements Serializable{
    
    private Article selectedarticle;
    
    private String option ="";

    public SelectionCtrl() {
    }
    
    @PostConstruct
    public void init(){
        selectedarticle = new Article();
  
    }

    public Article getSelectedarticle() {
        return selectedarticle;
    }

    public void setSelectedarticle(Article selectedarticle) {
        this.selectedarticle = selectedarticle;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
    
    
    
    
    
    
}
