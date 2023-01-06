package Modele;

import org.javatuples.Pair;

class VoirDangerS implements StraSingeAff {
    @Override
    public void seDeplacer(Singe singe,ZoneDeJeu zoneDeJeu, int a, int b) {
        String[][] matrice = zoneDeJeu.getMatrice();
        boolean k=true;
        Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
                new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1),

        };

        //s'il voit un cocotier
        if (k){
            for (int i=0; i<voisins.length; i++) {
                int x=voisins[i].getValue0() + singe.getX();
                int y=voisins[i].getValue1() + singe.getY();
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Cocotier().getCar()) {
                    matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
                    for (int j=0; j < voisins.length; j++) {
                        int v=voisins[j].getValue0() + x;
                        int w=voisins[j].getValue1() + y;
                        if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==" "){
                            //singe.setEtat(new EcureuilPerche(singe));
                            matrice[v][w]=singe.getCar();
                            singe.setPosition(v, w);
                            k=false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        //s'il voit un buisson
        else if (k){
            for (int i=0; i<voisins.length; i++) {
                int x=voisins[i].getValue0() + singe.getX();
                int y=voisins[i].getValue1() + singe.getY();
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Buisson().getCar()) {
                    matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
                    for (int j=0; j < voisins.length; j++) {
                        int v=voisins[j].getValue0() + x;
                        int w=voisins[j].getValue1() + y;
                        if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==" "){
                            //singe.setEtat(new EcureuilPerche(singe));
                            matrice[v][w]=singe.getCar();
                            singe.setPosition(v, w);
                            k=false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        //courir sens opposé
        else{
            if (a<singe.getX() && singe.getX()+1< zoneDeJeu.ligne && matrice[singe.getX()+1][singe.getY()]==" ") {
                matrice[singe.getX()][singe.getY()]=" ";
                matrice[singe.getX()+1][singe.getY()]=singe.getCar();
            }
            else if (b<singe.getY() && singe.getY()+1< zoneDeJeu.colonne && matrice[singe.getX()][singe.getY()+1]==" ") {
                matrice[singe.getX()][singe.getY()]=" ";
                matrice[singe.getX()][singe.getY()+1]=singe.getCar();
            }
            else if (a>singe.getX() && singe.getX()-1>=0 && matrice[singe.getX()-1][singe.getY()]==" ") {
                matrice[singe.getX()][singe.getY()]=" ";
                matrice[singe.getX()-1][singe.getY()]=singe.getCar();
            }
            else if (b>singe.getY() && singe.getY()-1 >=0 && matrice[singe.getX()][singe.getY()-1]==" ") {
                matrice[singe.getX()][singe.getY()]=" ";
                matrice[singe.getX()][singe.getY()-1]=singe.getCar();
            }
        }
        zoneDeJeu.setMatrice(matrice);
    }
}
