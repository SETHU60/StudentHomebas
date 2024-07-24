package za.ac.cput.service.landlordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Landlord;
import za.ac.cput.repository.LandlordRepository;

import java.util.List;

@Service
public class LandlordService implements ILandlordService{
    @Autowired
    private LandlordRepository repository;

    @Override
    public Landlord save(Landlord landlord) {
        return repository.save(landlord);
    }

    @Override
    public Landlord read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Landlord update(Landlord landlord) {
        return repository.save(landlord);
    }

    @Override
    public boolean deleteById(Long aLong) {
        repository.deleteById(aLong);
        return !repository.existsById(aLong);

    }

    @Override
    public List<Landlord> getall() {
        return repository.findAll();
    }
}
