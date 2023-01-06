package Modele;

import org.javatuples.Pair;

abstract class EtatSinge {

  protected Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};

  protected String car;

  protected Singe singe;

  protected int tour =0;

  public EtatSinge(Singe singe) {
    this.singe=singe;
  }

  public abstract void seDeplacer(ZoneDeJeu zoneDeJeu);

  public String getCar() {
    return car;
  }
}
