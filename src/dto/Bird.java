package dto;

import java.util.Objects;

public class Bird extends Animals {
    private String Species;
    private boolean CanFly;
    private String CageSize;

    //# Konstruktør
    public Bird(int AnimalID, String Name, int Age, int ShelterID, boolean Vaccinated, String species, boolean canFly, String cageSize) {
        super(AnimalID, Name, Age, ShelterID, Vaccinated);

        this.Species = species;
        this.CanFly = canFly;
        this.CageSize = cageSize;
    }

    //# Getter og setter

    public String getSpecies() {
        return Species;
    }


    public boolean isCanFly() {
        return CanFly;
    }

    public String getCageSize() {
        return CageSize;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return CanFly == bird.CanFly && Objects.equals(Species, bird.Species) && Objects.equals(CageSize, bird.CageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Species, CanFly, CageSize);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "Species='" + Species + '\'' +
                ", CanFly=" + CanFly +
                ", CageSize='" + CageSize + '\'' +
                "} " + super.toString();
    }
}

/*
Fugl:

Species
CanFly
CageSize

Felles keys:
AnimalID
Name
Age
Vaccinated
ShelterID

antall dyrehjem
ShelteID
name
address
PhoneNumber
-----
antall dyr

Hund:
AnimalID
Name
Age
Vaccinated
ShelterID
Breed
ReadyForAdoption
FoodType
DailyFoodAmount

Katt:
AnimalID
Name
Age
Vaccinated
ShelterID
Breed
Neutered
LitterType
DailyLitterAmount

 */
