package edu.ufp.inf.sd.rmi._03_pingpong.server;

import edu.ufp.inf.sd.rmi._03_pingpong.client.PongRI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * <p>Title: Projecto SD</p>
 * <p>Description: Projecto apoio aulas SD</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: UFP </p>
 * @author Rui Moreira
 * @version 1.0
 */
public interface PingRI extends Remote {

    void ping(Ball bola, PongRI clientPongRI) throws RemoteException;
}
