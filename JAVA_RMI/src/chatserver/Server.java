package chatserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public Server() {

	}

	public static void main(String[] args) throws RemoteException {
		IChatRoom chatroom;
		int port = 4320;
		chatroom = new ChatRoom("name");
		Registry reg = LocateRegistry.createRegistry(port);
		reg.rebind("Chatroom", chatroom);
	}
}
