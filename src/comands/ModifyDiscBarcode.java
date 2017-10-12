package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Comand;
import main.Disque;

public class ModifyDiscBarcode implements Comand {

    Disque disc = new Disque();

    public ModifyDiscBarcode(Disque disc) {
        this.disc = disc;
    }

    @Override
    public String getName() {
        return "Modifier le code barre de l'album";
    }

    @Override
    public void execute() {
        String newBarcode = Saisie.saisie("\nNouveau code barre : ");
        disc.setBarCode(newBarcode);

        if (newBarcode != null){
            System.out.println("Code barre de l'album modifié !");
        }

    }
}
