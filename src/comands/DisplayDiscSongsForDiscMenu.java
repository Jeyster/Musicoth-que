package comands;

import main.Comand;
import main.Disque;

public class DisplayDiscSongsForDiscMenu implements Comand {

    Disque disc = new Disque();

    public DisplayDiscSongsForDiscMenu(Disque disc) {
        this.disc = disc;
    }

    @Override
    public String getName() {
        return "Afficher l'album";
    }

    @Override
    public void execute() {

        disc.afficher();
    }
}
