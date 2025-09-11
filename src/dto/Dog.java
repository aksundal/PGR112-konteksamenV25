package dto;

import java.util.Objects;

public class Dog extends Animals {
    private String Breed;
    private boolean ReadyForAdoption;
    private String FoodType;
    private int DailyFoodAmount;

    //# Konstruktør
    public Dog(int AnimalID, String Name, int Age, int ShelterID, boolean Vaccinated, String breed, boolean readyForAdoption, String foodType, int dailyFoodAmount){
        super(AnimalID, Name, Age, ShelterID, Vaccinated);

        this.Breed = breed;
        this.ReadyForAdoption = readyForAdoption;
        this.FoodType = foodType;
        this.DailyFoodAmount = dailyFoodAmount;
    }

    //# Getter

    public String getBreed() {
        return Breed;
    }


    public boolean isReadyForAdoption() {
        return ReadyForAdoption;
    }


    public String getFoodType() {
        return FoodType;
    }



    public int getDailyFoodAmount() {
        return DailyFoodAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return ReadyForAdoption == dog.ReadyForAdoption && DailyFoodAmount == dog.DailyFoodAmount && Objects.equals(Breed, dog.Breed) && Objects.equals(FoodType, dog.FoodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Breed, ReadyForAdoption, FoodType, DailyFoodAmount);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Breed='" + Breed + '\'' +
                ", ReadyForAdoption=" + ReadyForAdoption +
                ", FoodType='" + FoodType + '\'' +
                ", DailyFoodAmount=" + DailyFoodAmount +
                "} " + super.toString();
    }
}
