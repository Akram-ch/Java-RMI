package chatServer.v1;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import babystep1.IPrinter;

public class Client {
	//java -cp ChatClient.jar chatServer.v1.Client "Gorice"
	String serverHost;
	int serverPort;
	Participant me;
	boolean connect;
	IChatRoom cr;
	List<IChatRoom> chat_rooms;
	
	Client(String name,String serverHost, int serverPort) throws UnknownHostException, IOException, NotBoundException{
		this.serverHost=serverHost;
		this.serverPort=serverPort;
		me = new Participant(name);
		this.connect=false;
		this.chat_rooms = new LinkedList<IChatRoom>();
		this.cr=null;
		Main();
	}
	
	void Main() throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(this.serverHost, this.serverPort);
		
		String[] registry_names = reg.list();
		for(String registry_name : registry_names)
			this.chat_rooms.add((IChatRoom) reg.lookup(registry_name));

		while(Prompt());
	}
	
	boolean Prompt() throws RemoteException {
		boolean retour = true;
		System.out.print("$ ");
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\A");
		String message = scanner.nextLine();
		

		switch(message) {
			case "connect":
			case "c":
				retour = Connection();
				break;
			case "quit" :
			case "q" :
			case "leave" :
			case "l" :
				retour = Leave();
				break;
			case "list":
				for(int i=0;i<this.chat_rooms.size();i++)
					System.out.println(i + " = " + this.chat_rooms.get(i).name());
					
				break;
			default :
				if(this.connect) {
					cr.send(this.me, message);
				}else System.out.println("> Command unknow");
		
		}
		return retour;
		
	}
	
	boolean Leave() throws RemoteException {
		if(this.connect) {
			this.cr.leave(this.me);
			this.connect=false;
			System.out.println("> Deconestion successfully");
			return true;
		}else return false;
	}
	
	boolean Connection() throws RemoteException {
		if(!this.connect) {
			System.out.println("> ChatRoom name :");
			System.out.print("$ ");
			
			Scanner scanner = new Scanner(System.in);
			//scanner.useDelimiter("\\A");
			String message = scanner.nextLine();
			
			try {
	            int number = Integer.parseInt(message);
	            if(number<this.chat_rooms.size()) {
	            	this.cr = (IChatRoom) this.chat_rooms.get(number);
					this.cr.connect(this.me);
					this.connect=true;
					System.out.println("> Connected successfully");
				}else{
					System.out.println("> Invalid Index");
					Connection();
				}
	        } catch (NumberFormatException e) {
	            System.out.println("> Input is not a number.");
	            Connection();
	        }
			
			
		}else System.out.println("> You already are connect");
		
		return true;
	}
	
	public static void main(String args[]) throws IOException, NotBoundException {
		new Client(args[0],"127.0.0.1",4320);
	}
}
