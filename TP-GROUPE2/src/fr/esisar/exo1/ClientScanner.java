package fr.esisar.exo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ClientScanner {
   public static final String IP_SERVEUR = "127.0.0.1";

   public ClientScanner() {
   }

   public static void main(String[] args) throws Exception {
      ClientScanner serveurUDP = new ClientScanner();
      serveurUDP.execute();
   }

   private void execute() throws IOException {
      System.out.println("D\u00e9but du scanning des ports UDP de 30 000 \u00e0 32000 sur la machine 127.0.0.1");
      DatagramSocket socket = new DatagramSocket();

      for(int port = 30000; port <= 32000; ++port) {
         System.out.println("Essai sur le port " + port);
         InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", port);
         byte[] bufE = (new String("hello")).getBytes();
         DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, adrDest);
         socket.send(dpE);
      }

      byte[] bufR = new byte[2048];
      DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
      socket.receive(dpR);
      System.out.println("Le serveur UDP \u00e9coute sur le port X = " + dpR.getPort());
      System.out.println("Fin du programme");
   }
}
