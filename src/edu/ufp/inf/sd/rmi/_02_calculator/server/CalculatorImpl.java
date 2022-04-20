package edu.ufp.inf.sd.rmi._02_calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Soma (Servant) = {0}", new Object[]{a+b});
        return a + b;
    }

    @Override
    public double add(ArrayList<Double> list) throws RemoteException {
        double soma = 0;
        for (Double aDouble : list) {
            soma += aDouble;
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Soma (Servant) = {0}", new Object[]{soma});
        return soma;
    }

    @Override
    public double div(double a, double b) throws RemoteException {
        if (b == 0){
            throw new RemoteArithmeticException("Erro ao dividir por zero");
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Divisão (Servant) = {0}", new Object[]{a/b});
        return a/b;
    }

    @Override
    public double mul(double a, double b) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Multiplicação (Servant) = {0}", new Object[]{a*b});
        return a*b;
    }

    @Override
    public double mul(ArrayList<Double> list) throws RemoteException {
        double result = 1;
        for (Double aDouble : list) {
            result *= aDouble;
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Multiplicação (Servant) = {0}", new Object[]{result});
        return result;
    }

    @Override
    public double sub(double a, double b) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Subtração (Servant) = {0}", new Object[]{a-b});
        return a-b;
    }

}