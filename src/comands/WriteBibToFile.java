package comands;

import main.Bibliotheque;
import main.Chanson;
import main.Comand;
import main.Disque;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteBibToFile implements Comand{

    Bibliotheque bibliotheque = new Bibliotheque();

    public WriteBibToFile(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }


    @Override
    public String getName() {
        return "Sauvegarder la musicothèque";
    }

    @Override
    public void execute() throws IOException {

        String fileName = "output.music";
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);

        if (!file.exists()){
            file.createNewFile();
        }


        for (Disque currentDisc : bibliotheque.getDisques()){

            for (Chanson currentSong : currentDisc.getChansons()){

                writer.write(currentDisc.getTitle() + " ; " + currentDisc.getBarCode() + " ; " + currentSong.getTitle() + " ; " + currentSong.getDuration() + "\n");
                writer.flush();


            }

        }
        writer.close();

        System.out.println("Musicothèque sauvegardée dans fichier " + fileName);

    }
}
