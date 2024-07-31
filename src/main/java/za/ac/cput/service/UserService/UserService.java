package za.ac.cput.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repo;
    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public User read(Long aLong) {
        return repo.findById(aLong).orElse(null);
    }

    @Override
    public User update(User user) {
        return repo.save(user);
    }

    @Override
    public boolean deleteById(Long aLong) {
        repo.deleteById(aLong);
        return !repo.existsById(aLong);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }
}
