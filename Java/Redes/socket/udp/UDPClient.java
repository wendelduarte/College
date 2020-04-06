import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();

		while (true) {
			byte[] sendData = new byte[1024];
			System.out.print("Cliente diz: ");
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getLocalHost(), 31811);
			clientSocket.send(sendPacket);

			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);

			String responseSentence = new String(receivePacket.getData());
			System.out.println("Servidor diz: " + responseSentence);
				
			if (responseSentence.trim().equalsIgnoreCase("Servidor desligado")) {
				break;
			}
		}
		clientSocket.close();
	}
}