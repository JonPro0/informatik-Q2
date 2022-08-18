package trees;

public class BinBaum {
    Knoten wurzel;
    Knoten wurzel2;

    public BinBaum() {
        // Top-down
//        wurzel = new Knoten(5);
//        wurzel.links = new Knoten(8, new Knoten(18), new Knoten(3));
//        wurzel.rechts = new Knoten(6);
//        wurzel.rechts.links = new Knoten(36);
//        wurzel.rechts.rechts = new Knoten(4, null, new Knoten(12));
//
//        System.out.println(wurzel.gibAus());

        // Bottom-Up
        Knoten t4 = new Knoten(4, null, new Knoten(12));
        Knoten t8 = new Knoten(8, new Knoten(18), new Knoten(3));
        Knoten t6 = new Knoten(6, new Knoten(36), t4);
        wurzel = new Knoten(5, t8, t6);


    }

    public Knoten suche(Integer gesucht){
        return wurzel.suche(gesucht);
    }

    public void einfuegen(int data) {
        Knoten newKnoten = new Knoten(data);
        Knoten runner = wurzel;
        boolean toInsert = true;

        while (toInsert) {
            // Sind die Daten größer als runner.data?
            // Fehler, weil Datentyp "T" kein ">" kann!
            if (runner.data < data) {
                if(runner.rechts == null){
                    runner.rechts = newKnoten;
                    toInsert = false;
                } else {
                    runner = runner.rechts;
                }
            }
            if (runner.data > data){
                if (runner.links == null) {
                    runner.links = newKnoten;
                    toInsert = false;
                }
                else runner = runner.links;
            }
        }

    }

    public static void main(String[] args) {
        BinBaum bb = new BinBaum();
        System.out.println(bb.suche(5));
        System.out.println(bb.suche(6));
        System.out.println(bb.suche(0));
        System.out.println(bb.suche(36));
        System.out.println(bb.suche(12));
    }
}

