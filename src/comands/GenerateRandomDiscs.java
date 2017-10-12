package comands;

import fr.lteconsulting.formations.outils.Saisie;
import main.Bibliotheque;
import main.Comand;
import main.Disque;

import java.io.IOException;

public class GenerateRandomDiscs implements Comand {

    Bibliotheque bib = new Bibliotheque();

    public GenerateRandomDiscs(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Ajouter des disques générés aléatoirement";
    }

    @Override
    public void execute() {

        int nbreDiscs = Saisie.saisieInt("\nCombien de disques aléatoires voulez-vous ajouter ?");

        if (nbreDiscs < 0){
            System.out.println("Veuillez saisie un entier positif ou nul.");
            return;
        }

        for (int i = 0; i < nbreDiscs; i++){
            Disque currentDisc = null;
            try {
                currentDisc = bib.generateRandomDiscFromFile("liste-chansons.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            bib.getDisques().add(currentDisc);
            System.out.println("Disque crée : " + currentDisc.getTitle() + ", " + currentDisc.getBarCode());
        }

    }
}
