package edu.ufp.inf.sd.rmi._05_observer.server;

import edu.ufp.inf.sd.rmi._05_observer.client.ObserverRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubjectRI  extends Remote {
    void attach(ObserverRI obsRI) throws RemoteException;
    void detach(ObserverRI obsRI) throws RemoteException;
    State getState() throws RemoteException;
    void setState(State state) throws RemoteException;
}
