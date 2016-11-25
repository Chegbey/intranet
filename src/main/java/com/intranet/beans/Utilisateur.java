package com.intranet.beans;

import java.sql.Timestamp;

public class Utilisateur {

	private Long   id;
	private String email;
    private String motDePasse;
    private String nom;
    private Timestamp dateInscription;
    
    /**************************************************************************************************************/
    /********************GET ET SET pour modifier et récupérer l'id de la table utilisateur************************/
    
    public Long getId() {

        return id;

    }
    public void setId( Long id ) {

        this.id = id;

    }

    /**************************************************************************************************************/
    /********************GET ET SET pour modifier et récupérer l'email de la table utilisateur************************/
    
    public void setEmail(String email) {
	this.email = email;
    }
    public String getEmail() {
	return email;
    }
    
    /*************************************************************************************************************************/
    /********************GET ET SET pour modifier et récupérer le mot de passe de la table utilisateur************************/
    
    public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
	return motDePasse;
    }
    
    /****************************************************************************************************************/
    /********************GET ET SET pour modifier et récupérer le nom de la table utilisateur************************/
    
    public void setNom(String nom) {
	this.nom = nom;
    }
    public String getNom() {
	return nom;
    }
    
    /********************************************************************************************************************************/
    /********************GET ET SET pour modifier et récupérer lla date d'inscription de la table utilisateur************************/
    public Timestamp getDateInscription() {

        return dateInscription;

    }
    public void setDateInscription( Timestamp dateInscription ) {

        this.dateInscription = dateInscription;

    }
}
