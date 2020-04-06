import java.net.DatagramPacket;
import java.net.DatagramSocket;

class UDPServer {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9988);

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		String sentence = "";
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			sentence = new String(receivePacket.getData()).trim();
			receiveData = new byte[1024];
			System.out.println("RECEBIDO: " + sentence);

			String capitalizedSentence = "STATUS 200 - OK";
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
			serverSocket.send(sendPacket);	
		}
	}
}