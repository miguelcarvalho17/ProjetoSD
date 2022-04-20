package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DigLibFactoryRI extends Remote {
    public DigLibSessionRI login(String user, String pwd) throws RemoteException;
    public boolean register(String user, String password) throws RemoteException;
}
