package Controleur;

import Modele.Personnage;
import Modele.ZoneDeJeu;

public class ReposerAnimal implements Icommande {
  @Override
  public void execute(ZoneDeJeu zoneDeJeu) {
    personnage.reposerAnimal(zoneDeJeu);
  }

  @Override
  public void undo(ZoneDeJeu zoneDeJeu) {

  }

  private Personnage personnage = Personnage.getInstance();

}
