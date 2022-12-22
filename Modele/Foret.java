package Modele;

import Modele.*;

class Foret implements ZoneDeJeu {

  private Personnage personnage;
  public Plante creerBuisson() {
    return new Buisson();
  }

  public Aliment creerChampignon() {
    return new Champignon();
  }

  public ZoneVide creerZoneVide() {
    return new ZoneVide();
  }

  @Override
  public Personnage creerPersonnage() {
    return new Personnage();
  }

  @Override
  public Animal creerAnimal() {
    return new Ecureuil();
  }

  @Override
  public Aliment creerAliment() {
    return new Gland();
  }

  @Override
  public Plante creerPlante() {
    return new Arbre();
  }

  @Override
  public AnimalDanger creerAnimalDanger() {
    return new Renard();
  }

  @Override
  public AlimentDanger creerAlimentDanger() {
    return new ChampignonVeni();
  }

}
