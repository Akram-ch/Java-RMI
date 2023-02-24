package babystep1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Printer extends UnicastRemoteObject implements IPrinter{
	
	private static final long serialVersionUID = 1L;

	Printer() throws RemoteException{
		
	}

	@Override
	public void print(String s) {
		System.out.println(s);
	}

}
