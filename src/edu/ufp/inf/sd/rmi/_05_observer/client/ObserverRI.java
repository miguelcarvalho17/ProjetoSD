package edu.ufp.inf.sd.rmi._05_observer.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObserverRI extends Remote {
    void update() throws RemoteException;
}
