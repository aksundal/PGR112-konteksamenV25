// Denne klassen er laget med utgangspunkt i foreleser, Per Lauvås, kode
// Canvas Modul 18: Forberedelse til eksamen - Film: eksamen 2023 - EventDB og mer UniversityDB
package databases;

import com.mysql.cj.jdbc.MysqlDataSource;
import dto.*;
import properties.ShelterDbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShelterAnimalsDao {
    private MysqlDataSource ShelterDB;

    public static final String PUSH_ALL_NEW_SHELTER_INFO = "INSERT INTO Shelter (ShelterID, Name, Address, PhoneNumber) VALUES (?,?,?,?)";
    public static final String PUSH_ALL_NEW_DOG_INFO = "INSERT INTO Dog (AnimalID, Breed, Name, Age, Vaccinated, ReadyForAdoption, ShelterID, FoodType, DailyFoodAmount) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String PUSH_NEW_CAT_INFO = "INSERT INTO Cat (AnimalID, Breed, Name, Age, Vaccinated, Neutered, ShelterID, LitterType, DailyLitterAmount) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String PUSH_NEW_BIRD_INFO = "INSERT INTO Bird (AnimalID, Species, Name, Age, Vaccinated, CanFly, ShelterID, CageSize) VALUES (?,?,?,?,?,?,?,?)";

    public static final String GET_ALL_ANIMALS = "SELECT 'Dog' AS Type, AnimalID, Name, Age, Vaccinated, ShelterID FROM Dog UNION ALL SELECT 'Cat', AnimalID, Name, Age, Vaccinated, ShelterID FROM Cat UNION ALL SELECT 'Bird', AnimalID, Name, Age, Vaccinated, ShelterID FROM Bird";
    public static final String GET_ALL_FLYING_ANIMALS = "SELECT * FROM Bird WHERE CanFly = TRUE";
    public static final String GET_ALL_VACCINATED_ANIMALS = "SELECT 'Dog' AS Type, AnimalID, Name, Age, Vaccinated, ShelterID FROM Dog WHERE Vaccinated = TRUE UNION ALL SELECT 'Cat', AnimalID, Name, Age, Vaccinated, ShelterID FROM Cat WHERE Vaccinated = TRUE UNION ALL SELECT 'Bird', AnimalID, Name, Age, Vaccinated, ShelterID FROM Bird WHERE Vaccinated = TRUE";
    public static final String GET_VACCINATED_NEUTERED_CATS = "SELECT * FROM Cat WHERE Vaccinated = TRUE AND Neutered = TRUE";

    public ShelterAnimalsDao(){
        ShelterDB = new MysqlDataSource();

        ShelterDB.setPassword(ShelterDbConn.PROPS.getProperty("pwd"));
        ShelterDB.setUser(ShelterDbConn.PROPS.getProperty("uname"));
        ShelterDB.setDatabaseName(ShelterDbConn.PROPS.getProperty("db_name"));
        ShelterDB.setServerName(ShelterDbConn.PROPS.getProperty("host"));
        ShelterDB.setPortNumber(Integer.parseInt(ShelterDbConn.PROPS.getProperty("port")));
    }

    public void insertNewShelterInfo(Shelter shelter) throws SQLException {
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(PUSH_ALL_NEW_SHELTER_INFO)) {

            stmnt.setInt(1, shelter.getShelterID());
            stmnt.setString(2,shelter.getName());
            stmnt.setString(3,shelter.getAddress());
            stmnt.setString(4, shelter.getPhoneNumber());

            stmnt.executeUpdate();

            System.out.println("Dyreheim lagt til:" + shelter.getName());
        }
        }


    public void insertNewDogInfo(Dog dog) throws SQLException {
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(PUSH_ALL_NEW_DOG_INFO)) {

            stmnt.setInt(1, dog.getAnimalID());
            stmnt.setString(2, dog.getBreed());
            stmnt.setString(3, dog.getName());
            stmnt.setInt(4, dog.getAge());
            stmnt.setBoolean(5, dog.isVaccinated());
            stmnt.setBoolean(6,dog.isReadyForAdoption());
            stmnt.setInt(7, dog.getShelterID());
            stmnt.setString(8,dog.getFoodType());
            stmnt.setInt(9, dog.getDailyFoodAmount());

            stmnt.executeUpdate();
        }
    }

    public void insertNewCatInfo(Cat cat) throws SQLException {
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(PUSH_NEW_CAT_INFO)) {

            stmnt.setInt(1, cat.getAnimalID());
            stmnt.setString(2, cat.getBreed());
            stmnt.setString(3, cat.getName());
            stmnt.setInt(4, cat.getAge());
            stmnt.setBoolean(5,cat.isVaccinated());
            stmnt.setBoolean(6,cat.isNeutered());
            stmnt.setInt(7, cat.getShelterID());
            stmnt.setString(8,cat.getLitterType());
            stmnt.setInt(9, cat.getDailyLitterAmount());

            stmnt.executeUpdate();

        }
    }

    public void insertNewBirdInfo(Bird bird) throws SQLException {
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(PUSH_NEW_BIRD_INFO)) {

            stmnt.setInt(1, bird.getAnimalID());
            stmnt.setString(2, bird.getSpecies());
            stmnt.setString(3, bird.getName());
            stmnt.setInt(4, bird.getAge());
            stmnt.setBoolean(5,bird.isVaccinated());
            stmnt.setBoolean(6,bird.isCanFly());
            stmnt.setInt(7, bird.getShelterID());
            stmnt.setString(8,bird.getCageSize());

            stmnt.executeUpdate();

        }
    }

    public List<Animals> getAllAnimals() throws SQLException {
        //
        List<Animals> animals = new ArrayList<>();
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(GET_ALL_ANIMALS);
            ResultSet rs = stmnt.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("Type");
                int id = rs.getInt("AnimalID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                boolean vaccinated = rs.getBoolean("Vaccinated");
                int shelterId = rs.getInt("ShelterID");

                switch (type) {
                    case "Dog" -> animals.add(new Dog(id, name, age, shelterId, vaccinated, "", false, "", 0));
                    case "Cat" -> animals.add(new Cat(id, name, age, shelterId, vaccinated, "", false, "", 0));
                    case "Bird" -> animals.add(new Bird(id, name, age, shelterId, vaccinated, "", false, ""));
                }
            }
        }
        return animals;
    }


    public List<Bird> getAllFlyingAnimals() throws SQLException {
        //
        List<Bird> birds = new ArrayList<>();
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(GET_ALL_FLYING_ANIMALS);
            ResultSet rs = stmnt.executeQuery()) {
            while (rs.next()) {
              int id = rs.getInt("AnimalID");
              String name = rs.getString("Name");
              int age = rs.getInt("Age");
                boolean vaccinated = rs.getBoolean("Vaccinated");
                int shelterId = rs.getInt("ShelterID");
                String species = rs.getString("Species");
                boolean canFly = rs.getBoolean("CanFly");
                String cageSize = rs.getString("CageSize");

                birds.add(new Bird(id, name, age, shelterId, vaccinated, species, canFly, cageSize));
            }
        }
        return birds;
    }

    public List<Animals> getAllVaccinatedAnimals() throws SQLException {
        //
        List<Animals> animals = new ArrayList<>();
        try(Connection conn = ShelterDB.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(GET_ALL_VACCINATED_ANIMALS);
            ResultSet rs = stmnt.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("Type");
                int id = rs.getInt("AnimalID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                boolean vaccinated = rs.getBoolean("Vaccinated");
                int shelterId = rs.getInt("ShelterID");

                switch (type) {
                    case "Dog" -> animals.add(new Dog(id, name, age, shelterId, vaccinated, "", false, "", 0));
                    case "Cat" -> animals.add(new Cat(id, name, age, shelterId, vaccinated, "", false, "", 0));
                    case "Bird" -> animals.add(new Bird(id, name, age, shelterId, vaccinated, "", false, ""));
                }
            }
        }
        return animals;
    }

    public List<Cat> getVaccinatedAndNeuteredCats() throws SQLException {
        List<Cat> cats = new ArrayList<>();
        try (Connection conn = ShelterDB.getConnection();
             PreparedStatement stmnt = conn.prepareStatement(GET_VACCINATED_NEUTERED_CATS);
             ResultSet rs = stmnt.executeQuery()){
            while(rs.next()) {
                int id = rs.getInt("AnimalID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                boolean vaccinated = rs.getBoolean("Vaccinated");
                boolean neutered = rs.getBoolean("Neutered");
                int shelterId = rs.getInt("ShelterID");
                String breed = rs.getString("Breed");
                String litterType = rs.getString("LitterType");
                int dailyLitterAmount = rs.getInt("DailyLitterAmount");

                cats.add(new Cat(id, name, age, shelterId, vaccinated, breed, neutered, litterType, dailyLitterAmount));
            }
        }
        return cats;

    }

}


