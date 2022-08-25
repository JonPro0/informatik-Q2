package trees;

public class TestBinBaum {
    /*
    * 1. Schreibe eine Methode Anzahl, die die Anzahl von Knoten im Baum zurückgibt
    *
    * */
    public static void main(String[] args) {
        BinSuchBaum bsb = new BinSuchBaum("5 9 32 2 6 8 7 4");

        System.out.println(bsb);
        System.out.println(bsb.tiefe());
    }
}
