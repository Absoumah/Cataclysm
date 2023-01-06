package Modele;

public class Ecureuil extends Animal {

  protected Personnage personnage=null;

  private EtatEcureuil etat;

  public Ecureuil(int x, int y) {
    super(x,y);
    etat = new EcureuilAffame(this);
    car=etat.car;
  }

  @Override
  void seDeplacer(ZoneDeJeu zoneDeJeu) {
    etat.seDeplacer(zoneDeJeu);
  }

  public void setEtat(EtatEcureuil etat) {
    this.etat=etat;
    car=etat.car;
  }

  public EtatEcureuil getEtat() {
    return etat;
  }


  public void setPeronnage(Personnage personnage) {
    this.personnage=personnage;
  }
}
