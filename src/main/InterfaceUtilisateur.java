package main;

import comands.*;
import fr.lteconsulting.formations.outils.Saisie;

import java.io.IOException;

public class InterfaceUtilisateur {

    // Attributs //
    private Bibliotheque bibliotheque = new Bibliotheque();


    // Getters/Setters //
    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }


    // Autres méthodes //


    // Interface utilisateur utilisant l'interface Comand pour mieux gérer les choix du menu
    public void executeMenu() {

        System.out.println("---------------------------------------------");
        System.out.println("--------------- Musicothèque ----------------");
        System.out.println("---------------------------------------------");

        Menu mainMenu = new Menu();

        mainMenu.addComand(new DisplayBib(bibliotheque));
        mainMenu.addComand(new DisplayDiscSongs(bibliotheque));
        mainMenu.addComand(new DisplayFoundDiscs(bibliotheque));
        mainMenu.addComand(new DisplayFoundDiscsByBarcode(bibliotheque));
        mainMenu.addComand(new DisplayFoundSongs(bibliotheque));
        mainMenu.addComand(new AddDiscs(bibliotheque));
        mainMenu.addComand(new ModifyDiscWithName(bibliotheque));
        mainMenu.addComand(new DeleteDiscs(bibliotheque));
        mainMenu.addComand(new GenerateRandomDiscs(bibliotheque));
        mainMenu.addComand(new WriteBibToFile(bibliotheque));
        mainMenu.addComand(new ReadFileToBib(bibliotheque, "output.music"));
        mainMenu.addComand(new Quit());

        while (true) {
            Comand comand = mainMenu.askComand();
            if (comand != null) {
                try {
                    comand.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    // Interface utilisateur //
    public void execute() {
        System.out.println("---------------------------------------------");
        System.out.println("-------- Gestionaire de musicothèque --------");
        System.out.println("---------------------------------------------");

        while (true){

            System.out.println("\n\nQue voulez-vous faire ?");
            System.out.println("\n1 - Afficher votre musicothèque");
            System.out.println("2 - Afficher les chansons d'un album");
            System.out.println("3 - Rechercher albums par nom");
            System.out.println("4 - Rechercher album par code barre");
            System.out.println("5 - Rechercher chansons par nom");
            System.out.println("6 - Ajouter un nouvel album");
            System.out.println("7 - Modifier un album");
            System.out.println("8 - Supprimer un album");
            System.out.println("\n(q pour quitter)");

            String reponse = Saisie.saisie("");

            switch (reponse) {
                case "1" :
                    this.bibliotheque.afficher();
                    break;
                case "2" :
                    DisplayDiscSongs displayDiscSongs = new DisplayDiscSongs(this.bibliotheque);
                    displayDiscSongs.execute();
                    break;
                case "3" :
                    DisplayFoundDiscs displayFoundDiscs = new DisplayFoundDiscs(this.bibliotheque);
                    displayFoundDiscs.execute();
                    break;
                case "4" :
                    DisplayFoundDiscsByBarcode displayFoundDiscsByBarcode = new DisplayFoundDiscsByBarcode(this.bibliotheque);
                    displayFoundDiscsByBarcode.execute();
                    break;
                case "5" :
                    DisplayFoundSongs displayFoundSongs = new DisplayFoundSongs(this.bibliotheque);
                    displayFoundSongs.execute();
                    break;
                case "6" :
                    AddDiscs addDiscs = new AddDiscs(this.bibliotheque);
                    addDiscs.execute();
                    break;
                case "7" :
                    this.bibliotheque.modifyDiscWithName();
                    break;
                case "8" :
                    DeleteDiscs deleteDiscs = new DeleteDiscs(this.bibliotheque);
                    deleteDiscs.execute();
                    break;
                case "q" :
                    System.out.println("\n-------------------- FIN --------------------");
                    System.exit(0);

                default:
                    System.out.println("Saisie incorrecte");
            }


        }

    }

}
