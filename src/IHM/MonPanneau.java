package IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import FICHIER.FileHTML;
import OO.Person;

public class MonPanneau extends JPanel implements ItemListener ,ActionListener{
	
	JLabel lblbienvenue,choix;
	JPanel pdifficulte ,op,pbtn,pcenter,diff1 ,diff2;
	JButton btnvalider;
	Border lineborder;
	String niveau []= {"Debutant","Intermidiaire","professionel"};
	JCheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7,son,score,Plein ,ombre;
	JComboBox niv;
	String ch,nom="",prenom="";
	int i=0;
   GestionProfil gp;

	public MonPanneau( GestionProfil gp ,String prenom,String nom) {
		this.gp=gp;
		
		
		
		
		this.setLayout(new BorderLayout());
        
       //ajout du mot bienvenue suivie par prenom nom avec ses modifications:
		lblbienvenue= new JLabel("Bienvenue" + " "+prenom+" "+nom);
		lblbienvenue.setFont(new Font("Imprint MT Shadow",Font.CENTER_BASELINE,50));
		lblbienvenue.setForeground(Color.white);
		lblbienvenue.setHorizontalAlignment(JLabel.CENTER);
		
		lblbienvenue.setOpaque(true);
		lblbienvenue.setBackground(Color.DARK_GRAY);
		
		pdifficulte = new JPanel();
		pdifficulte.setBorder(BorderFactory.createTitledBorder("Difficulté: "));
		pdifficulte.setPreferredSize(new Dimension(500,100));
		
		
		
		op= new JPanel();
		op.setBorder(BorderFactory.createTitledBorder("Options : 0"));
		
		
		niv=new JComboBox(niveau);
		//niv.setPreferredSize(new Dimension(100, 30));
		niv.setBounds(200, 100, 100, 30);
		diff1 = new JPanel();
		diff1.add(niv);
		pdifficulte.add(diff1,BorderLayout.NORTH);
		
		
		choix=new JLabel("Choisir la/les catégorie(s):");
		choix.setPreferredSize(new Dimension(200, 20));
		diff2 = new JPanel();
		diff2.add(choix);
		pdifficulte.add(diff2,BorderLayout.NORTH);
		
		
		ch1=new JCheckBox("1");
		diff2.add(ch1);
		
		ch2=new JCheckBox("2");
		diff2.add(ch2);
		ch3=new JCheckBox("3");
		diff2.add(ch3);
		ch4=new JCheckBox("4");
		diff2.add(ch4);
		ch5=new JCheckBox("5");
		diff2.add(ch5);
		ch6=new JCheckBox("6");
		diff2.add(ch6);
		ch7=new JCheckBox("7");
		diff2.add(ch7);
		
		ch3.setEnabled(false);
    	ch4.setEnabled(false);
    	ch5.setEnabled(false);
    	ch6.setEnabled(false);
    	ch7.setEnabled(false);
    	
		
		son=new JCheckBox("Emettre son");
		op.add(son);
		
		score=new JCheckBox("Afficher score");
		op.add(score);
		
		Plein=new JCheckBox("Plein ecran");
		op.add(Plein);
		
		ombre=new JCheckBox("Ombre");
		op.add(ombre);
		
		
		
		
		
		ch1.addActionListener(this);
		ch2.addActionListener(this);
		ch3.addActionListener(this);
		ch4.addActionListener(this);
		ch5.addActionListener(this);
		ch6.addActionListener(this);
		ch7.addActionListener(this);
		
		niv.addItemListener(this);
		pcenter=new JPanel();
		pcenter.setLayout(new FlowLayout());
		pcenter.add(pdifficulte);
		pcenter.add(op);
		
		pbtn=new JPanel();
		pbtn.setLayout(new FlowLayout());
		
		btnvalider=new JButton("Valider");
		btnvalider.setPreferredSize(new Dimension(85, 30));
		btnvalider.setHorizontalAlignment(JButton.CENTER);
		
		pbtn.add(btnvalider );
		btnvalider.addActionListener(this);
		this.add(lblbienvenue,BorderLayout.NORTH);
		
		this.add(pcenter,BorderLayout.CENTER);
		this.add(pbtn,BorderLayout.SOUTH);
		
		
		ActionListener actionListener = new ActionHandler();
		son.addActionListener(actionListener);
		score.addActionListener(actionListener);
		Plein.addActionListener(actionListener);
		ombre.addActionListener(actionListener);
	
		
		
	}
	
	
  public void itemStateChanged(ItemEvent arg0) {
	
		if (niv.getSelectedIndex() >= 0) {
			ch1.setEnabled(true);
			ch1.setSelected(false);

			ch2.setEnabled(true);
			ch2.setSelected(false);

			ch3.setEnabled(false);
			ch3.setSelected(false);

			ch4.setEnabled(false);
			ch4.setSelected(false);

			ch5.setEnabled(false);
			ch5.setSelected(false);

			ch6.setEnabled(false);
			ch6.setSelected(false);

			ch7.setEnabled(false);
			ch7.setSelected(false);

		}
		if (niv.getSelectedIndex() >= 1) {
			ch1.setEnabled(false);
			ch1.setSelected(true);

			ch2.setEnabled(false);
			ch2.setSelected(true);

			ch3.setEnabled(true);
			ch4.setEnabled(true);

		}
		if (niv.getSelectedIndex() >= 2) {

			ch3.setEnabled(false);
			ch3.setSelected(true);

			ch4.setEnabled(false);
			ch4.setSelected(true);

			ch5.setEnabled(true);
			ch6.setEnabled(true);
			ch7.setEnabled(true);

		}
	}
  class ActionHandler implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	         JCheckBox checkbox=(JCheckBox) e.getSource();
	         
				 if (checkbox == son) {
					 if (son.isSelected()) {
							i++;}	
					 else i--;
	        } else if (checkbox == score) {
	        	if (score.isSelected()) {
				i++;	}
	        	else i--;
	        	
	        } else if (checkbox == Plein) {
	        	if (Plein.isSelected()) {
					i++;	}
	        	else i--;
	           
	        }
	        else if (checkbox == ombre) {
	        	if (ombre.isSelected()) {
					i++;	}
	        	else i--;
	        	
	            System.out.println(i);
	         
	        }
				 if(i==0) {op.setBorder(BorderFactory.createTitledBorder("Options : 0 "));}
				 else {op.setBorder(BorderFactory.createTitledBorder("Options : "+i));}
	    }

  }
@Override

	public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        if (source == ch1) {
			if (!ch1.isSelected()) {
				ch2.setSelected(false);
			}
		} else if (source == ch2) {
			if (ch2.isSelected()) {
				ch1.setSelected(true);
			}
		} else if (source == ch3) {
			if (!ch3.isSelected()) {
				ch4.setSelected(false);
			}
		} else if (source == ch4) {
			if (ch4.isSelected()) {
				ch3.setSelected(true);
			}
		} else if (source == ch5) {
			if (!ch5.isSelected()) {
				ch6.setSelected(false);
				ch7.setSelected(false);
			}
		} else if (source == ch6) {
			if (ch6.isSelected()) {
				ch5.setSelected(true);
			} else {
				ch7.setSelected(false);
			}
		} else if (source == ch7) {
			if (ch1.isSelected()) {
				ch5.setSelected(true);
				ch6.setSelected(true);
			}
		}
       
	

 if  (source == btnvalider) {
		// recuperation des donnes
		int index = gp.jtp.getSelectedIndex();
		Person p = gp.list_person.get(index);
		// difficulte
		p.setDiff(this.niv.getSelectedIndex());
		// categorie
		// si box7 est selectionner => tout les box<7 sont selectionner
		if (ch7.isSelected()) {
			p.setcat(6);
		} else if (ch6.isSelected()) {
			p.setcat(5);
		} else if (ch5.isSelected()) {
			p.setcat(4);
		} else if (ch4.isSelected()) {
			p.setcat(3);
		} else if (ch3.isSelected()) {
			p.setcat(2);
		} else if (ch2.isSelected()) {
			p.setcat(1);
		} else if (ch1.isSelected()) {
			System.out.println("oui");
			p.setcat(0);
		}

		// options:
		if (son.isSelected())
			p.setoptions(0);
		if (score.isSelected())
			p.setoptions(1);
		if (Plein.isSelected())
			p.setoptions(2);
		if (ombre.isSelected())
			p.setoptions(3);

		// enregiter une page html
		FileHTML htmlFile = new FileHTML(p);
		// supprimer l'onglet s'il la page est enregistree
		
			if (htmlFile.ecrireHtml(p)) 
			{
				System.out.println("ecrire");
				
				
			}
		
	}}

}


	


