package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.AddressHelper;

public class AddressFactory {
    public static Address buildAddress(String streetName, String suburb, String city, String postalCode){
        if(
        AddressHelper.isNullOrEmpty(streetName) ||
        AddressHelper.isNullOrEmpty(suburb) ||
        AddressHelper.isNullOrEmpty(city) || AddressHelper.isNullOrEmpty(postalCode)
        ){return null;}
        return new Address.AddressBuilder()
                .setStreet(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setPostalCode(postalCode)
                .buildAddress();
    }
}
