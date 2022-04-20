package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DigLibSessionImpl  extends UnicastRemoteObject implements DigLibSessionRI{

    DigLibFactoryImpl digLibFactory;

    protected DigLibSessionImpl(DigLibFactoryImpl digLibFactory) throws RemoteException {
        super();
        this.digLibFactory = digLibFactory;

    }

    @Override
    public Book[] search(String book, String author) throws RemoteException {
    return this.digLibFactory.getDb().select(book, author);
    }

    @Override
    public void logout() throws RemoteException{
        this.digLibFactory.userSession.remove(this);
    }
}
