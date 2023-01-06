package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class DepDroite implements Icommande{

    private Personnage personnage = Personnage.getInstance();
    @Override
    public void execute(ZoneDeJeu zoneDeJeu) {
        personnage.droite(zoneDeJeu);
    }

    @Override
    public void undo(ZoneDeJeu zoneDeJeu) {

    }
}
