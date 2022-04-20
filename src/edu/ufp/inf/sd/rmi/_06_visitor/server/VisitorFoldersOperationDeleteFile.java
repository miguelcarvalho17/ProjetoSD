package edu.ufp.inf.sd.rmi._06_visitor.server;

public class VisitorFoldersOperationDeleteFile implements VisitorFoldersOperationsI{
    private String fileToDelete;
    private String fileToDeleteWithPrefix;

    public String getFileToDelete() {
        return fileToDelete;
    }

    public String getFileToDeleteWithPrefix() {
        return fileToDeleteWithPrefix;
    }

    public VisitorFoldersOperationDeleteFile(String newFolder) {
        this.fileToDelete = newFolder;
    }

    @Override
    public Object visitConcreteElementStateBooks(ElementFolderRI element) {
        return ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder().deleteFile(fileToDelete);
    }

    @Override
    public Object visitConcreteElementStateMagazines(ElementFolderRI element) {
        return null;
    }
}
