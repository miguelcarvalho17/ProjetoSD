package edu.ufp.inf.sd.rmi._06_visitor.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElementFolderRI extends Remote {
    Object acceptVisitor(VisitorFoldersOperationsI visitor) throws RemoteException;
}
