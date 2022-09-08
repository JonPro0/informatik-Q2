package trees;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TiereRaten extends BinBaum{
    Scanner eingabe = new Scanner(System.in);
    Frage wurzel;

    public TiereRaten() {
        generateTree();

        wurzel = new Frage("Ist es ein Saeugetier?");
        wurzel.ja = new Frage("Loewe");
        wurzel.nein =new Frage( "Papagei");
    }

    private void generateTree() {
        String [] strArray =  readMyFile().split("/");
        System.out.println(strArray[0]);
        for (String a :
                strArray) {
            System.out.println(a);
        }
    }

    private String readMyFile() {
        char[] array = new char[850];
        try {
            // Creates a reader using the FileReader
            FileReader input = new FileReader("baum.txt");

            // Reads characters
            input.read(array);
            System.out.println("Data in the file: ");

            // Closes the reader
            input.close();
            StringBuilder output = new StringBuilder();
            for (char c : array) {
                if (c >= 32 && c <= 125) {
                    output.append("").append(c);
                }
            }
            return output.toString();
        }

        catch(Exception e) {
            e.getStackTrace();
        }
        return "";
    }

    public void spiele() {
        System.out.println("Willkommen beim Expertensystem");
        Frage runner = wurzel;
        boolean toInsert = false;

        // Schleife
        while(runner != null) {
            if (runner.istTier()){
                System.out.println("Ist es ein(e) " + runner.inhalt + "  ja/nein");
            } else {
                System.out.println(runner.inhalt + "  ja/nein");
            }
            String antwort = eingabe.nextLine();
            if (antwort.equalsIgnoreCase("ja") && runner.ja != null) {
                runner = runner.ja;
            } else if (antwort.equalsIgnoreCase("ja")){
                System.out.println("Dein Tier ist: " + runner.inhalt);
                break;
            } else if (antwort.equalsIgnoreCase("nein") && runner.nein != null){
                runner = runner.nein;
            } else  if (antwort.equalsIgnoreCase("nein")){
                 toInsert = true;

                 break;
            } else {
                System.out.println("Die Antwort: " + antwort + "ist keine zulässige Antwort, bitte nur ja oder nein antworten");
            }
        }

        if(toInsert) {
            String tmp = runner.inhalt;
            runner.inhalt = frageNachKategorie(runner);
            runner.nein = new Frage(tmp);
            runner.ja = new Frage(frageNachTier());
            spiele();
        }

    }



    private String frageNachTier() {
        System.out.println("An welches Tier hast du gedacht?");
        return eingabe.nextLine();
    }

    private String frageNachKategorie(Frage cat) {
        System.out.println("Welche Frage hilft mir, um dein Tier zu erraten und dein  \n Tier von " + cat.inhalt + " zu unterscheiden");
        return eingabe.nextLine();
    }

    public static void main(String[] args) throws IOException {
        TiereRaten tr = new TiereRaten();
        tr.spiele();
        File datei = new File("baum.txt");
        FileWriter schreiber = new FileWriter(datei);
        schreiber.write(tr.wurzel.toString());
        schreiber.close();
    }
}

class Frage {
    String inhalt;
    Frage ja, nein;

    public Frage(String inhalt) {
        this.inhalt = inhalt;
    }

    public String toString() {
        // 1. Gib die aktuelle Zahl aus
        String output = "" + inhalt;

        // 2. Wenn links ein Knoten ist, gib ihn aus
        if (ja != null) {
            output += "/[" + ja.toString() + "]";
        }

        // 2. Wenn rechts ein Knoten ist, gib ihn aus
        if (nein != null) {
            output += "/<" + nein.toString() + ">";
        }

        return output;
    }
    public boolean istTier() {
        return ja == null;
    }
}