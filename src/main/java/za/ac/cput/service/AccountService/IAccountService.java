package za.ac.cput.service.AccountService;

import za.ac.cput.domain.Account;
import za.ac.cput.domain.Landlord;
import za.ac.cput.service.IService;

import java.util.List;

public interface IAccountService extends IService<Account, Long> {
    List<Account> getAll();
}
