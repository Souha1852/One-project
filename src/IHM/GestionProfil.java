package IHM;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import DAO.PersonManager;
import DAO.PseudoModel;
import OO.Person;

public class GestionProfil extends JFrame implements ActionListener{
     
	JButton btnvalider;
	 JLabel lblnom,nomf,prenomf,mdpfoc;
	 JLabel star1,star2,star3;
	 public JTextField tfnom;
	 JLabel lblprenom;
public  JTextField tfprenom;
	 JLabel lblpseudo;
public JTextField tfpseudo;
	 JLabel lhelp;
	 JSplitPane js;
	 public JTable pseudos;
     public JTabbedPane jtp ;
	 String ch,ch1="",ch2="";
	 JSplitPane jsp ;
 public JList<String> list_p;
 public ArrayList<Person> list_person;
	 
	 
	// public ArrayList<MonPanneau> listpanel=new ArrayList<MonPanneau>(); 
	PseudoModel md;
	int l,c;
	
	public  GestionProfil() {
		//paramétres de la fenetre:
		this.setTitle("Bienvenue !!");
		this.setSize(900,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(250,50);
		
		//affichage de la liste des pseudos:
		PersonManager pm=new PersonManager();
		ResultSet rs=pm.getallPersonne();
		
		md = new PseudoModel(rs);
		
		
		this.setLayout(new BorderLayout());
		//label et zone du saisie du nom 
		lblnom=new JLabel("Nom");
		lblnom.setHorizontalAlignment(JLabel.CENTER);
		lblnom.setVerticalAlignment(JLabel.CENTER);
		lblnom.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
		
		
		tfnom=new JTextField(15);
		tfnom.setHorizontalAlignment(JTextField.CENTER);
		tfnom.setText("tapper votre nom");
		
		star1 = new JLabel("*");
		star1.setForeground(Color.red);
	    star1.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
		
		//label et zone de saisie du prénom
		lblprenom=new JLabel("Prénom");
		lblprenom.setHorizontalAlignment(JLabel.CENTER);
		lblprenom.setVerticalAlignment(JLabel.CENTER);
		lblprenom.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
		
		tfprenom=new JTextField(15);
		tfprenom.setHorizontalAlignment(JTextField.CENTER);
		tfprenom.setText("tapper votre prenom");
		
		
		star2 = new JLabel("*");
		star2.setForeground(Color.red);
		star2.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
		
		//label et zone de saisie du motde passe 
		
		
		lblpseudo=new JLabel("Pseudo");
		lblpseudo.setHorizontalAlignment(JLabel.CENTER);
		lblpseudo.setVerticalAlignment(JLabel.CENTER);
		lblpseudo.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
		
		
		
		tfpseudo=new JTextField(15);
		tfpseudo.setHorizontalAlignment(JTextField.CENTER);
		tfpseudo.setText("tapper votre pseudo");
		
		
		star3 = new JLabel("*");
		star3.setForeground(Color.red);
		star3.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
		
		//ajout du boutton ajouter 
		btnvalider=new JButton("Valider");
		
		
		
		JPanel pn=new JPanel();
		pn.setLayout(new FlowLayout());
		
		pn.add(lblnom);
		pn.add(tfnom);
		pn.add(star1);
		pn.add(lblprenom);
		pn.add(tfprenom);
		pn.add(star2);
		pn.add(lblpseudo);
		pn.add(tfpseudo);
		pn.add(star3);
		pn.add(btnvalider);
		
	
	
		this.add(pn,BorderLayout.NORTH);
		
		/*************************************/
		
		jsp=new JSplitPane();
		
		
		pseudos=new JTable();
		pseudos.setModel(md);
		//pseudos.setBounds(50, 50, 500, 100);
		pseudos.setRowHeight(20);
		//pseudos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		
		pseudos.setPreferredSize(new Dimension(250,0));
		//pseudos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		jsp.setLeftComponent(pseudos);
		
		
		
		this.add(jsp);
		
		/**************************************/
		
		lhelp=new JLabel("help:"+ch2);
		this.add(lhelp,BorderLayout.SOUTH);
		
		/**EVENEMENT*/
		
		lblnom.addMouseListener(new EcouteurLabel(this));
		lblprenom.addMouseListener(new EcouteurLabel(this));
		lblpseudo.addMouseListener(new EcouteurLabel(this));
		tfnom.addFocusListener(new EcouteurFocus());
		tfprenom.addFocusListener(new EcouteurFocus1());
		tfpseudo.addFocusListener(new EcouteurFocus2());
		btnvalider.addActionListener(this);
		tfnom.addMouseMotionListener(new EcouteurHelp(this));
		tfprenom.addMouseMotionListener(new EcouteurHelp(this));
		tfpseudo.addMouseMotionListener(new EcouteurHelp(this));
		
		
		
		pseudos.addMouseMotionListener(new EcouteurJTable(this));
		pseudos.addMouseListener(new EcouteurList());
		
	    jtp = new JTabbedPane();
		jsp.setRightComponent(jtp);
		
		list_person=new  ArrayList<Person> ();
	}
		
		
	public int IndexlistPerson(String psd) {
		for(int i=0;i<list_person.size();i++) {
			if(list_person.get(i).getPseudo().equals(psd)) {
				return i;
			}
		}
		return -1;
	}
		

	/** fin constructeur*/
	class EcouteurList extends MouseAdapter 
	{
		public void mouseClicked(MouseEvent e) 
		{ if(e.getButton()==e.BUTTON1)
		{
			if (e.getClickCount()==2)
			{  
				
				String psd=(md.getValueAt(pseudos.getSelectedRow(), pseudos.getSelectedColumn())+"");
				int position=IndexlistPerson(psd);
				System.out.println(psd);
				System.out.println(position);
           if(position<0) {
        	   System.out.println(position);

		PersonManager pm=new PersonManager();
		int row = pseudos.getSelectedRow();
        int column =pseudos.getSelectedColumn();
        final String valueInCell = (String)pseudos.getValueAt(row, column);
		Person p=pm.Recherche(valueInCell);
	   jtp.addTab(psd, new MonPanneau( GestionProfil.this ,p.getNom(), p.getPrenom()));
	   list_person.add(p);
			}else {
					
	jtp.setSelectedIndex(position);
						}
				
			   }
		}
		if (e.getButton()==MouseEvent.BUTTON3)
		{
			JPopupMenu pop= new JPopupMenu();
			JMenuItem sup= new JMenuItem("Supprimer");
			JMenuItem mod= new JMenuItem("Renommer");
			JMenuItem supt= new JMenuItem("Supprimer tous");
			
			pop.add(sup);
			pop.add(supt);
			pop.add(new JSeparator());
			pop.add(mod);
			pseudos.setComponentPopupMenu(pop);
			
			pop.show(pseudos,e.getX(),e.getY());
			mod.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			    ch=JOptionPane.showInputDialog(GestionProfil.this, "saisir le nouveau pseudo ");
			   int ligne=pseudos.getSelectedRow();
			   
			   int colonne=pseudos.getSelectedColumn();
			   int posT=IndexlistPerson(md.getValueAt(pseudos.getSelectedRow(), pseudos.getSelectedColumn())+"");
			   
			   if(!ch.isBlank()){
				  
			   int a  = md.renommerLigne(ligne,md.getValueAt(pseudos.getSelectedRow(), pseudos.getSelectedColumn())+"", ch);	   
			    if(posT>=0) {
			    	if(a>0) {
					list_person.get(posT).setPseudo(ch);
					jtp.setTitleAt(posT, ch);
				}}}
			   else {
				   JOptionPane.showMessageDialog(GestionProfil.this, "operation annulé");
				   }
			   
				
			
			   
				
				
				
	
				}});
			//supprimer l'onglet
			sup.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int posT=IndexlistPerson(md.getValueAt(pseudos.getSelectedRow(), pseudos.getSelectedColumn())+"");
					int ligne=pseudos.getSelectedRow();
					md.supprimer(ligne);
			        //si l'onglet est ouvert on le supprime
						if( posT >=0) {
							list_person.remove(posT);
							jtp.remove(posT);
						}
				}
				});
		  //supprimer tous les onglets :
			supt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					md.supprimerall();
					jtp.removeAll();
					System.out.println("suppression du jTabbedpane with success");
					
				}
			});
		}
			
		};
		
		
	}
	class EcouteurFocus implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			if(tfnom.getText().equals("tapper votre nom"))
			{			tfnom.setText("");
			         
			          
			}
			else if(tfprenom.getText().equals("tapper votre prenom"))
			{tfprenom.setText("");
			}
			else if(tfpseudo.getText().equals("tapper votre pseudo"))
				{tfpseudo.setText("");
				  }
			
			
		}

		
		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			if(tfnom.getText().equals(""))
				{tfnom.setText("tapper votre nom");}
			else if(tfprenom.getText().equals(""))
			{tfprenom.setText("tapper votre prenom");}
			else if(tfpseudo.getText().equals(""))
				{tfpseudo.setText("tapper votre pseudo");}
			
		}
		
	}
	class EcouteurFocus1 implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			 if(tfprenom.getText().equals("tapper votre prenom"))
			{tfprenom.setText("");}
			
			
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			 if(tfprenom.getText().equals(""))
			{tfprenom.setText("tapper votre prenom");}
			
			
		}
		
	}
	class EcouteurFocus2 implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			 if(tfpseudo.getText().equals("tapper votre pseudo"))
				{tfpseudo.setText("");}
			
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			 if(tfpseudo.getText().equals(""))
				{tfpseudo.setText("tapper votre pseudo");}
			
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		Object source=a.getSource();
		if(source==btnvalider) {
			
			
            if(tfnom.getText().equals("tapper votre nom"))  {
                JOptionPane.showMessageDialog(this, "Veillez saisir un nom");
                return;
            }
           
            
            else if (tfprenom.getText().equals("tapper votre prenom")) {
            	JOptionPane.showMessageDialog(this, "Veillez saisir un prénom");
                return;
            }
           
            else if (tfpseudo.getText().equals("tapper votre pseudo") ) {
            	JOptionPane.showMessageDialog(this, "Veillez saisir un pseudo");
                return;
            }
			else {
					
			Person p=new Person(tfpseudo.getText(), tfnom.getText(), tfprenom.getText());	
			int rq=md.addElement(p);
			if(rq!=0) {
				tfnom.setText("tapper votre nom");
				tfprenom.setText("tapper votre prenom");
			    tfpseudo.setText("tapper votre pseudo");	}
			
			}
		
		
		
			
	}}}
