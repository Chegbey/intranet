package com.intranet.servlets;

import com.intranet.beans.*;
import com.intranet.dao.*;
import com.intranet.forms.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String CONF_DAO_FACTORY = "daofactory";

    /**
     * Default constructor. 
     */
    public Inscription() {
        // TODO Auto-generated constructor stub
    }

    private UtilisateurDao     utilisateurDao;


    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InscriptionForm form = new InscriptionForm(utilisateurDao);
		
		request.setAttribute( "form", form );
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Pr�paration de l'objet formulaire */

        InscriptionForm form = new InscriptionForm(utilisateurDao);

        

        /* Appel au traitement et � la validation de la requ�te, et r�cup�ration du bean en r�sultant */

        Utilisateur utilisateur = form.inscrireUtilisateur( request );

       
        
        /* Stockage du formulaire et du bean dans l'objet request */

        request.setAttribute( ATT_FORM, form );

        request.setAttribute( ATT_USER, utilisateur );
	    

        
        if ( form.getinscription_valid() == true)
        {
        	//this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );
        	response.sendRedirect("/intranet/connexion");
        }
        else
        {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward( request, response );
            
        }
  }
	
}
