package Modele;

import org.javatuples.Pair;

abstract class EtatSerpent {

  protected Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};
  protected Serpent serpent;

  protected String car;
  public EtatSerpent(Serpent serpent) {
    this.serpent=serpent;
  }

  abstract void seDeplacer(ZoneDeJeu zoneDeJeu);

  abstract void attaquer(ZoneDeJeu zoneDeJeu);


  public String getCar() {
    return car;
  }

  protected int tour =0;
}
