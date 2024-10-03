package fr.esisar.exo2;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PontTCPTaille {


	public static void main(String[] args) throws Exception {
		PontTCPTaille clientTCP = new PontTCPTaille();
		clientTCP.execute();
	}

	private void execute() throws IOException {
		System.out.println("D\u00e9but de la connexion au serveur 1 ");
		Socket socket = new Socket();
		InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", 8000);
		socket.connect(adrDest);
		byte[] buf = new byte[1024];
		InputStream is = socket.getInputStream();
		int taille = 0;

		for(int nbRead = is.read(buf); nbRead != -1; nbRead = is.read(buf)) {
			taille += nbRead;
		}

		socket.close();
		System.out.println("La taille du fichier envoy\u00e9 par le serveur 1 est\u00a0: " + taille + " octets");
		System.out.println("Fin du programme");
	}
}
