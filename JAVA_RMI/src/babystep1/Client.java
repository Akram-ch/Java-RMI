package babystep1;
import java.io.*;
import java.net.*;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException, NotBoundException {
		String name="John Doe";
		String serverHost = "127.0.0.1";
		int serverPort = 4320;
		
		//Connexion
		//Socket soc = new Socket(serverHost,serverPort);
	
		Registry registry = LocateRegistry.getRegistry(serverHost, serverPort);
		IPrinter printer = (IPrinter) registry.lookup("LinePrinter");
		
		printer.print("General Kenobi");
	//	soc.close();
	}
	
	
	
}
