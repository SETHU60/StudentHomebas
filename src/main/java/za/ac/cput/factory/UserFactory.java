package za.ac.cput.factory;

import za.ac.cput.domain.User;
import java.time.LocalDate;
import za.ac.cput.util.UserHelper;
public class UserFactory {



        public static User.UserBuilder buildUser(Name name, String gender, String password, LocalDate dateOfBirth){
            if(UserHelper.isObjectEmpty(name) ||
                    UserHelper.isNullOrEmpty(gender) ||
                    UserHelper.isNullOrEmpty(password) ||
                    dateOfBirth == null
            ) {
                return null;
            }

            return new User.UserBuilder()
                    .setName(Name)

                    .setGender(gender)
                    .setPassword(password)
                    .setDateOfBirth(dateOfBirth)
                    ;
        }
    }


