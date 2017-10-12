package main;

import fr.lteconsulting.formations.outils.Saisie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {


    public static void main(String[] args) throws IOException {

        Chanson chanson1 = new Chanson();
        chanson1.setTitle("Parabola");
        chanson1.setDuration(9);

        Chanson chanson2 = new Chanson();
        chanson2.setTitle("Lateralus");
        chanson2.setDuration(6);

        List<Chanson> chansons = new ArrayList<>();
        chansons.add(chanson1);
        chansons.add(chanson2);
        Disque disque1 = new Disque();
        disque1.setChansons(chansons);
        disque1.setTitle("Lateralus");
        disque1.setBarCode("0000");


        Chanson chanson3 = new Chanson();
        chanson3.setTitle("The Brain Dance");
        chanson3.setDuration(7);

        List<Chanson> chansons2 = new ArrayList<>();
        chansons2.add(chanson3);
        Disque disque2 = new Disque();
        disque2.setChansons(chansons2);
        disque2.setTitle("The Joy of Motion");
        disque2.setBarCode("0001");

        List<Disque> disques = new ArrayList<>();
        disques.add(disque1);
        disques.add(disque2);
        Bibliotheque biblio = new Bibliotheque();
        biblio.setDisques(disques);


        InterfaceUtilisateur iu = new InterfaceUtilisateur();
        iu.setBibliotheque(biblio);
        iu.executeMenu();



    }
}
