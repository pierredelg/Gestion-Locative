import java.util.Scanner;
class projet{

    void menuPrincipal(){
		System.out.println("_____________MENU PRINCIPAL________________________\n");
	System.out.println("(1) Gestion des locataires\n(2) Gestion des biens\n(3) Gestion des types de biens\n(4) Gestion des locations\n(5) Sauvegarde/restauration des données dans des fichiers\n(6) Quitter le programme\n");
    }

    void gestionDesLocataires(){
	System.out.println("____________GESTION DES LOCATAIRES__________________\n");
        System.out.println("\n(1) Ajouter, modifier ou supprimer un locataire\n(2) Afficher la liste des locataires par ordre alphabétique\n(3) Afficher la liste des locataires ayant loué un type de bien particulier\n(4) Rechercher la liste des locations d'un locataire particulier\n\n(0) Revenir au menu principal\n");
    }

    void ajouterModifierSupprimer(){
	System.out.println("_________AJOUTER, MODIFIER, SUPPRIMER__________________\n");
	System.out.println("\n(1) Ajouter locataire\n(2) Modifier locataire\n(3) Supprimer locataire\n\n(0) Revenir au menu principal\n");
    }

    void gestionDesBiens(){
        System.out.println("_____________GESTION DES BIENS______________________\n");	   System.out.println("\n(1) Ajouter, modifier ou supprimer un bien\n(2) Afficher la liste des biens par ordre alphabétique\n(3) Afficher la liste des biens d'un type particulier avac le nom du locataire s'il y'a lieu\n\n(0) Revenir au menu principal\n");
    }

    void gestionDesTypesDeBiens(){
        System.out.println("____________GESTION DES TYPES DE BIENS________________\n");	   System.out.println("\n(1) Ajouter, modifier ou supprimer un type de bien\n(2) Afficher la liste des types de biens\n\n(0) Revenir au menu principal");
    }

    void gestionDesLocations(){
        System.out.println("________________GESTION DES LOCATIONS_________________\n");	   System.out.println("\n(1) Louer un bien\n(2) Libérer un bien\n(3) Afficher la liste des biens loués\n(4) Afficher la liste des locataires de biens\n(5) Afficher la liste des locataires ayant au moins un bien en cours de location\n\n(0) Revenir au menu principal\n");
    }

    void sauvegardeRestauration(){
        System.out.println("_______________SAUVEGARDE/RESTAURATION________________\n");	   System.out.println("\n(1) Sauvegarde des données dans un ou plusieurs fichiers binaires\n(2) Restauration des données dans les structures choisies à partir des fichiers de sauvegarde\n\n(0) Revenir au menu principal\n");
    }

	int choixMenuPrincipal(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 && choix != 6);

	    return choix;
	}

    	int choixGestionDesLocataires(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 0 && choix != 1 && choix != 2 && choix != 3 && choix != 4);

	    return choix;
	}

    	int choixAjouterModifierSupprimer(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 0 && choix != 1 && choix != 2 && choix != 3);

	    return choix;
	}

      	int choixGestionDesBiens(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 0 && choix != 1 && choix != 2 && choix != 3);

	    return choix;
	}

        int choixGestionDesTypesDeBiens(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 0 && choix != 1 && choix != 2 );

	    return choix;
	}


    	int choixGestionDesLocations(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 0 && choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 );

	    return choix;
	}
    

    	int choixSauvegardeRestauration(){
	    Scanner sc = new Scanner (System.in);
	    int choix;
	    do{
		System.out.println("Que voulez vous faire ?");
		choix = sc.nextInt();
	    }while(choix != 0 && choix != 1 && choix != 2);

	    return choix;
	}
}
     
