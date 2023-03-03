package chatServer.v1;

import java.rmi.RemoteException;
import java.util.List;

public interface IChatRooms {
	public List<ChatRoom> getChat_rooms();
}
