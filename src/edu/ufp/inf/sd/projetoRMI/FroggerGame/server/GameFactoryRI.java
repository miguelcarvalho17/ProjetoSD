package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameFactoryRI extends Remote {
    public GameSessionRI login(String email, String pwd) throws RemoteException;
    public boolean register(String email, String password) throws RemoteException;
}
