package Modele;

import org.javatuples.Pair;

class SingeAffame extends EtatSinge {
  private StraSingeAff strategie;

  private Pair<Integer, Integer>[] voirDanger=new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1),

          new Pair(1,2),new Pair(2,1), new Pair(-2,1), new Pair(1,-2),
          new Pair(-1,2), new Pair(2,-1), new Pair<>(-1,-2), new Pair<>(-2,-1),

          new Pair(0,2),new Pair(2,0), new Pair(-2,0), new Pair(0,-2),
          new Pair(-2,2), new Pair(2,-2), new Pair<>(-2,2), new Pair<>(2,2),

          new Pair(0,3),new Pair(3,0), new Pair(-3,0), new Pair(0,-3),
          new Pair(-3,3), new Pair(3,-3), new Pair<>(-3,-3), new Pair<>(3,3),

          new Pair(1,3),new Pair(3,1), new Pair(-3,1), new Pair(1,-3),
          new Pair(-1,3), new Pair(3,-1), new Pair<>(-1,-3), new Pair<>(-3,-1),

          new Pair(2,3),new Pair(3,2), new Pair(-3,2), new Pair(2,-3),
          new Pair(-2,3), new Pair(3,-2), new Pair<>(-2,-3), new Pair<>(-3,-2)};

  public SingeAffame(Singe singe) {
    super(singe);
    car = Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_YELLOW + "M" + Colors.ANSI_RESET;
  }


  public void setStrategie(StraSingeAff strategie) {
    this.strategie=strategie;
  }
  @Override
  public void seDeplacer(ZoneDeJeu zoneDeJeu) {

    boolean k=true;
    String[][] matrice =zoneDeJeu.getMatrice();

    //voir daner
    for (int i=0; i<voirDanger.length; i++) {
      int a=voirDanger[i].getValue0() + singe.getX();
      int b=voirDanger[i].getValue1() + singe.getY();
      if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() &&
              matrice[a][b] == Colors.ANSI_RED_BACKGROUND+ Colors.ANSI_BLACK+ "S" + Colors.ANSI_RESET) {
        setStrategie(new VoirDangerS());
        strategie.seDeplacer(singe, zoneDeJeu, a, b);
        k=false;
        break;
      }
    }
    //voir banane
    if (k){
      for (int i=0; i<voisins.length; i++) {
        int a=voisins[i].getValue0() + singe.getX();
        int b=voisins[i].getValue1() + singe.getY();
        if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new Banane().getCar()) {
          setStrategie(new VoirBanane());
          strategie.seDeplacer(singe, zoneDeJeu, a, b);
          k=false;
          break;
        }
      }
    }
    //voir Champignon
    if (k){
      for (int i=0; i<voisins.length; i++) {
        int a=voisins[i].getValue0() + singe.getX();
        int b=voisins[i].getValue1() + singe.getY();
        if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new Champignon().getCar()) {
          setStrategie(new VoirChampignonS());
          strategie.seDeplacer(singe, zoneDeJeu, a, b);
          k=false;
          break;
        }
      }
    }
    //voir champignon hallu
    if (k){
      for (int i=0; i<voisins.length; i++) {
        int a=voisins[i].getValue0() + singe.getX();
        int b=voisins[i].getValue1() + singe.getY();
        if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new ChampignonHallu().getCar()) {
          setStrategie(new VoirChampignonHallu());
          strategie.seDeplacer(singe, zoneDeJeu, a, b);
          k=false;
          break;
        }
      }
    }

    //Deplacemant par défaut
    if (k) {
      for (int i=0; i < voisins.length; i++) {
        int a=voisins[i].getValue0() + singe.getX();
        int b=voisins[i].getValue1() + singe.getY();
        if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
          matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
          matrice[a][b]=car;
          singe.setPosition(a, b);
          break;
        }
      }
    }
    zoneDeJeu.setMatrice(matrice);
  }
}
