package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Property;
import za.ac.cput.util.PropertyHelper;

public class PropertyFactory {
    public static Property buildProperty(String propertyID, String propertyName, int numberOfRooms,int streetNumber, String streetName, String suburb, String city) {

             if (PropertyHelper.isNullOrEmpty(propertyID) || PropertyHelper.isNullOrEmpty(propertyName) || numberOfRooms <= 0 ){
               return  null;
             }

            Address address  = AddressFactory.buildAddress(streetNumber,streetName,suburb,city);

             return new Property.Builder().setPropertyID(propertyID)
                     .setPropertyName(propertyName)
                     .setNumberOfRooms(numberOfRooms)
                     .setAddress(address)
                     .build();

        }





}
