package dto;

import java.util.Objects;

//# Abstrakt klasse for alle dyra
public abstract class Animals {
    private int AnimalID;
    private String Name;
    private int Age;
    private int ShelterID;
    private boolean Vaccinated;

    //# Konstrukør
    public Animals(int animalID, String Name, int Age, int ShelterID, boolean Vaccinated){
        this.AnimalID = animalID;
        this.Name = Name;
        this.Age = Age;
        this.ShelterID = ShelterID;
        this.Vaccinated = Vaccinated;
    }

    //# <Getter
    public int getAnimalID() {
        return AnimalID;
    }


    public String getName() {
        return Name;
    }


    public int getAge() {
        return Age;
    }


    public int getShelterID() {
        return ShelterID;
    }


    public boolean isVaccinated() {
        return Vaccinated;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return AnimalID == animals.AnimalID && Age == animals.Age && ShelterID == animals.ShelterID && Vaccinated == animals.Vaccinated && Objects.equals(Name, animals.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AnimalID, Name, Age, ShelterID, Vaccinated);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "AnimalID=" + AnimalID +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", ShelterID=" + ShelterID +
                ", Vaccinated=" + Vaccinated +
                '}';
    }
}


/*

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

Fugl:
AnimalID
Name
Age
Vaccinated
ShelterID
Species
CanFly
CageSize

En velfungerende database som har informasjon om dyrehjemmene (shelters) og dyr
(animals). Tabellene i databasen er fylt med data basert på filen animals.txt.
• En eller flere klasser som kan kommunisere med databasen.
• En eller flere klasser som kan holde i data fra databasen. Det er forventet at arv benyttes for
klasser som omfatter ulike typer dyr ettersom de har mange felles egenskaper. Det er også
forventet at disse klassene blir benyttet i kommunikasjon med databasen.
 */