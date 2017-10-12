package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.*;

public class DisplayDiscSongs implements Comand {

    private Bibliotheque bib = new Bibliotheque();

    public DisplayDiscSongs(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Afficher les chansons d'un album";
    }

    @Override
    public void execute() {

        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(bib);
    /* Affiche les chansons d'un album dont le nom est saisie par l'utilisateur */
        String searchedDiscName = Saisie.saisie("\nNom de l'album : ");
        Disque foundDisc = bib.getDiscWithName(searchedDiscName);

        if (foundDisc == null) {
            System.out.println("Pas d'album avec le nom recherché.");
            return;
        }

        if (foundDisc.getChansons().isEmpty() == true){
            System.out.println("Album vide.");
            return;
        }

        for (Chanson current : foundDisc.getChansons()) {
            current.afficher();
        }
    }
}
