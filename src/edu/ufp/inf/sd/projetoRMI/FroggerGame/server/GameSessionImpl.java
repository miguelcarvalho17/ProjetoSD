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

    public Game insertGame(String title, String dificuldade) throws RemoteException{
        if (!this.gameFactory.getDb().existsGame(title)){
            Game g = this.gameFactory.getDb().insert(title, dificuldade);
            return g;
        }
        return null;
    }

    public Game joinGame(String t) throws RemoteException{
        for (Game g : this.gameFactory.getDb().getFroggerGames()){
            if (g.getName().compareTo(t) == 0){
                g.setNumPlayers();
                return g;
            }
        }
        return null;
    }

    public SubjectRI getSubject(String t) throws RemoteException{
        return this.gameFactory.getDb().getSubjectByName(t);
    }
}
