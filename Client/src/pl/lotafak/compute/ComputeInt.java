package pl.lotafak.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputeInt extends Remote{
    <T> T executeTask(Task<T> t) throws RemoteException;
}
