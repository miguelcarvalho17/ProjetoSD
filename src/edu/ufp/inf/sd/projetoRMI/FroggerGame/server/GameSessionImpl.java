package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import edu.ufp.inf.sd.rmi._04_diglib.server.Book;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameSessionImpl extends UnicastRemoteObject implements GameSessionRI {

    GameFactoryImpl gameFactory;

    protected GameSessionImpl(GameFactoryImpl gameFactory) throws RemoteException {
        super();
        this.gameFactory = gameFactory;

    }

    @Override
    public Game[] getAll() throws RemoteException {
        return this.gameFactory.getDb().getAll();
    }

    @Override
    public void logout() throws RemoteException{
        this.gameFactory.userSession.remove(this);
    }

    public void insertGame(String title, String dificuldade) throws RemoteException{
        this.gameFactory.getDb().insert(title, dificuldade);
    }
}
