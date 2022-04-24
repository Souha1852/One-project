package OO;

public class Person {
	String nom;
	String prenom;
	String pseudo;
	String Diff[]= {"Debutant","Intermidiaire","professionel"},difficulte;
	int categories[]= {0,0,0,0,0,0,0};
	int options[]= {0,0,0,0};
	
	public Person(String pseudo,String nom,String prenom) {
		this.nom=nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String pseudo) {
		this.prenom = prenom;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getDiff() {
		return difficulte;
	}
	public void setDiff(int i ) {
	
	this.difficulte=Diff[i];
	
	}
	public int getcatg(int i ) {
		return categories[i] ;
	
	}
	public String setcat(int pos ) {
	String choix="";
	for(int i=pos;i>=0;i--)
	{
		this.categories[i]=1;}
	 for (int i=0;i<categories.length;i++)
	    {
	    	if(categories[i]==0) 
	    	{ break;
	    }
	    	choix+="<p> Categorie :"+(i+1)+"</p>";
	    	System.out.println("tkhdm");
	    
	    }
	   return choix;
	   
	}
	
	
	public int getoptions(int i ) {
		return options[i] ;
	
	}
	public void setoptions(int i ) {
	
	
	
		this.options[i]=1;
	
	
	}
   
    public String getInfo() {System.out.println("tttt");
	return ("<p>Nom:   "+nom+"</p><p>Prenom:"+prenom+"</p><p>Pseudo:"+pseudo+"</p>");
	   
     }
   
    public String getDiffhtml()
    { String choix="";
    for (int i=0;i<categories.length;i++)
    {
    	if(categories[i]==0) 
    	{ break;
    }
    	choix+="<p> Categorie :"+(i+1)+"</p>";
    	System.out.println("tkhdm");
    
    }
   return choix;
   
}
    public String getOptions() {

   String option="";
   option="<p>Son:"+isclicked(0)
   +"</p><p>Affichage score:"+isclicked(1)
   +"</p><p>Plein ecran:"+isclicked(2)
   +"</p><p>Affichage Ombre:"+isclicked(3)+"</p>";
return option;
}
public String isclicked(int i ) {
	if(options[i]==1)
	{return "true";}
	else {return "false";
	}
	
}    

}
