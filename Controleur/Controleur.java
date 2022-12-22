package Controleur;

import Vue.Icommande;

public class Controleur {
    private Icommande icommande;

    private Icommande seBattre;

    private Icommande seDeplacer;

    private Icommande ramasserObjet;

    private Icommande reposerAnimal;

    public void seBattre() {
        seBattre.execute();
    }

    public void seDeplacer() {
        seDeplacer.execute();
    }

    public void ramasserObjet() {
        ramasserObjet.execute();
    }

    public void reposerObjet() {
        ramasserObjet.undo();
    }

    public void reposerAnimal() {
        reposerAnimal.execute();
    }
}
