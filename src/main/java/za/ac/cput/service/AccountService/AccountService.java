package za.ac.cput.service.AccountService;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Account;
import za.ac.cput.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Override
    public List<Account> getAll() {
        return repo.findAll();
    }

    @Override
    public Account read(Long aLong) {
        return repo.findById(aLong).orElse(null);
    }

    @Override
    public Account update(Account account) {
        return repo.save(account);
    }

    @Override
    public boolean deleteById(Long aLong) {
        repo.deleteById(aLong);
        return !repo.existsById(aLong);
    }

    @Autowired
    private AccountRepository repo;

    @Override
    public Account save(Account account){return repo.save(account);}


}
