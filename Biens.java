import java.util.*;

public class Biens{

	//classe qui regroupe les méthodes de la partie Gestion des biens du menu principal

	//déclaration des variables

    public static int indiceBien = 0;

    public static int compteurBien = 0;

    //déclaration des tableaux

    public static int [] tabIdentifiantBien = new int [100];

    public static int [] tabIdentifiantTypeDeBien= new int [100];

    public static int [] tabIdentifiantLocatairesBien = new int [100];

    public static String [] tabDescriptionBien = new String [100];

    //déclaration du scanner

    Scanner sc = new Scanner (System.in);

    //méthodes get afin de récupérer les données de la classe

    public static int getIndice(){

	return indiceBien;
    }

    public static int getIdentifiantBiens(){

	return compteurBien;
    }

    public static String [] getTabDescriptionBien(){

    	return tabDescriptionBien;
    }

    public static int [] getTabIdentifiantTypeDeBien(){

	return tabIdentifiantTypeDeBien;
    }

    public static int [] getTabIdentifiantBien(){

	return tabIdentifiantBien;
    }

    public static int [] getTabIdentifiantLocatairesBien(){

    	return tabIdentifiantLocatairesBien;
    }

    public String getDescriptionBien(int indice){

    	return tabDescriptionBien[indice];
    }

    public int getIdentifiantTypeDeBien(int indice){

	return tabIdentifiantTypeDeBien[indice];
    }

    public int getIdentifiantBien(int indice){

	return tabIdentifiantBien[indice];
    }

    public int getIdentifiantLocatairesBien(int indice){

    	return tabIdentifiantLocatairesBien[indice];
    }

    //méthodes set afin de modifier les valeurs

    public static void setIndice(int n){

	indiceBien = n;
    }

    public static void setCompteurBiens(int n){

	compteurBien = n;
    }

    public void setIdentifiantBien(int indice,int identifiant){

	tabIdentifiantBien[indice] = identifiant;
    }

    public void setIdentifiantTypeDeBien(int indice,int identifiant){

	tabIdentifiantTypeDeBien[indice] = identifiant;
    }

    public void setIdentifiantLocatairesBien(int indice,int identifiant){

	tabIdentifiantLocatairesBien[indice] = identifiant;
    }

    public void setDescriptionBien(int indice,String description){

	tabDescriptionBien[indice]= description;
    }

    void  creationBien(){

    	//méthode permettant de créer un bien

	int nouveau = 0;

	boolean mot = true;

	char ouiNon = ' ';

	//déclaration des objets

     	Locataires locataire = new Locataires();

		TypeDeBiens OtypeDeBiens =  new TypeDeBiens();

		int [] cloneIdentifiantTypeDeBiens = OtypeDeBiens.getTabIdentifiantTypeDeBien();

		//condition vérifiant s'il reste de la place pour ajouter un nouveau locataire

      	if (indiceBien == 100){

            System.out.println("Espace indisponible pour ajouter un nouveau locataire.");

        }

		else{

			//boucle vérifiant que l'utilisateur entre bien un nombre

	        do{

	            System.out.print("Veuillez entrer l'identifiant du type de bien :");

	            while(!sc.hasNextInt()){

	                System.out.println("\nCe n'est pas un nombre!\nVeuillez entrer l'identifiant du type de bien :");

	                sc.next();
	            }

		        nouveau = sc.nextInt();

	        }while(nouveau < 0);

	        //on vide le sc.nextInt() afin de ne pas avoir d'erreur

		    sc.nextLine();

		    for(int i = 0; i < cloneIdentifiantTypeDeBiens.length; i++){

			if(cloneIdentifiantTypeDeBiens[i] == nouveau)

			    mot = false;
		    }
		}

		if(mot == false){

		    compteurBien ++;

		    tabIdentifiantBien[indiceBien]= compteurBien;

		    tabIdentifiantTypeDeBien[indiceBien] = nouveau;

		    System.out.print("Veuillez entrer la description de ce bien :");

		    tabDescriptionBien[indiceBien]= sc.nextLine();

		    do{

			int [] verification = locataire.getTabIdentifiantLocataire();

			System.out.print("Veuillez entrer l'identifiant du dernier locataire parmi la liste d'identifiant disponible (0 sinon): \n");

			System.out.println("=> 0");

			for(int u = 0; u < verification.length;u++){

			    if(verification[u] != 0){

				System.out.println("=> "+verification[u]);
			    }
			}

			ouiNon = ' ';

			mot = true;
	        do{

	            while(!sc.hasNextInt()){

	                System.out.println("\nCe n'est pas un nombre!\nVeuillez entrer l'identifiant du dernier locataire:");

	                sc.next();
	            }

			    tabIdentifiantLocatairesBien[indiceBien] = sc.nextInt();

	        }while(tabIdentifiantLocatairesBien[indiceBien] < 0);

			sc.nextLine();

			for(int i = 0; i < verification.length; i++){

			    if(tabIdentifiantLocatairesBien[indiceBien] == verification[i]){

				mot = false;
			    }
			}

			if(mot == false){

				//on affiche les données du bien crée

			    System.out.println("Le bien vient d'être créer et voici les informations enregistrées pour ce bien:\n");

			    System.out.println("L'identifiant du nouveau bien est: " + tabIdentifiantBien[indiceBien]);

			    System.out.println("L'identifiant de ce type de bien est: " + tabIdentifiantTypeDeBien[indiceBien]);

			    System.out.println("La description de ce nouveau bien est: " + tabDescriptionBien[indiceBien]);

			    System.out.println("Numero identifiant du dernier locataire: " + tabIdentifiantLocatairesBien[indiceBien]);

			    indiceBien++;
			}

			else{

			    System.out.println("Ce locataire n'existe pas!");

			    do{

				System.out.println("Voulez vous recommencez? ( O / N )");

				ouiNon = sc.nextLine().charAt(0);

				if(ouiNon == 'n' && ouiNon == 'N'){

				    compteurBien--;
				}

			    }while(ouiNon != 'o' && ouiNon != 'O' && ouiNon != 'n' && ouiNon != 'N');
			}

		    }while(ouiNon == 'o' || ouiNon == 'O');
		}else
		    System.out.println("\nImpossible!! Aucun type de bien n'a cet identifiant !");
	}


    void modifierBien(){

    	//méthode permettant de modifier un bien

		int choix = 0;

		//boucle vérifiant que l'utilisateur entre bien un nombre

        do{

            System.out.print("Quel est l'identifiant du bien dont vous souhaitez modifier les informations? ");

            while(!sc.hasNextInt()){

                System.out.println("\nCe n'est pas un nombre!\nVeuillez entrer l'identifiant du bien dont vous souhaitez modifier les informations :");

                sc.next();
            }

	        choix = sc.nextInt();

        }while(choix < 0);

        	//appel de la methode chercheIndiceBien qui retourne l'indice où l'identifiant du bien est présent
        	//si aucun identifiant n'est trouvé retourne -1

		   choix = chercheIndiceBien(choix);

		   //message d'erreur si aucun indice pour l'identifiant n'est trouvé

		  if(choix == -1 ){

		        System.out.println("\nL'identifiant a été supprimé ou n'existe pas!");
		   }
		  else{

		  	//on affiche les données du bien 

		    System.out.println("\nVoici les informations sur ce bien:\n");

		    System.out.println("L'identifiant du type de bien est : " + tabIdentifiantTypeDeBien[choix]);

		    System.out.println("La description de ce bien est : " + tabDescriptionBien[choix]);

		    System.out.println("Numero identifiant du dernier locataire : " + tabIdentifiantLocatairesBien[choix]+"\n");

		    //on demande quelle donnée l'utilisateur souhaite modifier

		    System.out.println("Que voulez-vous modifier ?\n");

		    System.out.println("(1) L'identifiant du type de bien");

		    System.out.println("(2) La description de ce bien");

		    System.out.println("(3) Le numero identifiant du dernier locataire");

		    int choix2 = 0;

		    //boucle vérifiant que l'utilisateur entre bien un nombre

	        do{

	            System.out.print("\nQue voulez vous faire? ");

	            while(!sc.hasNextInt()){

	                System.out.println("\nCe n'est pas un nombre!\nQue voulez vous faire? ");

	                sc.next();
	            }

		        choix2 = sc.nextInt();

	        }while(choix2 < 0);

	        //on vide le sc.nextInt() afin de ne pas avoir d'erreur

		    sc.nextLine();

		    //1ere condition modification de l'identifiant du type de bien pour le bien selectionné

		    if (choix2 == 1){

		    	//boucle vérifiant que l'utilisateur entre bien un nombre

	            do{

			              System.out.println("Entrez le nouvel identifiant du type de bien : ");

	                      while(!sc.hasNextInt()){

	                          System.out.println("\nCe n'est pas un nombre!\nEntrez le nouvel identifiant du type de bien :");

	                          sc.next();
	                      }

	                      //on entre la nouvelle donnée dans le tableau

			              tabIdentifiantTypeDeBien[choix]= sc.nextInt();

	            }while(tabIdentifiantTypeDeBien[choix] < 0);

	            //on vide le sc.nextInt() afin de ne pas avoir d'erreur

		        sc.nextLine();

		        //on affiche la modification

			System.out.println("Le nouvel identifiant du type de bien est :");

			System.out.println(tabIdentifiantTypeDeBien[choix]);
		    }

		    if (choix2 == 2){

		    	//2eme condition modification de la description du bien

			System.out.println("Entrez la nouvelle description de ce bien : ");

			//on entre la nouvelle donnée dans le tableau

			tabDescriptionBien[choix]= sc.nextLine();

			//on affiche la modification

			System.out.println("Le nouvelle description de ce bien est :");

			System.out.println(tabDescriptionBien[choix]);
		    }

		    if (choix2 == 3){

		    	//3eme condition modification de l'identifiant du dernier locataire louant le bien

		    	//boucle vérifiant que l'utilisateur entre bien un nombre

	            do{

			              System.out.println("Entrez le nouvel identifiant du dernier locataire louant ce bien : ");

	                      while(!sc.hasNextInt()){

	                          System.out.println("\nCe n'est pas un nombre!\nEntrez le nouvel identifiant du dernier locataire louant ce bien :");

	                          sc.next();
	                      }

	                      //on entre la nouvelle donnée dans le tableau

			              tabIdentifiantLocatairesBien[choix]= sc.nextInt();

	            }while(tabIdentifiantLocatairesBien[choix] < 0);

	            //on vide le sc.nextInt() afin de ne pas avoir d'erreur

			    sc.nextLine();

			    //on affiche la modification

			System.out.println("Le nouvel identifiant du locataire louant ce bien sont :");

			System.out.println(tabIdentifiantLocatairesBien[choix]);
		    }
		}
    }

    void supprimerBien(){

    	//méthode permettant de supprimer un bien

		Locations Olocation = new Locations();

		int supp = 0;

		int resultat = 0;

		char ouiNon = ' ';

		boolean mot = true;

		//boucle vérifiant que l'utilisateur entre bien un nombre

	    do{

		       System.out.println("Quel est l'identifiant du bien que vous souhaitez supprimer ?");

		          System.out.print("Identifiant numéro : ");

	              while(!sc.hasNextInt()){

	                  System.out.println("\nCe n'est pas un nombre!\nQuel est l'identifiant du bien que vous souhaitez supprimer ?");

	                  sc.next();
	              }

		             supp = sc.nextInt();
	    }while(supp < 0);

	    //on vide le sc.nextInt() afin de ne pas avoir d'erreur

		sc.nextLine();

		for(int o = 0; o < 100; o++){

		    if(supp == Olocation.getIdentifiantBienLoue(o)){

			mot = false;

		    }
		}

		if(supp > compteurBien || mot == false){

		    System.out.println("\nL'identifiant "+supp+ " n'éxiste pas ou alors le bien est deja loué\n");
		}

		else{

		    System.out.println();

		    resultat = chercheIndiceBien(supp);

		    System.out.print(tabDescriptionBien[resultat] + " va être supprimé.\n");

		    //boucle de validation du choix de l'utilisateur

		    do{

			ouiNon = ' ';

			System.out.print("Validé ( O / N ): ");

			ouiNon = sc.nextLine().charAt(0);

		    }while(ouiNon != 'o' && ouiNon != 'O' && ouiNon != 'n' && ouiNon != 'N');

		    if(ouiNon == 'o' || ouiNon == 'O'){

		    	//on vide les données a l'indice du bien à supprimer

			tabIdentifiantBien[resultat]= 0;

			tabIdentifiantTypeDeBien[resultat]= 0;

			tabDescriptionBien[resultat]= null;

			tabIdentifiantLocatairesBien[resultat]= 0;

			System.out.println("\nLe bien et ses informations ont été supprimer !\n");

			if(indiceBien > 0){

				//on place les données du dernier bien créé a l'indice du bien supprimé

			    tabIdentifiantBien[resultat]= tabIdentifiantBien[indiceBien - 1];

			    tabIdentifiantTypeDeBien[resultat]= tabIdentifiantTypeDeBien[indiceBien - 1];

			    tabDescriptionBien[resultat]= tabDescriptionBien[indiceBien - 1];

			    tabIdentifiantLocatairesBien[resultat]= tabIdentifiantLocatairesBien[indiceBien - 1];

			    //on vide les tableau au dernier indice créé

			    tabIdentifiantBien[indiceBien - 1]= 0;

			    tabIdentifiantTypeDeBien[indiceBien - 1]= 0;

			    tabDescriptionBien[indiceBien - 1]= null;

			    tabIdentifiantLocatairesBien[indiceBien - 1]= 0;

			    //on décrémente l'indice du bien

			    indiceBien--;

			}
		    }

		    else{

			System.out.println("\nLe bien n'a pas été supprimer !");

		    }
		}
    }

    void afficherBienParOrdreAlphabetique(){

    	//méthode permettant d'afficher la liste des biens par ordre alphabétique

		int compteur = 0;

		System.out.println();

		//condition vérifiant qu'au moins un bien est créé

		if(tabDescriptionBien[0] == null){

		    System.out.println("Aucune données à trier !");
		}

		else{

		    for(int i = 0; i < tabDescriptionBien.length; i++){

				if(tabDescriptionBien[i] != null){

					//on incrémente un compteur quand le tableau n'est pas vide

			    	compteur++;
				}
			}

			//on crée un nouveau tableau de la taille du compteur

		    String tabDescriptionBien2 [] = new String [compteur];

		    for(int c = 0; c < tabDescriptionBien.length; c++){

				if(tabDescriptionBien[c] != null){

					//on place les données non nulles du tableau de description dans le nouveau tableau 

			    	tabDescriptionBien2[c] = tabDescriptionBien[c].toLowerCase();
				}
		    }

		    //on trie le nouveau tableau par ordre alphabétique

		    Arrays.sort(tabDescriptionBien2);

		    //on affiche le nouveau tableau 

		    for(int j = 0; j < tabDescriptionBien2.length; j++){

			System.out.println(tabDescriptionBien2[j]);
		    }
		}
    }

    void afficherListeBienTypeDeBien(){

    	//méthode affichant la liste des bien correspondant à un type de bien

    	//l'utilisateur rentre un nom de type de bien

        System.out.print("Entrez le nom du type de bien recherché: ");

        String rechercheTypeDeBien = sc.nextLine();

        String resultatRechercheNom = "";

        //le nom rentré par l'utilisateur est passé en minuscule

        rechercheTypeDeBien = rechercheTypeDeBien.toLowerCase();

        int identifiantRechercheTypeDeBien = 0;

        TypeDeBiens OTypeDeBiens = new TypeDeBiens();

        Locataires OLocataires = new Locataires();

        //appel de la méthode rechercheNomTypeDeBien dans la classe type de bien qui retourne le nom du type de bien
        //si aucun resultat n'est trouvé la méthode retourne -1

        identifiantRechercheTypeDeBien = OTypeDeBiens.rechercheNomTypeDeBien(rechercheTypeDeBien);

        //message d'erreur si aucun nom correspondant n'est trouvé dans le tableau  

        if(identifiantRechercheTypeDeBien == -1){

	    System.out.println("\nCe type de bien n'existe pas");
        }
        else{

        	//on affiche les biens

		    System.out.println("\nLa liste des biens de type " + rechercheTypeDeBien + " est :");

		    for(int i = 0 ; i < tabIdentifiantTypeDeBien.length ; i++){

				if(identifiantRechercheTypeDeBien == tabIdentifiantTypeDeBien[i]){

			   	 	System.out.println("\nIdentifiant : " + tabIdentifiantBien[i]+"\nBien: "+ tabDescriptionBien[i]);

			    	//on affiche les locataires s'il y en a

			    	if(tabIdentifiantLocatairesBien[i] != 0){

			    		//appel de la méthode rechercheNomLocataire qui retourne le nom du locataire en passant l'identifiant en parametre

						resultatRechercheNom = OLocataires.rechercheNomLocataire(tabIdentifiantBien[i]);

						System.out.println("Nom du locataire : " + resultatRechercheNom);
			    	}

			    	//message d'erreur s'il n'y a aucun locataire pour ce bien

			    	else{

						System.out.println("Nom du locataire : pas de locataire pour ce bien");
			    	}
				}
		    }
        }
    }

    int chercheIndiceBien (int supp){

    	//méthode recherchant l'indice où l'identifiant passé en parameStre est présent dans le tableau

	for(int i = 0; i < tabIdentifiantBien.length; i++){

	    if(tabIdentifiantBien[i] == supp){

		return i;
	    }
	}

	//si aucun identifiant correspondant n'est trouvé la méthode retourne -1

	return -1;
    }
}
