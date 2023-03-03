package babystep1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	int port;
	int backlog;
	Printer printer;
	
	Server() throws IOException, InterruptedException{
		this.port=4320;
		this.backlog=3;
		this.printer = new Printer();
		Main();
	}
	
	Server(int port) throws IOException, InterruptedException{
		this.port=port;
		this.backlog=3;
		this.printer = new Printer();
		Main();
	}
	
	void Main() throws IOException{
		//ServerSocket listenSoc = new ServerSocket(port, backlog);	
		
		Registry reg = LocateRegistry.createRegistry(port);
		reg.rebind("LinePrinter", printer);


	}

	public static void main(String args[]) throws IOException, InterruptedException {
		new Server(4320);
	}
}
