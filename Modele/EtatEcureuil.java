package Modele;

import org.javatuples.Pair;

abstract class EtatEcureuil {

  protected Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};

  protected String car;

  protected Ecureuil ecureuil;

  protected int tour =0;

  public EtatEcureuil(Ecureuil ecureuil) {
    this.ecureuil=ecureuil;
  }

  public abstract void seDeplacer(ZoneDeJeu zoneDeJeu);

}
