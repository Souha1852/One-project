package IHM;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TestEvents extends JFrame implements ActionListener,MouseListener{
	JPanel pan = new JPanel();
	JPanel subpan = new JPanel();
	JLabel login = new JLabel("Entrez le mot de passe: ");
	JLabel bienvenue = new JLabel("Bienvenue sur le site issatso officiel");
	JLabel mdp = new JLabel("   Mot de passe oublié ? ");
	JLabel contact = new JLabel("   Contactez nous");
	String again = "           Veillez saisir un mot de passe !!";
	String left1 = "           Reéssayez !! Une seule tentative restante!!";
	String left2 = "           Reéssayez !!  Deux tentatives restantes !!";
	JLabel warningHolder = new JLabel();
	JTextField password = new JTextField(15);
	ImageIcon icon = new ImageIcon("C:/images/background.png");
	Image image = icon.getImage();
	Image img = image.getScaledInstance(500,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon new_icon = new ImageIcon(img);
	JLabel background = new JLabel(new_icon);
	JButton  entrer = new JButton("       Entrer        ");
	int compteur = 0;
 TestEvents(){
	this.setTitle("Login Here!");
	this.setBounds(400,80,600,600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	bienvenue.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,30));
	login.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,30));
	password.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,30));
	entrer.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,30));
	mdp.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,25));
	contact.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,25));
	password.setToolTipText("Tapez le mot de passe correspondant");
	pan.setLayout(new FlowLayout());
	warningHolder.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,20));
	warningHolder.setForeground(Color.red);
    pan.add(background);
    pan.add(bienvenue);
    pan.add(login);	
	pan.add(password);
	pan.add(entrer);
	pan.add(warningHolder);
	subpan.setLayout(new BoxLayout(subpan,BoxLayout.PAGE_AXIS));
	subpan.add(mdp);
	subpan.add(contact);
	mdp.addMouseListener(this);
	contact.addMouseListener(this);
	entrer.addActionListener(this);
    this.add(pan,BorderLayout.CENTER);
    this.add(subpan,BorderLayout.SOUTH);
	this.setVisible(true);
	
}
	public void actionPerformed(ActionEvent e) {
		JButton source= (JButton) e.getSource();
		String str =password.getText();
		if (source == entrer ) {  
			 if(str.equals("") ) {
				 warningHolder.setText(again);}
		     else if (str.equals("issatso")== false ) {
		    	 compteur ++ ; 
		    	 this.remove(pan);
		    	 if (compteur ==1) {
		    		 password.setText("");
		    		 warningHolder.setText(left2);}
		    	 if (compteur ==2) {
		    		 password.setText("");
		    		 warningHolder.setText(left1);}
		    	 if (compteur == 3 ) {
		    		 JOptionPane.showMessageDialog(null,"Accèes bloqué !!");
		    		 System.exit(0);}
        	     this.add(pan);
        	     this.setVisible(true);}
		     else if (str.equals("issatso")== true ) {
		    	 JOptionPane.showMessageDialog(null,"Vous avez pu acceder au site officiel issatso !!");
		    	GestionProfil gp = new GestionProfil();
		    	 this.setVisible(false);
		     }
	}
	}


public void mouseClicked(MouseEvent e) {
	

}

public void mouseEntered(MouseEvent e) {
	JLabel source= (JLabel) e.getSource();
    source.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,35));
    source.setForeground(Color.blue); 
}
public void mouseExited(MouseEvent e) {
	JLabel source= (JLabel) e.getSource();
    source.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,30));
    source.setForeground(Color.darkGray); 	
}
public void mousePressed(MouseEvent e) {
	
	
}
public void mouseReleased(MouseEvent e) {
	
}
public static void main(String[] args) {
	TestEvents t = new TestEvents();
}
}
