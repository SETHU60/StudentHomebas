package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Entity
public class Landlord extends User{
    @Id
    private String landlordId;
    private int numOfPropertiesOwned;
    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToOne
    private Contact contact;


    public Landlord(LandlordBuilder builder){

        name = builder.name;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        this.contact = builder.contact;
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
    private Name name;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private Contact contact;
    
    
    private String landlordId;
    private int numOfPropertiesOwned;

    public LandlordBuilder Name(Name name){
        this.name = name;
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
