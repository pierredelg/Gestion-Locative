import java.util.*;

public class Locations{

	//classe qui regroupe les méthodes de la partie Gestion des locations du menu principal 

	//déclaration des variables 

    public static int compteurLocation = 0;

    public static int indiceLocation = 0;

    //déclaration des tableaux qui contiendront les données

    public static int [] tabIdentifiantLocation = new int [100];

    public static int [] tabIdentifiantBienLoue = new int [100];

    public static int [] tabIdentifiantLocataireBien = new int [100];

    public static String [] tabNomLocataireLocation = new String [100];

    public static String [] tabDescriptionBienLocation = new String[100];

    //déclaration des clones de tableaux des autres classes

    private int [] cloneTabIdentifiantLocataire = new int [500];

    private int [] cloneTabIdentifiantBien = new int [100];

    private int [] cloneTabIdentifiantTypeDeBien = new int [20];

    private int [] cloneTabBiensIdentifiantTypeDeBien = new int [100];

    private int [] [] cloneTabIdentifiantBienLoueLocataire = new int [500][5];

    private String [] cloneTabNomLocataire = new String [500];

    private String [] cloneTabDescriptionBien = new String [100];

    private String [] cloneTabNomTypeDeBien = new String [20];

    //déclaration des objets

    Scanner sc = new Scanner(System.in);

    Locataires objetLocataire = new Locataires();

    Biens objetBiens = new Biens();

    TypeDeBiens objetTypeDeBien = new TypeDeBiens();

    //méthodes get afin de récupérer les données de la classe

    public static int getIndice(){

	return indiceLocation;
    }

    public static int getCompteurLocation(){

	return compteurLocation;
    }

    public static String [] getTabDescriptionBienLocation(){

	return tabDescriptionBienLocation;
    }

    public static String [] getTabNomLocataireLocation(){

	return tabNomLocataireLocation;
    }

    public static int [] getTabIdentifiantLocation(){

	return tabIdentifiantLocation;
    }

    public static int [] getTabIdentifiantBienLoue(){

	return tabIdentifiantBienLoue;
    }

    public static int [] getTabIdentifiantLocataireBien(){

	return tabIdentifiantLocataireBien;
    }

    public int getIdentifiantLocation(int indice){

	return tabIdentifiantLocation[indice];
    }

    public int getIdentifiantBienLoue(int indice){

	return tabIdentifiantBienLoue[indice];
    }

    public int getIdentifiantLocataireBien(int indice){

	return tabIdentifiantLocataireBien[indice];
    }

    public String getNomLocataireLocation(int indice){

	return tabNomLocataireLocation[indice];
    }

    public String getDescriptionBienLocation(int indice){

	return tabDescriptionBienLocation[indice];
    }

//méthodes set afin de modifier les valeurs

    public static void setIndice(int n){

	indiceLocation = n;
    }

    public static void setCompteurLocation(int n){

	compteurLocation = n;
    }

    public void setIdentifiantLocation(int indice,int identifiant){

	tabIdentifiantLocation[indice] = identifiant;
    }

    public void setIdentifiantBienLoue(int indice,int identifiant){

	tabIdentifiantBienLoue[indice] = identifiant;
    }

    public void setIdentifiantLocataireBien(int indice,int identifiant){

	tabIdentifiantLocataireBien[indice] = identifiant;
    }

    public void setNomLocataireLocation(int indice, String nom){

	tabNomLocataireLocation[indice] = nom;
    }

    public void setDescriptionLocataireLocation(int indice, String description){

	tabDescriptionBienLocation[indice] = description;
    }

    void louerUnBien(){

    	//méthode qui permet la location d'un bien

		int resultatIdentifiantLocataire = 0;

		int resultatIdentifiantBien = 0;

		int resultatIdentifiantTypeDeBien = 0;

    	int resultatIdentifiantLocation = 0;

		int resultatIdentifiantBienLoue = 0;

		String choix = "";

		String resultatNomLocataire = "";

		String resultatDescriptionBien = "";

		String resultatNomTypeDeBien = "";

		//création de "clones" de tableaux des autres classes

		cloneTabNomTypeDeBien = objetTypeDeBien.getTabNomTypeDeBien();

		cloneTabIdentifiantTypeDeBien = objetTypeDeBien.getTabIdentifiantTypeDeBien();

		cloneTabDescriptionBien = objetBiens.getTabDescriptionBien();

		cloneTabBiensIdentifiantTypeDeBien = objetBiens.getTabIdentifiantTypeDeBien();

		cloneTabIdentifiantBien = objetBiens.getTabIdentifiantBien();

		cloneTabIdentifiantLocataire = objetLocataire.getTabIdentifiantLocataire();

		cloneTabNomLocataire = objetLocataire.getTabNomLocataire();

		//condition vérifiant que l'indice maximum des tableaux n'est pas atteint

		if(indiceLocation == 100){

			System.out.println("Espace indisponible pour ajouter un bien en location !");
		}
		else{

			//condition afin de vérifier qu'un locataire, un bien et un type de bien existe

			if(cloneTabIdentifiantTypeDeBien[0] != 0 && cloneTabIdentifiantBien[0] != 0 && cloneTabIdentifiantLocataire[0] != 0 ){

		    	System.out.println("Voici la liste des types de biens disponible :\n");

		    	//affichage des nom de type de bien

		    	for (int i = 0 ; i < cloneTabNomTypeDeBien.length ; i++){

					if (cloneTabNomTypeDeBien[i] != null){

			    		System.out.println("=> "+ cloneTabNomTypeDeBien[i]);
					}
		    	}

		    	System.out.println("\nEntrez le nom du type de bien recherché : ");

		    	resultatNomTypeDeBien = sc.nextLine();

		    	//boucle permettant de retrouver l'identifiant du type de bien avec le nom du type de bien

			    for(int j = 0 ; j < cloneTabNomTypeDeBien.length ; j++){

					if(resultatNomTypeDeBien.equals(cloneTabNomTypeDeBien[j])){

				    	resultatIdentifiantTypeDeBien = cloneTabIdentifiantTypeDeBien[j];
					}
			    }

			    System.out.println("Les différents biens disponibles pour le type choisi sont:\n");

			    //affichage des biens en fonction de l'identifiant du type de bien

			    for(int k = 0 ; k < cloneTabDescriptionBien.length; k ++){

					if(cloneTabBiensIdentifiantTypeDeBien[k] == resultatIdentifiantTypeDeBien){

				    	if (cloneTabIdentifiantBien[k] != 0){

							System.out.println("(" +cloneTabIdentifiantBien[k] + ") " + cloneTabDescriptionBien[k]);

			    		}
					}
		    	}
		    	//boucle afin de vérifier que le nombre soit bien un nombre
	            do{

	        	      System.out.println("\nVeuillez Entrer le numéro du bien choisi:");

	                   while(!sc.hasNextInt()){

	                          System.out.println("\nCe n'est pas un nombre!\nVeuillez entrer le numéro du bien choisi:");

	                          sc.next();
	                      }

	        	      resultatIdentifiantBien = sc.nextInt();

	            }while(resultatIdentifiantBien < 0);

	            //on vide le sc aprés le sc.nextInt() afin de ne pas avoir d'erreur

		    	sc.nextLine();

		    	//boucle de recherche de la description du bien avec l'identifiant du bien

		    	for(int l = 0 ; l < cloneTabIdentifiantBien.length ; l++){

					if ( cloneTabIdentifiantBien[l] == resultatIdentifiantBien){

			    		resultatDescriptionBien = cloneTabDescriptionBien[l];
					}
		    	}

		    	System.out.println("Vous souhaitez louer: " + resultatDescriptionBien);

		    	//boucle afin de confirmer le choix entré par l'utilisateur

		    	do{

					System.out.println("Confirmer le choix (o/n) ?");

					choix = sc.nextLine();

		    	}while(choix.charAt(0) != 'o' && choix.charAt(0) != 'O' && choix.charAt(0) != 'n' && choix.charAt(0) != 'N');

		    	if(choix.charAt(0) == 'o' || choix.charAt(0) == 'O'){

		    		//boucle de vérification que ce soit bien un nombre rentré par l'utilisateur

	                do{

	            	     System.out.println("Entrez l'identifiant du nouveau locataire pour ce bien:");

	                       while(!sc.hasNextInt()){

	                              System.out.println("\nCe n'est pas un nombre!\nVeuillez entrez l'identifiant du nouveau locataire pour ce bien:");

	                              sc.next();
	                          }

	            	      resultatIdentifiantLocataire = sc.nextInt();

	                }while(resultatIdentifiantLocataire < 0);

	                //on vide le sc aprés le sc.nextInt() afin de ne pas avoir d'erreur

					sc.nextLine();

					//boucle de recherche du nom du locataire avec l'identifiant du locataire

					for(int m = 0 ; m < cloneTabIdentifiantLocataire.length ; m++){

				    	if (cloneTabIdentifiantLocataire[m] == resultatIdentifiantLocataire){

							resultatNomLocataire = cloneTabNomLocataire[m];
			    		}
					}

					System.out.println("Le locataire choisi est: " + resultatNomLocataire );

					//boucle de confirmation du choix de l'utilisateur
					do{

				    	choix = "";

				    	System.out.println("Confirmer le choix (o/n) ?");

			    		choix = sc.nextLine();

					}while(choix.charAt(0) != 'o' && choix.charAt(0) != 'O' && choix.charAt(0) != 'n' && choix.charAt(0) != 'N');

					if (choix.charAt(0) == 'o' || choix.charAt(0) != 'O'){

						//on incrémente le compteur location pour la prochaine location

				    	compteurLocation++;

				    	//on remplit les tableaux des données de location au même indice

			    		tabIdentifiantLocation[indiceLocation] = compteurLocation;

				    	tabDescriptionBienLocation[indiceLocation] = resultatDescriptionBien;

				    	tabIdentifiantBienLoue[indiceLocation] = resultatIdentifiantBien;

				    	tabIdentifiantLocataireBien[indiceLocation] = resultatIdentifiantLocataire;

				    	tabNomLocataireLocation[indiceLocation] = resultatNomLocataire;

				    	//on incrémente l'indice pour la prochaine location

			    		indiceLocation ++;

				    	System.out.println(resultatNomLocataire+ " est maintenant le nouveau locataire du bien: "+resultatDescriptionBien);
					}
		    	}
			}
			//message d'erreur si aucun bien n'est présent a l'indice 0

			if(cloneTabIdentifiantBien[0] == 0){

			    System.out.println("\nIl n'y a aucun bien dans la base de donnée");
			}
			//message d'erreur si aucun type de bien n'est présent a l'indice 0

			if(cloneTabIdentifiantTypeDeBien[0] == 0){

			    System.out.println("Il n'y a aucun type de bien dans la base de donnée");
			}
			//message d'erreur si aucun locataire n'est présent a l'indice 0

			if(cloneTabIdentifiantLocataire[0] == 0){

			    System.out.println("Il n'y a aucun locataire dans la base de donnée");
			}
		}
    }

    void libererUnBien(){

    //méthode afin de libérer un bien

	int resultatIdentifiantLocation = 0;

	int resultatIdentifiantBienLoue = 0;

	int indicesuppression = 0;

	String choix = "";

	String resultatDescriptionBien = "";

	cloneTabIdentifiantBien = objetBiens.getTabIdentifiantBien();

	cloneTabDescriptionBien = objetBiens.getTabDescriptionBien();

	//message d'erreur si aucun bien n'est présent a l'indice 0

	if(tabIdentifiantBienLoue[0] == 0){

	    System.out.println("Il n'y a aucun bien loué dans la base de donnée");
	}

	//message d'erreur si aucun locataire n'est présent a l'indice 0

	if(tabIdentifiantLocataireBien[0] == 0){

	    System.out.println("Il n'y a aucun locataire louant un bien dans la base de donnée");
	}

	//condition de vérification qu'un bien soit en location par un locataire

	if(tabIdentifiantBienLoue[0] != 0 && tabIdentifiantLocataireBien[0] != 0 ){

		//appel de la méthode afin d'afficher les biens loués

	    afficherListeBiensLoue();

	    //boucle de vérification que le nombre rentré par l'utilisateur soit bien un nombre

        do{

            System.out.println("Quel bien souhaitez vous liberer ?");

           System.out.println("Entrez l'identifiant de la location que vous souhaitez supprimer :");

               while(!sc.hasNextInt()){

                      System.out.println("\nCe n'est pas un nombre!\nVeuillez entrez l'identifiant de la location que vous souhaitez supprimer :");

                      sc.next();
                  }

              resultatIdentifiantLocation = sc.nextInt();

        }while(resultatIdentifiantLocation < 0);

        //on vide le buffer de sc.nextInt() afin de ne pas avoir d'erreur

	    sc.nextLine();

	    //boucle de recherche de l'identifiant du bien loué dans le tableau 

	    for(int i = 0 ; i < tabIdentifiantLocation.length ; i++){

		if ( tabIdentifiantLocation[i] == resultatIdentifiantLocation){

		    resultatIdentifiantBienLoue = tabIdentifiantBienLoue[i];

		    //récuperation de l'indice pour supprimer les données des autres tableau

		    indicesuppression = i;
		}
	    }

	    //boucle de recherche de la description du bien avec l'identifiant du bien en location 

	    for(int j = 0 ; j < cloneTabDescriptionBien.length ; j ++){

		if( cloneTabIdentifiantBien[j] == resultatIdentifiantBienLoue){

		    resultatDescriptionBien = cloneTabDescriptionBien[j];
		}
	    }

	    System.out.println("Le bien que vous souhaitez liberer est : " + resultatDescriptionBien + " dont l'identifiant est " + resultatIdentifiantBienLoue);

	    //boucle de confirmation du choix de l'utilisateur

	    do{

		System.out.println("Confirmer le choix (o/n) ?");

		choix = sc.nextLine();

	    }while(choix.charAt(0) != 'o' && choix.charAt(0) != 'O' && choix.charAt(0) != 'n' && choix.charAt(0) != 'N');

	    if (choix.charAt(0) == 'o' || choix.charAt(0) == 'O'){

	    	//toutes les données dans les tableaux au même indice sont misent à zero

		tabIdentifiantLocation[indicesuppression] = 0;

		tabIdentifiantBienLoue[indicesuppression] = 0;

		tabIdentifiantLocataireBien[indicesuppression] = 0;

		tabNomLocataireLocation[indicesuppression] = "";

		//toutes les données du dernier bien en location rentré sont misent à la place de ce qui est supprimé

		tabIdentifiantLocation[indicesuppression] = tabIdentifiantLocation[indiceLocation - 1];

		tabIdentifiantBienLoue[indicesuppression] = tabIdentifiantBienLoue[indiceLocation - 1];

		tabIdentifiantLocataireBien[indicesuppression] = tabIdentifiantLocataireBien[indiceLocation - 1];

		tabNomLocataireLocation[indicesuppression] = tabNomLocataireLocation[indiceLocation - 1];

		//les données au dernier indice non vide sont misent a 0

		tabIdentifiantLocation[indiceLocation - 1] = 0;

		tabIdentifiantBienLoue[indiceLocation - 1] = 0;

		tabIdentifiantLocataireBien[indiceLocation - 1] = 0;

		tabNomLocataireLocation[indiceLocation - 1] = "";

		System.out.println("Le bien est libéré avec succès ");

		//on décrémente l'indice pour le prochain bien à mettre en location

		indiceLocation --;
	    }
	}

    }

    void afficherListeBiensLoue(){

    	//méthode qui affiche la liste des biens loués

    	//condition afin de vérifier que des biens sont en location et message d'erreur le cas échéant

        if(tabIdentifiantLocation[0] != 0){

	           System.out.println("Voici la liste des biens en location : \n");
        }
        else{

            System.out.println("\nAucun bien n'est en location !");
        }

    //boucle de recherche des informations des biens en location

	for(int i = 0; i < tabIdentifiantBienLoue.length ; i ++){

	    if(tabIdentifiantLocation[i] != 0){

		System.out.println("\nIdentifiant location: " +tabIdentifiantLocation[i]+"\nNom du bien: "+tabDescriptionBienLocation[i]+ "\nLocataire: "+tabNomLocataireLocation[i]);
	    }
	}
    }

    void afficherListeLocatairesBiens(){

    	//méthode afin d'afficher la liste des locataires ayant deja loué un bien

    	//creation des tableaux "clones" de la classe locataire 

	cloneTabNomLocataire = objetLocataire.getTabNomLocataire();

	cloneTabIdentifiantLocataire = objetLocataire.getTabIdentifiantLocataire();

	cloneTabIdentifiantBienLoueLocataire = objetLocataire.getTabIdentifiantBienLoueLocataire();

	//condition afin de vérifier qu'un locataire ayant loué un bien existe

    if (cloneTabIdentifiantBienLoueLocataire[0][0] != 0){

	       System.out.println("\nVoici la liste des locataires de bien : ");
    }
    else{

        System.out.println("\nAucun locataire ayant loué un bien n'existe!");
    }

    //boucle de recherche dans le tableau des biens d'un locataire et affichage des données des locataires ayant loués un bien

	for (int i = 0; i < cloneTabIdentifiantBienLoueLocataire.length; i ++){

	    if (cloneTabIdentifiantBienLoueLocataire[i][0] != 0){

		System.out.println("\nIdentifiant locataire: " + cloneTabIdentifiantLocataire[i] +"\nNom locataire: " + cloneTabNomLocataire[i]);
	    }
	}
    }

    void afficherListeLocataireLoueur(){

    	//méthode afin d'afficher la liste des locataires louant un bien

    	//condition de vérification qu'un locataire ayant un bien en cours de location existe 

        if (tabNomLocataireLocation[0] != null){

	           System.out.println("\nVoici la liste des locataires ayant au moins un bien en cours de location : ");
        }
        else{

            System.out.println("\nAucun locataire ayant au moins un bien en cours de location n'existe !");
        }

        //boucle qui affiche les informations sur les locataires ayant un bien en cours de location

	for (int i = 0 ; i < tabNomLocataireLocation.length ; i ++ ){

	    if (tabNomLocataireLocation[i] != null){

		System.out.println("\nIdentifiant locataire: " + tabIdentifiantLocataireBien[i] + "\nNom locataire: " + tabNomLocataireLocation[i]);
	    }
	}
    }
}
