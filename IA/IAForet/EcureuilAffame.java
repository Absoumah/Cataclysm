package Modele;


import org.javatuples.Pair;

class EcureuilAffame extends EtatEcureuil {
  private StraEcAffame strategie;

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

  public EcureuilAffame(Ecureuil ecureuil) {
    super(ecureuil);
    car = Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_BLACK + "E" + Colors.ANSI_RESET;
  }

  public void setStrategie(StraEcAffame strategie) {
    this.strategie=strategie;
  }
  @Override
  public void seDeplacer(ZoneDeJeu zoneDeJeu) {
      //voir Gland
      boolean k=true;
      String[][] matrice =zoneDeJeu.getMatrice();
      for (int i=0; i<voisins.length; i++) {
          int a=voisins[i].getValue0() + ecureuil.getX();
          int b=voisins[i].getValue1() + ecureuil.getY();
          if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new Gland().getCar()) {
              setStrategie(new VoirGland());
              strategie.seDeplacer(ecureuil, zoneDeJeu, a, b);
              k=false;
              break;
          }
      }
      //voir Champignon
      if (k){
          for (int i=0; i<voisins.length; i++) {
              int a=voisins[i].getValue0() + ecureuil.getX();
              int b=voisins[i].getValue1() + ecureuil.getY();
              if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new Champignon().getCar()) {
                  setStrategie(new VoirChampignon());
                  strategie.seDeplacer(ecureuil, zoneDeJeu, a, b);
                  k=false;
                  break;
              }
          }
      }
      //voir champignon venimeux
      if (k){
          for (int i=0; i<voisins.length; i++) {
              int a=voisins[i].getValue0() + ecureuil.getX();
              int b=voisins[i].getValue1() + ecureuil.getY();
              if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new ChampignonVeni().getCar()) {
                  setStrategie(new VoirChampignonVeni());
                  strategie.seDeplacer(ecureuil, zoneDeJeu, a, b);
                  k=false;
                  break;
              }
          }
      }
      //Voir danger
      if (k){
          for (int i=0; i<voirDanger.length; i++) {
              int a=voirDanger[i].getValue0() + ecureuil.getX();
              int b=voirDanger[i].getValue1() + ecureuil.getY();
              if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == "R" + Colors.ANSI_RESET) {
                  setStrategie(new VoirDanger());
                  strategie.seDeplacer(ecureuil, zoneDeJeu, a, b);
                  k=false;
                  break;
              }
          }
      }
      //Deplacemant par défaut
      if (k) {
          for (int i=0; i < voisins.length; i++) {
              int a=voisins[i].getValue0() + ecureuil.getX();
              int b=voisins[i].getValue1() + ecureuil.getY();
              if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() && matrice[a][b] == new ZoneVide().getCar()) {
                  matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                  matrice[a][b]=car;
                  ecureuil.setPosition(a, b);
                  zoneDeJeu.setMatrice(matrice);
                  break;
              }
          }
      }
  }

}

