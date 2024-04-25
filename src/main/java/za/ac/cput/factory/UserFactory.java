package za.ac.cput.factory;

import za.ac.cput.domain.User;
import java.time.LocalDate;
import za.ac.cput.util.UserHelper;
public class UserFactory {



        public static User.UserBuilder buildUser(String lastName, String firstName, String gender, String password, LocalDate dateOfBirth){
            if(UserHelper.isNullOrEmpty(lastName) ||
                    UserHelper.isNullOrEmpty(firstName) ||
                    UserHelper.isNullOrEmpty(gender) ||
                    UserHelper.isNullOrEmpty(password) ||
                    dateOfBirth == null
            ) {
                return null;
            }

            return new User.UserBuilder()
                    .setLastName(lastName)
                    .setFirstName(firstName)
                    .setGender(gender)
                    .setPassword(password)
                    .setDateOfBirth(dateOfBirth)
                    ;
        }
    }


