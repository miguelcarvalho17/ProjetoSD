package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GameSessionRI extends Remote {
    public void logout() throws RemoteException;
    public ArrayList<Game> getGames() throws RemoteException;
    public void insertGame(String title, String dificuldade) throws RemoteException;
    public SubjectRI getSubject(String t) throws RemoteException;
}
