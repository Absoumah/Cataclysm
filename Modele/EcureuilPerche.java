package Modele;

class EcureuilPerche extends EtatEcureuil {

    public EcureuilPerche(Ecureuil ecureuil) {
        super(ecureuil);
        car = Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_GREEN + "E" + Colors.ANSI_RESET;
    }

    @Override
   public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        String[][] matrice = zoneDeJeu.getMatrice();
        //matrice[ecureuil.getX()][ecureuil.getX()]=car;
        zoneDeJeu.setMatrice(matrice);
    }


}
