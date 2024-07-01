package za.ac.cput.domain;

/*
 * Author : Sabelo Kama (219149364)
 * Date : 22 April 2024
 * */

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class PropertyListingApplication extends Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long appNo;

    @OneToOne(cascade = CascadeType.ALL)
    private Property propertyID;

    @OneToOne(cascade = CascadeType.ALL)
    private Landlord landlordID;

    private double rentalPrice;
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public PropertyListingApplication(){}

    public PropertyListingApplication(Builder builder){
        this.appNo = builder.appNo;
        this.date = builder.date;
        this.status = builder.status;
        this.propertyID = builder.propertyID;
        this.landlordID = builder.landlordID;
        this.rentalPrice = builder.rentalPrice;
        this.location = builder.location;
        this.address = builder.address;
    }

    public Property getPropertyID() {
        return propertyID;
    }

    public Landlord getLandlordID() {
        return landlordID;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public String getLocation() {
        return location;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PropertyListingApplication that = (PropertyListingApplication) o;
        return Double.compare(rentalPrice, that.rentalPrice) == 0 && Objects.equals(propertyID, that.propertyID) && Objects.equals(landlordID, that.landlordID) && Objects.equals(location, that.location) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), propertyID, landlordID, rentalPrice, location, address);
    }

    @Override
    public String toString() {
        return "PropertyListingApplication{" +
                "propertyID='" + propertyID + '\'' +
                ", landlordID='" + landlordID + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", appNo='" + appNo + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public static class Builder{
        private long appNo;
        private LocalDate date;
        private Status status;
        private Property propertyID;
        private Landlord landlordID;
        private double rentalPrice;
        private String location;
        private Address address;

        public Builder setAppNo(long appNo) {
            this.appNo = appNo;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setPropertyID(Property propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder setLandlordID(Landlord landlordID) {
            this.landlordID = landlordID;
            return this;
        }

        public Builder setRentalPrice(double rentalPrice) {
            this.rentalPrice = rentalPrice;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy (PropertyListingApplication propertyApp){
            this.appNo = propertyApp.appNo;
            this.date = propertyApp.date;
            this.status = propertyApp.status;
            this.propertyID = propertyApp.propertyID;
            this.landlordID = propertyApp.landlordID;
            this.rentalPrice = propertyApp.rentalPrice;
            this.location = propertyApp.location;
            this.address = propertyApp.address;
            return this;
        }

        public PropertyListingApplication build(){

            return new PropertyListingApplication(this);
        }
    }
}
