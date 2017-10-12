package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.*;

/* Affiche le disque trouvé par recherche de son code barre (getDiscByBarcode)*/
public class DisplayFoundDiscsByBarcode implements Comand{

    private Bibliotheque bib = new Bibliotheque();

    public DisplayFoundDiscsByBarcode(Bibliotheque bib) {
        this.bib = bib;
    }


    @Override
    public String getName() {
        return "Rechercher album par code barre";
    }

    @Override
    public void execute() {

        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(bib);
        String searchedBarcode = Saisie.saisie("\nCode barre de l'album recherché : ");
        Disque foundDisc = this.bib.getDiscWithBarcode(searchedBarcode);

        if (foundDisc == null) {
            System.out.println("Pas d'album avec le code barre recherché.");
            return;
        }

        foundDisc.afficher();
        for (Chanson current : foundDisc.getChansons()){
            current.afficher();
        }
    }
}
