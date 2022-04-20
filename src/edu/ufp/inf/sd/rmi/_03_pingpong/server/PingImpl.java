package edu.ufp.inf.sd.rmi._03_pingpong.server;

import edu.ufp.inf.sd.rmi._03_pingpong.client.PongRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PingImpl extends UnicastRemoteObject implements PingRI {

    protected PingImpl() throws RemoteException {
        super();
    }

    @Override
    public void ping(Ball bola, PongRI clientPongRI) throws RemoteException {
        PingRunnable pr = new PingRunnable(bola, clientPongRI);
        new Thread(pr).start();
    }
}
