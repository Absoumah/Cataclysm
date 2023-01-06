package Modele;

class Singe extends Animal {

  private EtatSinge etat;

  private Personnage personnage = null;

  public Personnage getPersonnage() {
    return personnage;
  }

  public Singe(int x, int y) {
    super(x, y);
    etat=new Insouciant(this);
    car= etat.getCar();
  }

  @Override
  public void seDeplacer(ZoneDeJeu zoneDeJeu) {
    etat.seDeplacer(zoneDeJeu);

  }

  public void setEtat(EtatSinge etat) {
    this.etat=etat;
    car=etat.car;

  }

  public void setPeronnage(Personnage personnage) {
    this.personnage=personnage;
  }
}
