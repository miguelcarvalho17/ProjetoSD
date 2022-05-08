package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.client.Main;
import edu.ufp.inf.sd.rmi._04_diglib.server.Book;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * This class simulates a DBMockup for managing users and books.
 *
 * @author rmoreira
 *
 */
public class DB {

    private final ArrayList<Game> froggerGames;
    private final ArrayList<User> users;// = new ArrayList();
    private final ArrayList<SubjectRI> subjectsRI;

    /**
     * This constructor creates and inits the database with some books and users.
     */
    public DB() throws RemoteException {
        froggerGames = new ArrayList();
        users = new ArrayList();
        subjectsRI = new ArrayList<>();

        //Add one user
        users.add(new User("guest", "ufp"));
        String title = "Easy mode", dif  = "easy";
        SubjectRI s = new SubjectImpl(title);
        froggerGames.add(new Game(title, dif, s));
        subjectsRI.add(s);
    }

    /**
     * Registers a new user.
     * 
     * @param u username
     * @param p passwd
     */
    public void register(String u, String p) {
        if (!exists(u, p)) {
            users.add(new User(u, p));
        }
    }

    /**
     * Checks the credentials of an user.
     * 
     * @param u username
     * @param p passwd
     * @return
     */
    public boolean exists(String u, String p) {
        for (User usr : this.users) {
            if (usr.getEmail().compareTo(u) == 0 && usr.getPword().compareTo(p) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Inserts a new game into the DB.
     *
     * @param title titulo
     * @param dif dificuldade
     */
    public void insert(String title, String dif) throws RemoteException {
        SubjectRI subject = new SubjectImpl(title);
        froggerGames.add(new Game(title, dif, subject));
        subjectsRI.add(subject);
    }

    public boolean existsGame(String title) {
        for (Game g : this.froggerGames) {
            if (g.getName().compareTo(title) == 0) {
                return true;
            }
        }
        return false;
    }

    public SubjectRI getSubjectByName(String n) throws RemoteException {
        for (SubjectRI s :this.getSubjectsRI() ) {
            if(s.getName().compareTo(n) == 0){
                return s;
            }
        }
        System.out.println("Nada");
        return null;
    }

    public ArrayList<Game> getFroggerGames() {
        return froggerGames;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<SubjectRI> getSubjectsRI() {
        return subjectsRI;
    }
}
