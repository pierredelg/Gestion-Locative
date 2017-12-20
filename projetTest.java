import java.util.Scanner;
import java.io.*;

class projetTest{ 
    public static void main(String argv[])throws IOException{
	String fichier = "sauvegarde.bin";
	DataOutputStream dos;
	if (argv.length > 0) fichier = argv [0];
	dos = new DataOutputStream ( new BufferedOutputStream (new FileOutputStream(fichier)));
	
	Scanner sc = new Scanner(System.in);
	int choix = 0;
	projet monObjet = new projet();
	locataire monObjet2 = new locataire();
	

	do{
	    monObjet.menuPrincipal();
	
	    choix = monObjet.choixMenuPrincipal();
	

	    switch(choix){
	    case 1:
		monObjet.gestionDesLocataires();
		choix = monObjet.choixGestionDesLocataires();
		switch(choix){
		case 1:
		    monObjet.ajouterModifierSupprimer();
		    choix = monObjet.choixAjouterModifierSupprimer();
		    switch(choix){
		    case 1:
			monObjet2.ajouterLocataire();
			choix = 0;
			
			break;
		    case 2:

			break;

		    case 3:

			break;
		    default:
			choix = 0;
		    }
		    break;
		case 2:
		    System.out.println("____________AFFICHER LA LISTE DES LOCATAIRES PAR ORDRE ALPHABÉTIQUE_______________________\n");

		    //monObjet2.locatairesOrdreAlpha();
		    choix = 0;
		    break;
		case 3:
		    System.out.println("___________AFFICHER LA LISTE DES LOCATAIRES AYANT LOUÉ UN TYPE DE BIEN___________________\n");

		    //monObjet2.lacatairesLOueTypeDeBien();
		    choix = 0;
		    break;
		case 4:
		    System.out.println("__________RECHERCHER LA LISTE DES LOCATIONS D'UN LOCATAIRE PARTICULIER____________\n");

		    break;
		default:
		    choix = 0;
		}
		
		break;
	    
	    case 2:
		monObjet.gestionDesBiens();
		choix = monObjet.choixGestionDesBiens();

		switch(choix){
		case 1 :


		    break;
		case 2:


		    break;
		case 3:


		    break;
		default:
		    choix = 0;
		}
		    
		break;
	    
	    case 3:
		monObjet.gestionDesTypesDeBiens();
		choix = monObjet.choixGestionDesTypesDeBiens();

		switch(choix){
		case 1:

		    break;
		case 2:

		    break;

		default:
		    choix = 0;
		}
		break;
	    
	    case 4:
		monObjet.gestionDesLocations();
		choix = monObjet.choixGestionDesLocations();
		switch(choix){
		case 1:

		    break;
		case 2:

		    break;
		case 3:

		    break;
		case 4:

		    break;
		case 5:

		    break;
		default:
		    choix = 0;
		}
		break;
	    
	    case 5:
		monObjet.sauvegardeRestauration();
		choix = monObjet.choixSauvegardeRestauration();
		switch(choix){
		case 1:
		    monObjet2.ecrireTupleLocataire(dos, 0);
		    dos.close();
		    choix = 0;
		    break;
		case 2:

		    break;
		default:
		    choix = 0;
		}
		
		break;
	    default:
		choix = 6;
	    }
	    
	
	}while(choix == 0);

	System.out.println("A bientôt !\n");
    }
}
