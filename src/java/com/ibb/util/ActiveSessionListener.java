/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Stefanie Langhammer
 */
@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static Map<String, HttpSession> mySession = new HashMap<>();

    public static Map<String, HttpSession> getMySession() {
        return mySession;
    }

    public static void setMySession(Map<String, HttpSession> mySession) {
        ActiveSessionListener.mySession = mySession;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        mySession.put(se.getSession().getId(), se.getSession());
        System.out.println("Aktuelle Sitzung:" + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        mySession.remove(se.getSession().getId());
        System.out.println("Gelöschte Sitzung:" + se.getSession().getId());

    }

}
