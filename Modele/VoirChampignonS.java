package Modele;

import org.javatuples.Pair;

class VoirChampignonS implements StraSingeAff {

    @Override
    public void seDeplacer(Singe singe,ZoneDeJeu zoneDeJeu, int c, int d) {
        Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
                new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1)};

        String[][] matrice = zoneDeJeu.getMatrice();
        matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
        singe.setEtat(new SingeRassasie(singe));
        for (int i=0; i<voisins.length; i++){
            int a= voisins[i].getValue0()+ c;
            int b= voisins[i].getValue1()+ d;
            if (matrice[a][b]==zoneDeJeu.getPersonnage().getCar()){
                singe.setPeronnage(zoneDeJeu.getPersonnage());
                singe.setEtat(new SingeAmi(singe));
                break;
            }
        }
        matrice[c][d]=singe.getCar();
        singe.setPosition(c,d);
        zoneDeJeu.setMatrice(matrice);
    }
}
