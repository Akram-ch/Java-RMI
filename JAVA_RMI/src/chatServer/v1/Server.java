package chatServer.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	int port;
	int backlog;
	
	Server() throws IOException, InterruptedException{
		this.port=4320;
		this.backlog=3;
		Main();
	}
	
	Server(int port) throws IOException, InterruptedException{
		this.port=port;
		this.backlog=3;
		Main();
	}
	
	void Main() throws IOException{
		Registry reg = LocateRegistry.createRegistry(port);
		ChatRoom hello_world = new ChatRoom("Hello World");
		reg.rebind("LinePrinter", hello_world);
	}

	public static void main(String args[]) throws IOException, InterruptedException {
		new Server(4320);
	}
}
