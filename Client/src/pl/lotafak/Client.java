package pl.lotafak;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();

            HelloInt stub = (HelloInt) registry.lookup("Hello");
            CalculatorInt calculatorStub = (CalculatorInt) registry.lookup("Calculator");

            System.out.println(stub.sayHello());
            System.out.println(stub.sayHi("there"));

            ArrayList<Integer> arrList = new ArrayList<>();
            arrList.add(2);
            arrList.add(3);
            arrList.add(5);
            System.out.println(calculatorStub.Add(arrList));
            System.out.println(calculatorStub.Multiply(arrList));

            System.out.println("Execution stop");

        } catch (RemoteException e) {
            System.err.println(e.toString());
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
