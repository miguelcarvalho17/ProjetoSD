package edu.ufp.inf.sd.rmi._06_visitor.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConcreteElementFolderBooksImpl extends UnicastRemoteObject implements ElementFolderRI {
    private SingletonFolderOperationsBooks stateBooksFolder;

    public ConcreteElementFolderBooksImpl(String booksFolder) throws RemoteException {
        super();
        this.stateBooksFolder = SingletonFolderOperationsBooks.createSingletonFolderOperationsBooks(booksFolder);
    }

    public SingletonFolderOperationsBooks getStateBooksFolder() {
        return stateBooksFolder;
    }

    @Override
    public Object acceptVisitor(VisitorFoldersOperationsI visitor) throws RemoteException{
        return visitor.visitConcreteElementStateBooks(this);
    }

}
