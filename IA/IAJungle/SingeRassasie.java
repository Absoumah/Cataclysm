package Modele;

import org.javatuples.Pair;

import java.util.Random;

class SingeRassasie extends EtatSinge {

    private Pair<Integer, Integer>[] voirDanger=new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
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

    public SingeRassasie(Singe singe) {
        super(singe);
        car = Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_GREEN + "M" + Colors.ANSI_RESET;

    }

    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        tour+=1;
        String[][] matrice=zoneDeJeu.getMatrice();
        if (tour==3){
            tour=0;
            singe.setEtat(new SingeAffame(singe));
        }
        boolean k=true;
        for (int c=0; c<voirDanger.length; c++) {
            int a=voirDanger[c].getValue0() + singe.getX();
            int b=voirDanger[c].getValue1() + singe.getY();
            //voir cocotier
            if (a < zoneDeJeu.getLigne() && a>=0 && b>=0 && b < zoneDeJeu.getColonne() &&
                    matrice[a][b] == Colors.ANSI_RED_BACKGROUND+ Colors.ANSI_YELLOW+ "S" + Colors.ANSI_RESET) {
                for (int i=0; i < voisins.length; i++) {
                    int x=voisins[i].getValue0() + singe.getX();
                    int y=voisins[i].getValue1() + singe.getY();
                    if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Cocotier().getCar()) {
                        matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
                        for (int j=0; j < voisins.length; j++) {
                            int v=voisins[j].getValue0() + x;
                            int w=voisins[j].getValue1() + y;
                            if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET){
                                matrice[v][w]=singe.getCar();
                                singe.setPosition(v, w);
                                k=false;
                                break;
                            }
                        }
                        break;
                    }
                }
                //voir Buisson
                if (k){
                    for (int i=0; i < voisins.length; i++) {
                        int x=voisins[i].getValue0() + singe.getX();
                        int y=voisins[i].getValue1() + singe.getY();
                        if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == new Buisson().getCar()) {
                            matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
                            for (int j=0; j < voisins.length; j++) {
                                int v=voisins[j].getValue0() + x;
                                int w=voisins[j].getValue1() + y;
                                if (v < zoneDeJeu.getLigne() && v>=0 && w>=0 && w < zoneDeJeu.getColonne() && matrice[v][w]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET){
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
                //courir dans le sens inverse à revoir
                else{
                    if (a<singe.getX() && singe.getX()+1< zoneDeJeu.ligne && matrice[singe.getX()+1][singe.getY()]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                        matrice[singe.getX()][singe.getY()]=Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET;
                        matrice[singe.getX()+1][singe.getY()]=singe.getCar();
                    }
                    else if (b<singe.getY() && singe.getY()+1< zoneDeJeu.colonne && matrice[singe.getX()][singe.getY()+1]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                        matrice[singe.getX()][singe.getY()]=Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET;
                        matrice[singe.getX()][singe.getY()+1]=singe.getCar();
                    }
                    else if (a>singe.getX() && singe.getX()-1>=0 && matrice[singe.getX()-1][singe.getY()]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                        matrice[singe.getX()][singe.getY()]=Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET;
                        matrice[singe.getX()-1][singe.getY()]=singe.getCar();
                    }
                    else if (b>singe.getY() && singe.getY()-1 >=0 && matrice[singe.getX()][singe.getY()-1]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                        matrice[singe.getX()][singe.getY()]=Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET;
                        matrice[singe.getX()][singe.getY()-1]=singe.getCar();
                    }
                }
                break;
            }
        }
        //par défaut
        if (k){
            for (int i=0; i < voisins.length; i++) {
                int x=voisins[i].getValue0() + singe.getX();
                int y=voisins[i].getValue1() + singe.getY();
                if (x < zoneDeJeu.getLigne() && x>=0 && y>=0 && y < zoneDeJeu.getColonne() && matrice[x][y] == Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                    matrice[singe.getX()][singe.getY()]=new ZoneVide().getCar();
                    matrice[x][y]=car;
                    singe.setPosition(x,y);
                    zoneDeJeu.setMatrice(matrice);
                    break;
                }
            }
        }
    }

}
