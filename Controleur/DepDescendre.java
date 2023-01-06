package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class DepDescendre implements Icommande{

    private Personnage personnage = Personnage.getInstance();
    @Override
    public void execute(ZoneDeJeu zoneDeJeu) {
        personnage.descendre(zoneDeJeu);
    }

    @Override
    public void undo(ZoneDeJeu zoneDeJeu) {

    }

}
