import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPClient {

	public static void main(String[] args) throws Exception {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();// enviar e receber dados

		byte[] sendData = new byte[1024];
		System.out.print("Cliente diz: ");
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();

		InetAddress IPAddress = InetAddress.getLocalHost();

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9988);
		clientSocket.send(sendPacket);

		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);

		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("Servidor diz: " + modifiedSentence);

	}
}