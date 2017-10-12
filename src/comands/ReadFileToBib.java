package comands;

import main.Bibliotheque;
import main.Chanson;
import main.Comand;
import main.Disque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ReadFileToBib implements Comand {

    Bibliotheque bibliotheque = new Bibliotheque();
    String fileName = new String();

    public ReadFileToBib(Bibliotheque bibliotheque, String fileName) {
        this.bibliotheque = bibliotheque;
        this.fileName = fileName;
    }

    @Override
    public String getName() {
        return "Charger disques dans votre musicothèque";
    }

    @Override
    public void execute() throws IOException {

        File file = new File(fileName);
        FileReader fr = new FileReader(file);

        //Guard
        if (file.exists() == false){
            System.out.println("Le fichier à lire n'existe pas !");
            return;
        }

        BufferedReader br = new BufferedReader(fr);

        String line;

        while ((line = br.readLine()) != null) {

            String[] betweenSeparatorText = line.split(" ; ");

            Disque readedDisc = new Disque();
            readedDisc.setTitle(betweenSeparatorText[0]);
            readedDisc.setBarCode(betweenSeparatorText[1]);

            Chanson readedSong = new Chanson();
            readedSong.setTitle(betweenSeparatorText[2]);
            readedSong.setDuration(parseInt(betweenSeparatorText[3]));

            readedDisc.getChansons().add(readedSong);

            if (!bibliotheque.getDisques().toString().contains(readedDisc.getTitle())){
                bibliotheque.getDisques().add(readedDisc);
            }

            for (Disque currentDisc : bibliotheque.getDisques()){

                if (currentDisc.getTitle().equals(readedDisc.getTitle())){


                    if (!currentDisc.getChansons().toString().contains(readedSong.getTitle())){
                        currentDisc.getChansons().add(readedSong);
                    }


                }

            }

        }

        br.close();
        fr.close();

        System.out.println("\nDisques ajoutés à la musicothèque depuis le fichier " + fileName);

    }
}
