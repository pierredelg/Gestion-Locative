import java.util.*;

public class Locataires{
    
    public static int indiceLocataire = 0;

    public static int compteurLocataire = 0;

    public static int [] tabIdentifiantLocataire = new int [500];

    public static int[] [] tabIdentifiantBienLoueLocataire = new int [500][5];

    public static String [] tabNomLocataire = new String [500];

    public static String [] tabAdresseLocataire = new String [500];

    Scanner sc = new Scanner (System.in);

    Biens Biens = new Biens();

    TypeDeBiens TypeDeBiens = new TypeDeBiens();
    
    public static int getIndice(){
	
	return indiceLocataire;
    }

    public static int getIdentifiantLocataire(){
	
	return compteurLocataire;
    }

    public static int [] getTabIdentifiantLocataire(){

    	return tabIdentifiantLocataire;
    }

    public static String [] getTabNomLocataire(){

    	return tabNomLocataire;
    }

    public static String [] getTabAdresseLocataire(){

    	return tabAdresseLocataire;
    }

    public static int [] [] getTabIdentifiantBienLoueLocataire(){

    	return tabIdentifiantBienLoueLocataire;
    }
    
    public int getIdentifiantLocataire(int indice){

	return tabIdentifiantLocataire[indice];
    }
    
    public String getNomLocataire(int indice){

	return tabNomLocataire[indice];
    }
    
    public String getAdresseLocataire(int indice){

	return tabAdresseLocataire[indice];
    }
    
    public int getIdentifiantBienLoueLocataire(int indice1, int indice2){

	return tabIdentifiantBienLoueLocataire[indice1][indice2];
    }

    public void setCompteurLocataire(int n) {
	
	compteurLocataire = n;
    }

    public void setIndiceLocataire(int n){
	
	indiceLocataire = n;
    }
    
    public void setIdentifiantLocataire(int indice,int identifiant){

	tabIdentifiantLocataire[indice] = identifiant;
    }
    
    public void setNomLocataire(int indice,String nom){

	tabNomLocataire[indice] = nom;
    }
    
    public void setAdresseLocataire(int indice,String adresse){

	tabAdresseLocataire[indice] = adresse;
    }
    
    public void setIdentifiantBienLoueLocataire(int indice1, int indice2 ,int identifiant){

	tabIdentifiantBienLoueLocataire[indice1] [indice2] = identifiant;
    }

    void  creation(){
	    
	compteurLocataire++;
	    
	if (indiceLocataire == 500){
		
	    System.out.println("Espace indisponible pour ajouter un nouveau locataire.");

	}
		
	tabIdentifiantLocataire[indiceLocataire] = compteurLocataire;	
		
	System.out.println("Veuillez entrer le nom du nouveau locataire :");

	tabNomLocataire[indiceLocataire]= sc.nextLine();

	System.out.println("Veuillez entrer l'adresse du nouveau locataire :");

	tabAdresseLocataire[indiceLocataire]= sc.nextLine();
		
	char ouiNon = ' ';
		
	int indice2 = 0;
        
	do{
		
	    if (indice2 == 5){
		
		System.out.println("\n==============> Impossible <==============\n==============> 5 MAXIMUM <==============");
		
		ouiNon = 'n';
	    }
	    else{
		do{
		    
		    
		    ouiNon = ' ';
			
		    System.out.print("Veuillez entrer le numéro identifiant du bien loué par le nouveau locataire s'il y'a lieu! \"0\" sinon: ");

		    while(!sc.hasNextInt()){
			 
			System.out.print("\nCe n'est pas un nombre!\nVeuillez entrer le numéro identifiant du bien loué par le nouveau locataire s'il y'a lieu! \"0\" sinon: ");
			sc.next();
		    }
		   
		    tabIdentifiantBienLoueLocataire[indiceLocataire][indice2]= sc.nextInt();
		}while( tabIdentifiantBienLoueLocataire[indiceLocataire][indice2] < 0);
		       
		indice2 ++;
			
		sc.nextLine();
		
		if(tabIdentifiantBienLoueLocataire[indiceLocataire][0] != 0){	
		    do{
			    
			ouiNon = ' ';
			    
			System.out.println("Voulez vous rentrez un autre identifiant de bien loué? ( O / N ) ");
		    
			ouiNon = sc.nextLine().charAt(0);
			
		    }while(ouiNon != 'o' && ouiNon != 'O' && ouiNon != 'n' && ouiNon != 'N');
		}else
		    ouiNon = 'n';
		
	    }
		
	}while(ouiNon == 'o' || ouiNon == 'O');
				
	System.out.println("\nL'utilisateur vient d'être créer.");

	System.out.println("Voici les informations enregistrées pour ce locataire:");

	System.out.println("Identifiant: " + tabIdentifiantLocataire[indiceLocataire] );

	System.out.println("Nom: " + tabNomLocataire[indiceLocataire]);

	System.out.println("Adresse: " + tabAdresseLocataire[indiceLocataire]+ "");

	System.out.println("Numero d'identifiant du bien loué: \n");
		
	for(int i = 0; i < indice2 ; i++){
		    
	    System.out.print("[ " +tabIdentifiantBienLoueLocataire[indiceLocataire][i]+" ] \n");
	}
		
	System.out.println();
		
	indiceLocataire ++;

    }

    void modifierLocataires(){

    	int resultat = 0;

    	int supp = 0;

	int choix2 = 0;

	do{

	    System.out.print("\nQuel est l'identifiant du locataire dont vous souhaitez modifier les informations? ");

	    while(!sc.hasNextInt()){

		System.out.print("\nCe n'est pas un nombre!\nQuel est l'identifiant du locataire dont vous souhaitez modifier les informations?: ");
		sc.next();
	    }

	    supp = sc.nextInt();

	}while(supp < 0);

	resultat = chercheIndice(supp);
		
	if(resultat == -1 ){
		
	    System.out.println("\nL'identifiant " +supp+ " a été supprimer ou n'existe pas!");
	}
	else{
		 
	    System.out.println();
		 
	    System.out.println("Voici les informations sur ce locataire:\n");

	    System.out.println("Nom: " + tabNomLocataire[resultat]);

	    System.out.println("Adresse: " + tabAdresseLocataire[resultat]);

	    System.out.println("Numero identifiant du ou des bien(s) loué(s): ");

	    for(int i = 0; i < tabIdentifiantBienLoueLocataire[resultat].length ; i++){
				
		if(tabIdentifiantBienLoueLocataire[resultat][i] != 0){
			    
		    System.out.print(" [ " +tabIdentifiantBienLoueLocataire[resultat][i]+" ]\n");
		}
	    }
		    
	    System.out.println();

	    System.out.println("Que voulez-vous modifier ?\n");

	    System.out.println("(1) Le nom du locataire");

	    System.out.println("(2) L'adresse du locataire");

	    System.out.println("(3) Les biens loués du locataire");
		    
	    System.out.println();
		    
	    do{
			
		System.out.print("Que voulez vous faire ? ");

		while(!sc.hasNextInt()){
		
		    System.out.print("\nCe n'est pas un nombre!\nQue voulez vous faire ?: ");
		    sc.next();
		}
			
		choix2 = sc.nextInt();
		    
	    }while(choix2 != 0 && choix2 != 1 && choix2 != 2 && choix2 != 3);
		
	    sc.nextLine();
		    
	    switch(choix2){
		    
	    case 1:
		   		        
		System.out.println("Entrez le nouveau nom : ");
			
		tabNomLocataire[resultat] = sc.nextLine();

		System.out.println("Le nouveau nom du locataire est :");

		System.out.println(tabNomLocataire[resultat]);
			
		break;
			
	    case 2:

		System.out.println("Entrez la nouvelle adresse : ");

		tabAdresseLocataire[resultat]= sc.nextLine();

		System.out.println("Le nouvelle adresse du locataire est :");

		System.out.println(tabAdresseLocataire[resultat]);
			
		break;
		
	    case 3:
		int compteur = 0;
				
		System.out.println("\nNumero identifiant du bien loué:\n ");
				
		for(int i = 0; i < tabIdentifiantBienLoueLocataire[resultat].length ; i++){
			     	
		  		
			System.out.println("Identifiant ("+(i+1)+") [ " +tabIdentifiantBienLoueLocataire[resultat][i]+" ] ");
			compteur += 1;
					
		}
			
		int choice = 0;
		do{
		    
		    System.out.println("\nQuel identifiant de bien à loué souhaitez vous modifier? ");

		    while(!sc.hasNextInt()){
		
			System.out.print("\nCe n'est pas un nombre!\nQuel identifiant de bien à loué souhaitez vous modifier: ");
			sc.next();
		    }
		
		    choice = sc.nextInt();
		    
		}while(choice > compteur);

		do{
			
		    System.out.println("Entrez le nouvelle identifiant du bien loué par le locataire : ");

		 
		    while(!sc.hasNextInt()){
		
			System.out.print("\nCe n'est pas un nombre!\nEntrez le nouvelle identifiant du bien loué par le locataire: ");
			sc.next();
		    }

		    tabIdentifiantBienLoueLocataire[resultat][choice - 1]= sc.nextInt();
		}while( tabIdentifiantBienLoueLocataire[resultat][choice - 1] < 0);

		System.out.println("Les nouveaux identifiants des biens loués par ce locataire sont :");

		for(int j = 0; j < tabIdentifiantBienLoueLocataire[resultat].length ; j++){
				
			System.out.println("[ " +tabIdentifiantBienLoueLocataire[resultat][j]+" ] ");
		}
			
		break;
	    	
	    default:
				
		choix2 = 0;
	    }
	}
    }

    void supprimerLocataires(){

    	int resultat = 0;

    	int supp = 0;
	   
	char ouiNon = ' ';

	do{
	    ouiNon = ' ';
	    
	    System.out.println("Quel est l'identifiant du locataire que vous souhaitez supprimer?: ");

	    while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nQuel est l'identifiant du locataire que vous souhaitez supprimer?: ");
		sc.next();
	    }
	      	
	    ouiNon = ' ';
		
	    supp = sc.nextInt();
	    
	}while(supp < 0);
		
	resultat = chercheIndice(supp);
		
	sc.nextLine();
		
	if(resultat == -1){
		    
	    System.out.println("\nL'identifiant " +supp+ " a été supprimer ou n'existe pas!");
	}
	        
	else{
		    
	    if(supp > compteurLocataire){
			
		System.out.println("\nL'identifiant "+supp+ " n'éxiste pas!\n");
	    }
		    
	    else{
			
		System.out.println();
			
		resultat = chercheIndice(supp);

		System.out.print(tabNomLocataire[resultat] + " va être supprimé.\n");
		    
			
		do{
			    
		    ouiNon = ' ';
			    
		    System.out.print("Validé ( O / N ): ");
			    
		    ouiNon = sc.nextLine().charAt(0);
			
		}while(ouiNon != 'o' && ouiNon != 'O' && ouiNon != 'n' && ouiNon != 'N');

		if(ouiNon == 'o' || ouiNon == 'O'){

		    tabIdentifiantLocataire[resultat]= 0;
		
		    tabNomLocataire[resultat]= null;

		    tabAdresseLocataire[resultat]= null;

		    for(int i = 0; i < tabIdentifiantBienLoueLocataire[resultat].length ;i++){
				
			tabIdentifiantBienLoueLocataire[resultat][i] = 0;
		    }
	
		    System.out.println("\nLe Locataire et ses informations ont bien été supprimer !\n");
	    
		    if(indiceLocataire > 0){
		    
			tabIdentifiantLocataire[resultat]= tabIdentifiantLocataire[indiceLocataire - 1];
		
			tabNomLocataire[resultat]= tabNomLocataire[indiceLocataire - 1];

			tabAdresseLocataire[resultat]= tabAdresseLocataire[indiceLocataire - 1];		

			for(int i = 0; i < tabIdentifiantBienLoueLocataire[indiceLocataire - 1].length ;i++){
				    
			    tabIdentifiantBienLoueLocataire[resultat][i]= tabIdentifiantBienLoueLocataire[indiceLocataire - 1][i];
			}
			
			tabIdentifiantLocataire[indiceLocataire -1]= 0;
		
			tabNomLocataire[indiceLocataire - 1]= null;

			tabAdresseLocataire[indiceLocataire - 1]= null;
				
			for(int i = 0; i < tabIdentifiantBienLoueLocataire[indiceLocataire - 1].length ;i++){
				    
			    tabIdentifiantBienLoueLocataire[indiceLocataire - 1][i] = 0;
			}
		    }
			
		    indiceLocataire--;
		
		}
			
		else{
			    	
		    System.out.println("\nLe locataire n'a pas été supprimer !");	
		}
	    }
	}
    }

    void afficherLocataireParOrdreAlphabetique(){
	
	int compteur = 0;
	
	System.out.println();
	
	if(tabNomLocataire[0] == null){
	    
	    System.out.println("Aucune données à trier !");
	}

	else{
	    
	    for(int i = 0; i < tabNomLocataire.length; i++){
		
		if(tabNomLocataire[i] != null){
		    		
		    compteur++;
		}
	    }
	    	
	    String tabNomLocataire2 [] = new String [compteur];
	    
	    for(int c = 0; c < tabNomLocataire.length; c++){
		
		if(tabNomLocataire[c] != null){
		    
		    tabNomLocataire2[c] = tabNomLocataire[c].toLowerCase();
		}
	    }
	    
	    Arrays.sort(tabNomLocataire2);
	    
	    for(int j = 0; j < tabNomLocataire2.length; j++){
		
		System.out.println(tabNomLocataire2[j]);
	    }
	}
    }

    void afficherLocataireAyantLoueTypeDeBienParticulier(){
	
	String [] clone = TypeDeBiens.getTabNomTypeDeBien();
		
	int []cloneID = TypeDeBiens.getTabIdentifiantTypeDeBien();
	
	String tabNomTypeDeBien2 [] = new String [20];
	
	String recherche = " ";
	
	int indice = -1;
	
	int indice2 = 0;
	
	int identifiant=0;
	
	int compteur = 0;
        
	System.out.print("Entrez le nom du type de bien recherché: ");
		
	recherche = sc.nextLine();
	
	System.out.println("\n______________LISTE RECHERCHÉE______________\n");
	
	for(int i = 0; i < clone.length; i++){
	    	
	    if(clone[i] != null){
			
		tabNomTypeDeBien2[i] = clone[i].toLowerCase();
	    	
	    }
	}
	
	for(int n = 0; n < tabNomTypeDeBien2.length; n++){
			
	    if(recherche.equals( tabNomTypeDeBien2[n])){
		    
		indice = n;
	    }
	}
	
	if(indice == -1){
	    
	    System.out.println("\nIl n'y a pas de type " +recherche+ " existant!");
	}
		
	else{

	    identifiant = cloneID[indice];
	
	    int [] cloneIdentifiantTypeDeBien = Biens.getTabIdentifiantTypeDeBien();
	    	
	    int [] cloneIdentifiantBien = Biens.getTabIdentifiantBien();

	    for(int x = 0; x < cloneIdentifiantTypeDeBien.length; x ++){
			
		if(cloneIdentifiantTypeDeBien[x] == identifiant){
		   
		    compteur++;
		}
	    }

	    int [] indiceIdentifiantTypeDeBien = new int [compteur];

	    for(int j = 0; j < cloneIdentifiantTypeDeBien.length; j ++){
		
		if(cloneIdentifiantTypeDeBien[j] == identifiant){
		    
		    indiceIdentifiantTypeDeBien[indice2] = cloneIdentifiantBien[j];
		    		
		    indice2++;
		}
	    }
	    
	    boolean mot = true;
	    
	    for(int l = 0; l < tabIdentifiantBienLoueLocataire.length; l++){
			
		mot = true;
				
		for(int c = 0; c < tabIdentifiantBienLoueLocataire[l].length; c++){
		    
		    for(int n = 0; n < indiceIdentifiantTypeDeBien.length; n++){
			
			if(tabIdentifiantBienLoueLocataire[l][c] == indiceIdentifiantTypeDeBien[n] && mot == true ){
			    			
			    System.out.println(tabNomLocataire[l]);
			    		
			    mot = false;
			}
		    }
		}
	    }
	    if(mot == true)
		System.out.println("==============> Aucun locataire ne loue ce type de bien! <==============");
	}
    }

    void rechercherListeLocationLocataireParticulier(){

	Locations objetLocation = new Locations();
		
	int resultatIdentifiant = 0;
	
	String [] cloneTabNomLocataireLocation = objetLocation.getTabNomLocataireLocation();
	
	String [] cloneTabNomDescriptionBienLocation = objetLocation.getTabDescriptionBienLocation();
	
	int [] cloneTabIdentifiantLocation = objetLocation.getTabIdentifiantLocation();

	if(cloneTabIdentifiantLocation[0] == 0){
	    
	    System.out.println("\n==========> Aucun bien n'est loué ! <========== ");

	}
	
	else{

	    System.out.println("\nVoici la liste des locataires ayant loué un bien:\n");
	    
	    for(int i = 0; i < cloneTabNomLocataireLocation.length; i++){
		
		if(cloneTabNomLocataireLocation[i] != null){
		    
		    System.out.println(cloneTabIdentifiantLocation[i] + " - " + tabNomLocataire[i]+ "\n");
		}
	    }

	    do{
		
	    System.out.print("Saisissez l'identifiant du locataire dont vous voulez afficher les informations: ");

	      while(!sc.hasNextInt()){
		 
		System.out.print("\nCe n'est pas un nombre!\nSaisissez l'identifiant du locataire dont vous voulez afficher les informations: ");
		sc.next();
	    }
	   
	    resultatIdentifiant = sc.nextInt();

	    }while(resultatIdentifiant < 0);

	    for(int j = 0; j < cloneTabIdentifiantLocation.length; j ++){
		
		if(resultatIdentifiant == cloneTabIdentifiantLocation[j]){
		    
		    System.out.println("- "+ cloneTabNomDescriptionBienLocation[j]);
		}
	    }
	}
    }

    void afficherBaseDeDonnee(){
	
	if(compteurLocataire == 0){
	    	
	    System.out.println("\nLa base de donnée est vide!\n");
	}
	
	else{

	    for(int i = 0; i < tabIdentifiantLocataire.length; i++){
		
		if(tabIdentifiantLocataire[i] != 0){
		    		
		    System.out.println();
		    		
		    System.out.println("__________________________________________________");
		    		
		    System.out.print("\nIdentifiant: "+tabIdentifiantLocataire[i]+"\nNom: "+tabNomLocataire[i]+"\nAdresse: "+tabAdresseLocataire[i]+"\nIdentifiant bien loué: ");
		}

		for(int c = 0; c < tabIdentifiantBienLoueLocataire[i].length; c++){
		    
		    if(tabIdentifiantBienLoueLocataire[i][c] != 0){
			
			System.out.print("[ "+tabIdentifiantBienLoueLocataire[i][c]+ " ] ");
		    }
		}
	    }
	    System.out.println("\n");
	}
    }

    int chercheIndice (int supp){

    	//méthode recherchant l'indice où l'identifiant passé en parametre est présent dans le tableau
	    
	for(int i = 0; i < tabIdentifiantLocataire.length; i++){
	
	    if(tabIdentifiantLocataire[i] == supp && supp != 0){
	
		return i;
	    }
	}

	//si aucun identifiant correspondant n'est trouvé la méthode retourne -1

	return -1;  
    }
        
    public static String rechercheNomLocataire(int identifiantBien){

	for (int i = 0;i < tabIdentifiantBienLoueLocataire.length;i++){

	    for(int j = 0;j < tabIdentifiantBienLoueLocataire[i].length;j++){

		if (identifiantBien == tabIdentifiantBienLoueLocataire[i][j]){

		    return tabNomLocataire[i];
		}
	    }
	}
	return " ";
    }
}
