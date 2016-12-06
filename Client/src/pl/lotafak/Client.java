package pl.lotafak;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            HelloInt stub = (HelloInt) registry.lookup("Hello");

            System.out.println(stub.sayHello());
            System.out.println(stub.sayHi("there"));

        } catch (RemoteException e) {
            System.err.println(e.toString());
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
