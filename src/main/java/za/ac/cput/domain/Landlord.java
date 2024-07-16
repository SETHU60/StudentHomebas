package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Entity
public class Landlord extends User{

    private int numOfPropertiesOwned;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Document> documents;

    protected Landlord() {

    }

    public Landlord(LandlordBuilder builder){

        userId = builder.userId;
        name = builder.name;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        documents = builder.documents;
        this.contact = builder.contact;
    this.numOfPropertiesOwned = builder.numOfPropertiesOwned;
    }

    public int getNumOfPropertiesOwned() {
        return numOfPropertiesOwned;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "numOfPropertiesOwned=" + numOfPropertiesOwned +
                ", documents=" + documents +
                ", userId=" + userId +
                ", name=" + name +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Landlord landlord)) return false;
        return getNumOfPropertiesOwned() == landlord.getNumOfPropertiesOwned() && Objects.equals(documents, landlord.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumOfPropertiesOwned(), documents);
    }

    public static class LandlordBuilder{
    private Long userId;
    private Name name;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private Contact contact;
    private List<Document> documents;
    private int numOfPropertiesOwned;

        public LandlordBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public LandlordBuilder setDocuments(List<Document> documents) {
            this.documents = documents;
            return this;
        }

        public LandlordBuilder setName(Name name){
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

        public LandlordBuilder setNumOfPropertiesOwned(int numOfPropertiesOwned) {
            this.numOfPropertiesOwned = numOfPropertiesOwned;
            return this;
        }
        public Landlord buildLandlord(){return new Landlord(this);}
    }
}
