package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class DepGauche implements Icommande {
  @Override
  public void execute(ZoneDeJeu zoneDeJeu) {
    personnage.gauche(zoneDeJeu);
  }

  @Override
  public void undo(ZoneDeJeu zoneDeJeu) {

  }

  private Personnage personnage = Personnage.getInstance();

}
