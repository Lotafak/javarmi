package pl.lotafak;

import java.rmi.RemoteException;

public class HelloImpl implements HelloInt {
    @Override
    public String sayHello() throws RemoteException {
        return "Hello world!";
    }

    @Override
    public String sayHi(String name) {
        return "Hi " + name + "!";
    }
}
