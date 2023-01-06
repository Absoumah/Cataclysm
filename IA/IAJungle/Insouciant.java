package Modele;

import org.javatuples.Pair;

import java.util.Random;

class Insouciant extends EtatSinge {

    private Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
            new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};

    public Insouciant(Singe singe) {
        super(singe);
        car = Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_RED + "M" + Colors.ANSI_RESET;
    }
    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        tour+=1;
        String[][] matrice = zoneDeJeu.getMatrice();
        if (tour==3){
            tour=0;
            singe.setEtat(new SingeAffame(singe));
        }
        Random r=new Random();
        while (true) {
            Pair p=voisins[r.nextInt(7)];
            int a=(int) p.getValue0()+singe.getX();
            int b=(int) p.getValue1()+singe.getY();
            if (a < zoneDeJeu.getLigne() && a >=0 && b>=0 && b<zoneDeJeu.getColonne()) {
                if (matrice[a][b] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                    matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
                    matrice[a][b]=singe.getCar();
                    singe.setPosition(a,b);
                    zoneDeJeu.setMatrice(matrice);
                    break;
                }
            }
        }
    }
}
