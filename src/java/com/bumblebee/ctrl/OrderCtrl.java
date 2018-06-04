/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;


import com.bumblebee.model.Order;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Stefanie Langhammer
 */
@Named
@SessionScoped
public class OrderCtrl implements Serializable{
    

    private Order order;
    
    @Inject
    ShoppingCartCtrl shoppingCartCtrl;

    public OrderCtrl() {
        order = new Order();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShoppingCartCtrl getShoppingCartCtrl() {
        return shoppingCartCtrl;
    }

    public void setShoppingCartCtrl(ShoppingCartCtrl shoppingCartCtrl) {
        this.shoppingCartCtrl = shoppingCartCtrl;
    }
    
    
    
    
    
    
    public void createPdf() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        try {
            ctx.getExternalContext().redirect(request.getContextPath() + "/generate/orderPdf.pdf");
        } catch (IOException ex) {
            Logger.getLogger(OrderCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
