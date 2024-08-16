package za.ac.cput.service.UserService;

import za.ac.cput.domain.Account;
import za.ac.cput.domain.User;
import za.ac.cput.service.IService;

import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll();
}
