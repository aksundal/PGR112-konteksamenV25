package dto;

import java.util.Objects;

public class Cat extends Animals {
    private String Breed;
    private boolean Neutered;
    private String LitterType;
    private int DailyLitterAmount;

    //# Konstruktør
    public Cat (int AnimalID, String Name, int Age, int ShelterID, boolean Vaccinated, String breed, boolean neutered, String litterType, int dailyLitterAmount){
        super(AnimalID, Name, Age, ShelterID, Vaccinated);

        this.Breed = breed;
        this.Neutered = neutered;
        this.LitterType = litterType;
        this.DailyLitterAmount = dailyLitterAmount;


    }

    //# Getter

    public String getBreed() {
        return Breed;
    }


    public boolean isNeutered() {
        return Neutered;
    }


    public String getLitterType() {
        return LitterType;
    }


    public int getDailyLitterAmount() {
        return DailyLitterAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Neutered == cat.Neutered && DailyLitterAmount == cat.DailyLitterAmount && Objects.equals(Breed, cat.Breed) && Objects.equals(LitterType, cat.LitterType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Breed, Neutered, LitterType, DailyLitterAmount);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Breed='" + Breed + '\'' +
                ", Neutered=" + Neutered +
                ", LitterType='" + LitterType + '\'' +
                ", DailyLitterAmount=" + DailyLitterAmount +
                "} " + super.toString();
    }
}