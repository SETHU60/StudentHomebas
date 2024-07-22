package za.ac.cput.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Property;
import za.ac.cput.repository.PropertyRepository;

import java.util.List;
@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private PropertyRepository repo;

    @Override
    public Property create(Property property) {
        return repo.save(property);
    }

    @Override
    public Property read(String s) {
        return repo.findById(s).orElse(null);
    }

    @Override
    public Property update(Property property) {
        return repo.save(property);
    }

    @Override
    public boolean delete(String s) {
        repo.deleteById(s);
        return !repo.existsById(s);
    }
    @Override
    public List<Property> getAll() {
        return repo.findAll();

    }
}
