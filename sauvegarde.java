import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class sauvegarde{

	public static void main(String [] argv) throws IOException{ 

		Locataires sauvegardeLocataire = new Locataires();

		String fichier="sauvegarde.bin";
		DataOutputStream dos;
		if (argv.length>0) fichier = argv[0];
		dos = new DataOutputStream ( new BufferedOutputStream
			(new FileOutputStream(fichier)));

		sauvegardeLocataire.creation();
	
		sauvegardeLocataire.ecrireTupleLocataire(dos,0);
		System.out.println(dos.size());
		dos.close();

	}
}
