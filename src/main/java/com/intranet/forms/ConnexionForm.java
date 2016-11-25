package com.intranet.forms;

import com.intranet.beans.Utilisateur;
import com.intranet.dao.UtilisateurDaoImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public final class ConnexionForm {

    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_USER = "user";
    public  Boolean connexion = false;
    private String resultat;
    private Utilisateur utilisateur;
    private UtilisateurDaoImpl utilisateurdaoimpl;
    private Map<String, String> erreurs  = new HashMap<String, String>();


    public String getResultat() 
    {
      return resultat;
    }


    public Map<String, String> getErreurs() 
    {
       return erreurs;
    }


    public Utilisateur connecterUtilisateur( HttpServletRequest request ) 
    {
        /* R�cup�ration des champs du formulaire */

        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String user = getValeurChamp( request, CHAMP_USER);
        Utilisateur utilisateur = new Utilisateur();


        /* Validation du champ email. */

        try 
        {
           validationEmail( email );
        } 
        catch ( Exception e )
        {
           setErreur( CHAMP_EMAIL, e.getMessage() );
        }

        utilisateur.setEmail( email );


        /* Validation du champ mot de passe. */

        try 
        {
          validationMotDePasse( motDePasse );

        } 
        catch ( Exception e ) 
        {
          setErreur( CHAMP_PASS, e.getMessage() );
        }

        utilisateur.setMotDePasse( motDePasse );
        
       /* try {
        	validationmailMotDePasse(email, motDePasse);
        }
        catch ( Exception e)
        {
        	setErreur( CHAMP_USER, e.getMessage() );
        	
        } */
        
        /* Initialisation du r�sultat global de la validation. */

        if ( erreurs.isEmpty() ) 
        {
           resultat = "Succès de la connexion.";
           connexion = true;
        } 
        else 
        {
           resultat = "échec de la connexion.";
           connexion = false;
        }

        return utilisateur;
        

    }


    /**

     * Valide l'adresse email saisie.

     */

    private void validationEmail( String email ) throws Exception {

        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) 
        {
           throw new Exception( "Merci de saisir une adresse mail valide." );
        }

    }


    /**

     * Valide le mot de passe saisi.

     */

    private void validationMotDePasse( String motDePasse ) throws Exception {

        if ( motDePasse != null ) 
        {
            if ( motDePasse.length() < 3 ) 
            {
               throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }

        } 
        else 
        {
           throw new Exception( "Merci de saisir votre mot de passe." );
        }
        

    }

   private void validationmailMotDePasse(String email,String motDePasse) throws Exception {
	
	   if (utilisateurdaoimpl.trouver(email) == utilisateur)
	   {
		   throw new Exception("La saisie est mauvaise.");
	   }
   }
    /*

     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.

     */

    private void setErreur( String champ, String message ) {

        erreurs.put( champ, message );

    }


    /*

     * M�thode utilitaire qui retourne null si un champ est vide, et son contenu

     * sinon.

     */

    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {

        String valeur = request.getParameter( nomChamp );

        if ( valeur == null || valeur.trim().length() == 0 ) 
        {
          return null;
        } 
        else 
        {
          return valeur;
        }

    }

}
