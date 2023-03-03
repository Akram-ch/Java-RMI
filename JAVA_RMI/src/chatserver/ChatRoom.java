package chatserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom {

	ArrayList<IParticipant> participants;
	String name;
	
	protected ChatRoom(String name) throws RemoteException {
		super();
		participants = new ArrayList<IParticipant>();
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String name() throws RemoteException{
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void connect(IParticipant p)  throws RemoteException{
		participants.add(p);
		System.out.println(p.name() + " has entered the chat");
	}

	@Override
	public void leave(IParticipant p) throws RemoteException{
		participants.remove(p);
	}

	@Override
	public String[] who() throws RemoteException{
		// TODO Auto-generated method stub
		String[] array = participants.toArray(new String[participants.size()]);
		return array;
	}

	@Override
	public void send(IParticipant p, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("User " + p.name() + "says: " + msg);
		
	}


}
