package com.intranet.dao;


import com.intranet.beans.tprojet;

import java.sql.*;
import java.util.Calendar;

import static com.intranet.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.intranet.dao.DAOUtilitaire.initialisationRequetePreparee;



public class TprojetDaoImpl implements TprojetDao {

	private static final String SQL_SELECT_PAR_NUPROJ = "SELECT nuproj, libeco, libelo, secteu, maproj, audevi, demand FROM tprojet WHERE nuproj = ?;";
	private static final String SQL_INSERT           = "INSERT INTO tprojet (libeco, libelo, secteu, maproj, audevi, demand) VALUES('?', '?', '?', '?', '?', '?');";

    private DAOFactory          daoFactory;

    public TprojetDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	@Override
	public tprojet trouver(tprojet nuproj) throws DAOException {
		
		return trouver(SQL_SELECT_PAR_NUPROJ, nuproj);
		
	}

	@Override
	public void creer(tprojet tprojet) throws DAOException {
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        Calendar today = Calendar.getInstance();
	    String annee = today.get(Calendar.YEAR) + "" ;
	    String yy = "";
	    
        for (int i=2; annee.length() > i; i++)
        {
        	yy += annee.charAt(i);
        }
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, tprojet.getlibeco(), tprojet.getlibelo(), tprojet.getsecteu(), tprojet.getaudevi(), tprojet.getdemand() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                tprojet.setnuproj( yy + valeursAutoGenerees.getString( 001 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun nuproj auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
	}
	
	private tprojet trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        tprojet tprojet = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement une adresse email) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            if ( resultSet.next() ) {
            	tprojet = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return tprojet;
	}
    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static tprojet map( ResultSet resultSet ) throws SQLException {
    	tprojet tprojet = new tprojet();
    	tprojet.setnuproj(resultSet.getString("nuproj"));
    	tprojet.setlibeco( resultSet.getString( "libeco" ) );
    	tprojet.setlibelo( resultSet.getString( "libelo" ) );
    	tprojet.setsecteu( resultSet.getString( "secteu" ) );
    	tprojet.setmaproj( resultSet.getString( "maproj" ) );
    	tprojet.setaudevi( resultSet.getString("audevi"));
    	tprojet.setdemand( resultSet.getString("demand"));
        return tprojet;
    }

}
