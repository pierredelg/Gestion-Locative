import java.util.*;

public class TypeDeBiens{

    //classe qui regroupe les méthodes de la partie Gestion de type de bien dans le menu principal

    //déclaration des variables

    public static int indiceTypeDeBien = 0;

    public static int compteurTypeDeBien = 0;

    //déclaration des tableaux

    public static int [] tabIdentifiantTypeDeBien = new int [20];

    public static String [] tabNomTypeDeBien = new String [20];

    //déclaration des objets

    Scanner sc = new Scanner (System.in);

    Biens Biens = new Biens();

    //méthodes get afin de récupérer les données 

    public static int getIndice1(){

	return indiceTypeDeBien;
    }

    public static int getIdentifiantTypeDeBien1(){

        return compteurTypeDeBien;
    }

    public static int [] getTabIdentifiantTypeDeBien(){

        return  tabIdentifiantTypeDeBien;

    }

    public static  String[] getTabNomTypeDeBien(){

        return tabNomTypeDeBien;
    }

    public int getIdentifiantTypeDeBien(int indice){

        return tabIdentifiantTypeDeBien[indice];
    }

    public String getNomTypeDeBien(int indice){

        return tabNomTypeDeBien[indice];
    }

    //méthodes set afin de modifier les données

    public void setIndiceTypeDeBien(int n){

        indiceTypeDeBien = n;
    }

    public static void setCompteurTypeDeBien(int n){

        compteurTypeDeBien = n;
    }

    public void setIdentifiantTypeDeBien1(int indice,int identifiant){

        tabIdentifiantTypeDeBien[indice] = identifiant;
    }

    public void setNomTypeDeBien1(int indice,String nom){

        tabNomTypeDeBien[indice] = nom;
    }

    void creationTypeDeBien(){

        //méthode permettant de créer un type de bien

	String nouveau = "";

	char choix = ' ';

        //boucle 

	do{
	    choix = ' ';

	    System.out.print("\nVeuillez entrer le nom du nouveau type de bien: ");

	    nouveau = sc.nextLine();

        //le nom entré par l'utilisateur est passé en minuscule

	    nouveau = nouveau.toLowerCase();

        //boucle de vérification que le nom du type de bien n'existe pas déja

	    for(int i = 0; i < tabNomTypeDeBien.length; i++){

		    if(tabNomTypeDeBien[i] != null && tabNomTypeDeBien[i].equals(nouveau) ){

			System.out.println("\n================> Ce type de bien est deja existant! <================ ");

			do{

			    System.out.print("\nVoulez vous répeter l'opération ? (O / N): ");
			    choix = sc.nextLine().charAt(0);

			}while(choix != 'o' && choix != 'O' && choix != 'n' && choix != 'N');
		    }
	    }
	}while(choix == 'o' || choix == 'O');

	if(choix == ' '){

        //on incrémente le compteur du type de bien

	    compteurTypeDeBien++;

        //on remplit les tableaux a l'indice

	    tabIdentifiantTypeDeBien[indiceTypeDeBien] = compteurTypeDeBien;
	    
        tabNomTypeDeBien[indiceTypeDeBien] = nouveau;

	    System.out.println("\nLe type de bien vient d'être créer.");

	    System.out.println("L'identifiant du nouveau type de bien est: " + tabIdentifiantTypeDeBien[indiceTypeDeBien]+" et a pour description: " + tabNomTypeDeBien[indiceTypeDeBien]);
	    
        //on incrémente l'indice pour la prochaine création de type de bien

        indiceTypeDeBien++;

	}
    }


    void modifierTypeDeBien(){

        int choix = 0;

        //boucle de vérification que le nombre entré par l'utilisateur soit bien un nombre

        do{

    	       System.out.print("Quel est l'identifiant du type de bien dont vous souhaitez modifier les informations?");

               while(!sc.hasNextInt()){

                      System.out.println("\nCe n'est pas un nombre!\nQuel est l'identifiant du type de bien dont vous souhaitez modifier les informations?");

                      sc.next();
                  }

    	        choix = sc.nextInt();

        }while(choix < 0);

        //appel de la méthode cherche indice retournant l'indice du tableau où l'identifiant du type de bien est présente 

        choix = chercheIndice(choix);

        //on vide le buffer du sc.nextInt afin de ne pas avoir d'erreur

	sc.nextLine();

	if(choix >= 0){

        //affichage des données type de bien

	    System.out.println("Voici les informations enregistrées pour ce type de bien:");

	    System.out.println("\nL'identifiant du type de bien est : " + tabIdentifiantTypeDeBien[choix]);

	    System.out.println("Le libellé de ce type de bien est : " + tabNomTypeDeBien[choix]);

        //l'utilisateur entre les nouvelles données 

	    System.out.print("\nEntrez le nouveau libellé du type de bien : ");

	    tabNomTypeDeBien[choix] = sc.nextLine();

        //affichage des nouvelles données

	    System.out.println("Le nouveau nom de ce type de bien est : " + tabNomTypeDeBien[choix]);
	}else
	    System.out.println("\nAucun type de bien de cette identifiant existe!");

    }

    void supprimerTypeDeBien(){

        //méthode supprimant un type de bien 

    	String typeDeBien = " ";

    	int identifiant = -1 ;

    	boolean mot = true;

    	int indice2 = 0;

        int [] cloneID = Biens.getTabIdentifiantTypeDeBien();

        //l'utilisateur entre un nom de type de bien

    	System.out.print("Quel est le nom du type de bien que vous souhaitez supprimez? ");

    	typeDeBien = sc.nextLine();

        //boucle cherchant l'identifiant du type de bien avec le nom du type de bien

    	for(int i = 0; i < tabNomTypeDeBien.length; i++){

    	    if(typeDeBien.equals(tabNomTypeDeBien[i])){

    		identifiant = tabIdentifiantTypeDeBien[i];

            //on récupere l'indice où l'identifiant est présent

    		indice2 = i;
    	    }
    	}

        // message d'erreur si la méthode cherche indice ne trouve rien retourne -1
    	if(identifiant == -1){

    	    System.out.println("\nImpossible de supprimer le type \"" +typeDeBien+ "\" car il n'existe pas!");

        }


    	for(int c = 0; c < cloneID.length; c ++){

                if(cloneID[c] != 0  && cloneID[c] == identifiant){

                    mot = false;
                }
            }


    	if(mot == false )

                System.out.println("\nImpossible de supprimer " +typeDeBien+"! Des biens de ce type de biens sont existants.");

    	if(mot == true && identifiant != -1){

                System.out.println("\nLe type de bien " +typeDeBien+ " a bien été supprimer");

                tabIdentifiantTypeDeBien[indice2] = 0;

                tabNomTypeDeBien[indice2] = " ";

                if(indiceTypeDeBien   > 0){

                    //on deplace les données du dernier type de bien créé a l'indice du type de bien supprimé

                    tabIdentifiantTypeDeBien[indice2] = tabIdentifiantTypeDeBien[indiceTypeDeBien-1];

                    tabNomTypeDeBien[indice2] = tabNomTypeDeBien[indiceTypeDeBien-1];

                    //on vide les tableaux a l'indice du dernier type de bien créé 

                    tabIdentifiantTypeDeBien[indiceTypeDeBien-1] = 0;

                    tabNomTypeDeBien[indiceTypeDeBien-1] = null;

                    //on décrémente l'indice du type de bien

                    indiceTypeDeBien --;
                }
    	}
    }

    void afficherListeTypeDeBien(){

        //méthode affichant la liste des types de bien

        //condition vérifiant qu'un type de bien existe

        if(tabNomTypeDeBien[0] == null){

            System.out.println("Aucun type de bien a afficher!");

        }
        else {

            System.out.println("\nVoici la liste des types de biens : \n");

            //boucle affichant toutes les données des types de bien créés

            for(int i = 0;i < tabNomTypeDeBien.length;i++){

                if(tabNomTypeDeBien[i] != null){

                    System.out.println("Identifiant " + tabIdentifiantTypeDeBien[i] + "\nType de bien: " + tabNomTypeDeBien[i] + "\n");
                }
            }
        }
    }

    int chercheIndice (int supp){

        //méthode cherchant l'indice du tableau où l'identifiant donné en parametre est présent  

        for(int i = 0; i < tabIdentifiantTypeDeBien.length; i++){

            if(tabIdentifiantTypeDeBien[i] == supp){

                return i;
            }
        }
        //si aucun indice ne contient l'identifiant la valeur -1 est retournée
        return -1;
    }

    public static int rechercheNomTypeDeBien(String rechercheNom){

        //méthode recherchant le nom du type de bien avec un nom donné en parametre

        String comparaison = "";

        //boucle parcourant le tableau et recherche si le nom donné en parametre est présent dans le tableau

        for (int i = 0; i < tabNomTypeDeBien.length;i++){

            if(tabNomTypeDeBien[i] != null){

                comparaison = tabNomTypeDeBien[i];

                //pour effectuer la comparaison avec le nom on récupère le nom du tableau dans la variable
                // et on met le nom en minuscule

                comparaison = comparaison.toLowerCase();

                if (rechercheNom.equals(comparaison)){

                    return tabIdentifiantTypeDeBien[i];
                }
            }
        }
        //si aucun nom ne correspond a celui passé en parametre on retourne -1
        return -1;
    }
}
