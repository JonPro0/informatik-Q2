package tiere;

import java.util.Locale;
import java.util.Scanner;

public class TiereRaten {
    Scanner eingabe = new Scanner(System.in);
    Frage wurzel;

    public TiereRaten() {
        wurzel = new Frage("Ist es ein Säugetier?");
        wurzel.ja = new Frage("Loewe");
        wurzel.nein = new Frage("Papagei");
    }

    public void spiele() {
        System.out.println("Willkommen beim Expertensystem");
        boolean weiter = true;

        while (weiter) {
            spieleRunde();
            weiter = jaNeinFrage("Nochmal spielen?");
        }
    }

    public void spieleRunde() {
        Frage runner = wurzel;
        Frage pred = null;

        // Schleife
        while (runner != null) {
            if (runner.istTier()) {


                if (jaNeinFrage("Ist es ein(e) " + runner.inhalt + "? ")) {
                    System.out.println("Hurrah, ich habe das Tier geraten und damit gewonnen!");
                } else {
                    System.out.println("Oh je, ich bin am Ende meines Lateins. Welches Tier hast Du Dir gedacht? ");
                    String neuesTierStr = eingabe.nextLine();
                    System.out.println("Stelle eine Frage, um altes Tier und neues Tier zu unterscheiden, und für die" +
                            " ja die Antwort für neues Tier ist. ");
                    String neueFrageStr = eingabe.nextLine();

                    // Vorsicht!
                    Frage neueFrage = new Frage(neueFrageStr);
                    pred.nein = neueFrage;

                    // Setze neuesTier auf linke Antwort
                    neueFrage.ja = new Frage(neuesTierStr);

                    // Setze altesTier auf rechte Antwort
                    neueFrage.nein = runner;
                    runner = null;
                }
            } else {

                boolean tmp = jaNeinFrage(runner.inhalt);

                pred = runner;
                if (tmp) {
                    runner = runner.ja;
                } else {
                    runner = runner.nein;
                }
            }
        }
    }

    private boolean jaNeinFrage(String prompt) {
        System.out.print(prompt + " (j/n)?");
        return eingabe.nextLine().toLowerCase(Locale.ROOT).startsWith("j");
    }

    public static void main(String[] args) {
        TiereRaten tr = new TiereRaten();
        tr.spiele();
    }
}

class Frage {
    String inhalt;
    Frage ja, nein;

    public Frage(String inhalt) {
        this.inhalt = inhalt;
    }

    public boolean istTier() {
        return ja == null; // && nein == null;
    }
}