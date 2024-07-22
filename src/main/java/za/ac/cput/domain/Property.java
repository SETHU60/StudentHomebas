package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;
import java.util.Objects;

@Entity
public class Property {
    @Id
    private String propertyID;
    private  String propertyName;
    private  int numberOfRooms;
    private double price;

   @OneToOne
    private Address address;

   @OneToOne
    private Landlord landlord;

   @OneToMany
    private List<Document> pictures;

    protected Property() {
    }


    private Property(Builder builder){
        this.propertyID = builder.propertyID;
        this.propertyName = builder.propertyName;
        this.numberOfRooms = builder.numberOfRooms;
        this.address = builder.address;
        this.landlord = builder.landlord;
        this.pictures = builder.pictures;
        this.price= builder.price;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Address getAddress() {
        return address;
    }
    public Landlord getLandlord() {
        return landlord;
    }
    public List<Document> getPictures() {
        return pictures;
    }
    public double getPrice() {return price;}

    @Override
    public String toString() {
        return "Property{" +
                "propertyID='" + propertyID + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", address=" + address +
                ", landlord=" + landlord +
                ", pictures=" + pictures +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return numberOfRooms == property.numberOfRooms && Double.compare(price, property.price) == 0 && Objects.equals(propertyID, property.propertyID) && Objects.equals(propertyName, property.propertyName) && Objects.equals(address, property.address) && Objects.equals(landlord, property.landlord) && Objects.equals(pictures, property.pictures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyID, propertyName, numberOfRooms, price, address, landlord, pictures);
    }

    public static class Builder{

        private String propertyID;
        private  String propertyName;
        private  int numberOfRooms;
        private Address address;
        private Landlord landlord;
        private List<Document> pictures;
        private double price;

        public Builder(){
        }

        public Builder setLandlord(Landlord landlord) {
            this.landlord = landlord;
            return this;
        }

        public Builder setPictures(List<Document> pictures) {
            this.pictures = pictures;
            return this;
        }

        public Builder setPropertyID(String propertyID){
            this.propertyID = propertyID;
            return this;
        }
        public Builder setPropertyName(String propertyName){
            this.propertyName = propertyName;
            return this;
        }

        public Builder setNumberOfRooms(int numberOfRooms){
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        public Builder setAddress(Address address){
            this.address = address;
            return this;
        }
        public Builder setPrice(double price){
            this.price = price;
            return this;}
        public Builder copy(Property property){
            this.propertyID = property.propertyID;
            this.propertyName = property.propertyName;
            this.numberOfRooms = property.numberOfRooms;
            this.address = property.address;
            this.price = property.price;
            this.pictures = property.pictures;
            this.landlord = property.landlord;

            return this;
        }

        public Property build(){
         return new Property(this);

        }

    }
}
