package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Bibliotheque;
import main.Comand;
import main.InterfaceUtilisateur;

import java.util.UUID;


/* Ajouter des albums dans la bibliothèque */
public class AddDiscs implements Comand{

    private Bibliotheque bib = new Bibliotheque();

    public AddDiscs(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Ajouter un nouvel album";
    }

    @Override
    public void execute() {

        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(bib);
        String response = "O";

        while (response.equals("O")){  //boucle tant que l'utilisateur veut supprimer des chansons de l'album
            String discTitle = Saisie.saisie("Nom de l'album : ");
            String barCode = Saisie.saisie("Code barre de l'album (tapez auto pour générer aléatoirement) : ");

            if (barCode.equals("auto")){
                barCode = UUID.randomUUID().toString();
            }

            int isAdd = this.bib.addDisc(discTitle, barCode);
            if (isAdd == 1){
                System.out.println("Album ajouté !");
            }

            response = Saisie.saisie("\nAjouter un autre album ? (O/n) ");
        }    }
}
