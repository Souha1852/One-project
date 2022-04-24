package IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EcouteurHelp implements MouseMotionListener {
	GestionProfil gp;
	public EcouteurHelp(GestionProfil gp) {
	 this.gp=gp;
	
	
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {

		if(e.getSource()==gp.tfnom) {
			gp.lhelp.setText("HELP : Saisissez le nom de famille de la personne");
		}
		else if(e.getSource()==gp.tfprenom) {
			gp.lhelp.setText("HELP : Saisissez le prénom de la carte d'identité de la personne");
		}
		else if(e.getSource()==gp.tfpseudo) {
			gp.lhelp.setText("HELP : Propozez un pseudonyme de la personne de votre choix");
		}
		else
			{gp.lhelp.setText("HELP : ");
			}	
	}

}
