package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Bibliotheque;
import main.Comand;
import main.Disque;
import main.InterfaceUtilisateur;

import java.util.List;


/* Affiche les disques trouvés par recherche de leur nom (getDiscs)*/
public class DisplayFoundDiscs implements Comand{

    private Bibliotheque bib = new Bibliotheque();

    public DisplayFoundDiscs(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Rechercher albums par nom";
    }

    @Override
    public void execute() {

        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(bib);
        String searchedDiscName = Saisie.saisie("\nNom d'album recherché : ");
        List<Disque> foundDiscs = this.bib.getDiscsByName(searchedDiscName);

        if (foundDiscs.isEmpty()) {
            System.out.println("Pas d'album avec le nom recherché.");
            return;
        }

        for (Disque currentDisc : foundDiscs) {
            currentDisc.afficher();
        }
    }
}
