package chatserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Participant extends UnicastRemoteObject implements IParticipant{

	String name;
	
	protected Participant(String name) throws RemoteException {
		super();
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void receive(String name, String msg) {
		// TODO Auto-generated method stub
		System.out.println(name + " says: " + msg);
		
	}
	public void run() {
		
	}
	
}
