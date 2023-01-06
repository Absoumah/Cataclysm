package Modele;

import org.javatuples.Pair;

class VoirDanger implements StraEcAffame {
    @Override
    public void seDeplacer(Ecureuil ecureuil,ZoneDeJeu zoneDeJeu, int a, int b) {
        String[][] matrice = zoneDeJeu.getMatrice();
        boolean k=true;
        Pair<Integer,Integer>[] voisins =new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
                new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1),

                };


        //si vous êtes amis et à proximité
        for (int i=0; i<voisins.length; i++) {
            int x=voisins[i].getValue0() + ecureuil.getX();
            int y=voisins[i].getValue1() + ecureuil.getY();
            if (ecureuil.personnage!=null){
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == ecureuil.personnage.getCar()) {
                    matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                    for (int j=0; j < voisins.length; j++) {
                        int v=voisins[j].getValue0() + x;
                        int w=voisins[j].getValue1() + y;
                        if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==" "){
                            ecureuil.setEtat(new EcureuilPerche(ecureuil));
                            matrice[v][w]=ecureuil.getCar();
                            ecureuil.setPosition(v, w);
                            k=false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        //s'il voit un arbre
        if (k){
            for (int i=0; i<voisins.length; i++) {
                int x=voisins[i].getValue0() + ecureuil.getX();
                int y=voisins[i].getValue1() + ecureuil.getY();
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Arbre().getCar()) {
                    matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                    for (int j=0; j < voisins.length; j++) {
                        int v=voisins[j].getValue0() + x;
                        int w=voisins[j].getValue1() + y;
                        if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==" "){
                            ecureuil.setEtat(new EcureuilPerche(ecureuil));
                            matrice[v][w]=ecureuil.getCar();
                            ecureuil.setPosition(v, w);
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
                int x=voisins[i].getValue0() + ecureuil.getX();
                int y=voisins[i].getValue1() + ecureuil.getY();
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Buisson().getCar()) {
                    matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                    for (int j=0; j < voisins.length; j++) {
                        int v=voisins[j].getValue0() + x;
                        int w=voisins[j].getValue1() + y;
                        if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==" "){
                            ecureuil.setEtat(new EcureuilPerche(ecureuil));
                            matrice[v][w]=ecureuil.getCar();
                            ecureuil.setPosition(v, w);
                            k=false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        // todo courir sens opposé
        if (a<ecureuil.getX() && ecureuil.getX()+1< zoneDeJeu.ligne && matrice[ecureuil.getX()+1][ecureuil.getY()]==" ") {
            matrice[ecureuil.getX()][ecureuil.getY()]=" ";
            matrice[ecureuil.getX()+1][ecureuil.getY()]=ecureuil.getCar();
        }
        else if (b<ecureuil.getY() && ecureuil.getY()+1< zoneDeJeu.colonne && matrice[ecureuil.getX()][ecureuil.getY()+1]==" ") {
            matrice[ecureuil.getX()][ecureuil.getY()]=" ";
            matrice[ecureuil.getX()][ecureuil.getY()+1]=ecureuil.getCar();
        }
        else if (a>ecureuil.getX() && ecureuil.getX()-1>=0 && matrice[ecureuil.getX()-1][ecureuil.getY()]==" ") {
            matrice[ecureuil.getX()][ecureuil.getY()]=" ";
            matrice[ecureuil.getX()-1][ecureuil.getY()]=ecureuil.getCar();
        }
        else if (b>ecureuil.getY() && ecureuil.getY()-1 >=0 && matrice[ecureuil.getX()][ecureuil.getY()-1]==" ") {
            matrice[ecureuil.getX()][ecureuil.getY()]=" ";
            matrice[ecureuil.getX()][ecureuil.getY()-1]=ecureuil.getCar();
        }
        zoneDeJeu.setMatrice(matrice);
    }
}

