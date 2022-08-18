package trees;

class Knoten {
    public Knoten links;
    public Knoten rechts;
    public int data;

    public Knoten(int data) {
        this.data = data;
    }

    public Knoten(int data, Knoten links, Knoten rechts) {
        this.data = data;
        this.links = links;
        this.rechts = rechts;
    }

    public Knoten suche(int gesucht){
        //Wenn der Knoten der gesucht ist, gibt er sich selbst zurück
        if (data == gesucht) {
            return this;
        }
        //Wenn nicht, dann frag linken TB nach dem gesuchten TB
        //Wenn linker TB einen Knoten zurückgibt, gib den Knoten zurück
        else if (links != null) {
            Knoten ergebnis = links.suche(gesucht);
            if (ergebnis != null){
                return ergebnis;
            } else if (rechts != null){
                return rechts.suche(gesucht);
            }
        }

        //Wenn nicht, dann frag rechten TB nach dem gesuchten TB
        //Wenn rechter TB einen Knoten zurückgibt, gib den Knoten zurück
        if (rechts != null) {
            return rechts.suche(gesucht);
        }

        return null;
    }

    public String toString() {
        // 1. Gib die aktuelle Zahl aus
        String output = "" + data;

        // 2. Wenn links ein Knoten ist, gib ihn aus
        if (links != null) {
            output += "[" + links.toString() + "]";
        }

        // 2. Wenn rechts ein Knoten ist, gib ihn aus
        if (rechts != null) {
            output += "<" + rechts.toString() + ">";
        }

        return output;
    }


}
