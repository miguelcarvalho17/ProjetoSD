package edu.ufp.inf.sd.rmi._06_visitor.server;

import java.io.Serializable;

public interface VisitorFoldersOperationsI extends Serializable {
    Object visitConcreteElementStateBooks(ElementFolderRI element);
    Object visitConcreteElementStateMagazines(ElementFolderRI element);
}
