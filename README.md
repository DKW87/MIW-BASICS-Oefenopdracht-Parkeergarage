# Programming –Oefenopdrachten 1 - Parkeergarage

## Tip vooraf
Bij deze opdracht maak je gebruik van een scanner om invoer in te lezen. Als je na een getal een string inleest met nextLine(), levert dit echter een onverwacht resultaat op: de gebruiker krijgt niet de kans om een string in te voeren. Dit komt omdat na het lezen van een getal de \<Enter\> nog in de buffer blijft staan. Als je daarna een string probeert te lezen dan wordt de \<Enter\> gezien en daardoor een lege string ingelezen.

Dit probleem is te ondervangen door na het inlezen van een getal een nextLine() te doen om de buffer te legen. Dus stel dat de scanner invoer heet, dan voeg je na het inlezen van een getal het volgende statement toe: invoer.nextLine();

Overigens kun je bij het inlezen van een String waarin geen spaties zitten ook gebruik maken van de methode next().

## Inleiding
Het doel van deze opdracht is om een applicatie te schrijven die de parkeerkosten berekent in een parkeergarage. Na het invoeren van auto's die geparkeerd hebben, bepaalt de applicatie de parkeerkosten voor elke auto en de totale parkeerkosten voor alle auto's die hebben geparkeerd.

De parkeertarieven in de parkeergarage zijn als volgt:
Het tarief voor de eerste 3 uur is € 3,75 per uur. Voor de uren daarna is het tarief € 2,75 per uur. De maximale parkeerkosten bedragen € 25,--, dit is de prijs van een dagkaart.

## Beschrijving
Schrijf een applicatie die aan het doel van de opdracht voldoet. Doe dit als volgt.

0. Zet in block comments het doel van je programma en je naam en studentnummer.
1. Vraag de gebruiker om het aantal auto's dat heeft geparkeerd.
2. Maak drie arrays aan om de gegevens over auto's in op te slaan: één voor de kentekens, één voor de parkeerduur (in gehele uren) en één voor de parkeerkosten. Kies voor elke array het juiste datatype en zorg dat de arrays precies groot genoeg zijn om het door de gebruiker opgegeven aantal auto's in op te slaan.
3. Vraag de gebruiker per auto om het kenteken en de parkeerduur in gehele uren. Gebruik voor het inlezen van het kenteken de Scanner-methode next(). Sla de gegevens op in de hiervoor bij stap 2 aangemaakte arrays. De parkeerduur kan maximaal 24 uur zijn¹.
4. Bereken per auto de parkeerkosten op basis van de ingevoerde parkeerduur. Maak hierbij gebruik van een methode met de volgende signatuur:
   ```
   public static double berekenParkeergeld(int mpParkeerduur)
   ```
   Hoe de parkeerkosten worden berekend staat beschreven in de inleiding. Sla de parkeerkosten op in de hiervoor bij stap 2 aangemaakte array².
5. Druk een overzicht af met van elke auto het kenteken, de parkeerduur in uren en de parkeerkosten³.
6. Bereken het totaal van alle parkeergelden door de parkeerkosten van alle auto's bij elkaar op te tellen. Maak hierbij gebruik van een methode met de volgende signatuur:
   ```
   public static double berekenTotaleParkeerKosten(double[] mpParkeerKosten)
   ```
7. Druk dit totaal af⁴.

## Outputvoorbeeld
Zorg dat de output van je programma er hetzelfde uitziet als onderstaand outputvoorbeeld. Voor de duidelijkheid zijn in het voorbeeld de gegevens die de gebruiker heeft ingevoerd schuin en onderstreept. Jouw programma hoeft dus niets schuin en onderstreept af te drukken.

```
Dit programma is gemaakt door <student>, <studentnummer>
Hoeveel auto's hebben geparkeerd? 5
Auto 1
Kenteken: 91-RXK-6
Geparkeerde uren (max. 24): 12
Auto 2
Kenteken: 84-VR-NP
Geparkeerde uren (max. 24): 1
Auto 3
Kenteken: 2-ZNH-47
Geparkeerde uren (max. 24): 4
Auto 4
Kenteken: 06-LK-VP
Geparkeerde uren (max. 24): 25
De parkeerduur kan maximaal 24 uur zijn.
Geparkeerde uren (max. 24): 24
Auto 5
Kenteken: 48-KHB-5
Geparkeerde uren (max. 24): 7

Parkeeroverzicht
kenteken     uren    bedrag
91-RXK-6     12      25.00
84-VR-NP     1       3.75
2-ZNH-47     4       14.00
06-LK-VP     24      25.00
48-KHB-5     7       22.25

Totaal van alle parkeergelden: 90.0 euro.
```

## Richtlijnen bij coderen (zie ook MIW code conventions)
- Zorg dat je naam en het doel van het programma bovenin staan (MIWCC #1).
- Gebruik de juiste inspringing (indentation) bij de lay-out (MIWCC #2).
- Let op juist gebruik hoofdletters en kleine letters (MIWCC #4).
- Gebruik goede namen (MIWCC #5).
- Voorkom het gebruik van magic numbers (MIWCC #6).
- Voeg waar nodig commentaar toe dat inzicht geeft in je code (MIWCC #7)

---

¹ Je moet de ingevoerde parkeerduur controleren en indien nodig om nieuwe invoer vragen, totdat de invoer aan de eisen voldoet. Het ingevoerde kenteken hoef je niet te controleren.

² Als stap 4 je niet lukt, vul de array voor de parkeerkosten dan met (willekeurige) getallen, zodat je stap 5 en 6 wel kunt uitvoeren.

³ Je moet de parkeerkosten tonen met 2 decimalen en de gegevens in een tabel weergeven (zie voorbeeld). Je kunt hiervoor de methode System.out.printf gebruiken.

⁴ Bij het afdrukken van het totaalbedrag (stap 7) is het getoonde aantal decimalen niet van belang.