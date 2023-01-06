package Modele;

import java.io.*;
import java.util.ArrayList;

public abstract class ZoneDeJeu {

  protected String[][] matrice;
  protected int ligne;
  protected int colonne;
  protected ArrayList<Animal> lesAnimaux = new ArrayList<>();
  protected ArrayList<AnimalDanger> lesAnimauxDanger = new ArrayList<>();

  private Personnage personnage;

  public static ZoneDeJeu getFactory(String filename) throws IOException {
    FileReader file = new FileReader(filename);
    BufferedReader buffer = new BufferedReader(file);
    String line1 =buffer.readLine();
    char line = line1.charAt(0);
    int ligne =Integer.parseInt(buffer.readLine());
    int colonne =Integer.parseInt(buffer.readLine());
    if (line == 'F')
      return new Foret(buffer,ligne,colonne);
    else return new Jungle(buffer,ligne,colonne);
  }
  public abstract Animal creerAnimal(int x, int y) ;
  public abstract Aliment creerAliment() ;
  public abstract Plante creerPlante() ;
  public abstract AnimalDanger creerAnimalDanger(int x, int y) ;
  public abstract AlimentDanger creerAlimentDanger() ;
  public Plante creerBuisson() {
    return new Buisson();
  }
  public Aliment creerChampignon() {
    return new Champignon();
  }
  public void setMatrice(String[][] matrice) {
    this.matrice=matrice;
  }
  public ZoneVide creerZoneVide() {
    return new ZoneVide();
  }
  public Personnage creerPersonnage(){
    personnage= Personnage.getInstance();
  return personnage;}

  public Personnage getPersonnage() {
    return personnage;
  }

  public String[][] getMatrice() {
    return matrice;
  }
  public int getLigne() {
    return ligne;
  }
  public int getColonne() {
    return colonne;
  }

  public void deplacerAnimal() {
    for (Animal a: lesAnimaux){
      a.seDeplacer(this);
    }
  }
  public void deplacerAnimalDanger() {
    for (AnimalDanger a: lesAnimauxDanger){
      a.seDeplacer(this);
    }
  }
  public void delAnimal(int i, int j) {
    System.out.println(lesAnimaux.size());
    for (Animal a : lesAnimaux){
      if (a.getX()==i && a.getY()==j)
        this.lesAnimaux.remove(a);
      System.out.println(lesAnimaux.size());
        break;
    }

  }

  public void delAnimalD(int x, int y) {
    for (AnimalDanger a : lesAnimauxDanger){
      if (a.getX()==x && a.getY()==y){
        this.lesAnimauxDanger.remove(a);
        break;
      }

    }
  }
}
