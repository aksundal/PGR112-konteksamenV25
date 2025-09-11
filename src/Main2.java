// Denne klassen er inspirert av koden til foreleser, Per Lauvås
// PGR112/src/eksempler/_06/menyeksempel/Program.java og src/loesninger/_11/books/Program.java
import databases.ShelterAnimalsDao;
import java.sql.SQLException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ShelterAnimalsDao dao = new ShelterAnimalsDao();
        Scanner scanner = new Scanner(System.in);
        boolean runningProgram = true;

        while (runningProgram) {
            System.out.println("--- Dyreheimprogram for Dyrehjemsnettverket Poter og Nebb---");
            System.out.println("1. Sjå informasjon om alle dyr");
            System.out.println("2. Sjå informasjon om alle dyr som kan fly ");
            System.out.println("3. Sjå informasjon om alle dyr som er vaksinert");
            System.out.println("4. Sjå alle katter som er vaksinerte og kastrerte");
            System.out.println("5. Avslutt");
            System.out.println("Vel eit alternativ: ");
            System.out.println("Velg eit av alternativane over :) ");

            String userChoice = scanner.nextLine();
            try {
                switch (userChoice) {
                    case "1" -> dao.getAllAnimals().forEach(System.out::println);
                    case "2" -> dao.getAllFlyingAnimals().forEach(System.out::println);
                    case "3" -> dao.getAllVaccinatedAnimals().forEach(System.out::println);
                    case "4" -> dao.getVaccinatedAndNeuteredCats().forEach(System.out::println);
                    case "5" -> {
                        System.out.println("Avslutter programmet... Hade godt!");
                        runningProgram = false;
                    }
                    default -> System.out.println("Ugyldig valg, velg eit av alternativf frå 1 - 5");
                }
            } catch (SQLException e) {
                System.out.println("Feil ved henting av data: " + e.getMessage());
            }
        }
    }
}