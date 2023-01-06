package Modele;

public abstract class Aliment {
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

  public Aliment() {}
}
