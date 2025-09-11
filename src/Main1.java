import databases.ShelterAnimalsDao;
import dto.*;

import java.io.File;
import java.util.Scanner;
import java.sql.SQLException;

// Main for del 1
public class Main1 {
    public static void main(String[] args) {
        ShelterAnimalsDao dao = new ShelterAnimalsDao();
        String filePath = "src/files/animals.txt";
        File file = new File(filePath);

        boolean readingShelters = true;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isBlank()) continue;

                if (line.equals("---")) {
                    if (readingShelters) {
                        readingShelters = false;
                    }
                    continue;
                }

                if (readingShelters) {
                    try {
                        int shelterId = Integer.parseInt(line);
                        String name = scanner.nextLine();
                        String address = scanner.nextLine();
                        String phoneNumber = scanner.nextLine();
                        dao.insertNewShelterInfo(new Shelter(shelterId, name, address, phoneNumber));
                        System.out.println("Dyreheim lagt til: " + name);
                    } catch (NumberFormatException | SQLException ignored) {
                    }
                } else {
                    try {
                        int animalId = Integer.parseInt(line);
                        String name = scanner.nextLine();
                        int age = Integer.parseInt(scanner.nextLine());
                        boolean vaccinated = Boolean.parseBoolean(scanner.nextLine());
                        int shelterId = Integer.parseInt(scanner.nextLine());
                        String type = scanner.nextLine().toLowerCase();

                        switch (type) {
                            case "hund" -> {
                                String breed = scanner.nextLine();
                                boolean readyForAdoption = Boolean.parseBoolean(scanner.nextLine());
                                String foodType = scanner.nextLine();
                                int dailyFoodAmount = Integer.parseInt(scanner.nextLine());
                                dao.insertNewDogInfo(new Dog(animalId, name, age, shelterId, vaccinated, breed, readyForAdoption, foodType, dailyFoodAmount));
                                System.out.println("Hund lagt til: " + name);
                            }
                            case "katt" -> {
                                String breed = scanner.nextLine();
                                boolean neutered = Boolean.parseBoolean(scanner.nextLine());
                                String litterType = scanner.nextLine();
                                int dailyLitterAmount = Integer.parseInt(scanner.nextLine());
                                dao.insertNewCatInfo(new Cat(animalId, name, age, shelterId, vaccinated, breed, neutered, litterType, dailyLitterAmount));
                                System.out.println("Katt lagt til: " + name);
                            }
                            case "fugl" -> {
                                String species = scanner.nextLine();
                                boolean canFly = Boolean.parseBoolean(scanner.nextLine());
                                String cageSize = scanner.nextLine();
                                dao.insertNewBirdInfo(new Bird(animalId, name, age, shelterId, vaccinated, species, canFly, cageSize));
                                System.out.println("Fugl lagt til: " + name);
                            }
                        }
                    } catch (NumberFormatException | SQLException ignored) {
                    }
                }
            }
            System.out.println("Alle dyreheimer og dyr er lagt til i databasen!");
        } catch (Exception ignored) {
        }
    }
}


