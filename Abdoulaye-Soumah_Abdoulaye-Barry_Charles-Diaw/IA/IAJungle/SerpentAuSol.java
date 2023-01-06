package Modele;

import org.javatuples.Pair;

import java.util.Random;

class SerpentAuSol extends EtatSerpent {

    private static SerpentAuSol instance = null;

    public static SerpentAuSol getInstance(Serpent serpent) {
        if (instance==null)
            instance = new SerpentAuSol(serpent);
        return instance;
    }

    public SerpentAuSol(Serpent serpent) {
        super(serpent);
        car=Colors.ANSI_RED_BACKGROUND+ Colors.ANSI_BLACK+ "S" + Colors.ANSI_RESET;
    }

    @Override
    void seDeplacer(ZoneDeJeu zoneDeJeu) {
        String[][] matrice=zoneDeJeu.getMatrice();
        attaquer(zoneDeJeu);
        Random r=new Random();
        while (true) {
            Pair p=voisins[r.nextInt(7)];
            int a=(int) p.getValue0() + serpent.getX();
            int b=(int) p.getValue1() + serpent.getY();
            if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne()) {
                if (matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                    matrice[serpent.getX()][serpent.getY()]=new ZoneVide().getCar();
                    matrice[a][b]=car;
                    serpent.setPosition(a, b);
                    zoneDeJeu.setMatrice(matrice);
                    break;
                }
                else if(matrice[a][b]==new Buisson().getCar()){
                    serpent.setEtat(new SerpentBuisson(serpent));
                    matrice[serpent.getX()][serpent.getY()]=new ZoneVide().getCar();
                    matrice[a][b]=car;
                    serpent.setPosition(a, b);
                    zoneDeJeu.setMatrice(matrice);
                    break;
                }
            }

        }
    }

    @Override
    void attaquer (ZoneDeJeu zoneDeJeu){

    }
}
