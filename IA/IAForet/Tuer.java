package Modele;

class Tuer implements StrategieRenard {
    @Override
    public void execute(String[][] matrice, int i, int j) {
        matrice[i][j]=new ZoneVide().getCar();
    }
}
