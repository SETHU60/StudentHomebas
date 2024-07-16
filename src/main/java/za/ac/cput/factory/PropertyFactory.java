package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;
import za.ac.cput.util.PropertyHelper;

import java.util.List;

public class PropertyFactory {
    public static Property buildProperty(String propertyID, String propertyName, int numberOfRooms, String streetNumber, String streetName, String suburb, String city, Landlord landlord, List<Document> pictures) {

             if (
                     PropertyHelper.isNullOrEmpty(propertyID) ||
                     PropertyHelper.isNullOrEmpty(propertyName) ||
                     numberOfRooms <= 0 ||
                     Helper.isNullOrEmpty(streetNumber) ||
                     Helper.isObjectNull(landlord) ||
                     Helper.isListNullorEmpty(pictures)

             ){
               return  null;
             }

            Address address  = AddressFactory.buildAddress(streetName,streetName,suburb,city);

             return new Property.Builder().setPropertyID(propertyID)
                     .setPropertyName(propertyName)
                     .setNumberOfRooms(numberOfRooms)
                     .setAddress(address)
                     .setLandlord(landlord)
                     .setPictures(pictures)
                     .build();

        }





}
