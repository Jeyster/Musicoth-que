package comands;

import main.Bibliotheque;
import main.Comand;

public class ModifyDiscWithName implements Comand {

    private Bibliotheque bib = new Bibliotheque();

    public ModifyDiscWithName(Bibliotheque bib) {
        this.bib = bib;
    }

    @Override
    public String getName() {
        return "Modifier un album";
    }

    @Override
    public void execute() {

        bib.modifyDiscWithName();

    }
}
