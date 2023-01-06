package Modele;

import Modele.AlimentDanger;

class ChampignonHallu extends AlimentDanger {
    public ChampignonHallu() {
        super();
        car= Colors.ANSI_RED_BACKGROUND + Colors.ANSI_WHITE + "C" + Colors.ANSI_RESET;
    }
}
