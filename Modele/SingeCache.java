package Modele;

public class SingeCache extends EtatSinge{
    public SingeCache(Singe singe) {
        super(singe);
        car = Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_PURPLE + "M" + Colors.ANSI_RESET;
    }

    @Override
    public void seDeplacer(ZoneDeJeu zoneDeJeu) {

    }
}
