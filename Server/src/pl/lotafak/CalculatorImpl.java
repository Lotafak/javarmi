package pl.lotafak;

import java.rmi.RemoteException;
import java.util.List;

public class CalculatorImpl implements CalculatorInt {
    @Override
    public int Add(List<Integer> listToAdd) throws RemoteException {
        int sum = 0;
        for(int i : listToAdd)
            sum += i;
        return sum;
    }

    @Override
    public int Multiply(List<Integer> listToMultiply) throws RemoteException {
        int result = 1;

        for (int i : listToMultiply)
            result = result * i;

        return result;
    }
}
