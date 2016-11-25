package com.intranet.forms;

import com.intranet.beans.Utilisateur;
import com.intranet.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public class InscriptionForm {

	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_CONF   = "confirmation";
    private static final String CHAMP_NOM    = "nom";
    private  Boolean email_valid = null;
    private  Boolean pass_valid = null;
    private  Boolean conf_valid = null;
    private  Boolean nom_valid = null;
    private  Boolean inscription_valid = false;
    
    private String resultat;

    private Map<String, String> erreurs = new HashMap<String, String>(); /*Déclaration des erreurs*/
    private UtilisateurDao utilisateurDao; /*Déclaration d'un utilisateur*/

    /*********************************************************************************************************************************/
    /*********************************************************GET*********************************************************************/
    
    public Boolean getemail_valid(){
    	return email_valid;
    }
    
    public Boolean getpass_valid(){
    	return pass_valid;
    }
    
    public Boolean getconf_valid(){
    	return conf_valid;
    }
    
    public Boolean getnom_valid(){
    	return nom_valid;
    }
    
    public Boolean getinscription_valid(){
    	return inscription_valid;
    }
    
    public InscriptionForm( UtilisateurDao utilisateurDao ) {
        this.utilisateurDao = utilisateurDao;
    }
    
    public String getResultat() 
    {
        return resultat;
    }


    public Map<String, String> getErreurs() 
    {
        return erreurs;
    }
    
    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {

        String email = getValeurChamp( request, CHAMP_EMAIL );

        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        String confirmation = getValeurChamp( request, CHAMP_CONF );

        String nom = getValeurChamp( request, CHAMP_NOM );


        Utilisateur utilisateur = new Utilisateur();


        try 
        {
            traiterEmail( email, utilisateur);
        } 
        catch ( Exception e ) 
        {
           setErreur( CHAMP_EMAIL, e.getMessage() );
           
        }

        utilisateur.setEmail( email );


        try {
            traiterEmail( email, utilisateur );
            traiterMotsDePasse( motDePasse, confirmation, utilisateur );
            traiterNom( nom, utilisateur );

            if ( erreurs.isEmpty() ) {
                utilisateurDao.creer( utilisateur );
                resultat = "Succès de l'inscription.";
                inscription_valid = true;
            } else {
                resultat = "Échec de l'inscription.";
            }
        } catch ( DAOException e ) {
            resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return utilisateur;
    }
    
    
    
    
    private void traiterEmail( String email, Utilisateur utilisateur ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
            
        }
        utilisateur.setEmail( email );
       
    }

    /*
     * Appel à la validation des mots de passe reçus, chiffrement du mot de
     * passe et initialisation de la propriété motDePasse du bean
     */
    private void traiterMotsDePasse( String motDePasse, String confirmation, Utilisateur utilisateur ) {
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
            
        }
        
        utilisateur.setMotDePasse( motDePasse);
        
    }
    
        /*
         * Appel à la validation du nom reçu et initialisation de la propriété nom
         * du bean
         */
        private void traiterNom( String nom, Utilisateur utilisateur ) {
            try {
                validationNom( nom );
            } catch ( FormValidationException e ) {
                setErreur( CHAMP_NOM, e.getMessage() );
                
            }
            utilisateur.setNom( nom );
           
        }
    
    
    
    
    
    
    
    
    
    
    
        /* Validation de l'adresse email */
        private void validationEmail( String email ) throws FormValidationException {
            if ( email != null ) {
                if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                	email_valid = false;
                    throw new FormValidationException( "Merci de saisir une adresse mail valide." );   
                } else if ( utilisateurDao.trouver( email ) != null ) {
                	email_valid = false;
                    throw new FormValidationException( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
                }
            } else {
            	email_valid = false;
                throw new FormValidationException( "Merci de saisir une adresse mail." );
            }
            if ( email != null && email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) && utilisateurDao.trouver( email ) == null )
            {
            	email_valid = true;
            }
        }

        /* Validation des mots de passe */
        private void validationMotsDePasse( String motDePasse, String confirmation ) throws FormValidationException {
            if ( motDePasse != null && confirmation != null ) {
                if ( !motDePasse.equals( confirmation ) ) {
                	pass_valid = false;
                	conf_valid = false;
                    throw new FormValidationException( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
                } else if ( motDePasse.length() < 3 ) {
                	pass_valid = false;
                    throw new FormValidationException( "Les mots de passe doivent contenir au moins 3 caractères." );
                }
            } else {
            	pass_valid = false;
            	conf_valid = false;
                throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
            }
           
            if (motDePasse != null && confirmation != null && motDePasse.length() >= 3 && motDePasse.equals( confirmation ) )
            {
            	pass_valid = true;
            	conf_valid = true;
            }
        }

        /* Validation du nom */
        private void validationNom( String nom ) throws FormValidationException {
            if ( nom != null && nom.length() < 3 ) {
            	nom_valid = false;
                throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
            }
            else if (  nom != null && nom.length() >= 3 )
            {
            	nom_valid = true;
            }
        }

        /*
         * Ajoute un message correspondant au champ spécifié à la map des erreurs.
         */
        private void setErreur( String champ, String message ) {
            erreurs.put( champ, message );
        }

        /*
         * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
         * sinon.
         */
        private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
            String valeur = request.getParameter( nomChamp );
            if ( valeur == null || valeur.trim().length() == 0 ) {
                return null;
            } else {
                return valeur;
            }
        }
}