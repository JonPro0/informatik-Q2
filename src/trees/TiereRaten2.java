package trees;

import java.util.Scanner;

public class TiereRaten2 {
    Scanner eingabe = new Scanner(System.in);
    Frage2 wurzel;

    public TiereRaten2() {
        wurzel = new Frage2("Ist es ein Säugetier?");
        wurzel.ja = new Frage2("Loewe");
        wurzel.nein = new Frage2("Papagei");
    }

    public void spiele() {
        System.out.println("Willkommen beim Expertensystem");
        Frage2 runner = wurzel;

        // Schleife
        while (runner != null) {
            System.out.println(runner.inhalt + " ");
            boolean antwortJa = eingabe.nextLine().startsWith("j");

            if (runner.istTier()) {
                if (antwortJa) {
                    System.out.println("Hurrah, ich habe das Tier geraten und damit gewonnen!");
                } else {
                    System.out.println("Oh je, ich bin am Ende meines Lateins. Welches Tier hast Du Dir gedacht? ");
                    String neuesTier = eingabe.nextLine();
                    System.out.println("Stelle eine Frage, um altes Tier und neues Tier zu unterscheiden, und für die" +
                            " ja die Antwort für neues Tier ist. ");
                    String neueFrage = eingabe.nextLine();
                    System.out.println("Würg.");
                }
            } else {
                if (antwortJa) {
                    runner = runner.ja;
                } else {
                    runner = runner.nein;
                }
            }
        }
    }

    public static void main(String[] args) {
        TiereRaten2 tr = new TiereRaten2();
        tr.spiele();
    }
}

class Frage2 {
    String inhalt;
    Frage2 ja, nein;

    public Frage2(String inhalt) {
        this.inhalt = inhalt;
    }

    public boolean istTier() {
        return ja == null; // && nein == null;
    }
}