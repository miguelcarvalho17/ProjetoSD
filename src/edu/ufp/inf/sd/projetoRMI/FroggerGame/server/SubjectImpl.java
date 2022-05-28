package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.client.ObserverRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SubjectImpl extends UnicastRemoteObject implements SubjectRI {
    private String name;
    private State subjectState;
    private ArrayList<ObserverRI> observers = new ArrayList<>();

    public SubjectImpl(String title) throws RemoteException {
        this.name = title;
        this.subjectState = new State("", "");
        this.observers = new ArrayList<ObserverRI>();
    }

    @Override
    public void attach(ObserverRI obsRI) throws RemoteException{
        this.observers.add(obsRI);
    }

    @Override
    public void detach(ObserverRI obsRI) throws RemoteException{
        this.observers.remove(obsRI);
    }

    @Override
    public State getState() throws RemoteException{
        return this.subjectState;
    }

    @Override
    public void setState(State state) throws RemoteException{
        subjectState = state;
        notifyAllObservers();
    }

    public int getObservers()  throws RemoteException{
        return observers.size();
    }

    public void notifyAllObservers() throws RemoteException {
        for (int i = 0; i < observers.size(); i++){
            ObserverRI obsRI = observers.get(i);
            obsRI.update();
        }
    }

    public int findObserverPosition(ObserverRI obs) throws RemoteException{
        for (int i = 0; i < observers.size(); i++){
            if(obs.equals(observers.get(i))){
                return i;
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }
}
