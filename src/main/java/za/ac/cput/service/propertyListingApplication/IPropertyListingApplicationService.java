package za.ac.cput.service.propertyListingApplication;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import za.ac.cput.domain.PropertyListingApplication;
import za.ac.cput.service.IService;

import java.util.List;

public interface IPropertyListingApplicationService extends IService<PropertyListingApplication, Long> {
    List<PropertyListingApplication> getAll();
}
