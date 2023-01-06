package Modele;

import org.javatuples.Pair;

import java.util.Random;

public class Renard extends AnimalDanger {

  private Pair<Integer, Integer>[] voisins=new Pair[]{new Pair(0,1), new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
          new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};
  private StrategieRenard strategie;

  public Renard(int x, int y) {
    super(x, y);
    car= Colors.ANSI_YELLOW_BACKGROUND+ Colors.ANSI_BLACK + "R" + Colors.ANSI_RESET;
  }
  @Override
  void seDeplacer(ZoneDeJeu zoneDeJeu) {
    String[][] matrice = zoneDeJeu.getMatrice();
    attaquer(zoneDeJeu);
    Random r=new Random();
    while (true) {
      Pair p=voisins[r.nextInt(7)];
      int a=(int) p.getValue0()+x;
      int b=(int) p.getValue1()+y;
      if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne()) {
        if (matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
          matrice[x][y]=new ZoneVide().getCar();
          matrice[a][b]=car;
          setPosition(a,b);
          zoneDeJeu.setMatrice(matrice);
          break;
        }
      }
    }
  }
  public void setStrategie(StrategieRenard strategie) {
    this.strategie=strategie;
  }


  public void attaquer(ZoneDeJeu zoneDeJeu) {
    String[][] matrice= zoneDeJeu.getMatrice();
    for (int i=0; i < voisins.length; i++) {
      int a=voisins[i].getValue0()+x;
      int b=voisins[i].getValue1()+y;
      if (a < zoneDeJeu.getLigne() && a >= 0 &&  b < zoneDeJeu.getColonne() && b>=0) {
        String var = matrice[a][b];
        if ( var == Colors.ANSI_YELLOW_BACKGROUND+Colors.ANSI_BLACK+"E"+Colors.ANSI_RESET ||
                var == Colors.ANSI_YELLOW_BACKGROUND+Colors.ANSI_BLUE+"E"+Colors.ANSI_RESET ||
                var == Colors.ANSI_YELLOW_BACKGROUND+Colors.ANSI_RED+"E"+Colors.ANSI_RESET) {

          for (int j=0; j < voisins.length; j++) {
            int c=voisins[i].getValue0() + a;
            int d=voisins[i].getValue1() + b;
            if (c < zoneDeJeu.getLigne() && c >= 0 && d < zoneDeJeu.getColonne() && d >= 0 && matrice[c][d] != new Arbre().getCar()) {
              setStrategie(new Tuer());
              strategie.execute(matrice, a, b);
              zoneDeJeu.delAnimal(a, b);
              break;
            }
          }

          break;
        }
        else if (var == Colors.ANSI_YELLOW_BACKGROUND+Colors.ANSI_GREEN+"E"+Colors.ANSI_RESET ||
          var == Colors.ANSI_YELLOW_BACKGROUND+Colors.ANSI_YELLOW+"E"+Colors.ANSI_RESET){
          setStrategie(new FairePeur());
          strategie.execute(matrice, a, b);
          break;
        }
      }
    }
  }

}
