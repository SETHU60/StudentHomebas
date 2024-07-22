package za.ac.cput.service.AcademicDetails;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.service.IService;
import java.util.List;
@Service
public interface IAcademicDetailsService extends IService<AcademicDetails, String> {

    List<AcademicDetails> getAll();
}
