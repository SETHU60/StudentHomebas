package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

public class AddressId implements Serializable {
    private String street;
    private String postalCode;

    public AddressId(){}

    public AddressId(String street, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressId addressId = (AddressId) o;
        return Objects.equals(street, addressId.street) && Objects.equals(postalCode, addressId.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postalCode);
    }

    @Override
    public String toString() {
        return street + postalCode;
    }

}
