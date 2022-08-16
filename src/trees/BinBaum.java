package trees;

public class BinBaum {
    Knoten<Integer> wurzel;
    Knoten<Integer> wurzel2;

    public BinBaum() {
        // Top-down
        wurzel = new Knoten<Integer>(5);
        wurzel.links = new Knoten<>(8, new Knoten<>(18), new Knoten<>(3));
        wurzel.rechts = new Knoten<>(6);
        wurzel.rechts.links = new Knoten<>(36);
        wurzel.rechts.rechts = new Knoten<>(4, null, new Knoten<>(12));

        System.out.println(wurzel.gibAus());

        // Bottom-Up
        Knoten t4 = new Knoten<>(4, null, new Knoten<>(12));
        Knoten t8 = new Knoten<>(8, new Knoten<>(18), new Knoten<>(3));
        Knoten t6 = new Knoten<>(6, new Knoten<>(36), t4);
        wurzel = new Knoten<>(5, t8, t6);

        Knoten t5 = new Knoten<>(55, new Knoten<>(33), new Knoten<>(44));
        Knoten t7 = new Knoten<>(7, null, t5);
        Knoten t3 = new Knoten<>(6,t5, null);
        Knoten t1 = new Knoten<>(1, t3, new Knoten<>(132));
        Knoten t2 = new Knoten<>(8, t1, null);
        wurzel2 = new Knoten<>(5, t2, new Knoten<>(3));

        System.out.println(wurzel2.gibAus());

    }

    public void einfuegen(int data) {
        Knoten<> newKnoten = new Knoten(data);
        Knoten<> runter = wurzel;
        
        while (true) {
            // Sind die Daten größer als runner.data? 
            // Fehler, weil Datentyp "T" kein ">" kann! 
            if (runner.data > data) {
                 if(runner.rechts == null){
                     runner.rechts = newKnoten;
                 } else {
                     runner = runner.rechts;
                 }
            }
            if (runner.data < data){
                if (runner.links == null) runner.links = newKnoten;
                else runner = runner.links;
            }
        }
        
        }

    public static void main(String[] args) {
        new BinBaum();
    }
}

class Knoten<T> {
    public Knoten<T> links;
    public Knoten<T> rechts;
    public T data;

    public Knoten(T data) {
        this.data = data;
    }

    public Knoten(T data, Knoten<T> links, Knoten<T> rechts) {
        this.data = data;
        this.links = links;
        this.rechts = rechts;
    }

    public String gibAus() {
        // 1. Gib die aktuelle Zahl aus
        String output = data.toString();

        // 2. Wenn links ein Knoten ist, gib ihn aus
        if (links != null) {
            output +=  "[" + links.gibAus() + "]" ;
        }

        // 2. Wenn rechts ein Knoten ist, gib ihn aus
        if (rechts != null) {
            output += "<" + rechts.gibAus() + ">";
        }

        return output;
    }



}
