package pl.lotafak;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInt extends Remote {
    String sayHello() throws RemoteException;
    String sayHi(String name) throws RemoteException;
}
