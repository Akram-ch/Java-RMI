package chatserver;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import babystep1.IPrinter;

public class Client {
	private String serverHost;
	private int serverPort;
	
	Client(String serverHost, int serverPort) throws UnknownHostException, IOException, NotBoundException{
		this.serverHost=serverHost;
		this.serverPort=serverPort;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, NotBoundException {
		Client client = new Client("127.0.0.1",4320);
		Participant participant = new Participant("Akram");
		Registry reg = LocateRegistry.getRegistry(client.serverHost, client.serverPort);
		IChatRoom chatroom = (IChatRoom) reg.lookup("Chatroom");
		chatroom.connect(participant);
		
		
	}
}
