package comands;

import main.Comand;
import main.Disque;

public class DeleteSongs implements Comand {

    Disque disc = new Disque();

    public DeleteSongs(Disque disc) {
        this.disc = disc;
    }

    @Override
    public String getName() {
        return "Supprimer une chanson";
    }

    @Override
    public void execute() {
        disc.deleteSongs();
    }
}
