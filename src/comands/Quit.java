package comands;

import main.Bibliotheque;
import main.Comand;

public class Quit implements Comand {

    @Override
    public String getName() {
        return "Quitter";
    }

    @Override
    public void execute() {

        System.out.println("\n-------------------- FIN --------------------");
        System.exit(0);

    }
}
