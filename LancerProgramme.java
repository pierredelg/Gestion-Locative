import java.util.Scanner;
import java.io.*;

class LancerProgramme{ 
    
    public static void main(String argv[])throws Exception{
	
	Scanner sc = new Scanner(System.in);
	
	int choix = 0;
	
	Menu monObjet = new Menu();
	
	Locataires monObjet2 = new Locataires();
	
	Biens monObjet3 = new Biens();
	
	TypeDeBiens monObjet4 = new TypeDeBiens();
	
	Locations monObjet5 = new Locations();

	SauvegardeRestauration monObjet6 = new SauvegardeRestauration();

	/*Le menu principal est ses sous menus sont compris dans le seul "do while" du main car il permet de toujours rebondir sur le menu principal.*/
	
	do{
	    
	    monObjet.menuPrincipal();     // affichage menu principal
	
	    choix = monObjet.choixMenuPrincipal();    // choix du sous menu à afficher
	
	    switch(choix){              // 1er switch concernant le premier sous menu ( gestion des locataires)
	    
	    case 1:                        
		
		monObjet.gestionDesLocataires();     // affichage sous-menu gestion des locataires
			
		choix = monObjet.choixGestionDesLocataires();    
		
		switch(choix){
			
		case 1:
		    
		    monObjet.ajouterModifierSupprimerLocataire();    // affichage ajouter-modifier-supprimer
		    
		    choix = monObjet.choixAjouterModifierSupprimer();  
		    
		    switch(choix){        // switch permettant le choix entre afficher-modifier ou supprimer du sous-menu gestion des locataires
		    
		    case 1:                    
			
			monObjet2.creation();   // affichage de l'étape ajouter
			
			choix = 0;		        
					
			break;
			
		    case 2:
			
			monObjet2.modifierLocataires();    // affichage de l'étape modifier
			
			choix = 0;                        
			
			break;

		    case 3:
			
			monObjet2.supprimerLocataires();    // affichage de l'étape supprimer 
			
			choix = 0;
			
			break;
			
		    default:
			
			choix = 0;
		    }
		    break;
		
		case 2:
		    
		    monObjet2.afficherLocataireParOrdreAlphabetique();    // appel de la méthode permettant d'afficher les liste des locataires par ordre alpha
		    
		    choix = 0;
		    
		    break;
		    
		case 3:
		
		    monObjet2.afficherLocataireAyantLoueTypeDeBienParticulier();   // appel de la méthode permettant d'afficher une liste de locataire ayant loue un type de bien particulier
		
		    choix = 0;
		
		    break;
		    
		case 4:
		
		    monObjet2.rechercherListeLocationLocataireParticulier(); // permet l'affichage d'une liste concernant les locations d'un locataire particulier

		    choix = 0;

		    break;
		
		default:
		
		    choix = 0;
		}
		
		break;
	    	    
	    case 2:
		
		monObjet.gestionDesBiens(); // affichage sous-menu gestion des biens 
			
		choix = monObjet.choixGestionDesBiens(); 

		switch(choix){    // switch permettant le choix du sous-menu gestion des biens 
		
		case 1 :
		    
		    monObjet.ajouterModifierSupprimerBien();   // affichage du sous-menu permettant d'ajouter-modifier ou supprimer dans le sous-menu gestion des biens
		    
		    choix = monObjet.choixAjouterModifierSupprimer();  
		    
		    switch(choix){  
		    
		    case 1:
			
			monObjet3.creationBien();   // étape permettant l'ajout d'un bien
			
			choix = 0;
			
			break;
			
		    case 2:
			
			monObjet3.modifierBien();    // permet la modification d'un bien 
			
			choix = 0;
			
			break;
			
		    case 3:
			
			monObjet3.supprimerBien();   //  permet la suppression d'un bien 
			
			choix = 0;
			
			break;
			
		    default:
			
			choix = 0;
		    }
		    	
		    break;
		    
		case 2:
		    
		    monObjet3.afficherBienParOrdreAlphabetique();  // affiche directement les biens par ordre alpha
		    
		    choix = 0;
		    		    		
		    break;
		    
		case 3:
		    monObjet3.afficherListeBienTypeDeBien();   // affiche la liste des biens d'un type particulier avec le nom du locataire s'il y'a lieu
		    choix = 0;

		    break;
		
		default:
		    
		    choix = 0;
		}
		    
		break;
	    
	    case 3:
		
		monObjet.gestionDesTypesDeBiens();  // affichage du sous-menu gestion des types de biens 
		
		choix = monObjet.choixGestionDesTypesDeBiens();  

		switch(choix){   // switch permettant d'ajouter, modifier, supprimer un type de bien ou d'afficher la liste des types de biens 
		
		case 1:
		
		    monObjet.ajouterModifierSupprimerTypeDeBien();   // affiche le choix entre ajouter, modifier ou supprimer 
		
		    choix = monObjet.choixAjouterModifierSupprimer();   
		
		    switch(choix){
		
		    case 1:
		
			monObjet4.creationTypeDeBien();          // permet d'ajouter un type de bien
		
			choix = 0;
			
			break;

		    case 2:
			
			monObjet4.modifierTypeDeBien();     // permet de modifier un type de bien
			
			choix = 0;
			
			break;
			
		    case 3:
			
			monObjet4.supprimerTypeDeBien();     // permet de supprimer un type de bien
			
			choix = 0;
			
			break;
			
		    default:
			
			choix = 0;
		    }
		    
		    break;
		
		case 2:
		
		    monObjet4.afficherListeTypeDeBien();     // permet d'afficher la liste des types de biens 
		
		    choix = 0;
		
		    break;

		default:
		
		    choix = 0;
		}
		
		break;
	    
	    case 4:
		
		monObjet.gestionDesLocations();             // affichage du sous-menu gestion des locations 
			
		choix = monObjet.choixGestionDesLocations();
		
		switch(choix){
		
		case 1:
		
		    monObjet5.louerUnBien();                    // étape permettant de louer un bien
		
		    choix = 0;
		    
		    break;
		
		case 2:

		    monObjet5.libererUnBien();           // étape permettant de liberer un bien

		    choix = 0;

		    break;
		
		case 3:
		    monObjet5.afficherListeBiensLoue();           // étape permettant d'afficher  la liste des biens loués 
		    choix = 0;
		    break;
		
		case 4:
		    monObjet5.afficherListeLocatairesBiens();      // étape permettant d'afficher la liste des locataires  de biens 
		    choix = 0;
		    break;
		
		case 5:
		    monObjet5.afficherListeLocataireLoueur();      // étape permettant d'afficher la liste des locataires ayant au moins un bien en cours de location
		    choix = 0;
		    break;
		
		default:
		
		    choix = 0;
		}
		
		break;
	    
	    case 5:
	    
		monObjet2.afficherBaseDeDonnee();  // permet d'afficher la base de données des locataires si 'il y'a lieu
		
		choix = 0;
		
		break;
	    
	    case 6:
		
		monObjet.sauvegardeRestauration();      // affichage du menu sauvegarde-restauration
			
		choix = monObjet.choixSauvegardeRestauration();
		
		switch(choix){
		
		case 1:
		
		    monObjet6.ecrire();         // permet de sauvegarder les données entrer 
		
		    choix = 0;
		
		    break;
		
		case 2:

		    monObjet6.restaurer();     // permet de restaurer les données entrées 

		    choix = 0;

		    break;
		
		default:
		
		    choix = 0;
		}
		
		break;
	    
	    default:
		
		choix = 7;        // permet de quitter le programme 
	    }
	
	}while(choix == 0);

	System.out.println("\n====================> A bientôt ! <====================\n");
    }
}
