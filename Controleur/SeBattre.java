package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class SeBattre implements Icommande {
  @Override
  public void execute(ZoneDeJeu zoneDeJeu) {
    personnage.seBattre(zoneDeJeu);

  }

  @Override
  public void undo(ZoneDeJeu zoneDeJeu) {

  }

  private Personnage personnage = Personnage.getInstance();

}
