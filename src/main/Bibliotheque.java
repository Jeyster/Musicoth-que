package main;

import fr.lteconsulting.formations.outils.Saisie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bibliotheque {

    // Attributs //
    private List<Disque> disques = new ArrayList<>();


    // Getters/Setters //
    public List<Disque> getDisques() {
        return disques;
    }

    public void setDisques(List<Disque> disques) {
        this.disques = disques;
    }


    // Autres méthodes //
    public int getDuration() {
        int bibDuration = 0;

        for (Disque current : this.getDisques()) {
            bibDuration += current.getDuration();
        }
        return bibDuration;
    }

    public void afficher(){
        System.out.println("\nAlbums présents dans la bibliothèque : " + this.getDisques().toString());
        System.out.println("Durée totale de la bibliothèque (en minutes) : " + this.getDuration());
    }


    /* Renvoie le Disque dont le nom est la chaine de caractères name
    * rq : case sensitive, s'arrête dès que premier album trouvé (attention si plusieurs même nom) */
    public Disque getDiscWithName(String discName) {

        for (Disque currentDisc : this.getDisques()) {

            if (currentDisc.getTitle().equals(discName)) {
                return currentDisc;
            }

        }

        return null;

    }


    /* Renvoie les Disque dans une List dont le nom contient la chaine de caractères name
    * rq : case sensitive*/
    public List<Disque> getDiscsByName(String name) {

        List<Disque> results = new ArrayList<>();

        for (Disque currentDisc : this.getDisques()) {

            if (currentDisc.getTitle().contains(name)) {
                results.add(currentDisc);
            }

        }

        return results;
    }



    /* Renvoie les Chanson de la musicothèque dont le nom contient la chaine de caractères name dans une List
    * rq : case sensitive*/
    public List<Chanson> getSongsInDiscs(String discName) {

        List<Chanson> results = new ArrayList<>();

        for (Disque currentDisc : this.getDisques()) {

            for (Chanson currentSong : currentDisc.getSongsByName(discName)) {
                results.add(currentSong);
            }

        }

        return results;
    }

    /* Renvoie le Disque de code barre barCode */
    public Disque getDiscWithBarcode(String barCode) {

        for (Disque currentDisc : this.getDisques()) {

            if (currentDisc.getBarCode().contentEquals(barCode)) {
                return currentDisc;
            }

        }

        return null;
    }



    /* Ajouter un album */
    public int addDisc(String discTitle, String barCode){

        Disque disc = new Disque();
        disc.setTitle(discTitle);
        disc.setBarCode(barCode);

        disc.addSongs();
        this.getDisques().add(disc);

        if (disc != null){
            return 0;
        }

        return 1;
    }



    /* Supprimer un album */
    public int deleteDisc(String discTitle){

        int result = 0;
        List<Disque> discs = this.getDisques();

        for (int i = 0; i < discs.size(); i++){

            if (discs.get(i).getTitle().equals(discTitle)){
                discs.remove(i);
                result = 1;
            }

        }

        return result;

    }



    /* Modifier un album existant */
    public void modifyDiscWithName() {

        String searchedDiscName = Saisie.saisie("\nNom de l'album : ");
        Disque foundDisc = this.getDiscWithName(searchedDiscName);

        if (foundDisc == null) {
            System.out.println("Pas d'album avec le nom recherché.");
            return;
        }

        try {
            foundDisc.modifyDisc();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Disque generateRandomDiscFromFile(String fileName) throws IOException {

        Disque disc = new Disque();

        ImporterExporter ie = new ImporterExporter("");
        Outils tool = new Outils();
        List<String> stringsList = ie.importLinesFromFile(fileName);

        /* Donne un titre au hasard au disque */
        disc.setTitle(tool.chooseRandomStringInList(stringsList));
        UUID randomBarcode = UUID.randomUUID();
        disc.setBarCode(randomBarcode.toString());

        /* Détermine nombre aléatoire de chansons entre 1 et 10 */
        int randomSongsNumber = (int) (Math.random() * 10);

        for (int i = 0; i < randomSongsNumber; i++){
            int randomDuration = (int) (Math.random() * 20);
            Chanson newSong = disc.createSong(tool.chooseRandomStringInList(stringsList), randomDuration);
            disc.getChansons().add(newSong);
        }

        return disc;
    }


}
