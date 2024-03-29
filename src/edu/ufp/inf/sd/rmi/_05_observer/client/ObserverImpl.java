package edu.ufp.inf.sd.rmi._05_observer.client;

import edu.ufp.inf.sd.rmi._05_observer.server.State;
import edu.ufp.inf.sd.rmi._05_observer.server.SubjectRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObserverImpl extends UnicastRemoteObject implements ObserverRI {
    private String id;
    private State lastObserverState;
    protected SubjectRI subjectRI;
    protected ObserverGuiClient chatFrame;

    protected ObserverImpl(String id, ObserverGuiClient observerGuiClient, SubjectRI subjectRI) throws RemoteException {
        this.id = id;
        this.chatFrame = observerGuiClient;
        this.subjectRI = subjectRI;
        this.subjectRI.attach(this);
    }


    @Override
    public void update() throws RemoteException{
        this.lastObserverState = subjectRI.getState();
        chatFrame.updateTextArea();
    }

    public State getLastObserverState(){
        return lastObserverState;
    }

}
