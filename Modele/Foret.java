package Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Foret extends ZoneDeJeu {

  public Foret(BufferedReader buffer, int ligne, int colonne) throws IOException {
    matrice=new String[ligne][colonne];
    this.ligne=ligne;
    this.colonne=colonne;
    String line;
    int l=0;
    while( (line = buffer.readLine()) != null)
    {
      for (int i=0; i<line.length(); i++){
        char c = line.charAt(i);
        switch (c){
          case '@':
            Personnage personnage = creerPersonnage();
            personnage.setPosition(l,i);
            matrice[l][i]=personnage.getCar();
            break;
          case 'A':
            matrice[l][i]=(creerPlante().getCar());
            break;
          case 'B':
            matrice[l][i]=(creerBuisson().getCar());
            break;
          case 'C':
            matrice[l][i]=(creerChampignon().getCar());;
            break;
          case 'E':
            Animal a = creerAnimal(l,i);
            lesAnimaux.add(a);
            matrice[l][i]=a.getCar();
            break;
          case 'G':
            matrice[l][i]=(creerAliment().getCar());
            break;
          case 'M':
            matrice[l][i]=creerAlimentDanger().getCar();
            break;
          case 'R':
            AnimalDanger r = creerAnimalDanger(l,i);
            lesAnimauxDanger.add(r);
            matrice[l][i]=r.getCar();
            break;
          case ' ':
            matrice[l][i]=creerZoneVide().car;
            break;
          default:
            matrice[l][i]=creerZoneVide().car;
            break;
        }
      }
      l+=1;
    }

  }

  @Override
  public Animal creerAnimal(int x, int y) {
    return new Ecureuil(x,y);
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
  public AnimalDanger creerAnimalDanger(int x, int y) {
    return new Renard(x,y);
  }

  @Override
  public AlimentDanger creerAlimentDanger() {
    return new ChampignonVeni();
  }

}
