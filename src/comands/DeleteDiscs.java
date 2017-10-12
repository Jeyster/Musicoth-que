package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Bibliotheque;
import main.Comand;
import main.InterfaceUtilisateur;

/* Supprimer un album dans la bibliothèque */
public class DeleteDiscs implements Comand {

    private Bibliotheque bib = new Bibliotheque();

    public DeleteDiscs(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Supprimer un album";
    }

    @Override
    public void execute() {

        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(bib);
        String response = "O";

        while (response.equals("O")){  //boucle tant que l'utilisateur veut supprimer des chansons de l'album
            String discTitle = Saisie.saisie("Nom de l'album à supprimer : ");
            int isDelete = this.bib.deleteDisc(discTitle);
            if (isDelete == 1){
                System.out.println("Album supprimé !");
            }
            else {
                System.out.println("Cette album n'est pas votre musicotèque.");
            }


            response = Saisie.saisie("\nSupprimer un autre album ? (O/n) ");
        }
    }
}
