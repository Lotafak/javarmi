package pl.lotafak;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CalculatorInt extends Remote{
    int Add(List<Integer> listToAdd) throws RemoteException;
    int Multiply(List<Integer> listToMultiply) throws RemoteException;
}
