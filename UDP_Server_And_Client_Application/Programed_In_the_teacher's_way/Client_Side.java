import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDatagram {

    private static InetAddress host;
    private static final int PORT = 2082;
    private static DatagramSocket datagramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException unknownHostException) {
            System.out.println("ERROR : " + unknownHostException.getMessage());
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() {
        try {
            datagramSocket = new DatagramSocket();              //STEP 1
            Scanner userEntry = new Scanner(System.in);
            String message = "", response = "";
            do {
                System.out.println("Enter Message : ");
                message = userEntry.nextLine();
                if (!message.equals("***CLOSE***")) {
                    outPacket = new DatagramPacket(message.getBytes(), message.l
ength(), host, PORT); //STEP 2
                    datagramSocket.send(outPacket); //STEP 3
                    buffer = new byte[256]; //STEP 5
                    inPacket = new DatagramPacket(buffer, buffer.length); //STEP
 5
                    datagramSocket.receive(inPacket); //STEP 6
                    response = new String(inPacket.getData(), 0, inPacket.getLen
gth()); //STEP 7
                    System.out.println("\n SERVER RESPONSE > " + response );

                }

            } while (!message.equals("***CLOSE***"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("ERROR" + ioException.getMessage());

        }finally {
            System.out.println("\n * Closing connection ... *");
            datagramSocket.close();  // STEP 8

        }
    }

}