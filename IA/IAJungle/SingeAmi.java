package Modele;

import org.javatuples.Pair;

class SingeAmi extends EtatSinge {

    private Pair<Integer, Integer>[] presDuPersonnage=new Pair[]{new Pair(0,1),new Pair(1,0), new Pair(-1,0), new Pair(0,-1),
            new Pair(-1,1), new Pair(1,-1), new Pair<>(-1,1), new Pair<>(1,1),

            new Pair(1,2),new Pair(2,1), new Pair(-2,1), new Pair(1,-2),
            new Pair(-1,2), new Pair(2,-1), new Pair<>(-1,-2), new Pair<>(-2,-1),

            new Pair(0,2),new Pair(2,0), new Pair(-2,0), new Pair(0,-2),
            new Pair(-2,2), new Pair(2,-2), new Pair<>(-2,-2), new Pair<>(2,2)};

    public SingeAmi(Singe singe) {
        super(singe);
        car = Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_BLUE + "M" + Colors.ANSI_RESET;
    }

    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        if (tour ==2){
            tour=0;
            singe.setEtat(new SingeAffame(singe));
        }
        String[][] matrice =zoneDeJeu.getMatrice();
        Personnage p = singe.getPersonnage();
        for (int i=0; i<presDuPersonnage.length; i++) {
            int x=presDuPersonnage[i].getValue0() + p.getX();
            int y=presDuPersonnage[i].getValue1() + p.getY();
            if (x< zoneDeJeu.ligne && x >=0 && y< zoneDeJeu.colonne && y>=0 && matrice[x][y]==Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET) {
                matrice[x][y]=singe.getCar();
                matrice[singe.getX()][singe.getY()]=Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET;
                break;
            }
        }


    }
}
