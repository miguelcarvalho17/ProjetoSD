package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.client.ObserverRI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SubjectRI  extends Remote {
    void attach(ObserverRI obsRI) throws RemoteException;
    void detach(ObserverRI obsRI) throws RemoteException;
    State getState() throws RemoteException;
    int getObservers() throws RemoteException;
    void setState(State state) throws RemoteException;
    public String getName() throws RemoteException;
}
