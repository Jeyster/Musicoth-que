package main;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImporterExporter {

    private String textToWrite;

    public ImporterExporter(String textToWrite) {
        this.textToWrite = textToWrite;
    }

    public String getTextToWrite() {
        return textToWrite;
    }

    public void setTextToWrite(String textToWrite) {
        this.textToWrite = textToWrite;
    }



    public List<String> importLinesFromFile(String fileName) throws IOException {

        File file = new File(fileName);
        FileReader fr = new FileReader(file);

        //Guard
        if (file.exists() == false){
            System.out.println("Le fichier à lire n'existe pas !");
            return null;
        }

        BufferedReader br = new BufferedReader(fr);

        List<String> stringsList = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {

            String current = line;
            stringsList.add(current);
        }

        br.close();
        fr.close();

        return stringsList;

    }


}
