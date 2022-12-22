package Controleur;

import Modele.Gland;
import Modele.Personnage;
import Vue.Icommande;

class RamasserObjet implements Icommande {

  private Personnage personnage;
  @Override
  public void execute() {
    personnage.reposerObjet(new Gland());

  }

  @Override
  public void undo() {
    personnage.reposerObjet(new Gland());

  }



}
