package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Bibliotheque;
import main.Chanson;
import main.Comand;
import main.InterfaceUtilisateur;

import java.util.List;


/* Affiche les chansons trouvées par recherche de leur nom (getSongsInDiscs)*/
public class DisplayFoundSongs implements Comand{

    private Bibliotheque bib = new Bibliotheque();

    public DisplayFoundSongs(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Rechercher chansons par nom";
    }

    @Override
    public void execute() {

        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(bib);
        String searchedSongName = Saisie.saisie("\nNom de chanson recherché : ");
        List<Chanson> foundSongs = this.bib.getSongsInDiscs(searchedSongName);

        if (foundSongs.isEmpty()) {
            System.out.println("Pas de chansons avec le nom recherché.");
            return;
        }

        for (Chanson currentSong : foundSongs) {
            currentSong.afficher();
        }
    }
}
