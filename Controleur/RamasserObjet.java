package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class RamasserObjet implements Icommande {

  private Personnage personnage = Personnage.getInstance();
  @Override
  public void execute(ZoneDeJeu zoneDeJeu) {
    personnage.ramasserObjet(zoneDeJeu);

  }

  @Override
  public void undo(ZoneDeJeu zoneDeJeu) {
    personnage.reposerObjet(zoneDeJeu);

  }



}
