package pl.lotafak.compute;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.AccessControlException;
import java.security.AllPermission;

public class ComputeFactorial {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try{
            System.getSecurityManager().checkPermission(new AllPermission());
            Registry registry = LocateRegistry.getRegistry();
            ComputeInt compute = (ComputeInt)registry.lookup("Compute");

            Factorial task = new Factorial(10);

            int factorial = compute.executeTask(task);
            System.out.println(factorial);

        } catch (RemoteException e) {
            System.err.println("RemoteExteption:");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("NotBoundException:");
            e.printStackTrace();
        } catch (AccessControlException e){
            System.err.println("AccessControlException:");
            e.printStackTrace();
        }
    }
}
