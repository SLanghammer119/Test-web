/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Stefanie Langhammer
 */
@Named
@SessionScoped
public class LocaleCtrl implements Serializable{
    
    private Locale locale;

    public LocaleCtrl() {
        locale = new Locale("de");
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public void changeLanguage(String lang){
        locale = new Locale(lang);
    }
    
}
