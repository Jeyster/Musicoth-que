package main;

import fr.lteconsulting.formations.outils.Saisie;

import java.util.ArrayList;
import java.util.List;

/* Classe Menu dans laquelle on peut ajouter des commandes ou demander la saisie d'une commande */

public class Menu {

    private List<Comand> comands = new ArrayList<>();

    public void addComand(Comand comand){
        comands.add(comand);
    }

    public Comand askComand(){

        System.out.println("\n\nQue voulez-vous faire ?");

        for (int i = 0; i < comands.size(); i++){
            System.out.println((i+1) + " - " + comands.get(i).getName());
        }

        int choice = Saisie.saisieInt("");

        if ((choice) > comands.size()){
            System.out.println("Saisie incorrecte !");
            return null;
        }

        return comands.get(choice-1);

    }

}
