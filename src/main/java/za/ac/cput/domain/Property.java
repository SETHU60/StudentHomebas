package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Property {
    @Id
    private String propertyID;
    private  String propertyName;
    private  int numberOfRooms;
    @OneToOne
    private Address address;

    protected Property() {
    }

    private Property(Builder builder){
        this.propertyID = builder.propertyID;
        this.propertyName = builder.propertyName;
        this.numberOfRooms = builder.numberOfRooms;
        this.address = builder.address;
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

    @Override
    public String toString() {
        return "Property{" +
                "propertyID='" + propertyID + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", address=" + address +
                '}';
    }

    public static class Builder{

        private String propertyID;
        private  String propertyName;
        private  int numberOfRooms;
        private Address address;

        public Builder(){

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
        private Builder copy(Property property){
            this.propertyID = property.propertyID;
            this.propertyName = property.propertyName;
            this.numberOfRooms = property.numberOfRooms;
            this.address = property.address;

            return this;
        }

        public Property build(){
         return new Property(this);

        }



    }
}
