package edu.ufp.inf.sd.projetoRMI.FroggerGame.client;

import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.Game;
import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.GameFactoryRI;
import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.GameServer;
import edu.ufp.inf.sd.projetoRMI.FroggerGame.server.GameSessionRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.Registry;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Title: Projecto SD</p>
 * <p>
 * Description: Projecto apoio aulas SD</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Rui S. Moreira
 * @version 3.0
 */
public class FroggerClient {

    /**
     * Context for connecting a RMI client MAIL_TO_ADDR a RMI Servant
     */
    private SetupContextRMI contextRMI;
    /**
     * Remote interface that will hold the Servant proxy
     */
    private GameFactoryRI GameFactoryRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.err.println("usage: java [options] edu.ufp.sd.inf.ProjetoSD.FroggerGame.server <rmi_registry_ip> <rmi_registry_port> <service_name>");
            System.exit(-1);
        } else {
            //1. ============ Setup client RMI context ============
            FroggerClient hwc=new FroggerClient(args);
            //2. ============ Lookup service ============
            hwc.lookupService();
            //3. ============ Play with service ============
            hwc.playService();
        }
    }

    public FroggerClient(String args[]) {
        try {
            //List ans set args
            SetupContextRMI.printArgs(this.getClass().getName(), args);
            String registryIP = args[0];
            String registryPort = args[1];
            String serviceName = args[2];
            //Create a context for RMI setup
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(FroggerClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            //Get proxy MAIL_TO_ADDR rmiregistry
            Registry registry = contextRMI.getRegistry();
            //Lookup service on rmiregistry and wait for calls
            if (registry != null) {
                //Get service url (including servicename)
                String serviceUrl = contextRMI.getServicesUrl(0);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR lookup service @ {0}", serviceUrl);

                //============ Get proxy MAIL_TO_ADDR HelloWorld service ============
                GameFactoryRI = (GameFactoryRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
                //registry = LocateRegistry.createRegistry(1099);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return GameFactoryRI;
    }

    private void playService() {
        try {
            //============ Call HelloWorld remote service ============
            menuHome();



            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR finish, bye. ;)");
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void menuHome() throws RemoteException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        int option= sc.nextInt();
        switch(option) {
            case 1:
                Scanner scanEmail= new Scanner(System.in); //System.in is a standard input stream
                System.out.println("Enter your email: ");
                String email= scanEmail.nextLine();              //reads string

                Scanner scanPassword = new Scanner(System.in); //System.in is a standard input stream
                System.out.println("Enter your password: ");
                String password = scanPassword.nextLine();              //reads string

                GameSessionRI gameSessionRI = this.GameFactoryRI.login(email, password);
                if (gameSessionRI == null){
                    System.out.println("Invalid email or password");
                    menuHome();
                }else{
                    menuGame(gameSessionRI);
                }
                //gameSessionRI.logout();
                break;
            case 2:
                Scanner scanRegEmail= new Scanner(System.in); //System.in is a standard input stream
                System.out.println("Enter your email: ");
                String regEmail= scanRegEmail.nextLine();              //reads string

                Scanner scanRegPass = new Scanner(System.in); //System.in is a standard input stream
                System.out.println("Enter your password: ");
                String regPass = scanRegPass.nextLine();              //reads string

                this.GameFactoryRI.register(regEmail, regPass);
                menuHome();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void menuGame(GameSessionRI gameSessionRI) throws RemoteException {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Choose an option");
        System.out.println("1 - Join a game");
        System.out.println("2 - Create a new game");
        System.out.println("3 - Logout");
        int option= sc2.nextInt();

        switch (option){
            case 1:
                listGame(gameSessionRI);
                break;
            case 2:
                createGame(gameSessionRI);
                break;
            case 3:
                gameSessionRI.logout();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void createGame(GameSessionRI gameSessionRI) throws RemoteException {
        Scanner scanName= new Scanner(System.in); //System.in is a standard input stream
        System.out.println("Enter Title of Game: ");
        String title = scanName.nextLine();              //reads string

        Scanner scanDificuldade = new Scanner(System.in); //System.in is a standard input stream
        System.out.println("Enter difficulty(Easy, Medium, Hard): ");
        String dificuldade = scanDificuldade.nextLine();              //reads string
        String lower = dificuldade.toLowerCase();
        int level;
        switch (lower){
            case "easy":
                level = 1;
                break;
            case "medium":
                level = 2;
                break;
            case "hard":
                level = 3;
                break;
            default:
                System.out.println("Invalid option");
        }

        gameSessionRI.insertGame(title, dificuldade);

    }

    public void listGame(GameSessionRI gameSessionRI) throws RemoteException {
        Game[] games;
        games = gameSessionRI.getAll();
        System.out.println("List Games:");
        for (int i = 0; i < games.length; i++) {
            System.out.print(i+1 + ". ");
            games[i].printInfo();
        }

        Scanner scanOption= new Scanner(System.in); //System.in is a standard input stream
        System.out.println("Choose one Game to join: ");
        int option = scanOption.nextInt();              //reads integer


    }
}

// Criar um obvserver antes entrar no jogo, instanciar o jogo tambem (GUI jogo)
//  Attach para se juntar ao jogo
// Criar varios sapos, ver imagem jpg, criar novas imagens com outras cores

// Codigo do handler colocar noutra funçao

// Ir ao ao setState e atualizar


