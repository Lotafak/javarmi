package pl.lotafak;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args){
        HelloImpl hello = new HelloImpl();
        CalculatorImpl calculator = new CalculatorImpl();
        try {
            HelloInt helloStub = (HelloInt) UnicastRemoteObject.exportObject(hello, 0);
            CalculatorInt calculatorStub = (CalculatorInt) UnicastRemoteObject.exportObject(calculator, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Hello", helloStub);
            registry.bind("Calculator", calculatorStub);

            System.out.println("Server ready");

        } catch (RemoteException | AlreadyBoundException e) {
            System.err.println(e.toString());
        }
    }
}
