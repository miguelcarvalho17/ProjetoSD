package edu.ufp.inf.sd.projetoRabbitMQ.FroggerGame.client;

import com.rabbitmq.client.BuiltinExchangeType;
import edu.ufp.inf.sd.projetoRabbitMQ.FroggerGame.frogger.Main;
import edu.ufp.inf.sd.rabbitmqservices.util.RabbitUtils;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObserverClient extends javax.swing.JFrame{

    private Observer observer;

    /**
     * Creates new form ChatClientFrame
     *
     * @param args
     */
    public ObserverClient(String args[]) {
        RabbitUtils.printArgs(args);

        //Read args passed via shell command
        String host=args[0];
        int port=Integer.parseInt(args[1]);
        String exchangeName=args[2];
        int player = Integer.parseInt(args[3]);
        int level = Integer.parseInt(args[4]);
        String title = args[5];
        //String general=args[5];
        Thread thread = new Thread(){
            public void run(){
                Main f = null;
                try {
                    f = new Main(level, title, player);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                //2. Create the _05_observer object that manages send/receive of messages to/from rabbitmq
                try {
                    observer = new Observer(f, host, port, "guest", "guest",player, exchangeName, BuiltinExchangeType.FANOUT, "UTF-8");
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, " After initObserver()...");
                f.setObserver(observer);

                f.run();
            }
        };
        thread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int expectedArgs = 4;
                if (args.length >= expectedArgs) {
                    new ObserverClient(args).setVisible(true);
                } else {
                    Logger.getLogger(ObserverClient.class.getName()).log(Level.INFO, "check args.length < "+expectedArgs+"!!!" );
                }
            }
        });
    }
}
