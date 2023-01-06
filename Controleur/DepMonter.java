package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class DepMonter implements Icommande{

    private Personnage personnage = Personnage.getInstance();
    @Override
    public void execute(ZoneDeJeu zoneDeJeu) {
        personnage.monter(zoneDeJeu);

    }

    @Override
    public void undo(ZoneDeJeu zoneDeJeu) {

    }
}
