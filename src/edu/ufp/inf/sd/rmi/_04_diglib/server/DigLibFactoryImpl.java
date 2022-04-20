package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class DigLibFactoryImpl extends UnicastRemoteObject implements DigLibFactoryRI{

    private DBMockup db = new DBMockup();
    HashMap<DigLibSessionRI, String> userSession = new HashMap<DigLibSessionRI, String>();

    public DBMockup getDb() {
        return db;
    }

    public HashMap<DigLibSessionRI, String> getUserSession() {
        return userSession;
    }

    protected DigLibFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public DigLibSessionRI login(String user, String pwd) throws RemoteException {
        if (db.exists(user, pwd)){
            DigLibSessionRI digLibSessionRI =  new DigLibSessionImpl(this);
            userSession.put(digLibSessionRI, user);
            return digLibSessionRI;
        }
        return null;
    }

    @Override
    public boolean register(String user, String password) throws RemoteException{
        db.register(user, password);
            return true;
    }
}
