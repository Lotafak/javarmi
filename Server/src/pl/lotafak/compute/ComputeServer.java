package pl.lotafak.compute;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;
import java.security.AllPermission;

public class ComputeServer {
    public ComputeServer(){
        super();
    }

    public static void main(String[] args){
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        ComputeImpl compute = new ComputeImpl();
        try{
            System.getSecurityManager().checkPermission(new AllPermission());
            ComputeInt computeStub = (ComputeInt) UnicastRemoteObject.exportObject(compute, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Compute", computeStub);
            System.out.println("Computer Engine ready");
            System.in.read();

        } catch (RemoteException e) {
            System.err.println("RemoteException in ComputerEngine:");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.err.println("AlreadyBoundException in ComputerEngine:");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AccessControlException e){
            System.err.println("AccessControlException:");
            e.printStackTrace();
        }
    }
}
