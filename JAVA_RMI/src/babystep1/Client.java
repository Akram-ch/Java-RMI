package babystep1;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	String serverHost;
	int serverPort;
	
	Client(String serverHost, int serverPort) throws UnknownHostException, IOException, NotBoundException{
		this.serverHost=serverHost;
		this.serverPort=serverPort;
		Main();
	}
	
	void Main() throws UnknownHostException, IOException, NotBoundException {
		//
		
		Registry reg = LocateRegistry.getRegistry(this.serverHost, this.serverPort);
		IPrinter printer = (IPrinter) reg.lookup("LinePrinter");
		
		printer.print("Mdrrr");
	}
	
	public static void main(String args[]) throws IOException, NotBoundException {
		new Client("127.0.0.1",4320);
	}
}
