package chatServer.v1;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import babystep1.IPrinter;

public class Client {
	
	String serverHost;
	int serverPort;
	Participant me;
	
	Client(String serverHost, int serverPort) throws UnknownHostException, IOException, NotBoundException{
		this.serverHost=serverHost;
		this.serverPort=serverPort;
		me = new Participant("Venon");
		Main();
	}
	
	void Main() throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(this.serverHost, this.serverPort);
		IChatRoom hello_world = (IChatRoom) reg.lookup("LinePrinter");
		
		hello_world.connect(me);
		String[] who = hello_world.who();
		for(int i=0;i<who.length;i++) {
			System.out.println(who[i]);
		}
		while(true) {}
	}
	
	public static void main(String args[]) throws IOException, NotBoundException {
		new Client("127.0.0.1",4320);
	}
}
