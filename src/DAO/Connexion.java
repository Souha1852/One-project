package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Connexion {
	
	// Params de la connexion
		private static String url= "jdbc:mysql://127.0.0.1:3306/gestionprofil";
		private static String user= "root";
		private static String passwd= "";

		private static Connection cn = null;
	
	



	// Constructeur privé pour limiter l'instanciation
    private Connexion() {
    	// Etape 1: Chargement driver
    			try {
    				Class.forName("com.mysql.jdbc.Driver");
    				System.out.println("driver chargé...");
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				System.out.println("erreur chargement. "+e.getMessage());
    			}
    	
    	
    	try { 
			cn = DriverManager.getConnection(url, user, passwd);
			System.out.println("connexion établie....");
		} 
		catch ( Exception e ) {
			e.printStackTrace();  
		}
	}
 // On n'instancie la connexion que si le cn est different de null
 	public static Connection getConnection() {
 		if (cn == null) {
 			new Connexion();
 		}
 		return cn;
 	}
 	// Méthode de fermeture de la connexion
 	public static void Fermer() {
 		if (cn != null) {
 			try {  cn.close(); }
 			catch (SQLException e) { 
 				e.printStackTrace();  
 			}
 		}
 	}
 }


		
	
		


