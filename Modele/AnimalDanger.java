package Modele;

abstract class AnimalDanger {

    protected String car;
    protected int vie;

    protected int x ;

    protected int y;

    public AnimalDanger(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }

    abstract void seDeplacer(ZoneDeJeu zoneDeJeu);


    public String getCar() {
        return car;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
