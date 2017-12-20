import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class recuperation{

	public static void main(String [] argv) throws IOException{ 

		Locataires maRecup = new Locataires();

		String fichier="sauvegarde.bin";
		DataInputStream dis;
		if (argv.length>0) fichier = argv[0];
		dis = new DataInputStream ( new BufferedInputStream
			(new FileInputStream(fichier)));
		maRecup.lireTupleLocataire(dis,0);
		dis.close();
		maRecup.afficheTuple();
	}
}
