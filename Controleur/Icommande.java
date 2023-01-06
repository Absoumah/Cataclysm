package Controleur;

import Modele.ZoneDeJeu;

public interface Icommande {
  void execute(ZoneDeJeu zoneDeJeu) ;
  void undo(ZoneDeJeu zoneDeJeu);

}
