package Modele;

import org.javatuples.Pair;

import java.util.ArrayList;

public class Personnage {
  private Pair<Integer, Integer>[] voisins=new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1),

          new Pair(1,2),new Pair(2,1), new Pair(-2,1), new Pair(1,-2),
          new Pair(-1,2), new Pair(2,-1), new Pair<>(-1,-2), new Pair<>(-2,-1),

          new Pair(0,2),new Pair(2,0), new Pair(-2,0), new Pair(0,-2),
          new Pair(-2,2), new Pair(2,-2), new Pair<>(-2,-2), new Pair<>(2,2),

          new Pair(0,3),new Pair(3,0), new Pair(-3,0), new Pair(0,-3),
          new Pair(-3,3), new Pair(3,-3), new Pair<>(-3,-3), new Pair<>(3,3),

          new Pair(1,3),new Pair(3,1), new Pair(-3,1), new Pair(1,-3),
          new Pair(-1,3), new Pair(3,-1), new Pair<>(-1,-3), new Pair<>(-3,-1),

          new Pair(2,3),new Pair(3,2), new Pair(-3,2), new Pair(2,-3),
          new Pair(-2,3), new Pair(3,-2), new Pair<>(-2,-3), new Pair<>(-3,-2)};

  private static Personnage instance = null;

  public static Personnage getInstance() {
    if (instance==null)
      instance = new Personnage();
    return instance;
  }

  private String car =Colors.ANSI_PURPLE + "@" + Colors.ANSI_RESET;
  private ArrayList<Aliment> listeObjets = new ArrayList<>();
  private int vie;

  public String getCar() {
    return car;
  }

  public ArrayList<Aliment> getListeObjets() {
    return listeObjets;
  }

  public int getVie() {
    return vie;
  }



  private ArrayList<Animal> mesAnimaux = new ArrayList<>();

  public ArrayList<Animal> getMesAnimaux() {
    return mesAnimaux;
  }

  public void apprivoiser(Animal a){
    mesAnimaux.add(a);
  }

  private int x;
  private int y;

  void setPosition(int x, int y){
    this.x=x;
    this.y=y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void descendre(ZoneDeJeu zoneDeJeu) {
    String[][] matrice = zoneDeJeu.getMatrice();
    if (x+1 < zoneDeJeu.getLigne() && matrice[x+1][y]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET ){
        matrice[x][y]=new ZoneVide().getCar();
        matrice[x+1][y]=car;
        setPosition(x+1,y);
        zoneDeJeu.setMatrice(matrice);
    }
  }

  public void monter(ZoneDeJeu zoneDeJeu) {
    String[][] matrice = zoneDeJeu.getMatrice();
    if (x-1 >=0 && matrice[x-1][y]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET){
        matrice[x][y]=new ZoneVide().getCar();
        matrice[x-1][y]=car;
        setPosition(x-1,y);
        zoneDeJeu.setMatrice(matrice);
    }
  }

  public void droite(ZoneDeJeu zoneDeJeu) {
    String[][] matrice = zoneDeJeu.getMatrice();
    if (y+1 < zoneDeJeu.getColonne() && matrice[x][y+1]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET){
        matrice[x][y]=new ZoneVide().getCar();
        matrice[x][y+1]=car;
        setPosition(x,y+1);
        zoneDeJeu.setMatrice(matrice);
    }
  }

  public void gauche(ZoneDeJeu zoneDeJeu){
    String[][] m = zoneDeJeu.getMatrice();
    if (y-1 >= 0 && m[x][y-1] ==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET){
        m[x][y]=new ZoneVide().getCar();
        m[x][y-1]=car;
        zoneDeJeu.setMatrice(m);
        setPosition(x,y-1);
    }
  }

  public void seBattre(ZoneDeJeu zoneDeJeu) {
    String[][] matrice =zoneDeJeu.getMatrice();
    boolean c=true;
    for (Pair<Integer,Integer> p : voisins){
      int a = p.getValue0()+x;
      int b = p.getValue1()+y;
      if (matrice[a][b] == zoneDeJeu.creerAnimalDanger(a,b).getCar()){
        matrice[a][b]= new ZoneVide().getCar();
        zoneDeJeu.delAnimalD(a,b);
        zoneDeJeu.setMatrice(matrice);
        c=false;
        break;
      }
    }
    if (c){
      for (Pair<Integer,Integer> p : voisins){
        int a = p.getValue0()+x;
        int b = p.getValue1()+y;
        if (mesAnimaux.size() > 0){
          Animal w = mesAnimaux.get(0);
          if (matrice[a][b] == w.getCar() ){
            mesAnimaux.remove(mesAnimaux.size()-1);
            matrice[a][b]=new ZoneVide().getCar();
            break;
          }
        }

      }
    }
  }
  public void ramasserObjet(ZoneDeJeu zoneDeJeu) {
    String[][] matrice =zoneDeJeu.getMatrice();
    for (Pair<Integer,Integer> p : voisins){
      int a = p.getValue0()+x;
      int b = p.getValue1()+y;
      if (matrice[a][b] == zoneDeJeu.creerAliment().getCar()) {
        matrice[a][b]=new ZoneVide().getCar();
        listeObjets.add(new Gland());
        zoneDeJeu.setMatrice(matrice);
        break;
      }
      if (matrice[a][b] == new Champignon().getCar()){
        matrice[a][b]=new ZoneVide().getCar();
        listeObjets.add(new Champignon());
        zoneDeJeu.setMatrice(matrice);
        break;
      }
    }
  }

  public void reposerObjet(ZoneDeJeu zoneDeJeu) {
    String[][] matrice =zoneDeJeu.getMatrice();
    for (Pair<Integer,Integer> p : voisins) {
      int a=p.getValue0() + x;
      int b=p.getValue1() + y;
      if (listeObjets.size() > 0 && matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
        Aliment aliment=listeObjets.remove(listeObjets.size() - 1);
        matrice[a][b]=aliment.getCar();
        zoneDeJeu.setMatrice(matrice);
        break;
      }
    }
  }

  public void reposerAnimal(ZoneDeJeu zoneDeJeu) {
    String[][] matrice =zoneDeJeu.getMatrice();
    for (Pair<Integer,Integer> p : voisins) {
      int a=p.getValue0() + x;
      int b=p.getValue1() + y;
      if (mesAnimaux.size() != 0 && matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
        Animal animal = mesAnimaux.remove(mesAnimaux.size()-1);
        matrice[a][b]=animal.getCar();
        zoneDeJeu.setMatrice(matrice);
        break;
      }
    }
  }


}
