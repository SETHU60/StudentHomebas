package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.AddressHelper;

public class AddressFactory {
    public static Address buildAddress(int streetNumber, String streetName, String suburb, String city){
        if(AddressHelper.isIntEmpty(streetNumber) ||
        AddressHelper.isNullOrEmpty(streetName) ||
        AddressHelper.isNullOrEmpty(suburb) ||
        AddressHelper.isNullOrEmpty(city)
        ){return null;}
        return new Address.AddressBuilder().setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .buildAddress();
    }
}
