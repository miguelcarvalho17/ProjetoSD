package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.client.Main;
import edu.ufp.inf.sd.rmi._04_diglib.server.Book;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GameSessionImpl extends UnicastRemoteObject implements GameSessionRI {

    GameFactoryImpl gameFactory;

    protected GameSessionImpl(GameFactoryImpl gameFactory) throws RemoteException {
        super();
        this.gameFactory = gameFactory;

    }

    @Override
    public ArrayList<Game> getGames() throws RemoteException {
        return this.gameFactory.getDb().getFroggerGames();
    }

    @Override
    public void logout() throws RemoteException{
        this.gameFactory.userSession.remove(this);
    }

    public void insertGame(String title, String dificuldade) throws RemoteException{
        if (!this.gameFactory.getDb().existsGame(title)){
            this.gameFactory.getDb().insert(title, dificuldade);
        }
    }

    public SubjectRI getSubject(String t) throws RemoteException{
        return this.gameFactory.getDb().getSubjectByName(t);
    }
}
