package com.intranet.bdd;

import com.intranet.beans.tprojet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Connect {

	public static void main(String[] args) {      
	    try {
	      Class.forName("org.postgresql.Driver");
	      System.out.println("Driver O.K.");

	      String url = "jdbc:postgresql:intranet";
	      String user = "intranet";
	      String passwd = "postgres";
          
	      
	      ArrayList<String> tnuproj = new ArrayList<String>();
	      ArrayList<String> tlibeco = new ArrayList<String>();
	      ArrayList<String> tlibelo = new ArrayList<String>();
	      ArrayList<String> tsecteu = new ArrayList<String>();
	      ArrayList<String> tmaproj = new ArrayList<String>();
	      ArrayList<String> taudevi= new ArrayList<String>();
	      ArrayList<String> tdemand= new ArrayList<String>();
	      
	      ArrayList<tprojet> projet= new ArrayList<tprojet>();
	      
	      Connection conn = DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion effective !");
	      
	      //Création d'un objet Statement

	      Statement state = conn.createStatement();
          Statement state_projet = conn.createStatement();
          
	      //L'objet ResultSet contient le résultat de la requête SQL

	      ResultSet result = state.executeQuery("SELECT * FROM utilisateur;");
          ResultSet result_projet = state_projet.executeQuery("SELECT * FROM tprojet;");
          
	      //On récupère les MetaData

	      ResultSetMetaData resultMeta = result.getMetaData();
          ResultSetMetaData resultMeta_projet = result_projet.getMetaData();
	         

	      System.out.println("\n****************************************************************************************************************************************");

	      //On affiche le nom des colonnes

	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)

	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

	         

	      System.out.println("\n****************************************************************************************************************************************");

	         

	      while(result.next()){         

	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)

	        
	          System.out.print("\t" + result.getObject(i).toString() + " - " + i + " - " +"\t |");

	            

	        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------");


	      }
	      
	     
	  /*    while (result_projet.next())
	  	  {
	          tlibeco.add(result_projet.getObject(2).toString());
	  	  }  
          for ( String libeco : tlibeco)
          {
        	  System.out.println(libeco);
          }  */
          
	      /*********************************************************************************************************************************/
	      /***********************************STOCKAGE DES VALEURS DANS DES TABLEAUX********************************************************/
	      
	      System.out.println(resultMeta_projet.getColumnCount());
	      while (result_projet.next())
	      {
	    	  tprojet proj = new tprojet();
	    	  
		      for (int i=1; i < resultMeta_projet.getColumnCount(); i++)
		      {
		    	  
		    	   // System.out.print(resultMeta_projet.getColumnName(i).toUpperCase() + " | " + i +" |" + " * ");    	
		        	switch (resultMeta_projet.getColumnName(i).toUpperCase()) {
		     
		              
		              
		        	   case "NUPROJ" :
		    	 
		    	         
		    	        	  proj.setnuproj(result_projet.getObject(i).toString());
		                      tnuproj.add(result_projet.getObject(i).toString());
		                      break;
		     	          
		               case "LIBECO" : 
		            	  
		            	  
		            	   
		            	     proj.setlibeco(result_projet.getObject(i).toString());
		                     tlibeco.add(result_projet.getObject(i).toString());
		                     break;
		    	           
		            	  
		               case "LIBELO": 
		            	   
		            	  
		            		  proj.setlibelo(result_projet.getObject(i).toString());
		                      tlibelo.add(result_projet.getObject(i).toString());
		                      break;
		     	          
		            	   
		               case "SECTEU": 
		            	   
		            	   
		            		  proj.setsecteu(result_projet.getObject(i).toString());
		                      tsecteu.add(result_projet.getObject(i).toString());
		                      break;
		     	           
		            	   
		               case "MAPROJ": 
		            	   
		            	   
		            		  proj.setmaproj(result_projet.getObject(i).toString());
		                      tmaproj.add(result_projet.getObject(i).toString());
		                      break;
		     	           
		            	   
		               case "AUDEVI":
		            	   
		            	   
		            		  proj.setaudevi(result_projet.getObject(i).toString());
		                      taudevi.add(result_projet.getObject(i).toString());
		                      break;
		     	           
		            	   
		               case "DEMAND": 
		            	   
		            	  
		            		  proj.setdemand(result_projet.getObject(i).toString());
		                      tdemand.add(result_projet.getObject(i).toString());
		                      break;
		     	           
		            	   
		            default : 
		    		
		            
		         }
		        	
	  	       }
		      projet.add(proj);
	     }
	      /*********************************************************************************************************************************/
	      /******************************************AFFICHAGE DES PROJETS******************************************************************/
	      
	      for (int i=0; i < projet.size() ; i++)
	      {
	    	 
	    	  System.out.println("Projet n°" + i + " : " + projet.get(i).getnuproj() + " | " + projet.get(i).getlibeco() + " | " + projet.get(i).getlibelo() + " | " +  projet.get(i).getsecteu() + " | " +  projet.get(i).getmaproj() + " | " +  projet.get(i).getaudevi() + " | " +  projet.get(i).getdemand());
	    	 
	      }
	      
	      
          
         
          
          result_projet.close(); 
	      result.close();

	      state_projet.close();
	      state.close();
	         
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	   
	    
	    String date = "";
	    
	    Calendar today = Calendar.getInstance();
	    String nuproj = today.get(Calendar.YEAR) + "001" ;
	    System.out.println(nuproj.length());
	    for ( int i=0; nuproj.length() > i; i++)
	    {
	    	date += nuproj.charAt(i);
	    	System.out.println(i);
	    	System.out.println("date : " + date);
	    	
	    }
	    System.out.println(nuproj);
	    System.out.println(date);
	  }
	
}
