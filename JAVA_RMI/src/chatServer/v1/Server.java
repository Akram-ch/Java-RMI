package chatServer.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.List;

public class Server {
	//java -cp ChatServer.jar chatServer.v1.Server
	int port;
	int backlog;
	List<ChatRoom> chat_rooms;
	
	Server() throws IOException, InterruptedException{
		this.port=4320;
		this.backlog=3;
		this.chat_rooms = new LinkedList<ChatRoom>();
		Main();
	}
	
	Server(int port) throws IOException, InterruptedException{
		this.port=port;
		this.backlog=3;
		this.chat_rooms = new LinkedList<ChatRoom>();
		Main();
	}
	
	void Main() throws IOException{
		Registry reg = LocateRegistry.createRegistry(port);
		
		
		this.chat_rooms = (new ChatRooms()).getChat_rooms();

		
		for(ChatRoom chat_room : chat_rooms) 
			reg.rebind(chat_room.name, chat_room);
		
	}

	public static void main(String args[]) throws IOException, InterruptedException {
		new Server(4320);
	}
}
