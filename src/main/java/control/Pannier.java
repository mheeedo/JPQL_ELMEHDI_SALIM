package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.Client;
import model.Commande;



/**
 * Servlet implementation class Pannier
 */

public class Pannier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pannier() {
       super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "music" );
		EntityManager em =emf.createEntityManager();
			
			String nom = new String("cookie_tp_mvc");
			String temp = new String();
			Cookie[] cookies = request.getCookies();
	        if ( cookies != null ) {
	            for ( Cookie cookie : cookies ) {
	                if ( cookie != null && nom.equals( cookie.getName() ) ) {
	                     temp=cookie.getValue();
	                   
	                     break;
	                }
	            }
	        }
	        if(request.getParameter("ref")!=null) {
	        	Query query = em.
					      createQuery("select c from Client c where c.email = :email");
				 query.setParameter("email", temp);
				 List<Client> list = (List<Client>)query.getResultList( );
				  query = em.
					      createQuery("select a from Article a where a.ref = :ref");
				 query.setParameter("ref", request.getParameter("ref"));
				 List<Article> list2 = (List<Article>)query.getResultList( );
				 
				 Commande commande = new Commande(list.get(0),list2.get(0));
				 em.getTransaction().begin();
					em.persist(commande);
					em.getTransaction().commit();
	        	
	        }
	      
	        Query query = em.
				      createQuery("Select ar.titre from Commande c join c.client cl join c.article ar where cl.email = :email");
			 query.setParameter("email", temp);
			 List<String> list = (List<String>)query.getResultList( );
	
			
			request.setAttribute("panneau", list);
			request.getRequestDispatcher("pannier.jsp").forward(request, response);
			
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
