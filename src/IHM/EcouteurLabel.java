package IHM;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

class EcouteurLabel extends MouseAdapter	{

	GestionProfil f;
	public EcouteurLabel(GestionProfil f) {
		this.f=f;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==f.lblnom)
		f.lblnom.setForeground(Color.red);	
		if(e.getSource()==f.lblprenom)
			f.lblprenom.setForeground(Color.red);
		if(e.getSource()==f.lblpseudo)
			f.lblpseudo.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==f.lblnom)
		f.lblnom.setForeground(null);
		if(e.getSource()==f.lblprenom)
		f.lblprenom.setForeground(null);
		if(e.getSource()==f.lblpseudo)
		f.lblpseudo.setForeground(null);
	}
}