package chatServer.v1;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

public class ChatRooms implements IChatRooms{
	List<ChatRoom> chat_rooms;

	ChatRooms() throws RemoteException{
		this.chat_rooms = new LinkedList<ChatRoom>();
		setChat_rooms();
	}
	
	@Override
	public List<ChatRoom> getChat_rooms() {
		return chat_rooms;
	}
	
	private void setChat_rooms() throws RemoteException {
		this.chat_rooms.add(new ChatRoom("Food"));
		this.chat_rooms.add(new ChatRoom("Daily Life"));
		this.chat_rooms.add(new ChatRoom("Sport"));
		this.chat_rooms.add(new ChatRoom("Well being"));
		this.chat_rooms.add(new ChatRoom("Programmation"));
	}
}
