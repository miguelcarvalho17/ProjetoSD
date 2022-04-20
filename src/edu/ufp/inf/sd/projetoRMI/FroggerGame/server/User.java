package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

/**
 *
 * @author rmoreira
 */
public class User {

    private String email;
    private String pword;

    public User(String email, String pword) {
        this.email = email;
        this.pword = pword;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", pword=" + pword + '}';
    }

    /**
     * @return the uname
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pword
     */
    public String getPword() {
        return pword;
    }

    /**
     * @param pword the pword to set
     */
    public void setPword(String pword) {
        this.pword = pword;
    }
}
