package com.intranet.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.intranet.beans.tprojet;
import com.intranet.projet.Projets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Page
 */
@WebServlet("/Page")
public class Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public static final String ACCES_PUBLIC     = "/";
    public static final String ACCES_RESTREINT  = "/WEB-INF/page.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_PROJETS = "projets";
   
    private ArrayList<tprojet> projets = Projets.getprojets();
    private JsonArray jsonprojets = Projets.JSONprojets();
	private String json = new Gson().toJsonTree(projets).toString();
	
    public Page() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {

        /* Récupération d'une instance  */
    	ArrayList<tprojet> projets = Projets.getprojets();
        JsonArray jsonprojets = Projets.JSONprojets();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Récupération de la session depuis la requète */
		
        HttpSession session = request.getSession();
        
        ArrayList<tprojet> projets = Projets.getprojets();
		
        JsonArray jsonprojets = Projets.JSONprojets();
        
        request.setAttribute("json", json);
		request.setAttribute( "projets" , projets );
		request.setAttribute("jsonprojets", jsonprojets);
        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        } else {
            /* Affichage de la page restreinte */
            this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
	}

	
	
	public static JsonArray JSONprojets()
	{
		ArrayList<tprojet> projets = Projets.getprojets();
		JsonArray jsonprojets = new Gson().toJsonTree(projets).getAsJsonArray();
		return jsonprojets;
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayList<tprojet> projets = Projets.getprojets();
		JsonArray jsonprojets = Projets.JSONprojets();
		String json = new Gson().toJsonTree(projets).toString();
		/*for ( JsonElement projet : jsonprojets)
		{
			//System.out.println(projets.indexOf(projet));
			//System.out.println(projets.get(projets.indexOf(projet)).getnuproj());
			System.out.println(projet);
		}
		
		String nuproj = jsonprojets.get(0).getAsJsonObject().get("nuproj").toString();
		
		for(int i=0; jsonprojets.size() > i ; i++)
		{
			System.out.println(jsonprojets.get(1).getAsJsonObject().get("nuproj").toString());
			System.out.println(jsonprojets.get(1).getAsJsonObject());
		}*/
		
		System.out.println(json);
		
	}
	
}
