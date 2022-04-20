package edu.ufp.inf.sd.rmi._03_pingpong.client;


import edu.ufp.inf.sd.rmi._03_pingpong.server.Ball;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>
 * Title: Projecto SD</p>
 * <p>
 * Description: Projecto apoio aulas SD</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Rui S. Moreira
 * @version 3.0
 */

public interface PongRI extends Remote {
    void pong(Ball bola) throws RemoteException;
}
