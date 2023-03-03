package chatServer.v1;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import babystep1.IPrinter;

public class Client {
	
	String serverHost;
	int serverPort;
	Participant me;
	boolean connect;
	
	Client(String serverHost, int serverPort) throws UnknownHostException, IOException, NotBoundException{
		this.serverHost=serverHost;
		this.serverPort=serverPort;
		me = new Participant("Venon");
		this.connect=false;
		Main();
	}
	
	void Main() throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(this.serverHost, this.serverPort);
		IChatRoom hello_world = (IChatRoom) reg.lookup("LinePrinter");
		
		while(Prompt(hello_world));
	}
	
	boolean Prompt(IChatRoom cr) throws RemoteException {
		boolean retour = true;
		System.out.print("$ ");
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\A");
		String message = scanner.nextLine();
		switch(message) {
			case "connect":
			case "c":
				if(!this.connect) {
					cr.connect(this.me);
					this.connect=true;
					System.out.println("> Connected successfully");
				}else System.out.println("> You already are connect");
				break;
			case "quit" :
			case "q" :
			case "leave" :
			case "l" :
				if(this.connect) {
					cr.leave(this.me);
					this.connect=false;
					System.out.println("> Deconestion successfully");
				}else retour = false;
				break;
			default :
				if(this.connect) {
					cr.send(this.me, message);
				}else System.out.println("> Command unknow");
		
		}
		return retour;
		
	}
	
	public static void main(String args[]) throws IOException, NotBoundException {
		new Client("127.0.0.1",4320);
	}
}
