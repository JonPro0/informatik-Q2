package trees;

public class BinBaum {
    protected Knoten wurzel;

    public BinBaum() {
        wurzel = null;
    }

    public Knoten suche(Integer gesucht) {
        return wurzel.suche(gesucht);
    }

    @Override
    public String toString() {
        if (wurzel == null) {
            return "Baum leer";
        } else {
            return wurzel.toString();
        }
    }

    public String toStringSortiert() {
        if (wurzel == null) {
            return "Baum leer";
        } else {
            return wurzel.toStringSortiert();
        }
    }

    public int tiefe() {
        return wurzel.tiefe();
    }

    public boolean ausgeglichen() {
        if (wurzel == null) {
            throw new NullPointerException("Baum leer");
        } else {
            return wurzel.ausgeglichen();
        }
    }

    public int anzahl() {
        return wurzel.anzahl();
    }
}
