package edu.ufp.inf.sd.projetoRMI.FroggerGame.client;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.client.Main;
import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.State;
import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.SubjectRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObserverImpl extends UnicastRemoteObject implements ObserverRI {
    private String id;
    private State lastObserverState;
    protected SubjectRI subjectRI;
    protected Main gameWindow;

    protected ObserverImpl(String id, Main gameWindow, SubjectRI subjectRI) throws RemoteException {
        this.id = id;
        this.gameWindow = gameWindow;
        this.subjectRI = subjectRI;
        this.subjectRI.attach(this);
    }


    @Override
    public void update() throws RemoteException{
        this.lastObserverState = subjectRI.getState();
        gameWindow.froggerKeyboardHandler();
    }

    public State getLastObserverState(){
        return lastObserverState;
    }
}

