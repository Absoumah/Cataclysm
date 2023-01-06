package Controleur;

import Modele.ZoneDeJeu;
import Vue.Ihm;

public class Controleur {

    private  ZoneDeJeu zoneDeJeu;
    private  Ihm ihm;

    private Icommande seBattre;

    private Icommande gauche;
    private Icommande droite;
    private Icommande monter;
    private Icommande descendre;

    private Icommande ramasserObjet;

    private Icommande reposerAnimal;

    public Controleur(ZoneDeJeu zoneDeJeu, Ihm ihm) {
        this.zoneDeJeu= zoneDeJeu;
        this.ihm=ihm;
        this.seBattre = new SeBattre();
        this.gauche = new DepGauche();
        this.droite = new DepDroite();
        this.monter = new DepMonter();
        this.descendre = new DepDescendre();
        this.ramasserObjet = new RamasserObjet();
        this.reposerAnimal = new ReposerAnimal();
    }

    public void afficherMenu(){
        String c =ihm.afficherMenu();
        switch (c) {
            case "1":
                droite();
                break;
            case "2":
                gauche();
                break;
            case "3":
                monter();
                break;
            case "4":
                descendre();
                break;
            case "5":
                seBattre();
                break;
            case "6":
                ramasserObjet();
                break;
            case "7":
                reposerObjet();
                break;
            case "8":
                reposerAnimal();
                break;
            case "0":
                jouer=false;
                break;
            default:
                ihm.print("Invalide! Veuillez entrer un chiffre valide!");
                ihm.printLine();
                afficherMenu();
                break;
        }
    }

    public void seBattre() {
        seBattre.execute(zoneDeJeu);
    }

    public void gauche() {
        gauche.execute(zoneDeJeu);
    }
    public void droite() {droite.execute(zoneDeJeu);}
    public void descendre() { descendre.execute(zoneDeJeu);}
    public void monter() {monter.execute(zoneDeJeu);}
    public void ramasserObjet() {
        ramasserObjet.execute(zoneDeJeu);
    }

    public void reposerObjet() {
        ramasserObjet.undo(zoneDeJeu);
    }
    public void reposerAnimal() {
        reposerAnimal.execute(zoneDeJeu);
    }

    public void afficherMatrice(){
        for (int i=0; i<zoneDeJeu.getLigne();i++){
            for (int j=0; j<zoneDeJeu.getColonne(); j++){
                ihm.print(zoneDeJeu.getMatrice()[i][j]);
            }
            ihm.printLine();
        }
    }

    boolean jouer = true;
    int tour=0;
    public void commencer() {
        while (jouer){
            tour+=1;
            afficherMatrice();
            afficherMenu();
            zoneDeJeu.deplacerAnimal();
            zoneDeJeu.deplacerAnimalDanger();
        }
    }
}
