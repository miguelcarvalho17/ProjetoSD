package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import edu.ufp.inf.sd.rmi._04_diglib.server.Book;

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

    /**
     * This constructor creates and inits the database with some books and users.
     */
    public DB() {
        froggerGames = new ArrayList();
        users = new ArrayList();

        //Add one user
        users.add(new User("guest@ufp.edu.pt", "ufp"));
        froggerGames.add(new Game(true, "easy"));
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
     * Inserts a new book into the DigLib.
     *
     * @param state running
     * @param dif dificuldade
     */
    public void insert(Boolean state, String dif) {
        froggerGames.add(new Game(state, dif));
    }

    public Game[] getAll() {
        Game[] games = new Game[froggerGames.size()];
        for (int i = 0; i < froggerGames.size(); i++) {
            games[i] = froggerGames.get(i);
        }
        return games;
    }
}