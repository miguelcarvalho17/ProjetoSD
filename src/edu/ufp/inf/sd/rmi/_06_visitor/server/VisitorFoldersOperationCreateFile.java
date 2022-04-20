package edu.ufp.inf.sd.rmi._06_visitor.server;

public class VisitorFoldersOperationCreateFile implements VisitorFoldersOperationsI{

    private String fileToCreate;
    private String fileToCreateWithPrefix;

    public String getFileToCreate() {
        return fileToCreate;
    }

    public String getFileToCreateWithPrefix() {
        return fileToCreateWithPrefix;
    }

    public VisitorFoldersOperationCreateFile(String newFolder) {
        this.fileToCreate = newFolder;
    }

    @Override
    public Object visitConcreteElementStateBooks(ElementFolderRI element) {
        return ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder().createFile(fileToCreate);
    }

    @Override
    public Object visitConcreteElementStateMagazines(ElementFolderRI element) {
        return null;
    }
}
