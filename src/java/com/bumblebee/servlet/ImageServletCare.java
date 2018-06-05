/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stefanie Langhammer
 */
@WebServlet("/imageCare")
public class ImageServletCare extends HttpServlet {

    private static final long serialVersionUID = 1L;
	
	@PersistenceUnit(name = "Onlineshop_BumblebeePU")
	private EntityManagerFactory emf;
        
		
        @Override
	protected void doGet(
    	HttpServletRequest request, 
    	HttpServletResponse response)
        throws ServletException, IOException {

    	try {
    		String articleno = 
    			request.getParameter("articleno");	
			Query query = 
				emf.createEntityManager().createQuery("SELECT c.carephoto FROM Care c INNER JOIN c.articles a where a.articleno = :articleno");
					
			query.setParameter(
				"articleno", articleno);
					
			byte[] carephoto = 
				(byte[]) query.getSingleResult();
			response.reset();
			response.getOutputStream().write(carephoto);
		} catch(Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
}
