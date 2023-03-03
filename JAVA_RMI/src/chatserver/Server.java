package chatserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Server {
	ArrayList<IChatRoom> chatrooms;
	int port;
	Registry reg;
	public Server() throws RemoteException {
		port = 4320;
		reg = LocateRegistry.createRegistry(port);
		for (int i = 1; i <= 3; i++) {
			IChatRoom chatroom = new ChatRoom("Chatroom n°" + i);
			chatrooms.add(chatroom);
			
		}
		
		//reg.rebind("Chatroom", chatroom);
	}

	public static void main(String[] args) throws RemoteException {
		Server server = new Server();
	}
}
