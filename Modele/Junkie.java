package Modele;

import org.javatuples.Pair;

import java.util.Random;

class Junkie extends EtatEcureuil {

    private Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
            new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};
    public Junkie(Ecureuil ecureuil) {
        super(ecureuil);
        car = Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_RED + "E" + Colors.ANSI_RESET;
    }
    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        tour+=1;
        String[][] matrice = zoneDeJeu.getMatrice();
        if (tour==5){
            tour=0;
            ecureuil.setEtat(new EcureuilAffame(ecureuil));
        }
        Random r=new Random();
        while (true) {
            Pair p=voisins[r.nextInt(7)];
            int a=(int) p.getValue0()+ecureuil.getX();
            int b=(int) p.getValue1()+ecureuil.getY();
            if (a < zoneDeJeu.getLigne() && a >=0 && b>=0 && b<zoneDeJeu.getColonne()) {
                if (matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                    matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                    matrice[a][b]=ecureuil.getCar();
                    ecureuil.setPosition(a,b);
                    zoneDeJeu.setMatrice(matrice);
                    break;
                }
            }
        }
    }


}
