package paaohjelma;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto olutta = new Varasto(100.0, 20.2);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(1000.0);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutvarasto: " + olutta);
    }
}
