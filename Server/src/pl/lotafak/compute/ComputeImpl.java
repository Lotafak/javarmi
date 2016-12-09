package pl.lotafak.compute;

import java.rmi.RemoteException;

public class ComputeImpl implements ComputeInt {
    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }
}