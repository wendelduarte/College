import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket serverSocket = new DatagramSocket(31811);

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		String receiveSentence = "";
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			receiveSentence = new String(receivePacket.getData()).trim();
			
			receiveData = new byte[1024];
			System.out.println("Cliente diz: " + receiveSentence);

			if(receiveSentence.equals("QUIT")) {
				String response = "Servidor desligado";
				sendData = response.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
				serverSocket.send(sendPacket);
				break;
			} else {
				System.out.print("Servidor diz: ");
				String capitalizedSentence = inFromServer.readLine();
				sendData = capitalizedSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
				serverSocket.send(sendPacket);
			}	
		}	
		serverSocket.close();
	}
}