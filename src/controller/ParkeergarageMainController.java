package controller;

import java.util.Scanner;

/* Dit is een applicatie die de parkeerkosten berekent in een parkeergarage.
Na het invoeren van auto’s die geparkeerd hebben, bepaalt de applicatie de
parkeerkosten voor elke auto en de totale parkeerkosten voor alle auto’s die
hebben geparkeerd. Danny Kwant */
public class ParkeergarageMainController {

    public static void main(String[] args) {

        // local variabelen
        int aantalGeparkeerdeAutos;
        String ingevoerdeKenteken;
        int ingevoerdeUren;
        double parkeerKosten;
        double totaalParkeerGelden;
        final int MAXIMUM_TE_PARKEREN_UREN = 24;
        Scanner userInput;

        // scanner init
        userInput = new Scanner(System.in);

        System.out.println("Dit programma is gemaakt door Danny Kwant, 500955184\n");

        // haal invoer op van gebruiker hoeveel auto's er geparkeerd hebben
        // als de gekozen invoer 0 is, stel de vraag opnieuw om een geldige invoer op te geven
        do {
            System.out.print("Hoeveel auto's hebben geparkeerd in de parkeergarage? ");
            aantalGeparkeerdeAutos = userInput.nextInt();
            userInput.nextLine(); // clear buffer

            if (aantalGeparkeerdeAutos < 1) {
                System.out.println("Geen geldige input. Probeer het opnieuw. ");
            }

        } while (aantalGeparkeerdeAutos < 1);

        // init rijen waarin we alle gebruikersgegevens opslaan
        String[] rijKenteken = new String[aantalGeparkeerdeAutos];
        int[] rijParkeerDuur = new int[aantalGeparkeerdeAutos];
        double[] rijParkeerKosten = new double[aantalGeparkeerdeAutos];

        // herhaaldelijk vragen naar kentekens en parkeerduren om alle indexen voor rijKenteken en rijParkeerDuur helemaal te vullen
        for (int i = 0; i < aantalGeparkeerdeAutos; i++) {

            System.out.printf("%s %d %n", "Auto", i + 1);
            System.out.printf("%14s", "Kenteken: ");
            ingevoerdeKenteken = userInput.next();
            rijKenteken[i] = ingevoerdeKenteken;

            // Als ingevoerdeUren groter is dan maximum te parkeren uren, stel de vraag opnieuw om een geldige invoer te verkrijgen
            do {

                System.out.printf("%32s", "Geparkeerde uren (max. 24): ");
                ingevoerdeUren = userInput.nextInt();
                userInput.nextLine(); // clear buffer

                if (ingevoerdeUren > MAXIMUM_TE_PARKEREN_UREN) {
                    System.out.printf("%44s%n", "De parkeerduur kan maximaal 24 uur zijn.");
                }


            } while (ingevoerdeUren > MAXIMUM_TE_PARKEREN_UREN);


            rijParkeerDuur[i] = ingevoerdeUren;

            // Bereken de parkeerkosten op basis van de parkeerduur dmv methode berekenParkeergeld en sla het resultaat op in rijParkeerKosten[i]
            parkeerKosten = berekenParkeergeld(ingevoerdeUren);
            rijParkeerKosten[i] = parkeerKosten;

        }// for

        System.out.print("\n\nParkeerkosten\n");

        // Print headers voor de gegevens uit de rijen die daaronder komen
        System.out.printf("%s%8s%12s%n", "Kenteken", "Uren", "Bedrag");

        // print overzicht van alle gegevens in de rijen
        for (int i = 0; i < aantalGeparkeerdeAutos; i++) {
            System.out.printf("%s%8d%12.02f%n", rijKenteken[i], rijParkeerDuur[i], rijParkeerKosten[i]);
        }

        System.out.println();

        // Bereken totaal aantal aan parkeergelden mbv methode en print dat op de volgende regel
        totaalParkeerGelden = berekenTotaleParkeerKosten(rijParkeerKosten);
        System.out.printf("Totaal van alle parkeergelden is: %.2f euro.", totaalParkeerGelden);

    }//main

    // public methoden

    // Bereken per auto de parkeerkosten op basis van de ingevoerde parkeerduur
    public static double berekenParkeergeld(int mpParkeerduur) {
        double parkeerKosten = 0;
        final double START_TARIEF = 3.75;
        final double REGULIER_TARIEF = 2.75;
        final double DAG_TARIEF = 25.0;
        final int START_TARIEF_UREN = 3;

        if (mpParkeerduur <= START_TARIEF_UREN) {
            parkeerKosten = mpParkeerduur * START_TARIEF;

        } else {
            parkeerKosten = (START_TARIEF_UREN * START_TARIEF) + ((mpParkeerduur - START_TARIEF_UREN) * REGULIER_TARIEF);
        }

        if (parkeerKosten > DAG_TARIEF) {
            parkeerKosten = DAG_TARIEF;
        }

        return parkeerKosten;
    }

    // Bereken het totaal van alle parkeergelden door de parkeerkosten van alle auto’s bij elkaar op te tellen
    public static double berekenTotaleParkeerKosten(double[] mpParkeerKosten) {
        double totaalParkeerGelden = 0;

        for (int i = 0; i < mpParkeerKosten.length; i++) {
            totaalParkeerGelden += mpParkeerKosten[i];
        }

        return totaalParkeerGelden;
    }

}//class
