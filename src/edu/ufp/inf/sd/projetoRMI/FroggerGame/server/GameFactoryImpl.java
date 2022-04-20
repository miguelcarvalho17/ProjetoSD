package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class GameFactoryImpl extends UnicastRemoteObject implements GameFactoryRI {

    private DB db = new DB();
    HashMap<GameSessionRI, String> userSession = new HashMap<GameSessionRI, String>();

    public DB getDb() {
        return db;
    }

    public HashMap<GameSessionRI, String> getUserSession() {
        return userSession;
    }

    protected GameFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public GameSessionRI login(String email, String pwd) throws RemoteException {
        if (db.exists(email, pwd)){
            GameSessionRI gameSessionRI =  new GameSessionImpl(this);
            userSession.put(gameSessionRI, email);
            return gameSessionRI;
        }
        System.out.println("Nao entrei!");
        return null;
    }

    @Override
    public boolean register(String email, String password) throws RemoteException{
        db.register(email, password);
            return true;
    }
}
