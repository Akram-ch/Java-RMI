package babystep1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Printer extends UnicastRemoteObject implements IPrinter {

	public Printer() throws RemoteException {
		//super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void print(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
