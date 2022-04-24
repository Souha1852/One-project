package DAO;
import OO.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import IHM.GestionProfil;

public class PersonManager {
	Connection c =Connexion.getConnection();
	public int AjouterPersonne(Person p) {
		int a = 0;
		String rq = "insert into profilp(pseudo, nom, prenom) values (?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(rq);

			ps.setString(1, p.getPseudo());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());

			a = ps.executeUpdate();

			System.out.println("Ajout avec succées....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Pseudo deja existant !!! ");
		}
		return a;
	}
	public int Modifier(String pseudo, String nvpseudo) {
		// TODO Auto-generated method stub
		int a=0;
		
		String rq = "UPDATE profilp set pseudo = ? where pseudo = ?";
		try {
			PreparedStatement ps = c.prepareStatement(rq);
			ps.setString(2, pseudo);
			ps.setString(1, nvpseudo);
           
			a=ps.executeUpdate();

			System.out.println("Modification avec success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Pseudo deja existant !!! ");
		}
		return a;
	}
	public int Supprimer(String pseudo) {
		int a = 0;
		String rq = "DELETE from profilp where pseudo = ?";

		try {
			PreparedStatement ps = c.prepareStatement(rq);

			ps.setString(1, pseudo);

			a = ps.executeUpdate();

			System.out.println("suppression avec success...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de suppression. " + e.getMessage());
		}
		return a;
	}
	
	public int SupprimerTous() {
		int a = 0;
		String rq = "DELETE  from profilp";

		try {
			Statement st = c.createStatement();

			a =st.executeUpdate(rq);

			System.out.println("suppression de " + a + " personne avec success...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur de suppression. " + e.getMessage());
		}
		return a;
	}
	
	public Person Recherche(String pes) {
		Person p=null;
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("Select * from profilp where pseudo='"+pes+"'");
			if(rs.next()) {
				p = new Person(rs.getString("pseudo"), rs.getString("prenom"), rs.getString("nom"));
				System.out.println("Personne trouvée avec succès...");
			} else {
				System.out.println("Pas de personne avec ce pseudo!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur lors de la recherche!! "+e.getMessage());
		}
		return p;
	}
	public ResultSet getallPersonne(){
		// selection
		try {Statement st = c.createStatement();
			ResultSet rs =st.executeQuery("select pseudo from profilp");
			
			System.out.println("selection de toutes les personnes avec succées...");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur du  de selection!! "+e.getMessage());
			return null;
		}
	}

	public ResultSet getAllUser(String req) {
		ResultSet rs = null;
		try {Statement st = c.createStatement();
			rs = st.executeQuery(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
