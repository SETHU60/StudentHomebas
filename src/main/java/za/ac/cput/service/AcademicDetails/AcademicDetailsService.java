package za.ac.cput.service.AcademicDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.repository.AcademicDetailsRepository;

import java.util.List;
@Service
public class AcademicDetailsService implements IAcademicDetailsService{
    @Autowired
    private AcademicDetailsRepository repo;

    @Override
    public AcademicDetails save(AcademicDetails academicDetails) {
        return repo.save(academicDetails);
    }

    @Override
    public AcademicDetails read(String s) {
        return repo.findById(s).orElse(null);
    }

    @Override
    public AcademicDetails update(AcademicDetails academicDetails) {
        return repo.save(academicDetails);
    }

    @Override
    public boolean deleteById(String s) {
        repo.deleteById(s);
        return !repo.existsById(s);
    }
    @Override
    public List<AcademicDetails> getAll() {
        return repo.findAll();
    }


}
