package comands;

import main.Bibliotheque;
import main.Comand;

public class DisplayBib implements Comand {

    private Bibliotheque bib;

    public DisplayBib(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Afficher votre musicothèque";
    }

    @Override
    public void execute() {
        this.bib.afficher();
    }
}
