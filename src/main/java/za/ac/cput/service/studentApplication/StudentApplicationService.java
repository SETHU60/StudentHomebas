package za.ac.cput.service.studentApplication;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StudentApplication;
import za.ac.cput.repository.StudentApplicationRepository;

import java.util.List;

@Service
public class StudentApplicationService implements IStudentApplicationService {

    StudentApplicationRepository repository;

    @Autowired
    public StudentApplicationService(StudentApplicationRepository repository){
        this.repository = repository;
    }

    @Override
    public StudentApplication save(StudentApplication studentApp) {
        return repository.save(studentApp);
    }

    @Override
    public StudentApplication read(Long appNo) {
        return repository.findById(appNo).orElse(null);
    }

    @Override
    public StudentApplication update(StudentApplication studentApp) {
        return repository.save(studentApp);
    }

    @Override
    public boolean deleteById(Long appNo) {
        repository.deleteById(appNo);
        return !repository.existsById(appNo);
    }

    @Override
    public List<StudentApplication> getAll() {
        return repository.findAll();
    }
}
