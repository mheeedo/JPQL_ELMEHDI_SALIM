package control;

import java.io.IOException;
import java.io.PrintWriter;
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



/**
 * Servlet implementation class Connexion
 */

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 response.setContentType("text/html");
		 String error = new String("label.def");
	    
			
			
	    	 
	    		EntityManagerFactory emf =Persistence.createEntityManagerFactory( "music" );
	    		EntityManager em =emf.createEntityManager();
	    		 Query query = em.
	    			      createQuery("Select c from Client c  where c.email = :email and c.mdp = :mdp");
	    		 query.setParameter("email", request.getParameter("email"));
	    		 query.setParameter("mdp",(long)request.getParameter("mdp").hashCode()) ;
	    		 
	    		 List<Object[]> list = (List<Object[]>)query.getResultList( );
	    		 
	    		 if(list.isEmpty()) {
	    			 error = "label.elogin";
					request.setAttribute("error", error);
					request.getRequestDispatcher("connecter.jsp").forward(request, response);}
	    		 else {
				Cookie cookie = new Cookie("cookie_tp_mvc", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				Cookie cookie2 = new Cookie("cookie_tp_mvc", request.getParameter("email"));
				response.addCookie(cookie2);
				request.getRequestDispatcher("acceuil.jsp").forward(request, response);
			
			
				
			
			}
			
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
