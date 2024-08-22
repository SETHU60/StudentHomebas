package za.ac.cput.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.*;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.repository.DocumentRepository;
import za.ac.cput.repository.LandlordRepository;
import za.ac.cput.repository.PropertyRepository;
import za.ac.cput.service.AddressService;
import za.ac.cput.service.landlordService.LandlordService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private PropertyRepository repo;


    @Autowired
    private LandlordService landlordService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public Property save(Property property) {

        System.out.println("Property save called");

        List <Document> pictures = property.getPictures();
        Address address = property.getAddress();
        addressService.save(address);
        Landlord landlord = property.getLandlord();
        landlordService.save(landlord);

        if (pictures != null) {
            pictures = pictures.stream()
                    .map(document -> {
                        System.out.println("Document: " + document );
                        if (document.getDocumentId()  == null) {
                            // If picture id is null, save the picture directly
                            return documentRepository.save(document);

                        } else {

                            // If document is not null, try to find the author in the repository
                            Optional<Document> existingDocuments = documentRepository.findById(document.getDocumentId());
                            // Return the existing author if found, or save and return the new one if not found
                            return existingDocuments.orElseGet(() -> documentRepository.save(document));
                        }
                    })
                    .collect(Collectors.toList());
        }

        if (property != null) {
            System.out.println("Property to be Saved: " + property);
            if(Long.valueOf(property.getPropertyID()) ==  null ||
                    property.getPropertyID() == 0){
                System.out.println("saving new property]");

                property = repo.save(property);
                System.out.println("Saved");
                System.out.println("Saved property" + property);
            }else{
                System.out.println("checking if existing property exists");

                Optional<Property> existingProperty = repo.findById(property.getPropertyID());

                if (existingProperty.isPresent()) {
                    System.out.println("found property");
                    property = existingProperty.get();
                }}
        }
        return  property;
    }

    @Override
    public Property read(Long s) {
        return repo.findById(s).orElse(null);
    }

    @Override
    public Property update(Property property) {
        return repo.save(property);
    }

    @Override
    public boolean deleteById(Long s) {
        repo.deleteById(s);
        return !repo.existsById(s);
    }
    @Override
    public List<Property> getAll() {
        return repo.findAll();

    }
}
