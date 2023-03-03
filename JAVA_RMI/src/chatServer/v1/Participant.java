package chatServer.v1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Participant extends UnicastRemoteObject implements IParticipant {
	
	String name;

	Participant(String name)throws RemoteException{
		this.name = name;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public void receive(String name, String msg) {
		System.out.println(name + " : " + msg);
	}
}
