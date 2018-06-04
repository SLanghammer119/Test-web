/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;

import com.bumblebee.model.Article;
import com.bumblebee.model.Shoppingcart;
import com.bumblebee.model.Shoppingitem;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stefanie Langhammer
 */
@Named
@SessionScoped
public class ShoppingCartCtrl implements Serializable{
    
    private Shoppingcart shoppingcart;
//    private LookUpMDBean lookUpMDBean;
    private String errorMessage;
    private Collection<HttpSession> mySessions;

    @Inject
    ArticleCtrl articles;

    @Inject
    LogCtrl logCtrl;

    public ShoppingCartCtrl() {
    }


    @PostConstruct
    public void init() {
//        lookUpMDBean = new LookUpMDBean();
        shoppingcart = new Shoppingcart();
        if (logCtrl.getCustomer() != null) {
            shoppingcart.setCustomer(logCtrl.getCustomer());          
        }
    }

  
    public Double getTotal() {
        double total = 0.0;
        for (Shoppingitem s : shoppingcart.getShoppingitems()) {
            total = total + s.getTotalLine();
        }
        shoppingcart.setTotal(total);
        return total;
    }

//    public Collection<HttpSession> getMySessions() {
//        return ActiveSessionListener.getMySession().values();
//    }

    public void deleteArticle(Article a) {
        Shoppingitem shopitem = new Shoppingitem(a);
        int size = shoppingcart.getShoppingitems().size();
        if (shoppingcart.getShoppingitems().size() > 0) {
            for (int i = 0; i < size; i++) {
                if (shopitem.getArticle().getArticleno() == shoppingcart.getShoppingitems().get(i).getArticle().getArticleno()) {
                    shoppingcart.getShoppingitems().get(i).setNumber(-1 + shoppingcart.getShoppingitems().get(i).getNumber());
                    if (shoppingcart.getShoppingitems().get(i).getNumber() <= 0) {
                        shoppingcart.getShoppingitems().remove(i);
                    }
                }
            }
        }
    }
    

    public void addArticle(Article a) {
        boolean found = false;
        Shoppingitem shopitem = new Shoppingitem(a);
        int size = shoppingcart.getShoppingitems().size();
        if (shoppingcart.getShoppingitems().size() > 0) {
            for (int i = 0; i < size; i++) {
                if (shopitem.getArticle().getArticleno() == shoppingcart.getShoppingitems().get(i).getArticle().getArticleno()){
                    shoppingcart.getShoppingitems().get(i).setNumber(1 + shoppingcart.getShoppingitems().get(i).getNumber());
                    found = true;
                }
            }
            if (!found) {
                shopitem.setNumber(1);
                shoppingcart.getShoppingitems().add(shopitem);
            }
        } else {
            shopitem.setNumber(1);
            shoppingcart.getShoppingitems().add(shopitem);
        }
    }
    
    

//    public String foundCustomerDB() {
//        orderTotal.setPerson(lookUpDataBeanRemote().getCustomer((orderTotal.getPerson().getEmail())));
//        return "customerData";
//    }


//
//    public void finishOrder() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        try {
//            ipdAndSession();
//            // menuBean.setMenuDB();
//            lookUpMDBean.lookUpMDBeanRemote(orderTotal);
////        lookUpDataBeanRemote().saveOrder(orderTotal);
//            context.addMessage(null, new FacesMessage("Bestellung erfolgreich abgeschlossen"));
//        } catch (Exception e) {
//            Logger.getLogger(OrderBean.class.getName()).log(Level.SEVERE, null, e);
//            context.addMessage(null, new FacesMessage("Leider ist Ihre Bestellung fehlgeschlagen"));
//        }
//    }

//    public void ipdAndSession() {
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        shoppingcart.setSessionId((String) context.getSessionId(true));
//        HttpServletRequest request = (HttpServletRequest) context.getRequest();
//        shoppingcart.setIpAdress(request.getRemoteAddr());
//    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Shoppingcart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(Shoppingcart shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

    public ArticleCtrl getArticles() {
        return articles;
    }

    public void setArticles(ArticleCtrl articles) {
        this.articles = articles;
    }

    public LogCtrl getLogCtrl() {
        return logCtrl;
    }

    public void setLogCtrl(LogCtrl logCtrl) {
        this.logCtrl = logCtrl;
    }
    
    

}
