package edu.ufp.inf.sd.projetoRMI.FroggerGame.server;

import java.io.Serializable;

public class Game implements Serializable{

        private int numPlayers = 0;
        private String name;
        private String dificuldade;

        public Game(String title, String dif) {
            name = title;
            dificuldade = dif;
        }

        public void printInfo() {
            System.out.println("Game: " + this.getName());
            System.out.println("Dificuldade: " + this.getDificuldade());
            System.out.println("NumPlayers: " + this.getNumPlayers());
            System.out.println("------------------------------------------------------------------------------");
        }

        /**
         * @return the running status
         */
        public String getName() {
            return name;
        }

        /**
         * @param title of Game
         */
        public void setName(String title) {
            this.name = title;
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
