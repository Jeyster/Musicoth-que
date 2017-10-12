package main;

import comands.*;
import fr.lteconsulting.formations.outils.Saisie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Disque {


    // Attributs //
    private String title;
    private String barCode;
    private List<Chanson> chansons = new ArrayList<>();


    // Setters/Getters //
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public List<Chanson> getChansons() {
        return chansons;
    }

    public void setChansons(List<Chanson> chansons) {
        this.chansons = chansons;
    }


    // Autres méthodes //
    public int getDuration() {
        int discDuration = 0;

        for (Chanson current : this.getChansons()) {
            discDuration += current.getDuration();
        }
        return discDuration;
    }


    public void afficher(){
        System.out.println("\nTitre de l'album : " + this.getTitle());
        System.out.println("Chansons présentes dans l'album : " + this.getChansons().toString());
        System.out.println("Durée de l'album (en minutes) : " + this.getDuration());
        System.out.println("Code barre de l'album : " + this.getBarCode()+ "\n");
    }


    /* Renvoie les Chanson dans une List dont le nom contient la chaine de caractères name
    * case sensitive*/
    public List<Chanson> getSongsByName(String name) {
        List<Chanson> results = new ArrayList<>();

        for (Chanson currentSong : this.getChansons()) {

            if (currentSong.getTitle().contains(name)) {
                results.add(currentSong);
            }

        }

        return results;

    }




    /* Créer une chanson */
    public Chanson createSong(String songTitle, int duration){

        Chanson song = new Chanson();
        song.setTitle(songTitle);
        song.setDuration(duration);

        return song;
    }




    /* Ajouter des chansons à un album
    * écrit directement là où il faut dans la mémoire car java n'utilise que des pointeurs */
    public void addSongs(){

        String response = "O";

        while (response.equals("O")){  //boucle tant que l'utilisateur veut ajouter des chansons à l'album
            String songTitle = Saisie.saisie("\nNom de la chanson à ajouter: ");
            int duration = Saisie.saisieInt("Durée de cette chanson : ");
            Chanson newSong = createSong(songTitle, duration);

            if (newSong == null) {
                System.out.println("Pas de chanson créée.");
            }

            this.getChansons().add(newSong);
            System.out.println("Chanson ajoutée !");


            response = Saisie.saisie("\nAjouter une autre chanson à l'album ? (O/n) ");
        }

    }


    /* Supprimer une chanson */
    public int deleteSong(String songTitle){

        int result = 0;
        List<Chanson> songs = this.getChansons();

        for (int i = 0; i < songs.size(); i++){

            if (songs.get(i).getTitle().equals(songTitle)){
                songs.remove(i);
                result = 1;
            }

        }

        return result;

    }


    /* Supprimer des chansons
    * libère directement la mémoire là où il faut car java n'utilise que des pointeurs */
    public void deleteSongs(){

        String response = "O";

        while (response.equals("O")){  //boucle tant que l'utilisateur veut supprimer des chansons de l'album
            String songTitle = Saisie.saisie("\nNom de la chanson à supprimer: ");
            int isDelete = this.deleteSong(songTitle);
            if (isDelete == 1){
                System.out.println("Chanson supprimée !");
            }
            else {
                System.out.println("Cette chanson n'est pas dans l'album.");
            }


            response = Saisie.saisie("\nSupprimer une autre chanson de l'album ? (O/n) ");
        }

    }


    public void modifyDisc() throws IOException {

        Menu modifyMenu = new Menu();

        modifyMenu.addComand(new ModifyDiscTitle(this));
        modifyMenu.addComand(new ModifyDiscBarcode(this));
        modifyMenu.addComand(new AddSongs(this));
        modifyMenu.addComand(new DeleteSongs(this));
        modifyMenu.addComand(new DisplayDiscSongsForDiscMenu(this));
        modifyMenu.addComand(new QuitDiscMenu());

        int boucle = 1;
        while (boucle == 1) {
            Comand comand = modifyMenu.askComand();
            if (comand != null) {
                comand.execute();

                if (comand.getName() == "Revenir au menu principal"){
                    boucle = 0 ;
                }

            }

        }


/*        while (true){

            System.out.println("\nQue voulez-vous faire dans l'album ?");
            System.out.println("\n1 - Modifier son nom");
            System.out.println("2 - Modifier son code barre");
            System.out.println("3 - Ajouter une chanson");
            System.out.println("4 - Supprimer une chanson");
            System.out.println("5 - Afficher l'album");
            System.out.println("\n(q pour revenir au menu principal)");

            String reponse = Saisie.saisie("");

            switch (reponse) {
                case "1" :
                    String newTitle = Saisie.saisie("Nouveau nom : ");
                    this.setTitle(newTitle);

                    if (newTitle != null){
                        System.out.println("Nom de l'album modifié !");
                    }

                    break;
                case "2" :
                    String newBarcode = Saisie.saisie("Nouveau code barre : ");
                    this.setBarCode(newBarcode);

                    if (newBarcode != null){
                        System.out.println("Code barre de l'album modifié !");
                    }
                    break;
                case "3" :
                    this.addSongs();
                    break;
                case "4" :
                    this.deleteSongs();
                    break;
                case "5" :
                    this.afficher();
                    break;
                case "q" :
                    return;
                default:
                    System.out.println("Saisie incorrecte");
            }


        }*/
    }


    @Override
    public String toString() {
        return this.title;
    }
}
