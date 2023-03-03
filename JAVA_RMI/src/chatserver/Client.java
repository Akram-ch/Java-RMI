package chatserver;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import babystep1.IPrinter;
import java.util.Scanner;

public class Client {
	private String serverHost;
	private int serverPort;
	private Participant participant;
	private IChatRoom chatroom;
	
	public Client(String serverHost, int serverPort) throws UnknownHostException, IOException, NotBoundException{
		this.serverHost=serverHost;
		this.serverPort=serverPort;
		participant = new Participant("Akram");
		Registry reg = LocateRegistry.getRegistry(serverHost, serverPort);
		chatroom = (IChatRoom) reg.lookup("Chatroom");
	}
	
	public void run() throws RemoteException {
		Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(inputString);
        chatroom.send(participant, inputString);
        scanner.close();

	}
	
	
	public static void main(String[] args) throws UnknownHostException, IOException, NotBoundException {
		Client client = new Client("127.0.0.1",4320);
		client.chatroom.connect(client.participant);
		client.run();
		
		
	}
	
}
