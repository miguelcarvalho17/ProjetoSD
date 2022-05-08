package edu.ufp.inf.sd.projetoRMI.FroggerGame.client;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.SubjectRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObserverRI extends Remote {
    void update() throws RemoteException;
    public String getId() throws RemoteException;
    public SubjectRI getSubjectRI() throws RemoteException;
    public void setGameWindow(Main gameWindow) throws RemoteException;
}
