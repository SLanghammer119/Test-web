package com.bumblebee.servlet;


import java.io.IOException;
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
 *
 */
@WebServlet("/image")
public class ImageServletPhoto extends HttpServlet {
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
				emf.createEntityManager().createQuery(
					"select i.photo "
					+ "from Article i "
					+ "where i.articleno = :articleno");
			query.setParameter(
				"articleno", articleno);
					
			byte[] photo = 
				(byte[]) query.getSingleResult();
			response.reset();
			response.getOutputStream().write(photo);
		} catch(Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
}
