package FICHIER;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import OO.Person;

public class FileHTML {

	File f;
	Person p;
	String chemin;
	
	
	public FileHTML(Person person) {
	 this.p=person;
	 System.out.println("html");
	 this.chemin="C:/Users/soure/Desktop"+person.getPseudo()+".html";
	 f=new File(chemin);
	 
	}


   public boolean  ecrireHtml(Person p) 
   {   String html;
         html="<!DOCTYOE html> \r\n"
        		 +"<html lang=\"fr\">\r\n"
        		 +"    <head>\r\n"
        		 +"        <meta charset=\"utf-8\">\r\n"
                 +"        <title>config</title>\r\n"
        		 +"    </head>\r\n"
                 +"    <body>\r\n"
        		 +"       <div>\r\n"
                 +"           <fieldset>\r\n"
        		 +"                  <legend>Informations Personnelles</legend>\r\n"
                 +p.getInfo()
                 +"           </fieldset>\r\n"
                 +"           <fieldset>\r\n"
        		 +"                  <legend> Configuration</legend>\r\n"
        		 +"                    <fieldset>\r\n"
        		 +"                         <legend >Dificulte:"+p.getDiff()+"</legend>\r\n"
                 +p.getDiffhtml()
                 +"                    </fieldset>\r\n"
                  +"                   <fieldset>\r\n"
        		 +"                        <legend>Options </legend>\r\n"
        		 +p.getOptions()
                 +"                   </fieldset>\r\n"
                 +"           </fieldset>\r\n"
                 +"       </div>\r\n"
                 +"    </body>\r\n"
                 +"</html>";
         return save(html);
   
   }
   public Boolean save( String html)
   {  FileWriter ff=null;
	   System.out.println("html");
   
    try {
    ff=new FileWriter(f,false);
    ff.write(html);
    ff.close();
  //ouverture par chrome :
	Desktop desktop = Desktop.getDesktop();
	desktop.browse(new URI(chemin));
	return true;
}   catch (IOException e1) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	System.out.println("erreur fichier: "+e1.getMessage());
	return false;
}   catch (URISyntaxException e2) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	System.out.println("erreur navigateur: "+e2.getMessage());
	return false;
}}}
   