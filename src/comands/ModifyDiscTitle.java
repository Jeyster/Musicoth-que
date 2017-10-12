package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Comand;
import main.Disque;

public class ModifyDiscTitle implements Comand{

    Disque disc = new Disque();

    public ModifyDiscTitle(Disque disc) {
        this.disc = disc;
    }

    @Override
    public String getName() {
        return "Modifier le nom de l'album";
    }

    @Override
    public void execute() {
        String newTitle = Saisie.saisie("\nNouveau nom : ");
        disc.setTitle(newTitle);

        if (newTitle != null){
            System.out.println("Nom de l'album modifié !");
        }
    }
}
