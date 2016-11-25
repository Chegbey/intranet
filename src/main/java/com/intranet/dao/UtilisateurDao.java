package com.intranet.dao;

import com.intranet.beans.Utilisateur;

public interface UtilisateurDao {
	
	
	
    /*********************************************************/
	/*******FONCTION POUR CREER UN NOUVELLE UTILISATEUR*******/
    /*********************************************************/
	
	 void creer( Utilisateur utilisateur ) throws DAOException;


	 /***********************************************************************/
     /*******FONCTION POUR TROUVER DANS LA BDD UN NOUVELLE UTILISATEUR*******/
	 /***********************************************************************/
	 
	 Utilisateur trouver( String email ) throws DAOException;
	 
	 

	   
	 
}


