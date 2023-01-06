package Modele;

import org.javatuples.Pair;

import java.util.Random;

class Serpent extends AnimalDanger {
  private Pair<Integer, Integer>[] voisins=new Pair[]{new Pair(0,1), new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};
  private EtatSerpent etat;

  public Serpent(int x, int y) {
    super(x, y);
    etat=new SerpentAuSol(this);
    car=etat.getCar();
  }

  @Override
  void seDeplacer(ZoneDeJeu zoneDeJeu) {
    etat.seDeplacer(zoneDeJeu);
  }
  public void setEtat(EtatSerpent etat) {
    this.etat=etat;
    car=etat.getCar();
  }


  public void attaquer(ZoneDeJeu zoneDeJeu) {}


}
