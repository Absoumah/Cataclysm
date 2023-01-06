package Modele;

class SerpentBuisson extends EtatSerpent {

  private static SerpentBuisson instance=null;

  public static SerpentBuisson getInstance(Serpent serpent) {
    if (instance == null)
      instance=new SerpentBuisson(serpent);
    return instance;
  }


  public SerpentBuisson(Serpent serpent) {
    super(serpent);
    car=Colors.ANSI_RED_BACKGROUND+ Colors.ANSI_BLACK+ "S" + Colors.ANSI_RESET;
  }

  @Override
  void seDeplacer(ZoneDeJeu zoneDeJeu) {
    attaquer(zoneDeJeu);
    tour+=1;
    if (tour==5){
      tour=0;
      serpent.setEtat(new SerpentAuSol(serpent));
      serpent.seDeplacer(zoneDeJeu);
    }
  }

  @Override
  void attaquer(ZoneDeJeu zoneDeJeu) {
    String[][] matrice = zoneDeJeu.getMatrice();
    for (int i=0; i < voisins.length; i++) {
      int a=voisins[i].getValue0() + serpent.getX();
      int b=voisins[i].getValue1() + serpent.getY();
      if (a < zoneDeJeu.getLigne() && a >= 0 && b >= 0 && b < zoneDeJeu.getColonne() && matrice[a][b]==new Buisson().getCar()){
        for (int j=0; j < voisins.length; j++) {
          int c=voisins[j].getValue0() + serpent.getX();
          int d=voisins[j].getValue1() + serpent.getY();
          if (c < zoneDeJeu.getLigne() && c >= 0 && d >= 0 && d < zoneDeJeu.getColonne() &&
                  matrice[c][d] == Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_PURPLE + "M" + Colors.ANSI_RESET) {
            matrice[c][d]=new ZoneVide().getCar();
            break;
          }
        }
        break;
      }
    }
  }
}
