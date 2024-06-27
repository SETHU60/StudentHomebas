package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Landlord extends User{
    private String landlordId;
    private int numOfPropertiesOwned;

    public Landlord(UserBuilder builder) {
        super(builder);
    }

    public Landlord (LandlordBuilder builder){

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
       // this.contact = builder.contact;
    this.landlordId = builder.landlordId;
    this.numOfPropertiesOwned = builder.numOfPropertiesOwned;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public int getNumOfPropertiesOwned() {
        return numOfPropertiesOwned;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "landlordId='" + landlordId + '\'' +
                ", numOfPropertiesOwned=" + numOfPropertiesOwned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landlord landlord = (Landlord) o;
        return numOfPropertiesOwned == landlord.numOfPropertiesOwned && Objects.equals(landlordId, landlord.landlordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landlordId, numOfPropertiesOwned);
    }

    public static class LandlordBuilder{
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private Contact contact;
    
    
    private String landlordId;
    private int numOfPropertiesOwned;

    public LandlordBuilder setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public LandlordBuilder setGender(String gender){
        this.gender = gender;
        return this;
        }
        public LandlordBuilder setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
            return this;
        }

        public LandlordBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public LandlordBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public LandlordBuilder setContact(Contact contact){
        this.contact = contact;
            return this;
        }
        public LandlordBuilder setLandlordId(String landlordId) {
            this.landlordId = landlordId;
            return this;
        }

        public LandlordBuilder setNumOfPropertiesOwned(int numOfPropertiesOwned) {
            this.numOfPropertiesOwned = numOfPropertiesOwned;
            return this;
        }
        public Landlord buildLandlord(){return new Landlord(this);}
    }
}
