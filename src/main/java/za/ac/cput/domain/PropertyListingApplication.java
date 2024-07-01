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

    @OneToOne(cascade = CascadeType.ALL)
    private Property property;

    @OneToOne(cascade = CascadeType.ALL)
    private Landlord landlord;

    private double rentalPrice;
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public PropertyListingApplication(){}

    public PropertyListingApplication(Builder builder){
        this.appNo = builder.appNo;
        this.date = builder.date;
        this.status = builder.status;
        this.property = builder.property;
        this.landlord = builder.landlord;
        this.rentalPrice = builder.rentalPrice;
        this.location = builder.location;
        this.address = builder.address;
    }

    public Property getProperty() {
        return property;
    }

    public Landlord getLandlord() {
        return landlord;
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
        return Double.compare(rentalPrice, that.rentalPrice) == 0 && Objects.equals(property, that.property) && Objects.equals(landlord, that.landlord) && Objects.equals(location, that.location) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), property, landlord, rentalPrice, location, address);
    }

    @Override
    public String toString() {
        return "PropertyListingApplication{" +
                "property='" + property + '\'' +
                ", landlord='" + landlord + '\'' +
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
        private Property property;
        private Landlord landlord;
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

        public Builder setProperty(Property property) {
            this.property = property;
            return this;
        }

        public Builder setLandlord(Landlord landlord) {
            this.landlord = landlord;
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
            this.property = propertyApp.property;
            this.landlord = propertyApp.landlord;
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
