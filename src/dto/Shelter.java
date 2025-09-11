package dto;

import java.util.Objects;

public class Shelter {
    private int ShelterID;
    private String Name;
    private String Address;
    private String PhoneNumber;

    //# Konstruktør
    public Shelter(int ShelterID, String Name, String Address, String PhoneNumber) {
        this.ShelterID = ShelterID;
        this.Name = Name;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    //# Getter og setter

    public int getShelterID() {
        return ShelterID;
    }


    public String getName() {
        return Name;
    }


    public String getAddress() {
        return Address;
    }


    public String getPhoneNumber() {
        return PhoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return ShelterID == shelter.ShelterID && Objects.equals(Name, shelter.Name) && Objects.equals(Address, shelter.Address) && Objects.equals(PhoneNumber, shelter.PhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ShelterID, Name, Address, PhoneNumber);
    }

    @Override
    public String toString() {
        return "Shelter{" +
                "ShelterID=" + ShelterID +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
