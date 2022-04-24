package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable.DropLocation;

import DAO.PersonManager;
import OO.Person;

public class EcouteurJTable  implements MouseMotionListener{
  GestionProfil gp;
	public EcouteurJTable(GestionProfil gp) {
    this.gp=gp;
}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override

		
		public void mouseMoved(MouseEvent e) {
			System.out.println("");
			 if(e.getSource() == gp.pseudos) 

			 {   
				 int index = gp.pseudos.rowAtPoint(e.getPoint());
		              if( index>-1 ) {
		            	  
		        	  PersonManager pm= new PersonManager();
		              Person  p=pm.Recherche(gp.pseudos.getValueAt(index, 0)+"");
		              gp.pseudos.setToolTipText(p.getNom()+" "+p.getPrenom());
			
					
					}
		         
		        
		         } }}

	


