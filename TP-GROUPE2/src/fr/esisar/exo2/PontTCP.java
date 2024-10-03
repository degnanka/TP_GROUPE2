package fr.esisar.exo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PontTCP {
   public PontTCP() {
   }

   public static void main(String[] args) throws Exception {
      PontTCP clientTCP = new PontTCP();
      clientTCP.execute();
   }

   private void execute() throws IOException {
      System.out.println("D\u00e9but de la connexion au serveur 1 ");
      Socket s1 = new Socket();
      InetSocketAddress adrDest1 = new InetSocketAddress("127.0.0.1", 8000);
      s1.connect(adrDest1);
      System.out.println("D\u00e9but de la connexion au serveur 2 ");
      Socket s2 = new Socket();
      InetSocketAddress adrDest2 = new InetSocketAddress("127.0.0.1", 8200);
      s2.connect(adrDest2);
      System.out.println("D\u00e9but du transfert du fichier depuis serveur 1 vers serveur 2");
      InputStream is = s1.getInputStream();
      OutputStream os = s2.getOutputStream();
      byte[] buf = new byte[10240];

      int nbRead;
      for(nbRead = is.read(buf); nbRead != -1; nbRead = is.read(buf)) {
         os.write(buf, 0, nbRead);
      }

      System.out.print("Fin du transfert.");
      System.out.print("R\u00e9ponse du serveur 2\u00a0: ");
      InputStream is2 = s2.getInputStream();

      for(nbRead = is2.read(buf); nbRead != -1; nbRead = is2.read(buf)) {
         System.out.print(new String(buf, 0, nbRead));
      }

      s1.close();
      s2.close();
   }
}
