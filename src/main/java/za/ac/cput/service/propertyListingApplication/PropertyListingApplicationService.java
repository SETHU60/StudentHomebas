package za.ac.cput.service.propertyListingApplication;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.PropertyListingApplication;
import za.ac.cput.repository.PropertyListingApplicationRepository;

import java.util.List;

@Service
public class PropertyListingApplicationService implements IPropertyListingApplicationService {

    PropertyListingApplicationRepository repository;

    @Autowired
    public PropertyListingApplicationService(PropertyListingApplicationRepository repository){
        this.repository = repository;
    }

    @Override
    public PropertyListingApplication save(PropertyListingApplication propertyApp) {
        return repository.save(propertyApp);
    }

    @Override
    public PropertyListingApplication read(Long appNo) {
        return repository.findById(appNo).orElse(null);
    }

    @Override
    public PropertyListingApplication update(PropertyListingApplication propertyApp) {
        return repository.save(propertyApp);
    }

    @Override
    public boolean deleteById(Long appNo) {
        repository.deleteById(appNo);
        return !repository.existsById(appNo);
    }

    @Override
    public List<PropertyListingApplication> getAll() {
        return repository.findAll();
    }
}
