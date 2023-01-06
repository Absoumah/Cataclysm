package Modele;

public abstract class Animal {

  protected String car;
  protected int vie;

  protected int x ;
  protected int y;

  public Animal(int x, int y) {
    this.x=x;
    this.y=y;
  }

  void setPosition(int x, int y){
    this.x=x;
    this.y=y;
  }

  public String getCar() {
    return car;
  }

  public int getVie() {
    return vie;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  abstract void seDeplacer(ZoneDeJeu zoneDeJeu);



}
