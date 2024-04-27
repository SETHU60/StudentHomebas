package za.ac.cput.domain;


import java.util.Objects;

public class Address {
    private int streetNumber;
    private String streetName;
    private String suburb;
    private String city;


    protected Address(){}

    private Address(AddressBuilder builder){
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNumber == address.streetNumber && Objects.equals(streetName, address.streetName) && Objects.equals(suburb, address.suburb) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, suburb, city);
    }

    public static class AddressBuilder{

        private int streetNumber;
        private String streetName;
        private String suburb;
        private String city;

        public AddressBuilder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }
        public Address buildAddress(){return new Address(this);}
    }
}
