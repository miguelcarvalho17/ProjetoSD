package edu.ufp.inf.sd.rmi._03_pingpong.server;

import edu.ufp.inf.sd.rmi._03_pingpong.client.PongRI;

import java.rmi.RemoteException;

public class PingRunnable extends Thread{
    Ball ball;
    PongRI pongRI;

    public PingRunnable(Ball ball, PongRI pongRI) {
        this.ball = ball;
        this.pongRI = pongRI;
    }

    @Override
    public void run(){
        try {
            pongRI.pong(ball);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
