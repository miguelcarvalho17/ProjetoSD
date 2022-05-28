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

    protected ObserverImpl(String id, SubjectRI subjectRI) throws RemoteException {
        this.id = id;
        this.subjectRI = subjectRI;
        this.subjectRI.attach(this);
    }


    @Override
    public void update() throws RemoteException{
        this.lastObserverState = subjectRI.getState();
        if ((this.lastObserverState.getInfo().compareTo("UpPressed") == 0) || (this.lastObserverState.getInfo().compareTo("DownPressed") == 0) || (this.lastObserverState.getInfo().compareTo("LeftPressed") == 0) || (this.lastObserverState.getInfo().compareTo("RightPressed") == 0))
        {
            gameWindow.froggerHandler(this.lastObserverState);
        }
    }

    public State getLastObserverState(){
        return lastObserverState;
    }

    public String getId() {
        return id;
    }

    public SubjectRI getSubjectRI() {
        return subjectRI;
    }

    public void setGameWindow(Main gameWindow) {
        this.gameWindow = gameWindow;
    }
}

