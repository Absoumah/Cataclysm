package Vue;

import Controleur.Controleur;
import Modele.*;

import java.io.*;
import java.util.ArrayList;

public class Cataclysm {
    public static void main(String[] args) throws IOException {
        ZoneDeJeu zoneDeJeu=ZoneDeJeu.getFactory("carte2.txt");
        Ihm ihm=new Ihm();
        Controleur controleur=new Controleur(zoneDeJeu,ihm);
        controleur.commencer();

    }
}
