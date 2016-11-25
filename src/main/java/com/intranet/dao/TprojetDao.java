package com.intranet.dao;


import com.intranet.beans.tprojet;

public interface TprojetDao {

	
	  /*********************************************************/
		/*******FONCTION POUR CREER UN NOUVELLE UTILISATEUR*******/
	    /*********************************************************/
		
		 void creer( tprojet tprojet ) throws DAOException;


		 /***********************************************************************/
	     /*******FONCTION POUR TROUVER DANS LA BDD UN NOUVELLE UTILISATEUR*******/
		 /***********************************************************************/
		 
		 tprojet trouver( tprojet nuproj ) throws DAOException;
		 
		 
}
