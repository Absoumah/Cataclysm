package Modele;

import org.javatuples.Pair;

class EcureuilRassasie extends EtatEcureuil {

    private Pair<Integer, Integer>[] voisins=new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
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

    public EcureuilRassasie(Ecureuil ecureuil) {
        super(ecureuil);
        car = Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_BLUE + "E" + Colors.ANSI_RESET;
    }

    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        tour+=1;
        String[][] matrice=zoneDeJeu.getMatrice();
        if (tour==5){
            tour=0;
            ecureuil.setEtat(new EcureuilAffame(ecureuil));
        }
        boolean k=true;
        for (int c=0; c<voisins.length; c++) {
            int a=voisins[c].getValue0() + ecureuil.getX();
            int b=voisins[c].getValue1() + ecureuil.getY();
            //voir danger
            if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() &&
                    matrice[a][b] == Colors.ANSI_YELLOW_BACKGROUND+ Colors.ANSI_BLACK + "R" + Colors.ANSI_RESET) {
                //ami et à proximité
                for (int i=0; i<voisins.length; i++) {
                    int x=voisins[i].getValue0() + ecureuil.getX();
                    int y=voisins[i].getValue1() + ecureuil.getY();
                    if (ecureuil.personnage!=null){
                        if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == ecureuil.personnage.getCar()) {
                            for (int j=0; j < voisins.length; j++) {
                                int v=voisins[j].getValue0() + x;
                                int w=voisins[j].getValue1() + y;
                                if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==new ZoneVide().getCar()){
                                    matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
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
                if (k){
                    //voir arbre
                    for (int i=0; i < voisins.length; i++) {
                        int x=voisins[i].getValue0() + ecureuil.getX();
                        int y=voisins[i].getValue1() + ecureuil.getY();
                        //voir arbre
                        if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Arbre().getCar()) {
                            matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                            for (int j=0; j < voisins.length; j++) {
                                int v=voisins[j].getValue0() + x;
                                int w=voisins[j].getValue1() + y;
                                if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==new ZoneVide().getCar()){
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
                if (k){
                    //voir buisson
                    for (int i=0; i < voisins.length; i++) {
                        int x=voisins[i].getValue0() + ecureuil.getX();
                        int y=voisins[i].getValue1() + ecureuil.getY();
                        //voir buisson
                        if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Buisson().getCar()) {
                            matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                            for (int j=0; j < voisins.length; j++) {
                                int v=voisins[j].getValue0() + x;
                                int w=voisins[j].getValue1() + y;
                                if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==new ZoneVide().getCar()){
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
                //courir sens inverse
                if(k) {
                    if (a<ecureuil.getX() && ecureuil.getX()+1< zoneDeJeu.ligne && matrice[ecureuil.getX()+1][ecureuil.getY()]==new ZoneVide().getCar()) {
                        matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                        matrice[ecureuil.getX()+1][ecureuil.getY()]=ecureuil.getCar();
                        k=false;
                    }
                    else if (b<ecureuil.getY() && ecureuil.getY()+1< zoneDeJeu.colonne && matrice[ecureuil.getX()][ecureuil.getY()+1]==new ZoneVide().getCar()) {
                        matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                        matrice[ecureuil.getX()][ecureuil.getY()+1]=ecureuil.getCar();
                        k=false;
                    }
                    else if (a>ecureuil.getX() && ecureuil.getX()-1>=0 && matrice[ecureuil.getX()-1][ecureuil.getY()]==new ZoneVide().getCar()) {
                        matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                        matrice[ecureuil.getX()-1][ecureuil.getY()]=ecureuil.getCar();
                        k=false;
                    }
                    else if (b>ecureuil.getY() && ecureuil.getY()-1 >=0 && matrice[ecureuil.getX()][ecureuil.getY()-1]==new ZoneVide().getCar()) {
                        matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                        matrice[ecureuil.getX()][ecureuil.getY()-1]=ecureuil.getCar();
                        k=false;
                    }
                }
                break;
            }
        }
        //par défaut
        if (k){
            for (int i=0; i < voisins.length; i++) {
                int x=voisins[i].getValue0() + ecureuil.getX();
                int y=voisins[i].getValue1() + ecureuil.getY();
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new ZoneVide().getCar()) {
                    matrice[ecureuil.getX()][ecureuil.getY()]=new ZoneVide().getCar();
                    matrice[x][y]=car;
                    ecureuil.setPosition(x,y);
                    break;
                }
            }
        }
        zoneDeJeu.setMatrice(matrice);
    }


}
