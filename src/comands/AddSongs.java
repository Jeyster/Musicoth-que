package comands;

import main.Comand;
import main.Disque;

public class AddSongs implements Comand {

    Disque disc = new Disque();

    public AddSongs(Disque disc) {
        this.disc = disc;
    }

    @Override
    public String getName() {
        return "Ajouter une chanson";
    }

    @Override
    public void execute() {
        disc.addSongs();
    }
}
