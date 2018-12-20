import java.util.Scanner;

class Menu{

    Scanner sc = new Scanner (System.in);

    void menuPrincipal(){
		
	System.out.println("\n_____________MENU PRINCIPAL________________________\n");
		
	System.out.println("(1) Gestion des locataires\n(2) Gestion des biens\n(3) Gestion des types de biens\n(4) Gestion des locations\n(5) Afficher la base de donnée des locataires\n(6) Sauvegarde / restauration des données \n(7) Quitter le programme\n");
    }

    void gestionDesLocataires(){
	
	System.out.println("\n____________GESTION DES LOCATAIRES__________________\n");
        
        System.out.println("(1) Ajouter, modifier ou supprimer un locataire\n(2) Afficher la liste des locataires par ordre alphabétique\n(3) Afficher la liste des locataires ayant loué un type de bien particulier\n(4) Rechercher la liste des locations d'un locataire particulier\n\n(0) Revenir au menu principal\n");
    }

    void ajouterModifierSupprimerLocataire(){
	
	System.out.println("\n_________AJOUTER, MODIFIER, SUPPRIMER__________________\n");
	
	System.out.println("(1) Ajouter locataire\n(2) Modifier locataire\n(3) Supprimer locataire\n\n(0) Revenir au menu principal\n");
    }

    void ajouterModifierSupprimerBien(){
	
	System.out.println("\n_________AJOUTER, MODIFIER, SUPPRIMER__________________\n");
		
	System.out.println("(1) Ajouter un bien\n(2) Modifier un bien\n(3) Supprimer un bien\n\n(0) Revenir au menu principal\n");
    }

    void ajouterModifierSupprimerTypeDeBien(){
	
	System.out.println("\n_________AJOUTER, MODIFIER, SUPPRIMER__________________\n");
	
	System.out.println("(1) Ajouter un type de bien\n(2) Modifier un type de bien\n(3) Supprimer un type de bien\n\n(0) Revenir au menu principal\n");
    }

    void gestionDesBiens(){
        
        System.out.println("\n_____________GESTION DES BIENS______________________\n");	   System.out.println("(1) Ajouter, modifier ou supprimer un bien\n(2) Afficher la liste des biens par ordre alphabétique\n(3) Afficher la liste des biens d'un type particulier avec le nom du locataire s'il y'a lieu\n\n(0) Revenir au menu principal\n");
    }

    void gestionDesTypesDeBiens(){
        
        System.out.println("\n____________GESTION DES TYPES DE BIENS________________\n");	   System.out.println("(1) Ajouter, modifier ou supprimer un type de bien\n(2) Afficher la liste des types de biens\n\n(0) Revenir au menu principal");
    }

    void gestionDesLocations(){
        
        System.out.println("\n________________GESTION DES LOCATIONS_________________\n");	   System.out.println("(1) Louer un bien\n(2) Libérer un bien\n(3) Afficher la liste des biens loués\n(4) Afficher la liste des locataires de biens\n(5) Afficher la liste des locataires ayant au moins un bien en cours de location\n\n(0) Revenir au menu principal\n");
    }

    void sauvegardeRestauration(){
        
        System.out.println("\n_______________SAUVEGARDE/RESTAURATION________________\n");	   System.out.println("(1) Sauvegarde des données dans un fichier binaire\n(2) Restauration des données à partir du fichier de sauvegarde\n\n(0) Revenir au menu principal\n");
    }

    int choixMenuPrincipal(){
	    
	int choix = 0;
	    
	do{
	    
	    System.out.print("Que voulez vous faire ? ");
	    while(!sc.hasNextInt()){
		
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
	    choix = sc.nextInt();
	    
	}while(choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 && choix != 6 && choix != 7);

	return choix;
    }

    int choixGestionDesLocataires(){
	
	int choix;
	
	do{
	
	    System.out.print("Que voulez vous faire ? ");
	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
	    choix = sc.nextInt();
	    
	}while(choix != 0 && choix != 1 && choix != 2 && choix != 3 && choix != 4);

	return choix;
    }

    int choixAjouterModifierSupprimer(){
	
	int choix;
	
	do{
	
	    System.out.print("Que voulez vous faire ? ");
	    
	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
			
	    choix = sc.nextInt();
	    
	}while(choix != 0 && choix != 1 && choix != 2 && choix != 3);

	return choix;
    }

    
    int choixGestionDesBiens(){
	
	int choix;
	
	do{
	
	    System.out.print("Que voulez vous faire ? ");

	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
		
	    choix = sc.nextInt();
	    
	}while(choix != 0 && choix != 1 && choix != 2 && choix != 3);

	return choix;
    }

    int choixGestionDesTypesDeBiens(){
	
	int choix;
	
	do{
	
	    System.out.print("Que voulez vous faire ? ");

	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
	
	    choix = sc.nextInt();
	
	}while(choix != 0 && choix != 1 && choix != 2 && choix != 3 );

	return choix;
    }


    int choixGestionDesLocations(){
	
	int choix;
	
	do{
	
	    System.out.print("Que voulez vous faire ? ");

	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
			
	    choix = sc.nextInt();
	    
	}while(choix != 0 && choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 );

	return choix;
    }
    

    int choixSauvegardeRestauration(){
	
	int choix;
	
	do{
	
	    System.out.print("Que voulez vous faire ? ");

	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?");
		sc.next();
	    }
			
	    choix = sc.nextInt();
	    
	}while(choix != 0 && choix != 1 && choix != 2);

	return choix;
    }
}
     
