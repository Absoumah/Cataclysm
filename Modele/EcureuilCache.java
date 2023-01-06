package Modele;

class EcureuilCache extends EtatEcureuil {

    public EcureuilCache(Ecureuil ecureuil) {
        super(ecureuil);
        car = Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_YELLOW + "E" + Colors.ANSI_RESET;
    }

    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {

    }


}
