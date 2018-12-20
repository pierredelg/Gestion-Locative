import java.io.*;

public class SauvegardeRestauration{
   

    String fichier="sauvegarde.bin";

    DataOutputStream dos;

    DataInputStream dis;

    void ecrire()throws IOException{

	dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichier)));

	Locataires Olocataires = new Locataires();
	   
	TypeDeBiens OtypeDeBiens = new TypeDeBiens();
	   
	Biens Obiens = new Biens();
	   
	Locations Olocation = new Locations();

	/* ----------------écriture tuples locataires---------------------------- */

	int indiceLocataire = Olocataires.getIndice();
	   
	int compteurLocataire = Olocataires.getIdentifiantLocataire();
	    
	dos.writeInt(indiceLocataire);
	   
	dos.writeInt(compteurLocataire);
	    
	if( indiceLocataire > 0){
	   
	    for(int a = 0; a < indiceLocataire; a++){
		   
		dos.writeInt(Olocataires.getIdentifiantLocataire(a));		  

		dos.writeUTF(Olocataires.getNomLocataire(a));
	
		dos.writeUTF(Olocataires.getAdresseLocataire(a));
			   
		for(int b = 0; b < 5; b++){
		    
		    dos.writeInt( Olocataires.getIdentifiantBienLoueLocataire(a,b));
		}
	    }

	}
	else{
	       
	    System.out.println("\nAucune donnée locataire à sauvegarder!");
	}

	/*------------------écriture tuples type de bien--------------------------*/

	int indiceTypeDeBien = OtypeDeBiens.getIndice1();
	   
	int compteurTypeDeBien = OtypeDeBiens.getIdentifiantTypeDeBien1();
      
	dos.writeInt(indiceTypeDeBien);
	       
	dos.writeInt(compteurTypeDeBien);
	    
	if(indiceTypeDeBien > 0){
	       
	    for(int c = 0; c < indiceTypeDeBien; c++){

		dos.writeInt(OtypeDeBiens.getIdentifiantTypeDeBien(c));
		    
		dos.writeUTF(OtypeDeBiens.getNomTypeDeBien(c));
	    }
	    
	}
	else{
	    
	    System.out.println("\nAucune donnée de type de bien à sauvegarder!");
	}

	/*-----------------------écriture tuples biens--------------------------*/

	int indiceBiens = Obiens.getIndice();
	    
	int compteurBiens = Obiens.getIdentifiantBiens();
 
	dos.writeInt(indiceBiens);
	    
	dos.writeInt(compteurBiens);

	if(indiceBiens > 0){
	    
	    for(int d = 0; d < indiceBiens; d++){

		dos.writeInt(Obiens.getIdentifiantBien(d));
		   	
		dos.writeInt(Obiens.getIdentifiantTypeDeBien(d));
		   	
		dos.writeUTF(Obiens.getDescriptionBien(d));
		   	
		dos.writeInt(Obiens.getIdentifiantLocatairesBien(d));
	    }
	}
	else{

	    System.out.println("\nAucune donnée de biens à sauvegarder!");
	}

	/*-----------------------écriture tuples location---------------------------*/
		   
	int indiceLocation = Olocation.getIndice();
	   
	int compteurLocation = Olocation.getCompteurLocation();
  
	dos.writeInt(indiceLocation);
	    
	dos.writeInt(compteurLocation);
	    
	if(indiceLocation > 0){
	    
	    for(int e = 0; e < indiceLocation; e++){

		dos.writeInt(Olocation.getIdentifiantLocation(e));
		   
		dos.writeUTF(Olocation.getDescriptionBienLocation(e));
		   
		dos.writeInt(Olocation.getIdentifiantBienLoue(e));
		   
		dos.writeInt(Olocation.getIdentifiantLocataireBien(e));
		   
		dos.writeUTF(Olocation.getNomLocataireLocation(e));
	    }
	}
	else{
	        
	    System.out.println("\nAucune donnée de location à sauvegarder!");
	}
       
	System.out.println("\n================> Félicitation la sauvegarde est effectuée avec succés ! <================\n");
	    
	dos.close();

	/*------------------------------fin écriture---------------------------*/
    }


    void restaurer() throws IOException{
	//String fichier = "sauvegarde.bin"

	File f = new File (fichier);
		
	Locataires Olocataires2 = new Locataires();
		
	TypeDeBiens OtypeDeBiens2 = new TypeDeBiens();
		
	Biens Obiens2 = new Biens();
		
	Locations Olocation2 = new Locations();

	if(f.exists() && f.isFile() && f.length() > 0){

	    dis = new DataInputStream (new BufferedInputStream (new FileInputStream(fichier)));
		
	    /*----------------lecture tuples locataires-------------------------*/

	
			
	    int indiceLocataire2 = dis.readInt();
		
	    int compteurLocataire2 = dis.readInt();
        
	    Olocataires2.setIndiceLocataire(indiceLocataire2);
		
	    Olocataires2.setCompteurLocataire(compteurLocataire2);
	    
	    if( indiceLocataire2 > 0){
	
		for(int a = 0; a < indiceLocataire2; a++){
		   
		    Olocataires2.setIdentifiantLocataire(a, dis.readInt());
		
		    Olocataires2.setNomLocataire(a, dis.readUTF());
		
		    Olocataires2.setAdresseLocataire(a, dis.readUTF()); 
			   
		    for(int b = 0; b < 5; b++){
		
			Olocataires2.setIdentifiantBienLoueLocataire(a, b, dis.readInt());
		    }
		}
	    }
		  
	    /*----------------lecture tuples type de bien---------------------*/

        

	    int indiceTypeDeBien2 = dis.readInt();
		
	    int compteurTypeDeBien2 = dis.readInt();
		
	    OtypeDeBiens2.setIndiceTypeDeBien(indiceTypeDeBien2);
		
	    OtypeDeBiens2.setCompteurTypeDeBien(compteurTypeDeBien2);

	    if(indiceTypeDeBien2 > 0){

		for(int c = 0; c < indiceTypeDeBien2; c++){
		    
		    OtypeDeBiens2.setIdentifiantTypeDeBien1(c, dis.readInt());
		
		    OtypeDeBiens2.setNomTypeDeBien1(c, dis.readUTF());
		}
	    }

	    /*------------------lecture tuples biens---------------------*/



	    int indiceBiens2 = dis.readInt();
		
	    int compteurBiens2 = dis.readInt();
	
	    Obiens2.setIndice(indiceBiens2);
		
	    Obiens2.setCompteurBiens(compteurBiens2);
	    
	    if(indiceBiens2 > 0){

		for(int d = 0; d < indiceBiens2; d++){

		    Obiens2.setIdentifiantBien(d, dis.readInt());
		
		    Obiens2.setIdentifiantTypeDeBien(d, dis.readInt());
		
		    Obiens2.setDescriptionBien(d, dis.readUTF());
		
		    Obiens2.setIdentifiantLocatairesBien(d, dis.readInt());
		}
	    }

	    /*------------------lecture tuples location---------------------*/

        
		
	    int indiceLocation2 = dis.readInt();
		
	    int compteurLocation2 = dis.readInt();

	
		
	    Olocation2.setIndice(indiceLocation2);
		
	    Olocation2.setCompteurLocation(compteurLocation2);
	    
	    if(indiceLocation2 > 0){

		for(int e = 0; e < indiceLocation2; e++){

		    Olocation2.setIdentifiantLocation(e, dis.readInt());
		
		    Olocation2.setDescriptionLocataireLocation(e, dis.readUTF());
		
		    Olocation2.setIdentifiantBienLoue(e, dis.readInt());
		
		    Olocation2.setIdentifiantLocataireBien(e, dis.readInt());
		
		    Olocation2.setNomLocataireLocation(e, dis.readUTF());
		}
	    }
		
	    System.out.println("\n================> Félicitation la restauration a été effectuée avec succés ! <================\n");
	    
	    dis.close();

	    /*-------------------------fin lecture-----------------------------*/
    
	}else{
	
	    if(f.exists() == false || f.isFile() == false){
	    
		System.out.println("\n================> Aucun fichier de restauration existant! <================");
	    
	    }else
		System.out.println("\n================> Le fichier sauvegarde.bin est vide! <================");
	    
	
	}

    }
}
       

    
    

