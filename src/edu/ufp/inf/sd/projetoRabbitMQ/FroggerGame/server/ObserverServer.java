package edu.ufp.inf.sd.projetoRabbitMQ.FroggerGame.server;

import com.rabbitmq.client.BuiltinExchangeType;
import edu.ufp.inf.sd.projetoRabbitMQ.FroggerGame.client.ObserverClient;
import edu.ufp.inf.sd.rabbitmqservices.util.RabbitUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ObserverServer {
    private Server server;

    /**
     * Creates new form ChatClientFrame
     *
     * @param args
     */
    public ObserverServer(String args[]) throws IOException, TimeoutException {

        //1. Init the GUI components

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, " After initComponents()...");

        RabbitUtils.printArgs(args);

        //Read args passed via shell command
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String exchangeName = args[2];
        //int idJogo= Integer.parseInt(args[3]);
        //int idJogador=Integer.parseInt(args[3]);
        //String general=args[5];


        //2. Create the _05_observer object that manages send/receive of messages to/from rabbitmq
        this.server = new Server(this, host, port, "guest", "guest", exchangeName, BuiltinExchangeType.FANOUT, "UTF-8");
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, " After initObserver()...");


    }

    //================================================ BEGIN TO CHANGE ================================================

    /**
     * Sends msg through the _05_observer to the exchange where all observers are binded
     *
     * @param msgToSend
     */
    private void sendMsg(String user, String msgToSend) {
        try {
            msgToSend = user + ":" + msgToSend;
            System.out.println(msgToSend);
            this.server.sendMessage(msgToSend);
        } catch (IOException ex) {
            Logger.getLogger(ObserverServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //================================================ END TO CHANGE ================================================


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, TimeoutException {

        new ObserverServer(args);

    }
}
