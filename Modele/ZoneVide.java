package Modele;

import Modele.Plante;

public class ZoneVide extends Plante {
    public ZoneVide() {
        super();
        car = Colors.ANSI_GREEN_BACKGROUND+ Colors.ANSI_VIDE+Colors.ANSI_RESET;
    }
}
