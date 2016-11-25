package com.intranet.servlets;

import com.intranet.beans.Utilisateur;
import com.intranet.forms.ConnexionForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    
    
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Préparation de l'objet formulaire */

        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requète et récupération du bean en résultant */

        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requète */

        HttpSession session = request.getSession();

        String email = request.getParameter ("email");
        /**

         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean

         * Utilisateur � la session, sinon suppression du bean de la session.

         */

        if ( form.getErreurs().isEmpty() ) {

            session.setAttribute( ATT_SESSION_USER, utilisateur );
            
        } else {

            session.setAttribute( ATT_SESSION_USER, null );

        }


        /* Stockage du formulaire et du bean dans l'objet request */

        request.setAttribute( ATT_FORM, form );

        request.setAttribute( ATT_USER, utilisateur );

        if (form.connexion != true)
        {
        this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );
        }
        else
        {
        	response.sendRedirect("/intranet/accueil");
        }
        
	}

}
