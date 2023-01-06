package Modele;

class EcureuilAmi extends EtatEcureuil {

    private Personnage personnage;
    public EcureuilAmi(Ecureuil ecureuil) {
        super(ecureuil);
        car = Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_PURPLE + "E" + Colors.ANSI_RESET;
    }

    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {
        //todo
    }


}
