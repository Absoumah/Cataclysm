package Modele;

import org.javatuples.Pair;

class VoirGland implements StraEcAffame {
    @Override
    public void seDeplacer(Ecureuil e,ZoneDeJeu zoneDeJeu, int c, int d) {
        Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
                new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};

        String[][] matrice = zoneDeJeu.getMatrice();
        matrice[e.getX()][e.getY()]=new ZoneVide().getCar();
        e.setEtat(new EcureuilRassasie(e));
        for (int i=0; i<voisins.length; i++){
            int a= voisins[i].getValue0()+ c;
            int b= voisins[i].getValue1()+ d;
            if (matrice[a][b]==zoneDeJeu.getPersonnage().getCar() && a < zoneDeJeu.getLigne() && a >=0 && b>=0 && b<zoneDeJeu.getColonne()){
                e.setPeronnage(zoneDeJeu.getPersonnage());
                e.setEtat(new EcureuilAmi(e));
                zoneDeJeu.getPersonnage().apprivoiser(e);
                break;
            }
        }
        matrice[c][d]=e.getCar();
        e.setPosition(c,d);
        zoneDeJeu.setMatrice(matrice);
    }
}
