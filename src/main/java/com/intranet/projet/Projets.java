package com.intranet.projet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.intranet.beans.tprojet;
import com.intranet.dao.*;

import java.sql.*;
import java.util.ArrayList;


public class Projets {
     
	

	public static ArrayList<tprojet> getprojets()
	{
		ArrayList<tprojet> projet = new ArrayList<tprojet>();
	      
		try {
		      Class.forName("org.postgresql.Driver");
		      
	
		      String url = "jdbc:postgresql:intranet";
		      String user = "intranet";
		      String passwd = "postgres";
	          
		      
		      
		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      
		      
		      //Création d'un objet Statement
	
		      
	         Statement state_projet = conn.createStatement();
	        
		      //L'objet ResultSet contient le résultat de la requête SQL
	
		      
	         ResultSet result_projet = state_projet.executeQuery("SELECT * FROM tprojet;");
	        
		      //On récupère les MetaData
	
		     
	         ResultSetMetaData resultMeta_projet = result_projet.getMetaData();
		  
	        /*********************************************************************************************************************************/
	        /***********************************STOCKAGE DES VALEURS DANS DES TABLEAUX********************************************************/
	      
	         while (result_projet.next())
		       {
		    	  tprojet proj = new tprojet();
		    	  
			      for (int i=1; i < resultMeta_projet.getColumnCount(); i++)
			      {
			    	      	
			        	switch (resultMeta_projet.getColumnName(i).toUpperCase()) {
			     
			        	   case "NUPROJ" :
			    	 
			    	        	  proj.setnuproj(result_projet.getObject(i).toString());
			                      break;
			     	          
			               case "LIBECO" : 
			            	  
			            	     proj.setlibeco(result_projet.getObject(i).toString());
			                     break;
			    	           
			               case "LIBELO": 
			            	   
			            		  proj.setlibelo(result_projet.getObject(i).toString());
			                      break;
			            	   
			               case "SECTEU": 
			            	   
			            		  proj.setsecteu(result_projet.getObject(i).toString());
			                      break;
			     	           
			               case "MAPROJ": 
			            	   
			            		  proj.setmaproj(result_projet.getObject(i).toString());
			                      break;
			     	           
			               case "AUDEVI":
			            	   
			            		  proj.setaudevi(result_projet.getObject(i).toString());
			                      break;
			     	           
			               case "DEMAND": 
			            	   
			            		  proj.setdemand(result_projet.getObject(i).toString());
			                      break;
			     	           
			            	   
			              default : 
			    		  
			             }
		  	           }
		            projet.add(proj);
	                }

       
        
	          result_projet.close();
		      
	
		      state_projet.close();
		    
		         
			  } catch (Exception e) {
			      e.printStackTrace();
			  } 
				return projet;
		}
	
	public static ArrayList<tprojet> getprojetscroissant()
	{
		ArrayList<tprojet> projet = getprojets(); 
		
		
		
		
		
		
		return projet;
	}
	
	public static JsonArray JSONprojets()
	{
		ArrayList<tprojet> projets = getprojets();
		JsonArray jsonprojets = new Gson().toJsonTree(projets).getAsJsonArray();
		
		
		return jsonprojets;
	}
	
	public static void recherche()
	{
	  	
	}
	
}

