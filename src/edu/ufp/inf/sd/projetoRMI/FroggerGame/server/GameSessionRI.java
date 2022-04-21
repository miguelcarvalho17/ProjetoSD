package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameSessionRI extends Remote {
    public void logout() throws RemoteException;
    public Game[] getAll() throws RemoteException;
    public void insertGame(String title, String dificuldade) throws RemoteException;
}
