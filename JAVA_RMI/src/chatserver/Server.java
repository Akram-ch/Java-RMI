package chatserver;

import java.rmi.RemoteException;

public class Server {

	public Server() {

	}

	public static void main(String[] args) throws RemoteException {
		IChatRoom chatroom;
		chatroom = new ChatRoom("name");
	}
}
