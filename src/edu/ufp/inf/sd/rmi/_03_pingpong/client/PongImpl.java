package edu.ufp.inf.sd.rmi._03_pingpong.client;


import edu.ufp.inf.sd.rmi._03_pingpong.server.Ball;
import edu.ufp.inf.sd.rmi._03_pingpong.server.PingRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class PongImpl implements PongRI{

    public PongImpl(String []args) {
        try {
            //List ans set args
            SetupContextRMI.printArgs(this.getClass().getName(), args);
            String registryIP = args[0];
            String registryPort = args[1];
            String serviceName = args[2];
            //Create a context for RMI setup
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(PongClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private SetupContextRMI contextRMI;
    /**
     * Remote interface that will hold the Servant proxy
     */
    private PingRI pingRI;

    public Remote lookupService() {
        try {
            //Get proxy MAIL_TO_ADDR rmiregistry
            Registry registry = contextRMI.getRegistry();
            //Lookup service on rmiregistry and wait for calls
            if (registry != null) {
                //Get service url (including servicename)
                String serviceUrl = contextRMI.getServicesUrl(0);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR lookup service @ {0}", serviceUrl);

                //============ Get proxy MAIL_TO_ADDR HelloWorld service ============
                pingRI = (PingRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
                //registry = LocateRegistry.createRegistry(1099);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return pingRI;
    }

    public void playService() {
        try {
            //============ Call HelloWorld remote service ============
            Ball ball = new Ball(1);
            java.rmi.server.UnicastRemoteObject.exportObject(this, 0);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR finish, bye. ;)");
            pingRI.ping(ball, this);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pong(Ball bola)  throws RemoteException{
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "pong(): ball "+bola.getPlayerID());
        pingRI.ping(bola, this);
    }
}
