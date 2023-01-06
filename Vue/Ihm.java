package Vue;

import Controleur.*;

import java.util.Scanner;

public class Ihm {


  /*
  todo Strategie faire peur de renard
  todo supprimer les animaux tués
  todo voir les boucles while(true)
  todo revoir strategie renard quand un arbre à côté.
  todo donner banane au singe
  */
  public String afficherMenu() {
    System.out.println("Que voulez-vous faire ?");
    System.out.println("1- Aller à droite");
    System.out.println("2- Aller à gauche");
    System.out.println("3- Monter");
    System.out.println("4- Descendre");
    System.out.println("5- Se battre ");
    System.out.println("6- Ramasser un objet ");
    System.out.println("7- Reposer un objet ");
    System.out.println("8- Reposer son animal ");
    System.out.println("0- Quitter la partie ");
    Scanner sc=new Scanner(System.in);
    String choix=sc.nextLine();
    return choix;
  }

  public void print(String s) {
    System.out.print(s);
  }

  public void printLine(){
    System.out.println();
  }
}
