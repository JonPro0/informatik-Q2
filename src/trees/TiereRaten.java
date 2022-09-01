package trees;

public class TiereRaten {
    Frage wurzel;
}

class Frage{
    String inhalt;
    Frage ja, nein;

    public Frage(String inhalt){
        this.inhalt = inhalt;
    }
}
