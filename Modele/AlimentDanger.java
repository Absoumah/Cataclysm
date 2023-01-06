package Modele;

abstract class AlimentDanger {

  protected int ligne;
  protected int colonne;

  protected String car;

  public int getLigne() {
    return ligne;
  }

  public int getColonne() {
    return colonne;
  }

  public String getCar() {
    return car;
  }
}
