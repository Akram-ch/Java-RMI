package chatServer.v1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom {
	
	String name;
	List<IParticipant> participants;


	ChatRoom(String name)throws RemoteException{
		this.name = name;
		this.participants = new LinkedList<IParticipant>();
	}


	@Override
	public String name() {
		return this.name;
	}

	@Override
	public void connect(IParticipant p) {
		this.participants.add(p);
	}

	@Override
	public void leave(IParticipant p) {
		this.participants.remove(this.participants.indexOf(p));
	}

	@Override
	public String[] who() throws RemoteException {
		int size_p=this.participants.size();
		String list_p[] = new String[size_p];
		for(int i=0; i<size_p;i++) {
			list_p[i]=this.participants.get(i).name();
		}
		return list_p;
	}

	@Override
	public void send(IParticipant p, String msg) throws RemoteException {
		System.out.println(p.name() + " : " + msg);
	}
}
