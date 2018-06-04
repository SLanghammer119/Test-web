/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.util;

import com.bumblebee.ctrl.ShoppingCartCtrl;
import com.bumblebee.model.Customer;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Stefanie Langhammer
 */
@FacesValidator(value = "postcodeValidator")
public class PostcodeValidator implements Validator {

    @Inject
    ShoppingCartCtrl shoppingCtrl;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        Customer person = shoppingCtrl.getShoppingcart().getCustomer();

        System.out.println("Komponente:" + component.getClientId());

        String key = "postcodeFailed";

        String pattern = "^(?:[Dd]\\s*[- --]?\\s*)?[0-9]{5}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value.toString());
        if (!m.matches()) {
            throw new ValidatorException(getMessage(key, context));
        }
    }

    private FacesMessage getMessage(String key, FacesContext context) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
        FacesMessage fmsg = new FacesMessage(bundle.getString(key));

        return fmsg;
    }

}
