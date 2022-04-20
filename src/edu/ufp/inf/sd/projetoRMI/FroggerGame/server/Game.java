package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import java.io.Serializable;

public class Game implements Serializable{

        private int numPlayers;
        private Boolean running;
        private String dificuldade;

        public Game(Boolean state, String dif) {
            running = state;
            dificuldade = dif;
        }

        @Override
        public String toString() {
            return "Game{" + "Dificuldade=" + getDificuldade() + ", Running=" + getState() + ",NumPlayers= " + getNumPlayers()+ '}';
        }

        /**
         * @return the running status
         */
        public Boolean getState() {
            return running;
        }

        /**
         * @param state of Game, is Running? Yes or No
         */
        public void setState(Boolean state) {
            this.running = state;
        }

        /**
         * @return the title
         */
        public String getDificuldade() {
            return dificuldade;
        }

        /**
         * @param level dificuldade do jogo
         */
        public void setDificuldade(String level) {
            this.dificuldade = level;
        }

        public int getNumPlayers() {
        return numPlayers;
    }

        public void setNumPlayers() {
        this.numPlayers += 1;
    }
}
