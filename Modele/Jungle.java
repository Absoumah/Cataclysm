package Modele;

import Modele.*;

class Jungle implements ZoneDeJeu {

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
    return new Singe();
  }

  @Override
  public Aliment creerAliment() {
    return new Banane();
  }

  @Override
  public Plante creerPlante() {
    return new Cocotier();
  }

  @Override
  public AnimalDanger creerAnimalDanger() {
    return new Serpent();
  }

  @Override
  public AlimentDanger creerAlimentDanger() {
    return new ChampignonHallu();
  }


}
