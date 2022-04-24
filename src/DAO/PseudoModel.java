package DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.table.AbstractTableModel;

import IHM.GestionProfil;
import OO.Person;
public class PseudoModel extends AbstractTableModel {
	
	ResultSetMetaData rsmd=null;
    ArrayList<Object[]> data=new ArrayList<Object[]>();
    public PseudoModel(ResultSet rs) {
		try {
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				
				Object[]ligne=new Object[rsmd.getColumnCount()];
				for(int i=0;i<ligne.length;i++)
				{
					ligne[i]=rs.getObject(i+1);
				}	
				
					data.add(ligne);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object  getValueAt(int l, int c) {
		// TODO Auto-generated method stub
		return data.get(l)[c];
	}
	public int addElement(Person p) {
		PersonManager mp = new PersonManager();
		 int a=mp.AjouterPersonne(p);
		 if(a>0)
		 {System.out.println("Ajout dans data avec succes ");
		 Object lignes[]= new Object[1];
		  lignes[0]=p.getPseudo();
		  data.add(lignes);
		  this.fireTableDataChanged();
		 
		  }
		 else {System.out.println("Erreur d'ajout dans data .");}
		 return a;
		 }
	
	
	public void setValueAt(Object val, int l, int c) {
		
		  PersonManager mp= new PersonManager();
	
		      int a = mp.Modifier(""+data.get(l)[c], ""+ val );
		      System.out.println(val);
		      System.out.println(l);
		      System.out.println(c);
			  if(a>0)
			  { data.get(l)[c]=val;
			  System.out.println("Ajout dans data avec succes ");
			   }
			  else{System.out.println("Erreur d'ajoutans data.");
			  }
		      
		  
	     data.get(l)[c]=val;
		 this.fireTableDataChanged();
		}
	public void supprimer (int ligne) {
		PersonManager pm= new PersonManager();
		pm.Supprimer(""+data.get(ligne)[0]);
		data.remove(ligne);
	    this.fireTableDataChanged();//rafraishissement
	
	}
	public void supprimerall () {
		PersonManager pm= new PersonManager();
		int a=pm.SupprimerTous();
		data.clear();
	    this.fireTableDataChanged();//rafraishissement
	
	}
	public int renommerLigne(int ligne,String value, String nouveau) {
		
		// TODO Auto-generated method stub
		PersonManager pm= new PersonManager();
		int a = pm.Modifier(value, nouveau);
		if (a>0) {this.setValueAt(nouveau, ligne, 0);}
		this.fireTableDataChanged();
		return a;
	}
}



